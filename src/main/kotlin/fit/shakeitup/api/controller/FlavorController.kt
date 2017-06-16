package fit.shakeitup.api.controller

import fit.shakeitup.api.entity.Flavor
import fit.shakeitup.api.repository.FlavorRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.hateoas.*
import org.springframework.hateoas.config.EnableEntityLinks
import org.springframework.web.bind.annotation.*

@RestController
@EnableEntityLinks
@ExposesResourceFor(Flavor::class)
@RequestMapping("/flavor")
open class FlavorController(val flavorRepository: FlavorRepository) {

    @Autowired
    val entityLinks: EntityLinks? = null

    @GetMapping
    fun list(): Resources<Flavor>? {
        val flavors = Resources(flavorRepository.findAll())

        flavors.forEach {
            it.add(entityLinks!!.linkToSingleResource(Flavor::class.java, it.id))
        }

        return flavors
    }

    @GetMapping("/{id}")
    fun get(@PathVariable id: Int): Resource<Flavor>? {
        val flavor = Resource(flavorRepository.findOne(id),
                entityLinks!!.linkToSingleResource(Flavor::class.java, id))

        return flavor
    }

}