package com.growkeeper.clients;

import com.growkeeper.config.OpenWeatherConfig;
import com.growkeeper.domain.Location;
import com.growkeeper.dto.api.openWeatherDto.city.OpenWeatherCityRootDto;
import com.growkeeper.dto.api.openWeatherDto.weather.OpenWeatherRootDto;
import com.growkeeper.exception.LocationNotFoundException;
import com.growkeeper.exception.WeatherNotFoundException;
import com.growkeeper.mapper.LocationMapper;
import com.growkeeper.mapper.WeatherMapper;
import com.growkeeper.observer.LocationObserver;
import com.growkeeper.service.LocationService;
import com.growkeeper.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
@RequiredArgsConstructor
public class OpenWeatherClient implements LocationObserver {
    private final OpenWeatherConfig openWeatherConfig;
    private final RestTemplate restTemplate;
    private final LocationService locationService;
    private final LocationMapper locationMapper;
    private final WeatherService weatherService;
    private final WeatherMapper weatherMapper;

    private URI buildUrlToGetLocation(String city) {
        return UriComponentsBuilder.fromHttpUrl(openWeatherConfig.getOpenweatherApiGeocodingEndpoint())
                .queryParam("q", city)
                .queryParam("limit", 1)
                .queryParam("appid", openWeatherConfig.getOpenweatherApiKey())
                .build().encode().toUri();
    }

    private URI buildUrlToGetWeather(double lat, double lon) {
        return UriComponentsBuilder.fromHttpUrl(openWeatherConfig.getOpenweatherApiWeatherEndpoint())
                .queryParam("lat", lat)
                .queryParam("lon", lon)
                .queryParam("units", "metric")
                .queryParam("appid", openWeatherConfig.getOpenweatherApiKey())
                .build().encode().toUri();
    }

    public void getLocation(String city) {
        OpenWeatherCityRootDto[] openWeatherCityRootDto = restTemplate.getForObject(buildUrlToGetLocation(city), OpenWeatherCityRootDto[].class);
        if(openWeatherCityRootDto != null) {
            locationService.addLocation(locationMapper.mapToLocation(openWeatherCityRootDto[0]));
        } else {
            throw new LocationNotFoundException();
        }
    }

    public void getWeather(double lat, double lon) {
        OpenWeatherRootDto openWeatherRootDto = restTemplate.getForObject(buildUrlToGetWeather(lat, lon), OpenWeatherRootDto.class);
        if(openWeatherRootDto != null) {
            weatherService.addWeatherInBulk(weatherMapper.mapToWeatherList(openWeatherRootDto.getOpenWeatherListDtos()));
        } else {
            throw new WeatherNotFoundException();
        }
    }

    @Override
    public void locationChanged(Location newLocation) {
        getWeather(newLocation.getLocationLatitude(), newLocation.getLocationLongitude());
    }
}
