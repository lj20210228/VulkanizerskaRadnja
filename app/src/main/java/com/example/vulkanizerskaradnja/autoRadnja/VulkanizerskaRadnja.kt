package com.example.vulkanizerskaradnja.autoRadnja

import com.example.vulkanizerskaradnja.auto_radnja.gume.AutoGuma

class VulkanizerskaRadnja:Radnja {
    private var lista= mutableListOf<AutoGuma>()
    override fun dodajGumu(guma: AutoGuma?) {
        if (guma==null)
            throw NullPointerException("Guma za dodavanje ne moze biti null")
        for (g in lista){
            if(g.equals(guma))
                throw IllegalArgumentException("Guma vec postoji")
        }
        lista.add(guma)

    }

    override fun pronadjiGumu(markaModel: String?): List<AutoGuma> {


        val povratnaLista= mutableListOf<AutoGuma>()
        if(markaModel==null){
            throw NullPointerException("Marka i model ne mogu biti null")
        }
        if(markaModel.length<3){
            throw IllegalArgumentException("Morate uneti bar 3 karaktera za pretragu")
        }
        return lista.filter { it->
            it.getMarkaModel().equals(markaModel)
        }
    }


    override fun vratiSveGume(): List<AutoGuma> {
        return lista
    }
}