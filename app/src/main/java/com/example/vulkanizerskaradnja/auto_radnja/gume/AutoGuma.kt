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

    /**
     * Inicijalizacija klase na prosledjene vrednosti
     */
    init {
        setMarkaModel(markaModel)
        setSirina(sirina)
        setPrecnik(precnik)
        setVisina(visina)
    }
    /**
     * Funkcija koja vraca ime marke i modela
     *
     * @return Ime marke i modela,String tip
     * @throws NullPointerException Ako je marka model null, bacice se izuzetak
     */
    fun getMarkaModel():String{
        if(this.markaModel==null)
            throw NullPointerException("Marka i model nemaju vrednost")
        else
            return this.markaModel!!
    }

    /**
     * Set metoda za atribut markaModel
     *
     *
     * @param markaModel Parametar koji prosledjujemo funkciji
     * @throws NullPointerExceptiom Ukoliko je parametar null, baca se izuzetak
     * @throws IllegalArgumentException Ukoliko parametar sadrzi manje od 3 karaktera bacice se izuzetak
     */
    fun setMarkaModel(markaModel: String?){
        if(markaModel==null)
            throw NullPointerException("Marka i model ne smeju biti null")
        if(markaModel.length<3){
            throw IllegalArgumentException("Marka i model moraju imati minimum 3 karaktera")
        }
        this.markaModel=markaModel
    }

    /**
     * Funckija koja vraca vrednost atributa precnik
     *
     * @return Int vrednost precnika gume
     */
    fun getPrecnik():Int{
        return this.precnik
    }

    /**
     * Funckija koja menja vrednost precnika za prosledjeni parametar
     *
     * @param precnik Vrednost precnika koju zelimo da dodelimo
     * @throws IllegalArgumentException Ukoliko je precnik manji od 13 ili veci od 22 baca se izuzetak
     */
    fun setPrecnik(precnik: Int){
        if(precnik<13||precnik>22){
            throw IllegalArgumentException("Precnik van opsega")

        }
        this.precnik=precnik
    }

    /**
     * Funckija koja vraca sirinu gume
     *
     * @return Int vrednost sirine gume
     */
    fun getSirina():Int{
        return this.sirina
    }
    /**
     * Funckija koja menja vrednost sirine za prosledjeni parametar
     *
     * @param sirina Vrednost sirine koju zelimo da dodelimo
     * @throws IllegalArgumentException Ukoliko je sirina manji od 135 ili veci od 355 baca se izuzetak
     */
    fun setSirina(sirina: Int){
        if(sirina<135||sirina>355){
            throw IllegalArgumentException("Sirina van opsega")
        }
        this.sirina=sirina

    }

    /**
     * Funckija koja vraca visinu gume
     *
     * @return Int vrednost visinu gume
     */
    fun getVisina():Int{
        return this.visina
    }
    /**
     * Funckija koja menja vrednost visine za prosledjeni parametar
     *
     * @param sirina Vrednost visine koju zelimo da dodelimo
     * @throws IllegalArgumentException Ukoliko je visina manji od 25 ili veci od 95 baca se izuzetak
     */
    fun setVisina(visina: Int){
        if(visina<25||visina>95){

            throw IllegalArgumentException("Visina van opsega")
        }
        this.visina=visina

    }

    /**
     * Metoda  koja poredi 2 objekta i vraca true ako su isti ili false ako nisu
     *
     * @param other Any objekat koji se salje funkciji da bi se uporedio sa AutoGuma objektom
     * @return boolean Ako su svi parametri ovog i Any objekta isti vraca se true, u suprotnom false, ili ako other nije AutoGuma objekat takodje se vraca false
     */
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is AutoGuma) return false

        if (precnik != other.precnik) return false
        if (sirina != other.sirina) return false
        if (visina != other.visina) return false
        if (markaModel != other.markaModel) return false

        return true
    }


    /**
     * Metoda za hesiranje objekta AutoGuma
     * @return vraca se hash vrednost objekta AutoGuma
     */
    override fun hashCode(): Int {
        var result = precnik
        result = 31 * result + sirina
        result = 31 * result + visina
        result = 31 * result + (markaModel?.hashCode() ?: 0)
        return result
    }

    /**
     * Metoda za pretvaranje objekta u String
     *
     * @return String koji sadrzi podatke o gumi
     */
    override fun toString(): String {
        return "AutoGuma(markaModel=$markaModel, precnik=$precnik, sirina=$sirina, visina=$visina)"
    }


}
