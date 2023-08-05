package com.growkeeper.clients;

import com.growkeeper.config.OpenWeatherConfig;
import com.growkeeper.dto.api.openWeatherDto.city.OpenWeatherCityRootDto;
import com.growkeeper.dto.api.openWeatherDto.weather.OpenWeatherListDto;
import com.growkeeper.dto.api.openWeatherDto.weather.OpenWeatherRootDto;
import com.growkeeper.mapper.LocationMapper;
import com.growkeeper.mapper.WeatherMapper;
import com.growkeeper.service.LocationService;
import com.growkeeper.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class OpenWeatherClient {
    private final OpenWeatherConfig openWeatherConfig;
    private final RestTemplate restTemplate;
    private final LocationService locationService;
    private final LocationMapper locationMapper;
    private final WeatherService weatherService;
    private final WeatherMapper weatherMapper;


    private URI buildUrlForWeather(double lat, double lon) {
        return UriComponentsBuilder.fromHttpUrl(openWeatherConfig.getOpenweatherApiWeatherEndpoint())
                .queryParam("lat", lat)
                .queryParam("lon", lon)
                .queryParam("units", "metric")
                .queryParam("appid", openWeatherConfig.getOpenweatherApiKey())
                .build().encode().toUri();
    }

    private URI buildUrlForLocation(String city) {
        return UriComponentsBuilder.fromHttpUrl(openWeatherConfig.getOpenweatherApiGeocodingEndpoint())
                .queryParam("q", city)
                .queryParam("limit", 1)
                .queryParam("appid", openWeatherConfig.getOpenweatherApiKey())
                .build().encode().toUri();
    }

    public void getLocation(String city) {
        OpenWeatherCityRootDto[] openWeatherCityRootDto = restTemplate.getForObject(buildUrlForLocation(city), OpenWeatherCityRootDto[].class);
        locationService.createLocation(locationMapper.mapToLocation(openWeatherCityRootDto[0]));
    }

    public void getWeather(double lat, double lon) {
        OpenWeatherRootDto openWeatherRootDto = restTemplate.getForObject(buildUrlForWeather(lat, lon), OpenWeatherRootDto.class);
        weatherService.addWeatherInBulk(weatherMapper.mapToWeatherList(openWeatherRootDto.getOpenWeatherListDtos()));
    }

    /*
    public void getWeather(double lat, double lon) throws JsonProcessingException {
        String data = restTemplate.getForObject(buildUrlForWeather(lat, lon), String.class);
        data = data.substring(data.indexOf("\"list\":")+7, data.lastIndexOf(",\"city\":"));
        System.out.println(data);
        ObjectMapper om = new ObjectMapper();
        OpenWeatherWeatherRootDto[] openWeatherWeatherRootDtos = om.readValue(data, OpenWeatherWeatherRootDto[].class);
        for(OpenWeatherWeatherRootDto r : openWeatherWeatherRootDtos){
            System.out.println(r.getDt_txt() + " - "
                    + r.getOpenWeatherWeatherDto().get(0).getMain() + "; "
                    + "temp: " + r.getOpenWeatherMainDto().getTemp() + "; "
                    + "wind: " + r.getOpenWeatherWindDto().getSpeed() + "; "
                    + "rain: " + r.getOpenWeatherRainDto().get_3h() + "; "
                    + "clouds: " + r.getOpenWeatherCloudsDto().getAll() + ";");
        }
    }
     */
}
