package com.fnra.lettercominationgenerator.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fnra.lettercominationgenerator.api.service.LetterCombinationGeneratorService;
import com.fnra.lettercominationgenerator.api.utils.LetterCombinationGeneratorUtility;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@EnableSwagger2
@RequestMapping("/api/v1")
public class LetterCombinationGeneratorController{

	private static final Logger LOGGER = LoggerFactory.getLogger(LetterCombinationGeneratorController.class);

	@Autowired
	private LetterCombinationGeneratorService letterCombinationGeneratorService;


	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/generate-letter-combinations/{phoneNumber}")
	public ResponseEntity<?> generateLetterCombinations(@PathVariable String phoneNumber
			//,@RequestParam(name = "start") int startIndex, 
			//@RequestParam(name = "pageSize") int pageSize
			) {
		try {
			// validate the phone number
			if(!LetterCombinationGeneratorUtility.validatePhoneNumber(phoneNumber)) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			LOGGER.info("Request received for phone {} ", phoneNumber);
			LOGGER.info("Response sent for phone {}", phoneNumber);
			return new ResponseEntity(letterCombinationGeneratorService.generateLetterCombinations(phoneNumber), HttpStatus.OK);
		} catch (Exception ex) {
			LOGGER.error("Exception occured", ex);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
