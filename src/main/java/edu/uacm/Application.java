package edu.uacm;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.uacm.domain.Aeropuerto;
import edu.uacm.domain.AeropuertoRepository;
import edu.uacm.domain.Avion;
import edu.uacm.domain.AvionRepository;
import edu.uacm.domain.Vuelo;
import edu.uacm.domain.VueloRepository;

@SpringBootApplication
public class Application implements CommandLineRunner {
	private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AeropuertoRepository AR;
    @Autowired
    private AvionRepository AV;
    @Autowired
    private VueloRepository V;
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    public void run(String... strings) throws Exception {      
    	log.debug("Entrando a Aeropuerto Insertar");
    	Aeropuerto ae=new Aeropuerto();
    	ae.setNombreaeropuerto("AeroTexas");
		ae.setCiudad("Ciudad de Mexico");
		ae.setPais("Mexico");
		AR.save(ae);
		log.debug("Entrando a Aviones Insertar");
		Avion av=new Avion();
		av.setModeloavion("x87");
		av.setCapacidad(40);
		av.setLineaaerea("LineaExpress");
		AV.save(av);
		log.debug("Entrando a Vuelos Insertar");
		Vuelo v=new Vuelo();
		SimpleDateFormat parseador = new SimpleDateFormat("dd/MM/yy HH:mm");
		Date date = parseador.parse("31/03/2016 17:23");
		Date date2 = parseador.parse("1/04/2016 02:23");
		v.setIdvuelo(100L);
		v.setHorallegada(date);
		v.setHorasalida(date2);
		v.setAeropuerto_idaeropuerto(1L);
		v.setAeropuerto_idaeropuerto2(4L);
		v.setAvion_idavion(1L);
		V.save(v);
		
		
       
    }


}
