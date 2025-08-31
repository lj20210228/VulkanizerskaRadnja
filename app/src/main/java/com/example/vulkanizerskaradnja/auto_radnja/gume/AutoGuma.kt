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
    var markaModel:String?=null,
    var precnik:Int=-1
    ,var sirina:Int=-1,
    var visina:Int=-1
){
    fun getMarkaModel():String{
        if(this.markaModel==null)
            throw NullPointerException("Marka i model nemaju vrednost")
        else
            return this.markaModel!!
    }
    fun setMarkaModel(markaModel: String?){
        if(markaModel==null)
            throw NullPointerException("Marka i model ne smeju biti null")
        if(markaModel.length<3){
            throw IllegalArgumentException("Marka i model moraju imati minimum 3 karaktera")
        }
        this.markaModel=markaModel
    }
    fun getPrecnik():Int{
        return this.precnik
    }
    fun setPrecnik(precnik: Int){
        if(precnik<13||precnik>22){
            throw IllegalArgumentException("Precnik van opsega")

        }
        this.precnik=precnik
    }
    fun getSirina():Int{
        return this.sirina
    }
    fun setSirina(sirina: Int){
        if(sirina<135||sirina>355){
            throw IllegalArgumentException("Sirina van opsega")
        }
        this.sirina=sirina

    }
    fun getVisina():Int{
        return this.visina
    }
    fun setVisina(visina: Int){
        if(visina<25||visina>95){

            throw IllegalArgumentException("Visina van opsega")
        }
        this.visina=visina

    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is AutoGuma) return false

        if (precnik != other.precnik) return false
        if (sirina != other.sirina) return false
        if (visina != other.visina) return false
        if (markaModel != other.markaModel) return false

        return true
    }

    override fun hashCode(): Int {
        var result = precnik
        result = 31 * result + sirina
        result = 31 * result + visina
        result = 31 * result + (markaModel?.hashCode() ?: 0)
        return result
    }

    override fun toString(): String {
        return "AutoGuma(markaModel=$markaModel, precnik=$precnik, sirina=$sirina, visina=$visina)"
    }


}
