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
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import edu.uacm.Application;
import edu.uacm.domain.Avion;
import edu.uacm.domain.AvionRepository;


//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes =Application.class)
@WebAppConfiguration
public class UsersDbUnitTestCase {  
	@Autowired
	DataSource dataSource;
	@Autowired
	AvionRepository rp;
	
	@Test
	public void findsAndReadsExistingPersonByFirstName() throws Exception {
		//PersonRepository repository = new PersonRepository(dataSource());
		//Person charlie = repository.findPersonByFirstName("Charlie");
	
		Avion a=rp.findOne(1L);
		//assertThat(charlie.getFirstName(), is("Charlie"));
		//assertThat(charlie.getLastName(), is("Brown"));
		//assertThat(charlie.getAge(), is(42));
	}
   
  
}  
