package org.unitec.elementos1903;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Elementos1903Application implements CommandLineRunner {
    
@Autowired
RepoCliente repoCliente;

	public static void main(String[] args) {
		SpringApplication.run(Elementos1903Application.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        //repoCliente.save(new Cliente(1, "Rody", "rodyypb@gmail.com"));
        //repoCliente.save(new Cliente(2, "Firulais", "firulais@gmail.com"));
        //***BUSCAR TODOS -findAll() Y BUSCAR POR EMAIL -finByEmail() [Referenciado en la clase "RepoCliente]***
        
        for(Cliente c: repoCliente.findByEmail("firulais@gmail.com")){
            System.out.println(c);
        }
        //***BUSCAR POR ID***
        System.out.println(repoCliente.findById(2));
        //***BORRAR EL PRIMERO Y VOLVEMOS A INSERTAR
        repoCliente.deleteById(1);
    }

}
