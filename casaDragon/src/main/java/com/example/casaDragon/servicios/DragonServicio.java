package com.example.casaDragon.servicios;

import com.example.casaDragon.helpers.MensajeServicios;
import com.example.casaDragon.models.Dragon;
import com.example.casaDragon.repositorios.DragonRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DragonServicio {

    @Autowired
    DragonRepositorio dragonRepositorio;
    //agregarUnDragon
    public Dragon agregarDragon(Dragon datosDragon) throws Exception{
        //llamar a las validaciones
        try{
            return dragonRepositorio.save(datosDragon);
        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }
    //buscarTodosDragones
    public List<Dragon> buscarDragones()throws Exception{
        try{
            return dragonRepositorio.findAll();
        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //BuscarUnDragonLLavePrimaria
    public Dragon buscarDragonPorId(Integer idDrgon)throws Exception{
        try{

            Optional<Dragon>dragonEncontrado= dragonRepositorio.findById(idDrgon);
            if(dragonEncontrado.isPresent()){
                return dragonEncontrado.get();
            }else{
                throw new Exception(MensajeServicios.USUARIO_NO_ENCONTRADO.getMensaje());
            }

        }
        catch(Exception error){
            throw new Exception(error.getMessage());
        }


    }


    //EditarInformacionDragon
    public Dragon modificarDragon(Integer idDragon, Dragon datosNuevosDragon) throws Exception{
        try{
            //Buscar el dragon que me van a editar
            Optional<Dragon> dragonEncontrado=dragonRepositorio.findById(idDragon);
            if(dragonEncontrado.isPresent()){
                //Traer los datos del dragon que estan en la BD
                Dragon dragon = dragonEncontrado.get();

                //Guardo los datos nuevos del dragon utilizando el mismo objeto
                dragon.setEdad(datosNuevosDragon.getEdad());
                return dragonRepositorio.save(dragon);

            }else{
                throw new Exception(MensajeServicios.USUARIO_NO_ENCONTRADO.getMensaje());
            }

        }catch(Exception error){
            throw  new Exception(error.getMessage());
        }
    }

    //EliminarDragon
    public boolean eliminarDragon(Integer id)throws Exception{
        try{
            Optional<Dragon> dragonEncontrado=dragonRepositorio.findById(id);
            if(dragonEncontrado.isPresent()){
                dragonRepositorio.deleteById(id);
                return true;

            }else{
                throw new Exception(MensajeServicios.USUARIO_NO_ENCONTRADO.getMensaje());
            }

        }catch(Exception error){
            throw  new Exception(error.getMessage());
        }
    }
    //buscarUnDragonNombre

}
