package com.example.cleanarchitectureandroiddictionary.feature_dictionary.domain.repository

import com.example.cleanarchitectureandroiddictionary.core.util.Resource
import com.example.cleanarchitectureandroiddictionary.feature_dictionary.domain.model.WordInfo
import kotlinx.coroutines.flow.Flow


interface WordInfoRepository {
    fun getWordInfo(word : String?): Flow<Resource<List<WordInfo>>>
}