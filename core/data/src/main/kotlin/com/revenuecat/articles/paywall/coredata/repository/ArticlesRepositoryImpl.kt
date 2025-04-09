/*
 * Copyright (c) 2025 RevenueCat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.revenuecat.articles.paywall.coredata.repository

import com.revenuecat.articles.paywall.core.model.Article
import com.revenuecat.articles.paywall.core.network.CatArticlesDispatchers
import com.revenuecat.articles.paywall.core.network.Dispatcher
import com.revenuecat.articles.paywall.core.network.service.CatArticlesService
import com.skydoves.sandwich.ApiResponse
import com.skydoves.sandwich.suspendOnSuccess
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

internal class ArticlesRepositoryImpl @Inject constructor(
  private val catArticlesService: CatArticlesService,
  @Dispatcher(CatArticlesDispatchers.IO) private val ioDispatcher: CoroutineDispatcher,
) : ArticlesRepository {

  override fun fetchArticles(): Flow<ApiResponse<List<Article>>> = flow {
    val response = catArticlesService.fetchArticles().suspendOnSuccess { data }
    emit(response)
  }.flowOn(ioDispatcher)
}
