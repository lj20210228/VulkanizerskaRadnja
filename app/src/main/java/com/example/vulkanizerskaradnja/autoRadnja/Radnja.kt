package com.example.vulkanizerskaradnja.autoRadnja

import com.example.vulkanizerskaradnja.auto_radnja.gume.AutoGuma

interface Radnja {
    fun dodajGumu(guma: AutoGuma?)
    fun pronadjiGumu(markaModel:String?):List<AutoGuma>
    fun vratiSveGume():List<AutoGuma>

}