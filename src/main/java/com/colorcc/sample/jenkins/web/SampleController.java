package com.colorcc.sample.jenkins.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/sample")
public class SampleController {
	
	@RequestMapping(value="/hello", method=RequestMethod.GET)
	public String hello() {
		return "Hello world.";
	}

}
