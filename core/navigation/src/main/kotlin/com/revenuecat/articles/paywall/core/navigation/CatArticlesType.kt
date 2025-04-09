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
package com.revenuecat.articles.paywall.core.navigation

import android.net.Uri
import android.os.Bundle
import androidx.core.os.BundleCompat
import androidx.navigation.NavType
import com.revenuecat.articles.paywall.core.model.Article
import kotlinx.serialization.json.Json

object CatArticlesType : NavType<Article>(isNullableAllowed = false) {

  override fun put(bundle: Bundle, key: String, value: Article) {
    bundle.putParcelable(key, value)
  }

  override fun get(bundle: Bundle, key: String): Article? =
    BundleCompat.getParcelable(bundle, key, Article::class.java)

  override fun parseValue(value: String): Article {
    return Json.decodeFromString(Uri.decode(value))
  }

  override fun serializeAsValue(value: Article): String = Uri.encode(Json.encodeToString(value))
}
