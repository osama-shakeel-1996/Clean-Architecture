package com.example.cleanarchitectureandroiddictionary.feature_dictionary.domain.model

import com.example.cleanarchitectureandroiddictionary.feature_dictionary.data.remote.dto.DefinitionDto

data class Meaning(
    var definitions: List<Definition>,
    var partOfSpeech: String
)
