package com.example.Task.FXApplication.controller;

import com.example.Task.FXApplication.model.WeatherData;
import com.example.Task.FXApplication.service.*;
import jakarta.mail.MessagingException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

import java.awt.event.ActionEvent;
import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class Controller {
    @FXML
    private ResourceBundle resources;
    private Locale locale;

    @FXML
    private URL location;

    @FXML
    private Button eng;

    @FXML
    private Button german;

    @FXML
    private TextField sendermail;
    @FXML
    private PasswordField passfield;

    @FXML
    private TextField recivieremail;

    @FXML
    private Button sendMailButton;
    @FXML
    private Button chooseFile;

    @FXML
    void initialize() {
        FileReaderService readerService = new FileReaderService();
        CheckLaunchService checkForLaunchService = new CheckLaunchService();
        WeatherAnalyzeService weatherAnalyzeService = new WeatherAnalyzeService();
        EmailSenderService emailSenderService = new EmailSenderService();
        DataParsingService parsingService = new DataParsingService();
        FileWriterService fileWriterService = new FileWriterService();

        File file = new File("D:\\JAVA\\HitachitFX\\src\\main\\resources\\com\\example\\hitachitfx\\result.csv");

        chooseFile.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("CSV files (*.csv)", "*.csv");
            fileChooser.getExtensionFilters().add(extFilter);
            File inputFile = fileChooser.showOpenDialog(chooseFile.getScene().getWindow());

            String[][] data = readerService.reader(inputFile);
            List<WeatherData> weatherDataList = parsingService.parseData(data);
            fileWriterService.writeData(weatherAnalyzeService.analyze(weatherDataList), checkForLaunchService.weatherReport(weatherDataList));
        });

        sendMailButton.setOnAction(event -> {
            String sMail = sendermail.getText();
            String pass = passfield.getText();
            String rMail = recivieremail.getText();
            try {
                emailSenderService.sendEmailWithAttachment(sMail, pass, rMail, file);
            } catch (MessagingException e) {
                throw new RuntimeException(e);
            }
        });

        eng.setOnAction(event -> {
            loadLang("eng");
        });

        german.setOnAction(event -> {
            loadLang("ger");
        });

    }

    private void loadLang(String lang) {
        locale = new Locale(lang);
        resources = ResourceBundle.getBundle("lang", locale);
        sendermail.setText(resources.getString("sendermail"));
        passfield.setText(resources.getString("passfield"));
        recivieremail.setText(resources.getString("reciviermail"));
        sendMailButton.setText(resources.getString("sendEmail"));
        chooseFile.setText(resources.getString("chooseFile"));




    }


}
