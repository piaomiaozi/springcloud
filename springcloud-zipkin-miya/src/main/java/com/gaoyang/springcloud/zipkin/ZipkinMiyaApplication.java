package com.gaoyang.springcloud.zipkin;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import brave.sampler.Sampler;

/**
 * EurekaClient启动类
 * 
 * @author gaoyang
 *
 */
@SpringBootApplication
@RestController
public class ZipkinMiyaApplication {

	private static final Logger log = Logger.getLogger(ZipkinMiyaApplication.class.getName());

	@Autowired
	private RestTemplate restTemplate;

	@Bean
	RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@Bean
	Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}

	public static void main(String[] args) {
		SpringApplication.run(ZipkinMiyaApplication.class, args);
	}

	@RequestMapping("/hi")
	public String home() {
		log.log(Level.INFO, "hi is being called");
		return "hi i'm miya!";
	}

	@RequestMapping("/miya")
	public String info() {
		log.log(Level.INFO, "info is being called");
		return restTemplate.getForObject("http://localhost:8988/info", String.class);
	}
}
