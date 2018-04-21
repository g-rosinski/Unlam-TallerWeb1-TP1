package ar.edu.unlam.tallerweb1.persistencia;

import java.util.*;

import static org.assertj.core.api.Assertions.*;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Direccion;
import ar.edu.unlam.tallerweb1.modelo.Farmacia;

public class ConsultaDeFarmaciasTest extends SpringTest {
	
	@Test
	@Transactional @Rollback(true)
	public void consultaDeFarmaciaPorDiaDeTurno(){
		
		Farmacia farmacia1 = new Farmacia("Don Jose","4555-5555","2");
		Farmacia farmacia2 = new Farmacia("Don Juan","4555-5555","2");
		Farmacia farmacia3 = new Farmacia("Don Pepito","4555-5555","3");
		Farmacia farmacia4 = new Farmacia("Don Pepelepu","4555-5555","4");
		
		Session sessionTest = getSession();
		sessionTest.save(farmacia1);
		sessionTest.save(farmacia2);
		sessionTest.save(farmacia3);
		sessionTest.save(farmacia4);
		
		List<Farmacia> farmaciaTurnoBuscado = sessionTest.createCriteria(Farmacia.class).add(Restrictions.eq("diaDeTurno", "2")).list();
		assertThat(farmaciaTurnoBuscado.size()).isEqualTo(2);
		
	}
	
	@SuppressWarnings("unchecked")
	@Test
	@Transactional @Rollback(true)
	public void consultaDeFarmaciaPorCalle(){
		Direccion dir_Farmacia1 = new Direccion("Av. Rivadavia","7800");
		Direccion dir_Farmacia2 = new Direccion("Av. Rivadavia","2100");
		Direccion dir_Farmacia3 = new Direccion("Av. Cordoba","750");
		Direccion dir_Farmacia4 = new Direccion("Amenabar","960");
				
		Farmacia farmacia1 = new Farmacia("Don Jose","4555-5555","2", dir_Farmacia1);
		Farmacia farmacia2 = new Farmacia("Don Juan","4555-5555","2", dir_Farmacia2);
		Farmacia farmacia3 = new Farmacia("Don Pepito","4555-5555","3", dir_Farmacia3);
		Farmacia farmacia4 = new Farmacia("Don Pepelepu","4555-5555","4", dir_Farmacia4);
		
		Session sessionTest = getSession();
		
		sessionTest.save(dir_Farmacia1);
		sessionTest.save(dir_Farmacia2);
		sessionTest.save(dir_Farmacia3);
		sessionTest.save(dir_Farmacia4);
		
		sessionTest.save(farmacia1);
		sessionTest.save(farmacia2);
		sessionTest.save(farmacia3);
		sessionTest.save(farmacia4);
		
		List<Farmacia> farmaciasBuscadas = sessionTest.createCriteria(Farmacia.class)
														.createAlias("calle", "direccion")
														.add(Restrictions.like("direccion.calle","Av. Rivadavia"))
														.add(Restrictions.like("direccion.numero", "2100"))
														.list();
		assertThat(farmaciasBuscadas.size()).isEqualTo(1);
	}

}
