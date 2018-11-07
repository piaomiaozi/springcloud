package com.gaoyang.springcloud.feign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gaoyang.springcloud.feign.service.SchedualServiceHi;

@RestController
public class HiController {

	@Autowired
	private SchedualServiceHi schedualServiceHi;

	@GetMapping(value = "/hi")
	public String sayHi(@RequestParam String name) {
		return this.schedualServiceHi.sayHiFromClientOne(name);
	}
}
