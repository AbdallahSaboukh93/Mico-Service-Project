package com.springdatarest.springdatarest.controller;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class MainController {

	@Value("${spring.application.name}")
	private String appName;

	@Value("${server.port}")
	private String serverPort;
	// Logger logger = LoggerFactory.getLogger(MainController.class);
	private static final Logger logger = LogManager.getLogger(MainController.class);

	@GetMapping
	public String getTest() {
		logger.info("Entering into method getInvoice()");
		try {
			logger.info("finding Invices");
			throw new RuntimeException(
					"project " + appName + " on port" + serverPort + " has Exception" + "Invoice not available");
		} catch (Exception e) {
			logger.error(" Unable to find invoice" + e.getMessage());
			e.printStackTrace();
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			logger.error("Exception is -: " + sw.toString());
		}
		return "test method";

	}

}
