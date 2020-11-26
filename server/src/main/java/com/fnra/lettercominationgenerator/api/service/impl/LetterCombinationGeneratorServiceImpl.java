package com.fnra.lettercominationgenerator.api.service.impl;

import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.fnra.lettercominationgenerator.api.model.Combination;
import com.fnra.lettercominationgenerator.api.service.LetterCombinationGeneratorService;
import com.fnra.lettercominationgenerator.api.utils.LetterCombinationGeneratorUtility;

@Service
@CacheConfig(cacheNames={"combinations"})
public class LetterCombinationGeneratorServiceImpl implements LetterCombinationGeneratorService{

	@Override
	@Cacheable
	public List<Combination> generateLetterCombinations(String phoneNumber) {
		return LetterCombinationGeneratorUtility.generateLettersCombinations(phoneNumber,0,100);
	}

}
