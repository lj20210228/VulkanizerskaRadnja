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


/**
 * Testovi za klasu AutoGuma
 */
class AutoGumaTest {
     var guma: AutoGuma?=null

    /**
     * Funkcija za inicijalizovanje objekta koji ce se koristiti u svim testovima i izvrsavace se pre svake metode
     */
    @BeforeEach
    fun setUp(){
        guma=AutoGuma("Tigar",18,165,75)

    }

    /**
     * Funckija za inicijalizovanje metode, izvrsava se na kraju, inicijalizuje objekat na null
     */
    @AfterEach
    fun tearDown(){
        guma=null
    }

    /**
     * Test za metodu getMarkaModel(), poredi se da li su jednaki zadat string sa povratnom vrednoscu metode
     */
    @Test
    fun getMarkaModelTest_uspesno(){
        assertEquals("Tigar",guma?.getMarkaModel())

    }

    /**
     * Test za metodu setMarkaModel kad joj se prosledi null vrednost za parametar markaModel,
     * test prolazi ako metoda vrati NullPointerException
     */
    @Test
    fun setMarkaModelTest_null(){
        assertThrows<NullPointerException>{guma?.setMarkaModel(null)}
    }

    /**
     * Parametrizovani test koji prosledjuje prazan string, string sa 1 i 2 karaktera,
     * ukoliko se vrati IllegalArgumentException test prolazi
     */
    @ParameterizedTest
    @CsvSource("'',m,mm")
    fun setMarkaModelTest_manjeod3(markaModel:String){

        assertThrows<IllegalArgumentException> {
            guma?.setMarkaModel(markaModel)

        }
    }

    /**
     * Prodledjuje se ispravna vrednost za parametar markaModel, ukoliko je dodeljena vrednost prosledjenog parametra,
     * ukoliko je ta vrednost ispravna test prolazi
     */
    @Test
    fun setMarkaModel_uspesno(){
        guma?.setMarkaModel("Michelin")
        assertEquals("Michelin",guma?.getMarkaModel())

    }

    /**
     * Test za metodu za dohvatanje vrednosti visine, ukoliko je ispravno dohvacena visina,
     * test prolazi
     */
    @Test
    fun getVisina(){
        assertEquals(75,guma?.getVisina())
    }
    /**
     * Test za metodu za dohvatanje vrednosti sirine, ukoliko je ispravno dohvacena sirina,
     * test prolazi
     */
    @Test
    fun getSirina(){
        assertEquals(165,guma?.getSirina())
    }
    /**
     * Test za metodu za dohvatanje vrednosti precnika, ukoliko je ispravno dohvacena precnika,
     * test prolazi
     */
    @Test
    fun getPrecnik(){
        assertEquals(18,guma?.getPrecnik())
    }

    /**
     * Test za metodu za promenu vrednosti visine, prosledjuju joj se argumenti koji nisu ispravni, ukoliko se vrati
     * IllegalArgumentException test prolazi
     */
    @ParameterizedTest
    @CsvSource(
        "18",
        "100"
    )
    fun setVisina_vanOpsega(visina:Int){
        assertThrows<IllegalArgumentException> {guma?.setVisina(visina)  }

    }

    /**
     * Test za promenu vrednosti visine, prosledjeni su joj ispravni argumenti,
     * ukoliko se ispravno promeni vrednost visine, test prolazi
     */
    @ParameterizedTest
    @CsvSource(
        "28",
        "88"

    )
    fun setVisina_uspesno(visina:Int){
        guma?.setVisina(visina)
        assertEquals(visina,guma?.getVisina())

    }
    /**
     * Test za metodu za promenu vrednosti sirine, prosledjuju joj se argumenti koji nisu ispravni, ukoliko se vrati
     * IllegalArgumentException test prolazi
     */
    @ParameterizedTest
    @CsvSource(
        "110",
        "400"
    )
    fun setSirina_vanOpsega(sirina:Int){
        assertThrows<IllegalArgumentException> {guma?.setSirina(sirina)  }

    }
    /**
     * Test za promenu vrednosti sirine, prosledjeni su joj ispravni argumenti,
     * ukoliko se ispravno promeni vrednost sirine, test prolazi
     */
    @ParameterizedTest
    @CsvSource(
        "155",
        "255"
    )
    fun setSirina_uspesno(sirina:Int){

        guma?.setSirina(sirina)
        assertEquals(sirina,guma?.getSirina())
    }
    /**
     * Test za metodu za promenu vrednosti precnika, prosledjuju joj se argumenti koji nisu ispravni, ukoliko se vrati
     * IllegalArgumentException test prolazi
     */
    @ParameterizedTest
    @CsvSource(
        "10",
        "100"
    )
    fun setPrecnik_vanOpsega(precnik:Int){
        assertThrows<IllegalArgumentException> {guma?.setPrecnik(precnik)  }

    }
    /**
     * Test za promenu vrednosti precnika, prosledjeni su joj ispravni argumenti,
     * ukoliko se ispravno promeni vrednost precnika, test prolazi
     */
    @ParameterizedTest
    @CsvSource(
        "17",
        "20"
    )
    fun setPrecnik_uspesno(precnik:Int){

        guma?.setPrecnik(precnik)
        assertEquals(precnik,guma?.getPrecnik())
    }

    /**
     * Test za proveru equals metode, dodajemo novi objekat i poredimo ga sa vec postojecim objektom,
     * ukoliko funkcija vrati true, test prolazi
     */
    @Test
    fun testEqualsIstiObjekat(){
        val guma2=AutoGuma("Tigar",18,165,75)
        assertTrue(guma?.equals(guma2)!!)
    }
    /**
     * Test za proveru equals metode, prosledjujemo null i poredimo ga sa vec postojecim objektom,
     * ukoliko funkcija vrati false, test prolazi
     */
    @Test
    fun testEqualsNull(){
        assertFalse(guma?.equals(null)!!)
    }

    /**
     * Test za proveru equals metode, prosledjujemo jos vise parova objekata sa boolean vrednoscu da li su jednake,
     * po markaModel, sirini, precniku i visini, koji su namerno razliciti u svakom testu,
     * ako za svaki parametar test vrati ispravnu vrednost, test prolazi
     */
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

    /**
     * Test koji proverava metodu hashCode, gde se porede 2 ista hesovana objekta i ako su jednaka,
     * test prolazi
     */
    @Test
    fun hashCodeTest(){
        val guma1=AutoGuma()
        val guma2=AutoGuma()
        assertEquals(guma1.hashCode(),guma2.hashCode())
    }

    /**
     * Test koji proverava metodu hashCode, gde se porede 2 razlicita hesovana objekta i ako nisu jednaka,
     * test prolazi
     */
    @Test
    fun testHashCodeRazliciti() {
        val g1 = AutoGuma("Tigar", 15, 155, 80)
        val g2 = AutoGuma("Michelin", 15, 155, 80)
        assertNotEquals(g1.hashCode(), g2.hashCode())
    }

    /**
     * Test koji proverava toString() metodu, i ako rezultat sadrzi sve parametre,
     * nebitno kojim redosledom, test prolazi
     */
    @Test
    fun testToString(){
        val rezultat=guma.toString()
        assertTrue(rezultat.contains("Tigar"))
        assertTrue(rezultat.contains("18"))

        assertTrue(rezultat.contains("165"))

        assertTrue(rezultat.contains("75"))

    }



}