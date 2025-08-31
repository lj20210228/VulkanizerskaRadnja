package com.example.vulkanizerskaradnja.auto_radnja.gume

interface Radnja {
    fun dodajGumu(guma:AutoGuma)
    fun pronadjiGumu(markaModel:String):List<AutoGuma>
    fun vratiSveGume():List<AutoGuma>

}