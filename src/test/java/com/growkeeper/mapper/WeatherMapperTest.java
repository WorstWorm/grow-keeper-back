package com.growkeeper.mapper;

import com.growkeeper.domain.Weather;
import com.growkeeper.dto.WeatherDto;
import com.growkeeper.dto.api.openWeatherDto.weather.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WeatherMapperTest {

    @Test
    void mapToWeatherTest() {
        //GIVEN
        WeatherMapper weatherMapper = new WeatherMapper();

        //WHEN
        OpenWeatherMainDto openWeatherMainDto = new OpenWeatherMainDto();
        openWeatherMainDto.setTemp(20.0);
        OpenWeatherWeatherDto openWeatherWeatherDto = new OpenWeatherWeatherDto();
        openWeatherWeatherDto.setMain("Rain");
        ArrayList<OpenWeatherWeatherDto> openWeatherWeatherDtos = new ArrayList<>();
        openWeatherWeatherDtos.add(openWeatherWeatherDto);
        OpenWeatherCloudsDto openWeatherCloudsDto = new OpenWeatherCloudsDto();
        openWeatherCloudsDto.setAll(60);
        OpenWeatherWindDto openWeatherWindDto = new OpenWeatherWindDto();
        openWeatherWindDto.setSpeed(10.0);
        OpenWeatherRainDto openWeatherRainDto = new OpenWeatherRainDto();
        openWeatherRainDto.set_3h(15.0);
        OpenWeatherListDto givenOpenWeatherDto = new OpenWeatherListDto();
        givenOpenWeatherDto.setOpenWeatherMainDto(openWeatherMainDto);
        givenOpenWeatherDto.setOpenWeatherWeatherDto(openWeatherWeatherDtos);
        givenOpenWeatherDto.setOpenWeatherCloudsDto(openWeatherCloudsDto);
        givenOpenWeatherDto.setOpenWeatherWindDto(openWeatherWindDto);
        givenOpenWeatherDto.setOpenWeatherRainDto(openWeatherRainDto);
        givenOpenWeatherDto.setDt_txt("2023-08-14 21:00:00");

        Weather receivedWeather = weatherMapper.mapToWeather(givenOpenWeatherDto);

        Weather expectedWeather = new Weather(20.0, "Rain", 60, 10.0, 15.0, LocalDateTime.of(2023,8,14,21,0,0));

        //THEN
        assertEquals(expectedWeather.getWeatherTemperature(), receivedWeather.getWeatherTemperature());
        assertEquals(expectedWeather.getWeatherType(), receivedWeather.getWeatherType());
        assertEquals(expectedWeather.getWeatherClouds(), receivedWeather.getWeatherClouds());
        assertEquals(expectedWeather.getWeatherWind(), receivedWeather.getWeatherWind());
        assertEquals(expectedWeather.getWeatherRain(), receivedWeather.getWeatherRain());
        assertEquals(expectedWeather.getWeatherTime(), receivedWeather.getWeatherTime());
    }

    @Test
    void mapToWeatherDtoTest() {
        //GIVEN
        WeatherMapper weatherMapper = new WeatherMapper();

        //WHEN
        Weather givenWeather = new Weather(20.0, "Rain", 60, 10.0, 15.0, LocalDateTime.of(2023,8,14,21,0,0));

        WeatherDto receivedWeather = weatherMapper.mapToWeatherDto(givenWeather);

        WeatherDto expectedWeather = new WeatherDto(20.0, "Rain", 60, 10.0, 15.0, LocalDateTime.of(2023,8,14,21,0,0));

        //THEN
        assertEquals(expectedWeather.getWeatherTemperature(), receivedWeather.getWeatherTemperature());
        assertEquals(expectedWeather.getWeatherType(), receivedWeather.getWeatherType());
        assertEquals(expectedWeather.getWeatherClouds(), receivedWeather.getWeatherClouds());
        assertEquals(expectedWeather.getWeatherWind(), receivedWeather.getWeatherWind());
        assertEquals(expectedWeather.getWeatherRain(), receivedWeather.getWeatherRain());
        assertEquals(expectedWeather.getWeatherTime(), receivedWeather.getWeatherTime());
    }

    @Test
    void mapToWeatherListTest() {
        //GIVEN
        WeatherMapper weatherMapper = new WeatherMapper();

        //WHEN
        OpenWeatherMainDto openWeatherMainDto1 = new OpenWeatherMainDto();
        openWeatherMainDto1.setTemp(20.0);
        OpenWeatherWeatherDto openWeatherWeatherDto1 = new OpenWeatherWeatherDto();
        openWeatherWeatherDto1.setMain("Rain");
        ArrayList<OpenWeatherWeatherDto> openWeatherWeatherDtos1 = new ArrayList<>();
        openWeatherWeatherDtos1.add(openWeatherWeatherDto1);
        OpenWeatherCloudsDto openWeatherCloudsDto1 = new OpenWeatherCloudsDto();
        openWeatherCloudsDto1.setAll(60);
        OpenWeatherWindDto openWeatherWindDto1 = new OpenWeatherWindDto();
        openWeatherWindDto1.setSpeed(10.0);
        OpenWeatherRainDto openWeatherRainDto1 = new OpenWeatherRainDto();
        openWeatherRainDto1.set_3h(15.0);
        OpenWeatherListDto givenOpenWeatherDto1 = new OpenWeatherListDto();
        givenOpenWeatherDto1.setOpenWeatherMainDto(openWeatherMainDto1);
        givenOpenWeatherDto1.setOpenWeatherWeatherDto(openWeatherWeatherDtos1);
        givenOpenWeatherDto1.setOpenWeatherCloudsDto(openWeatherCloudsDto1);
        givenOpenWeatherDto1.setOpenWeatherWindDto(openWeatherWindDto1);
        givenOpenWeatherDto1.setOpenWeatherRainDto(openWeatherRainDto1);
        givenOpenWeatherDto1.setDt_txt("2023-08-14 21:00:00");

        OpenWeatherMainDto openWeatherMainDto2 = new OpenWeatherMainDto();
        openWeatherMainDto2.setTemp(0.5);
        OpenWeatherWeatherDto openWeatherWeatherDto2 = new OpenWeatherWeatherDto();
        openWeatherWeatherDto2.setMain("Snow");
        ArrayList<OpenWeatherWeatherDto> openWeatherWeatherDtos2 = new ArrayList<>();
        openWeatherWeatherDtos2.add(openWeatherWeatherDto2);
        OpenWeatherCloudsDto openWeatherCloudsDto2 = new OpenWeatherCloudsDto();
        openWeatherCloudsDto2.setAll(100);
        OpenWeatherWindDto openWeatherWindDto2 = new OpenWeatherWindDto();
        openWeatherWindDto2.setSpeed(17.0);
        OpenWeatherRainDto openWeatherRainDto2 = new OpenWeatherRainDto();
        openWeatherRainDto2.set_3h(0.0);
        OpenWeatherListDto givenOpenWeatherDto2 = new OpenWeatherListDto();
        givenOpenWeatherDto2.setOpenWeatherMainDto(openWeatherMainDto2);
        givenOpenWeatherDto2.setOpenWeatherWeatherDto(openWeatherWeatherDtos2);
        givenOpenWeatherDto2.setOpenWeatherCloudsDto(openWeatherCloudsDto2);
        givenOpenWeatherDto2.setOpenWeatherWindDto(openWeatherWindDto2);
        givenOpenWeatherDto2.setOpenWeatherRainDto(openWeatherRainDto2);
        givenOpenWeatherDto2.setDt_txt("2023-12-10 12:00:00");

        ArrayList<OpenWeatherListDto> givenOpenWeatherDtos = new ArrayList<>();
        givenOpenWeatherDtos.add(givenOpenWeatherDto1);
        givenOpenWeatherDtos.add(givenOpenWeatherDto2);

        Weather expectedWeather1 = new Weather(20.0, "Rain", 60, 10.0, 15.0, LocalDateTime.of(2023,8,14,21,0,0));
        Weather expectedWeather2 = new Weather(0.5, "Snow", 100, 17.0, 0.0, LocalDateTime.of(2023,12,10,12,0,0));

        List<Weather> receivedWeatherList = weatherMapper.mapToWeatherList(givenOpenWeatherDtos);

        List<Weather> expectedWeatherList = new ArrayList<>();
        expectedWeatherList.add(expectedWeather1);
        expectedWeatherList.add(expectedWeather2);

        //THEN
        for(int i=0; i<receivedWeatherList.size(); i++) {
            assertEquals(expectedWeatherList.get(i).getWeatherTemperature(), receivedWeatherList.get(i).getWeatherTemperature());
            assertEquals(expectedWeatherList.get(i).getWeatherType(), receivedWeatherList.get(i).getWeatherType());
            assertEquals(expectedWeatherList.get(i).getWeatherClouds(), receivedWeatherList.get(i).getWeatherClouds());
            assertEquals(expectedWeatherList.get(i).getWeatherWind(), receivedWeatherList.get(i).getWeatherWind());
            assertEquals(expectedWeatherList.get(i).getWeatherRain(), receivedWeatherList.get(i).getWeatherRain());
            assertEquals(expectedWeatherList.get(i).getWeatherTime(), receivedWeatherList.get(i).getWeatherTime());
        }

    }

    @Test
    void mapToWeatherDtoListTest() {
        //GIVEN
        WeatherMapper weatherMapper = new WeatherMapper();

        //WHEN
        Weather givenWeather1 = new Weather(20.0, "Rain", 60, 10.0, 15.0, LocalDateTime.of(2023,8,14,21,0,0));
        Weather givenWeather2 = new Weather(0.5, "Snow", 100, 17.0, 0.0, LocalDateTime.of(2023,12,10,12,0,0));

        List<Weather> givenWeatherList = new ArrayList<>();
        givenWeatherList.add(givenWeather1);
        givenWeatherList.add(givenWeather2);

        List<WeatherDto> receivedWeatherDtoList = weatherMapper.mapToWeatherDtoList(givenWeatherList);
        WeatherDto expectedWeather1 = new WeatherDto(20.0, "Rain", 60, 10.0, 15.0, LocalDateTime.of(2023,8,14,21,0,0));
        WeatherDto expectedWeather2 = new WeatherDto(0.5, "Snow", 100, 17.0, 0.0, LocalDateTime.of(2023,12,10,12,0,0));

        List<WeatherDto> expectedWeatherDtoList = new ArrayList<>();
        expectedWeatherDtoList.add(expectedWeather1);
        expectedWeatherDtoList.add(expectedWeather2);

        //THEN
        for(int i=0; i<receivedWeatherDtoList.size(); i++) {
            assertEquals(expectedWeatherDtoList.get(i).getWeatherTemperature(), receivedWeatherDtoList.get(i).getWeatherTemperature());
            assertEquals(expectedWeatherDtoList.get(i).getWeatherType(), receivedWeatherDtoList.get(i).getWeatherType());
            assertEquals(expectedWeatherDtoList.get(i).getWeatherClouds(), receivedWeatherDtoList.get(i).getWeatherClouds());
            assertEquals(expectedWeatherDtoList.get(i).getWeatherWind(), receivedWeatherDtoList.get(i).getWeatherWind());
            assertEquals(expectedWeatherDtoList.get(i).getWeatherRain(), receivedWeatherDtoList.get(i).getWeatherRain());
            assertEquals(expectedWeatherDtoList.get(i).getWeatherTime(), receivedWeatherDtoList.get(i).getWeatherTime());
        }
    }
}