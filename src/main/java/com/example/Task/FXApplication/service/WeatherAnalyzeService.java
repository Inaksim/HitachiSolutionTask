package com.example.Task.FXApplication.service;

import com.example.Task.FXApplication.model.CalculatedWeather;
import com.example.Task.FXApplication.model.WeatherData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WeatherAnalyzeService {
    public List<CalculatedWeather> analyze (List<WeatherData> dataList) {
        int temperatureSum = 0;
        int windSum = 0;
        int humiditySum = 0;
        int precipitationSum = 0;
        List<String> cloudsList = new ArrayList<>();

        List<Integer> temperatureList = new ArrayList<>();
        List<Integer> windList = new ArrayList<>();
        List<Integer> humidityList = new ArrayList<>();
        List<Integer> precipitationList = new ArrayList<>();

        for (WeatherData data : dataList) {
            temperatureSum += data.getTemperature();
            windSum += data.getWind();
            humiditySum += data.getHumidity();
            precipitationSum += data.getPrecipitation();


            cloudsList.add(data.getClouds());

            temperatureList.add(data.getTemperature());
            windList.add(data.getWind());
            humidityList.add(data.getHumidity());
            precipitationList.add(data.getPrecipitation());
        }

        double temperatureAvg = (double) temperatureSum / dataList.size();
        int temperatureMax = Collections.max(temperatureList);
        int temperatureMin = Collections.min(temperatureList);
        double temperatureMedian = calculateMedian(temperatureList);

        double windAvg = (double) windSum / dataList.size();
        int windMax = Collections.max(windList);
        int windMin = Collections.min(windList);
        double windMedian = calculateMedian(windList);

        double humidityAvg = (double) humiditySum / dataList.size();
        int humidityMax = Collections.max(humidityList);
        int humidityMin = Collections.min(humidityList);
        double humidityMedian = calculateMedian(humidityList);

        double precipitationAvg = (double) precipitationSum / dataList.size();
        int precipitationMax = Collections.max(precipitationList);
        int precipitationMin = Collections.min(precipitationList);
        double precipitationMedian = calculateMedian(precipitationList);
        CalculatedWeather stats = new CalculatedWeather(
                temperatureAvg, temperatureMax, temperatureMin, temperatureMedian,
                windAvg, windMax, windMin, windMedian,
                humidityAvg, humidityMax, humidityMin, humidityMedian,
                precipitationAvg, precipitationMax, precipitationMin, precipitationMedian
        );
        List<CalculatedWeather> list = new ArrayList<>();
        list.add(stats);
        return list;

    }

    private static double calculateMedian(List<Integer> list) {
        int size = list.size();
        Collections.sort(list);

        if (size % 2 == 0) {
            int middle = size / 2;
            return (double) (list.get(middle - 1) + list.get(middle)) / 2;
        } else {
            int middle = size / 2;
            return list.get(middle);
        }
    }
}
