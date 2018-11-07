package com.gaoyang.springcloud.ribbon.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gaoyang.springcloud.ribbon.service.HelloService;

@RestController
public class HelloControler {

	@Autowired
	private HelloService helloService;

	@GetMapping(value = "/hi")
	public String hi(@RequestParam String name) {
		return this.helloService.hiService(name);
	}
}
