package com.example.Task.FXApplication.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WeatherData {

    private int temperature;
    private int wind;
    private int humidity;
    private int precipitation;
    private String lightning;
    private String clouds;
}
