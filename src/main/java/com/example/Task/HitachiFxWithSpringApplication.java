package com.example.Task;

import com.example.Task.FXApplication.App;
import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class HitachiFxWithSpringApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(HitachiFxWithSpringApplication.class, args);
		Application.launch(App.class, args);
		context.close();

	}


}
