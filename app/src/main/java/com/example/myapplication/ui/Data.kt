package com.example.myapplication.ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.myapplication.R

object Data {
    val menuList = mutableListOf(
        MenuData(name = R.string.titan_pumpkin, background = R.drawable.m1),
        MenuData(name = R.string.raspberry_smoothie, background = R.drawable.m2),
        MenuData(name = R.string.unknown_salad, background = R.drawable.m3)
    )
    val materialList = mutableListOf(
        MaterialData(
            name = R.string.titan_pumpkin,
            desc = R.string.titan_pumpkin_desc,
            background = R.drawable.f2
        ),
        MaterialData(
            name = R.string.magical_ghost_fruit,
            desc = R.string.magical_ghost_fruit_desc,
            background = R.drawable.f3
        )
    )

    val hotVegetableList = mutableListOf(
        Vegetable(name = R.string.titan_star_banana, rating = 4.5, background = R.drawable.f1)
    )

    val visitorList = mutableListOf(
        R.drawable.u1,
        R.drawable.u2,
        R.drawable.u3,
        R.drawable.u4
    )
}

data class MenuData(
    @StringRes val name: Int, @DrawableRes val background: Int
)

data class MaterialData(
    @StringRes val name: Int, @StringRes val desc: Int, @DrawableRes val background: Int
)

data class Vegetable(
    @StringRes val name: Int, val rating: Double, @DrawableRes val background: Int
)