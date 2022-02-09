package com.kotlin.apirest

import com.kotlin.apirest.dao.PersonaRepository
import com.kotlin.apirest.model.Persona
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@SpringBootApplication
class ApirestApplication: CommandLineRunner {

    @Autowired
    val personaRepository: PersonaRepository? = null

    override fun run(vararg args: String?) {
        val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
        val per = Persona(190327876,"Jean","Prouvay", LocalDate.parse("1993-04-23"))
        personaRepository!!.save(per)
    }
}

fun main(args: Array<String>) {
    runApplication<ApirestApplication>(*args)
}
