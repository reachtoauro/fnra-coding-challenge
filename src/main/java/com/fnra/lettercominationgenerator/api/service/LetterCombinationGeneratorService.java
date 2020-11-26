package com.fnra.lettercominationgenerator.api.service;

import java.util.List;

import com.fnra.lettercominationgenerator.api.model.Combination;

public interface LetterCombinationGeneratorService {

	List<Combination> generateLetterCombinations(String phoneNumber);

}
