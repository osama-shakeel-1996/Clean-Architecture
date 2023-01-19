package com.example.cleanarchitectureandroiddictionary.feature_dictionary.domain.model

import com.example.cleanarchitectureandroiddictionary.feature_dictionary.data.remote.dto.MeaningDto
import com.example.cleanarchitectureandroiddictionary.feature_dictionary.data.remote.dto.PhoneticDto

data class WordInfo(
                    var meanings: List<Meaning>?,
                    var phonetic: String?,
                    var word: String?,
                    var origin: String?
                    )
