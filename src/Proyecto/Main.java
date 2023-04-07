package Proyecto;

import java.util.*;
public class Main {
	public static void main(String[] args) {
		ArrayList<Persona> pacientes = new ArrayList<>();
		pacientes.add(new Persona("Juan", "Niño", "No Grave"));
		pacientes.add(new Persona("Maria", "Adulto", "Grave - Cirugía"));
		pacientes.add(new Persona("Pedro", "Adulto Mayor", "Crónico"));
		pacientes.add(new Persona("Luisa", "Adulto", "No Grave"));
		pacientes.add(new Persona("Carlos", "Adulto Mayor", "Grave - Hospitalización"));
		pacientes.add(new Persona("Ana", "Niño", "Crónico"));
		pacientes.add(new Persona("Marta", "Adulto", "Grave - Hospitalización"));
		pacientes.add(new Persona("Jorge", "Niño", "No Grave"));
		pacientes.add(new Persona("Sofia", "Adulto Mayor", "Grave - Cirugía"));
		pacientes.add(new Persona("David", "Niño", "Grave - Hospitalización"));
		pacientes.add(new Persona("Sofia", "Adulto", "Grave - Cirugía"));
		
		EPS eps = new EPS(2, 1, 1, 1, 1, pacientes);
		eps.atenderPacientes();
		eps.actualizarPrioridades();
	}

}
