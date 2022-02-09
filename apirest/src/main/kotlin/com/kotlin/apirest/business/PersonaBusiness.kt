package com.kotlin.apirest.business

import com.kotlin.apirest.dao.PersonaRepository
import com.kotlin.apirest.exception.BusinessException
import com.kotlin.apirest.exception.NotFoundException
import com.kotlin.apirest.model.Persona
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*
import kotlin.jvm.Throws

@Service
class PersonaBusiness: IPersonaBusiness {

    @Autowired
    val personaRepository: PersonaRepository? = null

    @Throws(BusinessException::class)
    override fun list(): List<Persona> {
        try{
            return personaRepository!!.findAll()
        }catch (e:Exception){
            throw BusinessException(e.message);
        }
    }

    @Throws(BusinessException::class, NotFoundException::class)
    override fun load(idPersona: Long): Persona {
        val op: Optional<Persona>
        try{
            op = personaRepository!!.findById(idPersona)
        }catch (e:Exception){
            throw BusinessException(e.message)
        }

        if(!op.isPresent){
            throw NotFoundException("No se encontro la persona con el id $idPersona")
        }
        return op.get();
    }

    @Throws(BusinessException::class)
    override fun save(persona: Persona): Persona {
        try{
            return personaRepository!!.save(persona)
        }catch (e:Exception){
            throw BusinessException(e.message)
        }
    }

    @Throws(BusinessException::class)
    override fun remove(idPersona: Long) {
        val op: Optional<Persona>
        try {
            op = personaRepository!!.findById(idPersona)
        }catch (e:Exception){
            throw BusinessException(e.message)
        }

        if(!op.isPresent){
            throw NotFoundException("No se encontro la persona con el id $idPersona")
        }else{
            try {
                personaRepository!!.deleteById(idPersona)
            }catch (e:Exception){
                throw BusinessException(e.message)
            }
        }
    }

    fun ejemplos(){
        val variableInmutable: String //una vez se le asigne un valor no se puede modificar
        var variableMutable: String // se puede modificar su valor todas las veces que se quiera
        var numero = 2
        var numero2: Int
        numero2 = 2
        var string = ""
        var string2: String
        string2 = ""

    }
}