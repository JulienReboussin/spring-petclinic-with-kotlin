package org.springframework.samples.petclinic

import org.springframework.samples.petclinic.owner.PetType
import org.springframework.samples.petclinic.owner.PetTypeRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class FoodController(var petTypeRepo: PetTypeRepository) {

    @GetMapping("/food")
    fun food() = "<h1>Do you want some food ?</h1>"

    @GetMapping("/eatpet")
    fun eatPet(@RequestParam id: Long): String {
        val pet: PetType? = petTypeRepo.findById(id);
        return "<h1>Do you want to eat a ${pet?.name ?: "pizza"} ?</h1>"
    }
}
