package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Farmacia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String numero;
	private String diaDeTurno;
	
	
	public Farmacia(String nombre, String numero, String diaDeTurno) {
		this.nombre = nombre;
		this.numero = numero;
		this.diaDeTurno = diaDeTurno;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
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

}
