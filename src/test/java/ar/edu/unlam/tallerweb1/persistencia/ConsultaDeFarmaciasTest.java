package ar.edu.unlam.tallerweb1.persistencia;

import java.util.*;
import static org.assertj.core.api.Assertions.*;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Farmacia;

public class ConsultaDeFarmaciasTest extends SpringTest {
	
	@Test
	@Transactional @Rollback(true)
	public void consultaDeFarmaciaPorDiaDeTurno(){
		
		Farmacia Farmacia1 = new Farmacia("Don Jose","4555-5555","2");
		Farmacia Farmacia2 = new Farmacia("Don Juan","4555-5555","2");
		Farmacia Farmacia3 = new Farmacia("Don Pepito","4555-5555","3");
		Farmacia Farmacia4 = new Farmacia("Don Pepelepu","4555-5555","4");
		
		Session sessionTest = getSession();
		sessionTest.save(Farmacia1);
		sessionTest.save(Farmacia2);
		sessionTest.save(Farmacia3);
		sessionTest.save(Farmacia4);
		
		List<Farmacia> farmaciaTurnoBuscado = sessionTest.createCriteria(Farmacia.class).add(Restrictions.eq("diaDeTurno", "2")).list();
		assertThat(farmaciaTurnoBuscado.size()).isEqualTo(2);
		
	}

}
