package com.example.Task.FXApplication.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CalculatedWeather {
    double temperatureAvg;
    int temperatureMax;
    int temperatureMin;
    double temperatureMedian;

    double windAvg;
    int windMax;
    int windMin;
    double windMedian;

    double humidityAvg;
    int humidityMax;
    int humidityMin;
    double humidityMedian;

    double precipitationAvg;
    int precipitationMax;
    int precipitationMin;
    double precipitationMedian;
}
