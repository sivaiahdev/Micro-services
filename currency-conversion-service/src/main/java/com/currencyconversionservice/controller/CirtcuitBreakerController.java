package com.currencyconversionservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
public class CirtcuitBreakerController {
	@GetMapping("/sample-api")
	//@Retry(name = "sample-api", fallbackMethod = "hardCodeResponse")
	//@RateLimiter(name="default")
	//@Bulkhead(name="default")//concurrent calls
	@CircuitBreaker(name = "sample-api", fallbackMethod = "hardCodeResponse")
	public String sampleApi() {
		ResponseEntity<String> response = new RestTemplate().getForEntity("http://localhost:8080/some-dum", null,
				String.class);
		return response.getBody();
	}

	public String hardCodeResponse(Exception ex) {
		return "Fallbackresponse";

	}

}
