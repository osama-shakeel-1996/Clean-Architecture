package com.example.cleanarchitectureandroiddictionary.feature_dictionary.data.remote.dto

import com.example.cleanarchitectureandroiddictionary.feature_dictionary.domain.model.Definition

data class DefinitionDto(
    val antonyms: List<String>?,
    val definition: String?,
    val synonyms: List<Any>?,
    val example : List<String>?,

){
    fun toDefinition() : Definition {
        return Definition(
            antonyms =  antonyms,
            definition = definition,
            synonyms = synonyms,
            example = example
        )
    }
}