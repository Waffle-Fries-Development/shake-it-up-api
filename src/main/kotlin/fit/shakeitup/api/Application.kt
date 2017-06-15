package fit.shakeitup.api

import fit.shakeitup.api.entity.Flavor
import fit.shakeitup.api.repository.FlavorRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
open class Application {
    @Bean
    fun init(repository: FlavorRepository) = CommandLineRunner {
        repository.save(Flavor("Chocolate", true))
        repository.save(Flavor("Vanilla", true))
        repository.save(Flavor("Strawberry", true))
        repository.save(Flavor("Greenberry", true))
        repository.save(Flavor("Vegan Chocolate", true))
        repository.save(Flavor("Vegan Tropical Strawberry", true))
        repository.save(Flavor("Cafe Latte", true))
    }

    companion object {
        @JvmStatic fun main(args: Array<String>) {
            SpringApplication.run(Application::class.java, *args)
        }
    }
}