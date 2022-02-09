package com.kotlin.apirest.dao

import com.kotlin.apirest.model.Persona
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonaRepository: JpaRepository<Persona, Long>