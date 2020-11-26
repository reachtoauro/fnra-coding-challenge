package com.fnra.lettercominationgenerator.api.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fnra.lettercominationgenerator.api.model.Combination;

@Component
public class LetterCombinationGeneratorUtility {

	private static final Logger LOGGER = LoggerFactory.getLogger(LetterCombinationGeneratorUtility.class);

	public static boolean validatePhoneNumber(String phoneNo) {
		try {
			// digits only validation and either 7 or 10 digits
			if (!phoneNo.matches("^[0-9]*$") && phoneNo.length() != 7 && phoneNo.length() != 10)
				return false;
			return true;
		} catch (Exception npe) {
			LOGGER.error("Error while validating phone", npe);
			return false;
		}

	}

	public static List<Combination> generateLettersCombinations(String phoneNumber, int startIndex, int endIndex) {
		int count=0;
		List<Combination> response = new ArrayList<>();
		
		HashMap<Character, String> mapDigits = new HashMap<>();
		// map to stores all characters that corresponds to that digit in phone
		mapDigits.put('1', "1");
		mapDigits.put('2', "ABC");
		mapDigits.put('3', "DEF");
		mapDigits.put('4', "GHI");
		mapDigits.put('5', "JKL");
		mapDigits.put('6', "MNO");
		mapDigits.put('7', "PQRS");
		mapDigits.put('8', "TUV");
		mapDigits.put('9', "WXYZ");
		mapDigits.put('0', "0");

		List<String> result = new ArrayList<>();
		if (phoneNumber == null || phoneNumber.length() == 0) {
			return null;
		}

		result.add("");

		for (int i = 0; i < phoneNumber.length(); i++) {
			ArrayList<String> tempArr = new ArrayList<>();
			String option = mapDigits.get(phoneNumber.charAt(i));

			for (int j = 0; j < result.size(); j++) {
				for (int p = 0; p < option.length(); p++) {
					count++;
					if(count >= startIndex && count <= endIndex) {
						tempArr.add(new StringBuilder(result.get(j)).append(option.charAt(p)).toString());
					}
					
				}
			}

			result.clear();
			if(!tempArr.isEmpty())
				result.addAll(tempArr);
		}
		for(int i=0; i<result.size(); i++) {
			Combination combination = new Combination();
			combination.setCombination(result.get(i));
			combination.setIndex(i);
			response.add(combination);
		}
			
		return response;
	}
}
