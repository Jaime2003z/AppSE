package Proyecto;

public class Persona {
	private String nombre;
	private String tipo;
	private String prioridad;

	public Persona(String nombre, String tipo, String prioridad) {
		this.nombre = nombre;
		this.tipo = tipo;
		this.prioridad = prioridad;
	}

	public String getNombre() {
		return nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public String getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(String prioridad) {
		this.prioridad = prioridad;
	}
}
