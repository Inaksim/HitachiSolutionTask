package com.example.Task.FXApplication.service;

import com.example.Task.FXApplication.model.WeatherData;

import java.util.ArrayList;
import java.util.List;

public class CheckLaunchService {
    public List<WeatherData> weatherReport(List<WeatherData> weatherData) {
        for(WeatherData row : weatherData) {
            if(row.getTemperature() > 2 && row.getTemperature() < 31 &&
                    row.getWind() < 10 &&
                    row.getHumidity() < 60 &&
                    row.getPrecipitation() == 0 &&
                    row.getLightning().equals("No") &&
                    !row.getClouds().equals("Comulus") && !row.getClouds().equals("Nimbus") ) {
                WeatherData finalData = new WeatherData(row.getTemperature(), row.getWind(), row.getHumidity(), row.getPrecipitation(), row.getLightning(), row.getClouds());
                List<WeatherData> finaList = new ArrayList<>();
                finaList.add(finalData);
                return finaList;
            }
        }
        return null;
    }
}
