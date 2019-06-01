
import org.springframework.data.annotation.Id;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Servicios Especiales
 */
public class Cliente {
    
    @Id
    private Integer id;
    private String nombre;
    private String email;



    public Cliente(Integer id, String nombre, String email) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
    }
        public Cliente() {
    }
    
}
