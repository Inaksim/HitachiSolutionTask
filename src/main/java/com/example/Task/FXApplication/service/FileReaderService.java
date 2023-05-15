package com.example.Task.FXApplication.service;

import com.opencsv.CSVReader;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class FileReaderService {
    public String[][] reader(File file) {
        List<String[]> list = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(file))) {
            String[] row;
            String[] header = reader.readNext();
            while ((row = reader.readNext()) != null) {
                list.add(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        String[][] data = new String[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            data[i] = list.get(i);
        }
        return data;
    }
}
