package com.example.vulkanizerskaradnja.autoRadnja

import com.example.vulkanizerskaradnja.auto_radnja.gume.AutoGuma

/**
 * Interfejs koji sluzi za metode za rukovanje podacima o gumama
 */
interface Radnja {
    /**
     * Metoda za dodavanje nove gume u listu
     *
     * @param guma Guma koja treba da se doda u listu
     * @throws NullPointerException Ukoliko je prosledjeni parametar null baca se izuzetak
     * @throws IllegalArgumentException Ukoliko se prosledjeni parametar vec nalazi u listi, baca se izuzetak
     *
     */
    fun dodajGumu(guma: AutoGuma?)

    /**
     * Metoda za pronalezenje guma sa odredjenim nazivom marke i modela
     *
     * @param markaModel Parametar za pretragu, ime marke i modela gume
     * @throws NullPointerException Ukoliko je parametar null, baca se izuzetak
     * @throws IllegalArgumentException Ukoliko je duzina parametra kraca od 3 karaktera baca se izuzetak
     * @see AutoGuma vezano za prethodni izuzetak
     * @return [List[AutoGuma]] Vraca se lista guma sa datom markom i modelom
     *
     */
    fun pronadjiGumu(markaModel:String?):List<AutoGuma>

    /**
     * Metoda za pronalezenje svih guma u listi
     *
     * @return List[AutoGuma] Vraca se lista svih guma
     */
    fun vratiSveGume():List<AutoGuma>

}