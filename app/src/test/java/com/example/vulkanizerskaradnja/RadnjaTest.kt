package com.example.vulkanizerskaradnja

import com.example.vulkanizerskaradnja.autoRadnja.Radnja
import com.example.vulkanizerskaradnja.auto_radnja.gume.AutoGuma
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import kotlin.test.assertEquals

/**
 * Apstraktna klasa za test interfejsa radnja
 * @property radnja Instanca interfjesa koji ce se koristiti za pozivanje metoda u testovima
 * @property guma1 Objekat klase [AutoGuma] koji ce se koristiti u testovima
 * @property guma2 Objekat klase [AutoGuma] koji ce se koristiti u testovima
 */
abstract class RadnjaTest {


     var radnja:Radnja?= null

    /**
     * Funkcija za odredjivanje koji je tip objekta radnja(npr Vulkanizerska, Prodavnica itd...)
     *
     * @return objekat [Radnja]
     */
    abstract fun getInstance():Radnja
     var guma1:AutoGuma?=null
     var guma2:AutoGuma?=null


    /**
     * Metoda koja se poziva pre svakog testa kako se podaci ne bi izgubili u medjuvremenu, inciijalizuje
     * objekte radnja guma1 i guma2
     */
    @BeforeEach
    fun setUp(){
        radnja=getInstance()
        guma1=AutoGuma(markaModel = "Tigar",19,155,85)
        guma2=AutoGuma(markaModel = "Tigar",19,155,85)

    }

    /**
     * Metoda koja se poziva na kraju, kako ne bi doslo do curenja memorije,
     * inicijalizuje radnju,gumu1 i gumu2 na null
     */
    @AfterEach
    fun tearDown(){
        radnja=null
        guma1=null
        guma2=null
    }


    /**
     * Test koji proverava metodu dodajGumu kada mu se prosledi null, ako metoda baci
     * [NullPointerException] test prolazi
     */
    @Test
    fun dodajGumuTest_null(){
        assertThrows<NullPointerException> {
            radnja?.dodajGumu(null)
        }
    }

    /**
     * Test koji proverava metodu dodajGumu kada guma vec postoji, ukoliko metoda baci
     * [IllegalArgumentException] test prolazi
     */
    @Test
    fun dodajGumuTest_vecPostoji(){
        radnja?.dodajGumu(guma1)
        assertThrows<IllegalArgumentException> {
            radnja?.dodajGumu(guma2)
        }
    }


    /**
     * Parametrizovani test koji za vise objekata guma proverava da li ce uspesno biti dodati,
     * dodaju se u lokalnu listu koja se poredi sa svim dodatim elementima u radnji,ako su isti
     * test prolazi
     */
    @ParameterizedTest
    @CsvSource(
        "Tigar,18,85,185",
        "Michelin,18,95,195",
        "Sava,16,90,185"

    )
    fun dodajGumuTest_uspesno(markaModel: String,precnik:Int,visina:Int,sirina:Int){
        val guma=AutoGuma(markaModel,precnik,sirina,visina)
        radnja?.dodajGumu(guma)
        val lista= mutableListOf<AutoGuma>()
        lista.add(guma)

        assertEquals(lista,radnja?.vratiSveGume())

    }

    /**
     * Test za metodu za pronalezenje gume po markaModel parametru, ukoliko je markaModel null,
     * metoda treba da baci [NullPointerException] da bi test prosao
     */
    @Test
    fun pronadjiGumu_markaModelNull(){
        assertThrows<NullPointerException> {
            radnja?.pronadjiGumu(null)
        }
    }

    /**
     * Parametrizovani test koji testira metodu pronadjiGumu kada mu se proslede parametri koji imaju manje od 3
     * karaktera, ukoliko metoda baci [IllegalArgumentException] test prolazi
     */
    @ParameterizedTest
    @CsvSource(
        "'',m,mm "
    )
    fun pronadjiGumu_manjeod3(markaModel:String){
        assertThrows<IllegalArgumentException> {
            radnja?.pronadjiGumu(markaModel)
        }

    }

    /**
     * Test koji proverava da li metoda pronadjiGumu uspesno vraca sve gume, tako sto se iste gume ubacuju
     * u lokalnu listu koja se poredi sa svim gumama koje su dodate u radnju
     */
    @Test
    fun pronadjiGumu_uspesno(){
        guma2?.setPrecnik(20)

        radnja?.dodajGumu(guma1)
        radnja?.dodajGumu(guma2)
        val lista= mutableListOf<AutoGuma>()
        guma1?.let { lista.add(it) }
        guma2?.let { lista.add(it) }
        assertEquals(lista,radnja?.pronadjiGumu("Tigar"))
    }

    /**
     * Test u kome se proverava da li metoda pronadjiSveGume ispravno vraca sve gume u listi,
     * tako sto se porede sve gume u listi i sve gume dodate u lokalnu listu
     */
    @Test
    fun pronadjiSveGumeTest(){
        val guma1=AutoGuma(markaModel = "Tigar",19,155,85)
        val guma2=AutoGuma(markaModel = "Tigar",20,155,85)
        val guma3=AutoGuma(markaModel = "Tigar",19,185,85)


        val lista= mutableListOf<AutoGuma>()
        lista.add(guma1)
        lista.add(guma2)
        lista.add(guma3)
        radnja?.dodajGumu(guma1)
        radnja?.dodajGumu(guma2)
        radnja?.dodajGumu(guma3)
        assertEquals(lista,radnja?.vratiSveGume())


    }

}