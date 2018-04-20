package ar.edu.unlam.tallerweb1.persistencia;

import org.hamcrest.core.IsNull;
import org.hibernate.Session;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Usuario;


public class PersistenciaDeUsuarioTest extends SpringTest {

	
	@Test
	@Transactional @Rollback(true)
	public void pruebaDeRegistrarUnUsuario(){
		Usuario userNuevo = new Usuario();
		userNuevo.setEmail("hola@dominio.com");
		userNuevo.setPassword("calle falsa");
		
		Session session = getSession();
		session.save(userNuevo);
		
		Usuario userBuscado = session.get(Usuario.class, userNuevo.getId());
		
		Assert.assertThat(userBuscado, IsNull.notNullValue());
	}
	
	@Test
	@Transactional @Rollback(true)
	public void pruebaDeModificarUnUsuario(){
		Usuario user = new Usuario();
		
		user.setEmail("hola@dominio.com");
		user.setPassword("calle falsa");
		user.setRol("Admin");
		
		Session session = getSession();
		session.save(user);
		
		Usuario userModificado = session.get(Usuario.class, user.getId());
		userModificado.setEmail("hola@modificado.com");
		
		session.save(userModificado);
		
		Assert.assertEquals( userModificado.getEmail(), user.getEmail());
		//Assert.assertEquals( user.getEmail(), "hola@dominio.com"); // Chequeo hardcode del mail
	}
	
	@Test
	@Transactional @Rollback(true)
	public void pruebaDeEliminacionDeUnUsuario(){
		Usuario user = new Usuario();

		user.setEmail("hola@dominio.com");
		user.setPassword("calle falsa");
		user.setRol("Admin");
		
		Session session = getSession();
		session.save(user);
		
		Usuario userDelete = session.get(Usuario.class, user.getId());
		session.delete(userDelete);
		session.flush();
		
		Assert.assertThat(session.get(Usuario.class, user.getId()), IsNull.nullValue());
	}
}
