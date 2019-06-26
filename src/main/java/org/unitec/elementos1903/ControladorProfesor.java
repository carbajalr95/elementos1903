/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.unitec.elementos1903;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Servicios Especiales
 */
@RestController
@RequestMapping("/api")
public class ControladorProfesor {
    //METODO DE GUARDADO
    
    @Autowired
    RepoProfesor repoProfe;
    
    //GUARDAR
    @PostMapping("/profesor")
    public Estatus guardar(@RequestBody String json) throws Exception{
        
        //PRIMERO VAMOS A RECIBIR UN JSON DEL CLIENTE
        //A UN OBJETO JAVA CON LA CLASE OBJECT MAPPER
        
        ObjectMapper maper=new ObjectMapper();
        
        //ahora si lo leemos
        
       Profesor profe= maper.readValue(json,Profesor.class);
       
       repoProfe.save(profe);
        // Generamos el status
       Estatus e=new Estatus();
       e.setMensaje("Profe guardado con exito");
       e.setSuccess(true);
               
               
       return e;
    }
    @GetMapping("/profesor")
    public List<Profesor>buscarTodos(){
        return repoProfe.findAll();
    }
    //BORRAR
    @DeleteMapping("/profesor/(id)")
    public Estatus borrar(@PathVariable Integer id){
        repoProfe.deleteById(id);
        Estatus e=new Estatus();
        e.setSuccess(true);
        e.setMensaje("PROFESOR BORRADO CON EXITO");
        return e;
    }

    //ACTUALIZAR
    @PutMapping("/profesor")
    public Estatus actualizar(@RequestBody String json) throws Exception{
        //PRIMERO VAMOS A RECIBIR UN JSON DEL CLIENTE
        //A UN OBJETO JAVA CON LA CLASE OBJECT MAPPER
        
        ObjectMapper maper=new ObjectMapper();
        
        //ahora si lo leemos
        
       Profesor profe= maper.readValue(json,Profesor.class);
       
       repoProfe.save(profe);
        // Generamos el status
       Estatus e=new Estatus();
       e.setMensaje("Profe guardado con exito");
       e.setSuccess(true);
               
               
       return e;
    }
    //BUSCAR POR ID
    @GetMapping("/profesor/(id)")
    public Profesor buscarPorId(@PathVariable Integer id){
        
        return repoProfe.findById(id).get();
    }

    
}
