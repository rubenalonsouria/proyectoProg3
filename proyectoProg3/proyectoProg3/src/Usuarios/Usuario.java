package Usuarios;

import java.time.LocalDate;

public abstract class Usuario {
	protected static int id;// identificacion para el cine
	protected String correo;
	protected String password;
	protected String nombre;
	protected String apellido;
	protected String dni;
	protected LocalDate fechaNacimineto; // Si es tu cumpleanos descuento, COMPROBAR funcionamiento localDate.

	// Constructor con todos los atributos
	public Usuario(String correo, String password, String nombre, String apellido, String dni,
			LocalDate fechaNacimineto) {
		super();
		this.correo = correo;
		this.password = password;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.fechaNacimineto = fechaNacimineto;
		id = id + 1;

	}
	// Getters y setters

	public static int getId() {
		return id;
	}

	public static void setId(int id) {
		Usuario.id = id;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public LocalDate getFechaNacimineto() {
		return fechaNacimineto;
	}

	public void setFechaNacimineto(LocalDate fechaNacimineto) {
		this.fechaNacimineto = fechaNacimineto;
	}
	// ToString

	@Override
	public String toString() {
		return "Usuario [correo=" + correo + ", password=" + password + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", dni=" + dni + ", fechaNacimineto=" + fechaNacimineto + "]";
	}

}
