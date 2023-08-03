package com.growkeeper.clients;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.growkeeper.config.OpenWeatherConfig;
import com.growkeeper.dto.OpenWeatherObjectDto;
import com.growkeeper.weatherDto.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
@RequiredArgsConstructor
public class OpenWeatherClient {
    private final OpenWeatherConfig openWeatherConfig;
    private final RestTemplate restTemplate;

    private URI buildUrlForWeather(String lat, String lon) {
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

    public void getWeather(String lat, String lon) throws JsonProcessingException {
        String data = restTemplate.getForObject(buildUrlForWeather(lat, lon), String.class);
        data = data.substring(data.indexOf("\"list\":")+7, data.lastIndexOf(",\"city\":"));
        System.out.println(data);
        ObjectMapper om = new ObjectMapper();
        Root[] roots = om.readValue(data, Root[].class);
        for(Root r : roots){
            System.out.println(r.getDt_txt() + " - "
                    + r.getWeather().get(0).getMain() + "; "
                    + "temp: " + r.getMain().getTemp() + "; "
                    + "wind: " + r.getWind().getSpeed() + "; "
//                    + "rain: " + r.getRain().get_3h() + "; "
                    + "clouds: " + r.getClouds().getAll() + ";");
        }
    }

    public void getLocation(String city) {
        String data = restTemplate.getForObject(buildUrlForLocation(city), String.class);
        String lat = data.substring((data.indexOf("\"lat\":"))+6, (data.lastIndexOf(",\"lon\":")));
        String lon = data.substring((data.indexOf("\"lon\":"))+6, (data.lastIndexOf(",\"country")));
        System.out.println(lat+"/"+lon);

    }
}
