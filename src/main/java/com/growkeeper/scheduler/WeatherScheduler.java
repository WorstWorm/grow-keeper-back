package com.growkeeper.scheduler;

import com.growkeeper.clients.OpenWeatherClient;
import com.growkeeper.domain.Location;
import com.growkeeper.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WeatherScheduler {

    private final OpenWeatherClient openWeatherClient;
    private final LocationService locationService;

    @Scheduled(cron = "0 10 */3 * * *")
    public void updateWeather() {
        Location location = locationService.getLocation();
        openWeatherClient.getWeather(location.getLocationLatitude(), location.getLocationLongitude());
    }
}
