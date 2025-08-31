package com.example.vulkanizerskaradnja

import com.example.vulkanizerskaradnja.auto_radnja.gume.AutoGuma
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.ParameterizedTest

import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNotEquals
import kotlin.test.assertTrue

class AutoGumaTest {
     var guma: AutoGuma?=null
    @BeforeEach
    fun setUp(){
        guma=AutoGuma("Tigar",18,165,75)

    }
    @AfterEach
    fun tearDown(){
        guma=null
    }

    @Test
    fun getMarkaModelTest_uspesno(){
        assertEquals("Tigar",guma?.getMarkaModel())

    }

    @Test
    fun setMarkaModelTest_null(){
        assertThrows<NullPointerException>{guma?.setMarkaModel(null)}
    }
    @ParameterizedTest
    @CsvSource("'',m,mm")
    fun setMarkaModelTest_manjeod3(markaModel:String){

        assertThrows<IllegalArgumentException> {
            guma?.setMarkaModel(markaModel)

        }
    }
    @Test
    fun setMarkaModel_uspesno(){
        guma?.setMarkaModel("Michelin")
        assertEquals("Michelin",guma?.getMarkaModel())

    }

    @Test
    fun getVisina(){
        assertEquals(75,guma?.getVisina())
    }
    @Test
    fun getSirina(){
        assertEquals(165,guma?.getSirina())
    }
    @Test
    fun getPrecnik(){
        assertEquals(18,guma?.getPrecnik())
    }

    @ParameterizedTest
    @CsvSource(
        "18",
        "100"
    )
    fun setVisina_vanOpsega(visina:Int){
        assertThrows<IllegalArgumentException> {guma?.setVisina(visina)  }

    }
    @ParameterizedTest
    @CsvSource(
        "28",
        "88"

    )
    fun setVisina_uspesno(visina:Int){
        guma?.setVisina(visina)
        assertEquals(visina,guma?.getVisina())

    }
    @ParameterizedTest
    @CsvSource(
        "110",
        "400"
    )
    fun setSirina_vanOpsega(sirina:Int){
        assertThrows<IllegalArgumentException> {guma?.setSirina(sirina)  }

    }
    @ParameterizedTest
    @CsvSource(
        "155",
        "255"
    )
    fun setSirina_uspesno(sirina:Int){

        guma?.setSirina(sirina)
        assertEquals(sirina,guma?.getSirina())
    }
    @ParameterizedTest
    @CsvSource(
        "10",
        "100"
    )
    fun setPrecnik_vanOpsega(precnik:Int){
        assertThrows<IllegalArgumentException> {guma?.setPrecnik(precnik)  }

    }
    @ParameterizedTest
    @CsvSource(
        "17",
        "20"
    )
    fun setPrecnik_uspesno(precnik:Int){

        guma?.setPrecnik(precnik)
        assertEquals(precnik,guma?.getPrecnik())
    }

    @Test
    fun testEqualsIstiObjekat(){
        val guma2=AutoGuma("Tigar",18,165,75)
        assertTrue(guma?.equals(guma2)!!)
    }
    @Test
    fun testEqualsNull(){
        assertFalse(guma?.equals(null)!!)
    }

    @ParameterizedTest
    @CsvSource(
        "Tigar, 155, 65, 20 , Tigar,155,65,20,true",


        "Tigar, 155, 65, 20 , Michelin,155,65,20,false",
        "Tigar, 155, 65, 20 , Tigar,165,65,20,false",
        "Tigar, 155, 65, 20 , Tigar,155,85,20,false",
        "Tigar, 155, 65, 20 , Tigar,155,65,19,false"

    )
    fun testEqualsRazlicito(markaModel1: String, sirina1:Int,visina1:Int,precnik1:Int,
                            markaModel2: String, sirina2:Int,visina2:Int,precnik2:Int,isto:Boolean
    ){
        val guma1=AutoGuma(
            markaModel1, sirina = sirina1, visina = visina1, precnik = precnik1
        )
        val guma2=AutoGuma(
            markaModel2, sirina = sirina2, visina = visina2, precnik = precnik2
        )
        assertEquals(isto,guma1.equals(guma2))
    }
    @Test
    fun hashCodeTest(){
        val guma1=AutoGuma()
        val guma2=AutoGuma()
        assertEquals(guma1.hashCode(),guma2.hashCode())
    }

    @Test
    fun testHashCodeRazliciti() {
        val g1 = AutoGuma("Tigar", 15, 155, 80)
        val g2 = AutoGuma("Michelin", 15, 155, 80)
        assertNotEquals(g1.hashCode(), g2.hashCode())
    }

    @Test
    fun testToString(){
        val rezultat=guma.toString()
        assertTrue(rezultat.contains("Tigar"))
        assertTrue(rezultat.contains("18"))

        assertTrue(rezultat.contains("165"))

        assertTrue(rezultat.contains("75"))

    }



}