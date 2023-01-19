package com.example.cleanarchitectureandroiddictionary.feature_dictionary.data.remote.dto

import android.webkit.WebStorage
import com.example.cleanarchitectureandroiddictionary.feature_dictionary.data.local.entities.WordInfoEntity
import com.example.cleanarchitectureandroiddictionary.feature_dictionary.domain.model.WordInfo

data class WordInfoDto(
    var meanings: List<MeaningDto>?,
    var phonetic: String?,
    var phonetics: List<PhoneticDto>?,
    var sourceUrls: List<String>?,
    var word: String?,
    var origin: String?
){
    fun toWordInfoEntity() : WordInfoEntity{
        return WordInfoEntity(
            phonetic = phonetic,
            meanings = meanings!!.map { it.toMeaning() },
            word = word,
            origin = origin
        )
    }
}