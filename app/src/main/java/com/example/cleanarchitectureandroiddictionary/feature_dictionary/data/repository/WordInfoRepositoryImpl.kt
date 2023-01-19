package com.example.cleanarchitectureandroiddictionary.feature_dictionary.data.repository

import com.example.cleanarchitectureandroiddictionary.core.util.Resource
import com.example.cleanarchitectureandroiddictionary.feature_dictionary.data.local.WordInfoDao
import com.example.cleanarchitectureandroiddictionary.feature_dictionary.data.remote.DictionaryApi
import com.example.cleanarchitectureandroiddictionary.feature_dictionary.domain.model.WordInfo
import com.example.cleanarchitectureandroiddictionary.feature_dictionary.domain.repository.WordInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class WordInfoRepositoryImpl(
    private val api : DictionaryApi,
    private val dao : WordInfoDao
) : WordInfoRepository{
    override fun getWordInfo(word: String?): Flow<Resource<List<WordInfo>>> = flow{
        emit(Resource.Loading())
        val  wordInfos  = dao.getWordInfos(word!!).map { it.toWordInfo() }
        emit(Resource.Loading(data = wordInfos))

        try {
            val remoteWordsInfo = api.getWordInfo(word)
            dao.deleteWordInfos(remoteWordsInfo.map { it.word!! })
            dao.insertWordInfos(remoteWordsInfo.map { it.toWordInfoEntity() })
        }catch (e : HttpException){
            emit(Resource.Error(
                message = e.message(),
                data = wordInfos
            ))
        }catch (e : IOException){
            emit(Resource.Error(
                message = e.message,
                data = wordInfos
            ))
        }
        val newWordInfos = dao.getWordInfos(word).map { it.toWordInfo() }
        emit(Resource.Success(newWordInfos))
    }

}