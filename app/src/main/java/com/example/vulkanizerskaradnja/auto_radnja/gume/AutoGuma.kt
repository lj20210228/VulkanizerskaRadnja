package com.example.vulkanizerskaradnja.auto_radnja.gume

/**
 * Klasa koja cuva podatke o Auto Gumama
 *
 * @property markaModel Podaci o marki i modelu gume, String vrednost
 * @property precnik Podaci o precniku gume Int vrednost
 * @property sirina Podaci o sirini gume Int vrednost
 * @property visina Podaci o sirini gume Int vresnost
 */
data class AutoGuma(
    val markaModel:String?=null,
    val precnik:Int=-1
    ,val sirina:Int=-1,
    val visina:Int=-1
){


}
