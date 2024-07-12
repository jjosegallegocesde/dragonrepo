package com.example.casaDragon.controladores;

import com.example.casaDragon.models.Dragon;
import com.example.casaDragon.servicios.DragonServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("casadradoapi/v1/dragon")
public class ControladorDragon {

    //Inyecta el servicio
    @Autowired
    DragonServicio dragonServicio;

    @PostMapping
    public ResponseEntity<?> guardarDragon(@RequestBody Dragon datosClienteDragon){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(dragonServicio.agregarDragon(datosClienteDragon));

        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());

        }
    }

    @GetMapping
    public ResponseEntity<?> buscarDragones(){
        return null;
    }

    /*@GetMapping
    public ResponseEntity<?> buscarDragon(){
        return null;
    }*/

    @PutMapping
    public ResponseEntity<?> editarDragon(){
        return null;
    }

    @DeleteMapping
    public ResponseEntity<?> eliminarDragon(){
        return null;
    }




}
