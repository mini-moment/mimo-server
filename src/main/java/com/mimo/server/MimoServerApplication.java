
package com.mimo.server;

import java.io.File;

import org.springframework.beans.factory.annotation.Value;
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
	
	@Value("${path.videoStoragePath}")
	private String videoStoragePath;

	@Bean
	public boolean createVideoDirectory() {
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
