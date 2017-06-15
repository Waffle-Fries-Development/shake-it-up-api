package fit.shakeitup.api.controller

import fit.shakeitup.api.entity.Flavor
import fit.shakeitup.api.repository.FlavorRepository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/flavor")
class FlavorController(val flavorRepository: FlavorRepository) {

    @GetMapping
    fun list(): MutableList<Flavor>? {
        return flavorRepository.findAll()
    }

    @GetMapping("/{id}")
    fun get(@PathVariable id: Int): Flavor? {
        return flavorRepository.findOne(id)
    }

}