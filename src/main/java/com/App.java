package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.jpa.DBConfig1;
import com.jpa.DBConfig2;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableConfigurationProperties(value = { DBConfig1.class, DBConfig2.class })
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
