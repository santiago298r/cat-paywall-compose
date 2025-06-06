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
package com.revenuecat.articles.paywall.core.designsystem.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.revenuecat.articles.paywall.compose.core.designsystem.R

@Immutable
data class CatArticlesBackground(
  val color: Color = Color.Unspecified,
  val tonalElevation: Dp = Dp.Unspecified,
) {
  companion object {
    @Composable
    fun defaultBackground(darkTheme: Boolean): CatArticlesBackground {
      return if (darkTheme) {
        CatArticlesBackground(
          color = colorResource(id = R.color.background_dark),
          tonalElevation = 0.dp,
        )
      } else {
        CatArticlesBackground(
          color = colorResource(id = R.color.background),
          tonalElevation = 0.dp,
        )
      }
    }
  }
}

val LocalBackgroundTheme: ProvidableCompositionLocal<CatArticlesBackground> =
  staticCompositionLocalOf { CatArticlesBackground() }
