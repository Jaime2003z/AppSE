package Proyecto;

import java.util.*;

public class EPS {
	private int numConsultorios;
	private int numCamillas;
	private int numQuirofanos;
	private int numMedicos;
	private int numFisioterapeutas;
	private ArrayList<Persona> pacientes;
	private Queue<Persona> consultas;
	private Queue<Persona> terapias;
	private Queue<Persona> urgencias;

	public EPS(int numConsultorios, int numCamillas, int numQuirofanos, int numMedicos, int numFisioterapeutas,
			ArrayList<Persona> pacientes) {
		this.numConsultorios = numConsultorios;
		this.numCamillas = numCamillas;
		this.numQuirofanos = numQuirofanos;
		this.numMedicos = numMedicos;
		this.numFisioterapeutas = numFisioterapeutas;
		this.pacientes = pacientes;
		this.consultas = new LinkedList<>();
		this.terapias = new LinkedList<>();
		this.urgencias = new LinkedList<>();
	}

	public void atenderPacientes() {
		for (Persona paciente : pacientes) {
			switch (paciente.getTipo()) {
			case "Niño":
				politicasNinios(paciente);
				break;
			case "Adulto":
				politicasAdultos(paciente);
				break;
			case "Adulto Mayor":
				politicasAdultosMayores(paciente);
				break;
			}
		}
	}

	public void politicasNinios(Persona paciente) {
		switch (paciente.getPrioridad()) {
		case "No Grave":
			consultas.add(paciente);
			break;
		case "Crónico":
			terapias.add(paciente);
			break;
		case "Grave - Hospitalización":
			urgencias.add(paciente);
			break;
		case "Grave - Cirugía":
			atenderCirugia(paciente);
			break;
		}
	}

	public void politicasAdultos(Persona paciente) {
		switch (paciente.getPrioridad()) {
		case "No Grave":
			consultas.add(paciente);
			break;
		case "Crónico":
			terapias.add(paciente);
			break;
		case "Grave - Hospitalización":
			urgencias.add(paciente);
			break;
		case "Grave - Cirugía":
			atenderCirugia(paciente);
			break;
		}
	}

	public void politicasAdultosMayores(Persona paciente) {
		switch (paciente.getPrioridad()) {
		case "No Grave":
			consultas.add(paciente);
			break;
		case "Crónico":
			terapias.add(paciente);
			break;
		case "Grave - Hospitalización":
			atenderHospitalizacion(paciente);
			break;
		case "Grave - Cirugía":
			atenderCirugia(paciente);
			break;
		}
	}

	public void atenderCirugia(Persona paciente) {
		if (numMedicos > 0 && numQuirofanos > 0) {
			System.out.println("Se atiende a " + paciente.getNombre() + " en quirófano.");
			paciente.setPrioridad("Grave - Hospitalización");
			numMedicos--;
			numQuirofanos--;
		} else {
			cancelarCitasMedicas(2);
			atenderCirugia(paciente);
		}
	}

	public void atenderHospitalizacion(Persona paciente) {
		if (numCamillas > 0) {
			System.out.println("Se hospitaliza a " + paciente.getNombre() + ".");
			paciente.setPrioridad("Grave - Cirugía");
			numCamillas--;
		} else {
			cancelarCitasMedicas(2);
			atenderHospitalizacion(paciente);
		}
	}

	public void cancelarCitasMedicas(int horas) {
		numMedicos++;
		numQuirofanos++;
		for (int i = 0; i < horas; i++) {
			if (!consultas.isEmpty()) {
				Persona paciente = consultas.poll();
				System.out.println("Se cancela la cita de " + paciente.getNombre() + ".");
			}
			if (!terapias.isEmpty()) {
				Persona paciente = terapias.poll();
				System.out.println("Se cancela la terapia de " + paciente.getNombre() + ".");
			}
		}
	}

	public void actualizarPrioridades() {
		Random random = new Random();
		for (Persona paciente : pacientes) {
			int nuevaPrioridad = random.nextInt(4);
			switch (nuevaPrioridad) {
			case 0:
				paciente.setPrioridad("No Grave");
				break;
			case 1:
				paciente.setPrioridad("Crónico");
				break;
			case 2:
				paciente.setPrioridad("Grave - Hospitalización");
				break;
			case 3:
				paciente.setPrioridad("Grave - Cirugía");
				break;
			}
		}
	}
}
