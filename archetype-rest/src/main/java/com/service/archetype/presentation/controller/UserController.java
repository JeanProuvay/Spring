package com.service.archetype.presentation.controller;

import com.service.archetype.data.entity.Usuario;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("admin")
public class UserController {

    //@Secured({"ROLE_USER","ROLE_ADMIN"})
    //@PreAuthorize("hasRole('ROLE_USER') OR hasRole('ROLE_ADMIN')")
    @GetMapping("users")
    public ResponseEntity<String> GetUsuario() {
           String helloWorld = "Devuelve un listado de todos los usuarios";
            return new ResponseEntity<>(helloWorld, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<String> GetUsuario(@RequestParam String id) {
        String helloWorld = "Devuelve el detalle del usuario";
        return new ResponseEntity<>(helloWorld, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<String> PostUsuario(@RequestBody Usuario usuario) {
        String helloWorld = "Crea un usuario";
        return new ResponseEntity<>(helloWorld, HttpStatus.OK);
    }

    @PatchMapping("")
    public ResponseEntity<String> PutUsuario(@RequestParam String id, @RequestBody Usuario usuario) {
        String helloWorld = "Modifica un usuario";
        return new ResponseEntity<>(helloWorld, HttpStatus.OK);
    }

    @DeleteMapping("")
    public ResponseEntity<String> DeleteUsuario(@RequestParam String id) {
        String helloWorld = "Elimina un usuario";
        return new ResponseEntity<>(helloWorld, HttpStatus.OK);
    }
}

/*

permisos con Roles especificos
mantenedor de usuarios con arquitectura RESTFul y
agregar Swagger
capa mapper de desacopleo del dominio
test unitarios
mantenedor roles con tdd

200 (Ok), cuando una operación fue exitosa.
201 (Created), cuando se creó un registro (recuerdan? con el método POST)
403 (Forbidden), cuando intentamos leer un registro para el que no tenemos acceso
404 (Not found), cuando intentamos leer un registro que no existe.
 */