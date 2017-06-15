package fit.shakeitup.api.repository

import fit.shakeitup.api.entity.Flavor
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface FlavorRepository : JpaRepository<Flavor, Int>