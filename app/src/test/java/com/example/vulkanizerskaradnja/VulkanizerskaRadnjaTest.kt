package com.example.vulkanizerskaradnja

import com.example.vulkanizerskaradnja.autoRadnja.Radnja
import com.example.vulkanizerskaradnja.autoRadnja.VulkanizerskaRadnja

/**
 * Klasa koja sluzi kao test klasa za [VulkanizerskaRadnja] klasu, a sve njene metode se implementiraju
 * u test klasi interfejsa [RadnjaTest]
 */
class VulkanizerskaRadnjaTest:RadnjaTest() {
    /**
     * Metoda koja vraca instancu klase [VulkanizerskaRadnja]
     */
    override fun getInstance(): Radnja {
        return VulkanizerskaRadnja()

    }
}