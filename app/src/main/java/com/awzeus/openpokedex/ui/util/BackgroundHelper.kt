package com.awzeus.openpokedex.ui.util

import com.awzeus.openpokedex.R

class BackgroundHelper {

    fun getColorForType(type: String): Int = when(type){
        "normal" -> R.color.type_normal
        "fire" -> R.color.type_fire
        "water" -> R.color.type_water
        "electric" -> R.color.type_electric
        "grass" -> R.color.type_grass
        "ice" -> R.color.type_ice
        "fighting" -> R.color.type_fighting
        "poison" -> R.color.type_poison
        "ground" -> R.color.type_ground
        "flying" -> R.color.type_flying
        "psychic" -> R.color.type_psychic
        "bug" -> R.color.type_bug
        "rock" -> R.color.type_rock
        "ghost" -> R.color.type_ghost
        "dragon" -> R.color.type_dragon
        "steel" -> R.color.type_steel
        "fairy" -> R.color.type_fairy
        else -> R.color.type_normal
    }

    fun getDrawableForType(type: String): Int = when(type){
        "normal" -> R.drawable.rounded_rectangle_normal
        "fire" -> R.drawable.rounded_rectangle_fire
        "water" -> R.drawable.rounded_rectangle_water
        "electric" -> R.drawable.rounded_rectangle_electric
        "grass" -> R.drawable.rounded_rectangle_grass
        "ice" -> R.drawable.rounded_rectangle_ice
        "fighting" -> R.drawable.rounded_rectangle_fighting
        "poison" -> R.drawable.rounded_rectangle_poison
        "ground" -> R.drawable.rounded_rectangle_normal
        "flying" -> R.drawable.rounded_rectangle_flying
        "psychic" -> R.drawable.rounded_rectangle_psychic
        "bug" -> R.drawable.rounded_rectangle_bug
        "rock" -> R.drawable.rounded_rectangle_rock
        "ghost" -> R.drawable.rounded_rectangle_ghost
        "dragon" -> R.drawable.rounded_rectangle_dragon
        "steel" -> R.drawable.rounded_rectangle_steel
        "fairy" -> R.drawable.rounded_rectangle_fairy
        else -> R.drawable.rounded_rectangle_normal
    }
}

/*
* <!-- Pokemon Types -->
<color name="type_normal">#A8A77A</color>
<color name="type_fire">#C22E28</color>
<color name="type_water">#6390F0</color>
<color name="type_electric">#F7D02C</color>
<color name="type_grass">#7AC74C</color>
<color name="type_ice">#96D9D6</color>
<color name="type_fighting">#962E28</color>
<color name="type_poison">#A33EA1</color>
<color name="type_ground">#AF9C22</color>
<color name="type_flying">#A98FF3</color>
<color name="type_psychic">#F95587</color>
<color name="type_bug">#A6B91A</color>
<color name="type_rock">#B6A136</color>
<color name="type_ghost">#735797</color>
<color name="type_dragon">#6F35FC</color>
<color name="type_dark">#705746</color>
<color name="type_steel">#B7B7CE</color>
<color name="type_fairy">#D685AD</color>*/