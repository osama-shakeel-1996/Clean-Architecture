package com.example.cleanarchitectureandroiddictionary.feature_dictionary.domain.model

data class Definition(
    val antonyms: List<String>,
    val definition: String,
    val synonyms: List<Any>,
    val example : List<String>?,
)
