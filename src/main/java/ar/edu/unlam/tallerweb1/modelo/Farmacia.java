package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Farmacia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String telefono;
	private String diaDeTurno;
	@OneToOne
	private Direccion calle;
	
	

	public Farmacia(String nombre, String numero, String diaDeTurno) {
		this.nombre = nombre;
		this.telefono = numero;
		this.diaDeTurno = diaDeTurno;
	}
	public Farmacia(String nombre, String numero, String diaDeTurno, Direccion calle) {
		this.nombre = nombre;
		this.telefono = numero;
		this.diaDeTurno = diaDeTurno;
		this.calle = calle;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNumero() {
		return telefono;
	}
	public void setNumero(String numero) {
		this.telefono = numero;
	}
	public String getDiaDeTurno() {
		return diaDeTurno;
	}
	public void setDiaDeTurno(String diaDeTurno) {
		this.diaDeTurno = diaDeTurno;
	}
	public Long getId() {
		return id;
	}
	public Direccion getCalle() {
		return calle;
	}
	public void setCalle(Direccion calle) {
		this.calle = calle;
	}

}
