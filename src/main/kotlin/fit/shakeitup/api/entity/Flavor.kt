package fit.shakeitup.api.entity

import com.github.slugify.Slugify
import org.springframework.hateoas.ResourceSupport
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
class Flavor : ResourceSupport {
    constructor(name: String, active: Boolean?) {
        this.name = name
        this.slug_name = Slugify().slugify(name)
        this.active = active
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Int? = null

    @NotNull
    var name: String? = null

    @NotNull
    var slug_name: String? = null

    var active: Boolean? = false

}