package com.example.Task.FXApplication.service;

import com.example.Task.FXApplication.model.WeatherData;
import java.util.ArrayList;
import java.util.List;

public class DataParsingService {
    public static List<WeatherData> parseData(String[][] csvData) {
        List<WeatherData> dataList = new ArrayList<>();
        for (int i = 1; i < csvData[0].length; i++) {
            WeatherData weatherData = new WeatherData(
                    Integer.parseInt(csvData[0][i]),
                    Integer.parseInt(csvData[1][i]),
                    Integer.parseInt(csvData[2][i]),
                    Integer.parseInt(csvData[3][i]),
                    csvData[4][i],
                    csvData[5][i]);
            dataList.add(weatherData);
        }
        return dataList;
    }
}
