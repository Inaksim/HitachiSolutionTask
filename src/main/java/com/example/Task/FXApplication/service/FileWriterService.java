package com.example.Task.FXApplication.service;

import com.example.Task.FXApplication.model.CalculatedWeather;
import com.example.Task.FXApplication.model.WeatherData;
import com.opencsv.CSVWriter;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileWriterService {
    public static void writeData(List<CalculatedWeather> stats, List<WeatherData> launchDay) {
        File file = new File("D:\\JAVA\\HitachitFX\\src\\main\\resources\\com\\example\\hitachitfx\\result.csv");
        try (FileWriter outputFile = new FileWriter(file)) {
            CSVPrinter csvPrinter = new CSVPrinter(outputFile, CSVFormat.DEFAULT.withDelimiter(';'));
            CSVWriter writer = new CSVWriter(outputFile);

            String[] header = {" ", "Temperature", "Wind(m/s)", "Humidity(%)", "Precipitation(%)"};
            String[] avgRow = {"Average"};
            String[] maxRow = {"Max"};
            String[] minRow = {"Min"};
            String[] medRow = {"Mid"};
            String[] dayForLaunchRow = {"Launch day"};
            writer.writeNext(header);

            String[] avgData = new String[0];
            String[] maxData = new String[0];
            String[] minData = new String[0];
            String[] medData = new String[0];
            String[] dayForLaunch = new String[0];

            for (CalculatedWeather data : stats) {
                avgData = (new String[]{String.valueOf(data.getTemperatureAvg()), String.valueOf(data.getWindAvg()), String.valueOf(data.getHumidityAvg()), String.valueOf(data.getPrecipitationAvg())});
                maxData = (new String[]{String.valueOf(data.getTemperatureMax()), String.valueOf(data.getWindMax()), String.valueOf(data.getHumidityMax()), String.valueOf(data.getPrecipitationMax())});
                minData = (new String[]{String.valueOf(data.getTemperatureMin()), String.valueOf(data.getWindMin()), String.valueOf(data.getHumidityMin()), String.valueOf(data.getPrecipitationMin())});
                medData = (new String[]{String.valueOf(data.getTemperatureMedian()), String.valueOf(data.getWindMedian()), String.valueOf(data.getHumidityMedian()), String.valueOf(data.getPrecipitationMedian())});
            }

            for (WeatherData data : launchDay) {
                dayForLaunch = (new String[]{String.valueOf(data.getTemperature()), String.valueOf(data.getWind()), String.valueOf(data.getHumidity()), String.valueOf(data.getPrecipitation()), String.valueOf(data.getLightning()), String.valueOf(data.getClouds())});
            }
            writer.writeNext(uniteArrays(avgRow, avgData));
            writer.writeNext(uniteArrays(maxRow, maxData));
            writer.writeNext(uniteArrays(minRow, minData));
            writer.writeNext(uniteArrays(medRow, medData));
            writer.writeNext(uniteArrays(dayForLaunchRow, dayForLaunch));
            csvPrinter.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static String[] uniteArrays(String[] arr1, String[] arr2){
        String[] res = new String[arr1.length + arr2.length];
        System.arraycopy(arr1, 0, res, 0, arr1.length );
        System.arraycopy(arr2, 0, res, arr1.length, arr2.length);
        return res;
    }
}

