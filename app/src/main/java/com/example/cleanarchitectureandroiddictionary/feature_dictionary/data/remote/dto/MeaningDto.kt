package com.example.cleanarchitectureandroiddictionary.feature_dictionary.data.remote.dto

import com.example.cleanarchitectureandroiddictionary.feature_dictionary.domain.model.Meaning

data class MeaningDto(
    var antonyms: List<Any>?,
    var definitions: List<DefinitionDto>?,
    var partOfSpeech: String?,
    var synonyms: List<Any>?
){
    fun toMeaning() : Meaning {
            return Meaning(
                definitions = definitions!!.map { it.toDefinition() },
                partOfSpeech= partOfSpeech
            )
    }
}