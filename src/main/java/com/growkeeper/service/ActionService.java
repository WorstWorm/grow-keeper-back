package com.growkeeper.service;

import com.growkeeper.config.WateringParametersConfig;
import com.growkeeper.config.WeatherParametersConfig;
import com.growkeeper.dto.AreaDto;
import com.growkeeper.dto.EventDto;
import com.growkeeper.dto.PlantDto;
import com.growkeeper.dto.WeatherDto;
import com.growkeeper.enums.ActionOptions;
import com.growkeeper.enums.InsolationOptions;
import com.growkeeper.mapper.AreaMapper;
import com.growkeeper.mapper.EventMapper;
import com.growkeeper.mapper.PlantMapper;
import com.growkeeper.mapper.WeatherMapper;
import com.growkeeper.observer.AreaObserver;
import com.growkeeper.observer.WeatherObserver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ActionService implements WeatherObserver, AreaObserver {
    private final AreaService areaService;
    private final PlantService plantService;
    private final WeatherService weatherService;
    private final EventService eventService;
    private final WeatherMapper weatherMapper;
    private final AreaMapper areaMapper;
    private final EventMapper eventMapper;
    private final PlantMapper plantMapper;

    private final WeatherParametersConfig weather = new WeatherParametersConfig();
    private final WateringParametersConfig water = new WateringParametersConfig();

    final Map<AreaDto, PlantDto> plantsAtAreas = new HashMap<>();

    private void addAreasWithPlants(List<AreaDto> areas) {
        for(AreaDto a : areas) {
            if(a.getAreaScientificName()!=null) {
                plantsAtAreas.put(a, plantMapper.mapToPlantDto(plantService.getPlant(a.getAreaScientificName())));
            }
        }
    }

    public void neededActionCheck() {
        List<EventDto> neededActions = new ArrayList<>();
        List<WeatherDto> incomingWeather = weatherMapper.mapToWeatherDtoList(weatherService.getWeathers());

        List<AreaDto> areas = areaMapper.mapToAreaDtoList(areaService.getAreas());
        addAreasWithPlants(areas);
        for(Map.Entry<AreaDto, PlantDto> entry : plantsAtAreas.entrySet()) {
            neededActions.addAll(isSunProtectNeeded(entry.getKey().getAreaId(), entry.getValue(), incomingWeather));
            neededActions.addAll(isWindProtectNeeded(entry.getKey().getAreaId(), entry.getKey().getAreaCovered(), incomingWeather));
            neededActions.addAll(isColdProtectNeeded(entry.getKey().getAreaId(), incomingWeather));
            neededActions.addAll(isWateringNeeded(entry.getKey().getAreaId(), entry.getValue(), incomingWeather));
        }

        eventService.addEvents(eventMapper.mapToEventList(neededActions));
    }

    private List<EventDto> isSunProtectNeeded(int area, PlantDto plantOnArea, List<WeatherDto> incomingWeather) {
        List<EventDto> actionToBeAdded = new ArrayList<>();
        for(WeatherDto w : incomingWeather) {
            if(w.getWeatherTemperature() > weather.getTemperature_high()
                    && w.getWeatherClouds() < weather.getClouds_high()
                    && plantOnArea.getPlantSunlight() != InsolationOptions.FULL_SUN) {
                actionToBeAdded.add(new EventDto(area, ActionOptions.SUN_PROTECT, w.getWeatherTime().toLocalDate()));
            } else if (w.getWeatherTemperature() > weather.getTemperature_veryhigh()
                    && plantOnArea.getPlantSunlight() != InsolationOptions.FULL_SUN) {
                actionToBeAdded.add(new EventDto(area, ActionOptions.SUN_PROTECT, w.getWeatherTime().toLocalDate()));
            }
        }
        actionToBeAdded = actionToBeAdded.stream().distinct().collect(Collectors.toList());
        return actionToBeAdded;
    }

    private List<EventDto> isWindProtectNeeded(int area, boolean isAreaCoveredFromTheSun, List<WeatherDto> incomingWeather) {
        List<EventDto> actionToBeAdded = new ArrayList<>();
        for(WeatherDto w : incomingWeather) {
            if(w.getWeatherWind() > weather.getWind_strong() && !isAreaCoveredFromTheSun) {
                actionToBeAdded.add(new EventDto(area, ActionOptions.WIND_PROTECT, w.getWeatherTime().toLocalDate()));
            } else if (w.getWeatherWind() > weather.getWind_verystrong()) {
                actionToBeAdded.add(new EventDto(area, ActionOptions.WIND_PROTECT, w.getWeatherTime().toLocalDate()));
            }
        }
        actionToBeAdded = actionToBeAdded.stream().distinct().collect(Collectors.toList());
        return actionToBeAdded;
    }

    private List<EventDto> isColdProtectNeeded(int area, List<WeatherDto> incomingWeather) {
        List<EventDto> actionToBeAdded = new ArrayList<>();
        for(WeatherDto w : incomingWeather) {
            if (w.getWeatherTemperature() < weather.getTemperature_low()) {
                actionToBeAdded.add(new EventDto(area, ActionOptions.COLD_PROTECT, w.getWeatherTime().toLocalDate()));
            }
        }
        actionToBeAdded = actionToBeAdded.stream().distinct().collect(Collectors.toList());
        return actionToBeAdded;
    }

    private List<EventDto> isWateringNeeded(int area, PlantDto plantOnArea, List<WeatherDto> incomingWeather) {
        List<EventDto> actionToBeAdded = new ArrayList<>();
        int hotDaysInWeek = 0;
        for(WeatherDto w : incomingWeather) {
            if(w.getWeatherTemperature() > weather.getTemperature_high()) {
                hotDaysInWeek++;
            }
            if(w.getWeatherTemperature() < weather.getTemperature_low()) {
                hotDaysInWeek--;
            }
        }
        hotDaysInWeek = hotDaysInWeek/8;

        int wateringFrequency;
        switch (plantOnArea.getPlantWatering()) {
            case FREQUENT -> {
                wateringFrequency = water.getFrequent();
                break;
            }
            case AVERAGE -> {
                wateringFrequency = water.getAverage();
                break;
            }
            case MINIMUM -> {
                wateringFrequency = water.getMinimum();
                break;
            }
            default -> wateringFrequency = -1;
        }
        if(wateringFrequency > 0) {
            wateringFrequency = wateringFrequency / hotDaysInWeek;
            for(int i=1; i<=5; i+=wateringFrequency) {
                actionToBeAdded.add(new EventDto(area, ActionOptions.WATER, LocalDate.now().plusDays(wateringFrequency)));
            }
        }

        return actionToBeAdded;
    }

    @Override
    public void areaChanged() {
        neededActionCheck();
    }

    @Override
    public void weatherChanged() {
        neededActionCheck();
    }
}
