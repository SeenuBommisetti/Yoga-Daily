package com.example.yogadaily.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Asana(
    @StringRes val dayRes: Int,
    @StringRes val titleRes: Int,
    @DrawableRes val imageRes: Int,
    @StringRes val benefitsRes: Int,
    @StringRes val stepsRes: List<Int>
)
