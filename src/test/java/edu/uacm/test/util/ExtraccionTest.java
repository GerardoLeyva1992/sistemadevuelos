package edu.uacm.test.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.dbunit.DatabaseUnitException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import edu.uacm.Application;


//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes =Application.class)
@WebAppConfiguration
public class ExtraccionTest {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	/*@Autowired
	DataSource dataSource;
	@Before
	public void iniciar() throws FileNotFoundException, SQLException, DatabaseUnitException, IOException{
		log.debug("Entrando a iniciar");
		DBUnitData.extraerDatasetsUnoxUno(dataSource.getConnection());	
	}
	*/
	@Test
	public void pruebaDeHumo(){
	
	
	
	
	}
	

}
