package com.example.day7;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class logger 
{

	Logger logger=LoggerFactory.getLogger(logger.class);
	@GetMapping("/get")
	public String hello()
	{
		logger.trace("A TRACE Message");
	    logger.debug("A DEBUG Message");
	    logger.info("An INFO Message");
	    logger.warn("A WARN MEssage");
	    logger.error("AN ERROR Message");
	    return "Hello Scaler";
	}
	
}
