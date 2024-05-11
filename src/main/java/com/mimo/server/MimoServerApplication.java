
package com.mimo.server;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class MimoServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MimoServerApplication.class, args);
	}

	@Bean
	public boolean createVideoDirectory() {
		String videoStoragePath = System.getProperty("user.dir").toString() + "/video";
		File Folder = new File(videoStoragePath);

		if (!Folder.exists()) {
			try {
				Folder.mkdir();
			} catch (Exception e) {
				e.getStackTrace();
			}
		}
		return true;
	}
}
