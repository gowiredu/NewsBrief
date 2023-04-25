package com.gowiredu.newsbrief.repository

import com.gowiredu.newsbrief.api.RetrofitInstance
import com.gowiredu.newsbrief.db.ArticleDatabase
import com.gowiredu.newsbrief.models.Article

class NewsRepository (
    val db: ArticleDatabase
) {
    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getBreakingNews(countryCode, pageNumber)

    suspend fun searchNews(searchQuery: String, pageNumber: Int) =
        RetrofitInstance.api.searchForNews(searchQuery, pageNumber)

    suspend fun upsert(article: Article) = db.getArticlesDao().upsert(article)

    fun getSavedNews() = db.getArticlesDao().getAllArticles()

    suspend fun deleteArticle(article: Article) = db.getArticlesDao().deleteArticle(article)

}