package edu.uacm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.uacm.domain.Aeropuerto;
import edu.uacm.domain.AeropuertoRepository;
import edu.uacm.domain.Avion;
import edu.uacm.domain.AvionRepository;

@SpringBootApplication
public class Application implements CommandLineRunner {

   // @Autowired
    //private PostRepository repository;
    @Autowired
    private AeropuertoRepository AR;
    @Autowired
    private AvionRepository AV;
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    public void run(String... strings) throws Exception {
        //for (int i = 0; i < 5; i++) {
    	//Long i=3;
    	Aeropuerto ae=new Aeropuerto();
    	ae.setNombreaeropuerto("AeroTexas");
		ae.setCiudad("Ciudad de Mexico");
		ae.setPais("Mexico");
		AR.save(ae);
		Avion av=new Avion();
		av.setModeloavion("x87");
		av.setCapacidad(40);
		av.setLineaaerea("LineaExpress");
		AV.save(av);
		
          //  repository.save(new Post("My post number #" + (i+1)));
        //}
    }


}
