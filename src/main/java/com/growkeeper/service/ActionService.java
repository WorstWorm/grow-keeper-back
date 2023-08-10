package com.growkeeper.service;

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
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ActionService {
    @Autowired
    AreaService areaService;
    @Autowired
    PlantService plantService;
    @Autowired
    WeatherService weatherService;
    @Autowired
    EventService eventService;
    @Autowired
    WeatherMapper weatherMapper;
    @Autowired
    AreaMapper areaMapper;
    @Autowired
    EventMapper eventMapper;
    @Autowired
    PlantMapper plantMapper;
    Map<AreaDto, PlantDto> plantsAtAreas = new HashMap<>();

    public void neededActionCheck() {
        List<EventDto> neededActions = new ArrayList<>();
        List<WeatherDto> incomingWeather = weatherMapper.mapToWeatherDtoList(weatherService.getWeathers());
        List<AreaDto> areas = areaMapper.mapToAreaDtoList(areaService.getAreas());
        for(AreaDto a : areas) {
            if(!a.getAreaScientificName().equals(" ")) {
                plantsAtAreas.put(a, plantMapper.mapToPlantDto(plantService.getPlant(a.getAreaScientificName())));
            }
        }
        for(Map.Entry<AreaDto, PlantDto> entry : plantsAtAreas.entrySet()) {
            neededActions.addAll(isSunProtectNeeded(entry.getKey().getAreaId(), entry.getValue(), incomingWeather));
            neededActions.addAll(isWindProtectNeeded(entry.getKey().getAreaId(), entry.getKey().getAreaCovered(), incomingWeather));
            neededActions.addAll(isColdProtectNeeded(entry.getKey().getAreaId(), incomingWeather));
        }
        eventService.addEvents(eventMapper.mapToEventList(neededActions));
    }

    private List<EventDto> isSunProtectNeeded(int area, PlantDto plant, List<WeatherDto> incomingWeather) {
        List<EventDto> actionToBeAdded = new ArrayList<>();
        for(WeatherDto w : incomingWeather) {
            if(w.getWeatherTemperature()>25.0 && w.getWeatherClouds() < 15 && plant.getPlantSunlight()!= InsolationOptions.FULL_SUN) {
                actionToBeAdded.add(new EventDto(area, ActionOptions.SUN_PROTECT, w.getWeatherTime().toLocalDate()));
            } else if (w.getWeatherTemperature()>30.0 && plant.getPlantSunlight()!= InsolationOptions.FULL_SUN) {
                actionToBeAdded.add(new EventDto(area, ActionOptions.SUN_PROTECT, w.getWeatherTime().toLocalDate()));
            }
        }
        actionToBeAdded = actionToBeAdded.stream().distinct().collect(Collectors.toList());
        return actionToBeAdded;
    }

    private List<EventDto> isWindProtectNeeded(int area, boolean covered, List<WeatherDto> incomingWeather) {
        List<EventDto> actionToBeAdded = new ArrayList<>();
        for(WeatherDto w : incomingWeather) {
            if(w.getWeatherWind()>14.0 && !covered) {
                actionToBeAdded.add(new EventDto(area, ActionOptions.WIND_PROTECT, w.getWeatherTime().toLocalDate()));
            } else if (w.getWeatherWind()>17.5) {
                actionToBeAdded.add(new EventDto(area, ActionOptions.WIND_PROTECT, w.getWeatherTime().toLocalDate()));
            }
        }
        actionToBeAdded = actionToBeAdded.stream().distinct().collect(Collectors.toList());
        return actionToBeAdded;
    }

    private List<EventDto> isColdProtectNeeded(int area, List<WeatherDto> incomingWeather) {
        List<EventDto> actionToBeAdded = new ArrayList<>();
        for(WeatherDto w : incomingWeather) {
            if (w.getWeatherTemperature() < 18) {
                actionToBeAdded.add(new EventDto(area, ActionOptions.COLD_PROTECT, w.getWeatherTime().toLocalDate()));
            }
        }
        actionToBeAdded = actionToBeAdded.stream().distinct().collect(Collectors.toList());
        return actionToBeAdded;
    }
}
