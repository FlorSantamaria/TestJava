package ar.edu.unlam.pb2;

import java.util.ArrayList;
import java.util.List;

public class Atencion {
	private Integer id;
	private Duenio duenio;
	private Mascota mascota;
	private Double precio;
	private List <Medicamento>medicamentos;
	
	public Atencion(Integer id, Duenio duenio, Mascota mascota, Double precio) {
		this.id=id;
		this.duenio = duenio;
		this.mascota = mascota;
		this.precio = precio;
		this.medicamentos=new ArrayList<>();
	}

	

	public Duenio getDuenio() {
		return duenio;
	}



	public void setDuenio(Duenio duenio) {
		this.duenio = duenio;
	}



	public Mascota getMascota() {
		return mascota;
	}



	public void setMascota(Mascota mascota) {
		this.mascota = mascota;
	}



	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}



	public void agregarMedicamento(Medicamento medicamento) {
	this.medicamentos.add(medicamento);
		
	}



	public Integer obtenerMedicamentos() {
		return this.medicamentos.size();
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public List<Medicamento> getMedicamentos() {
		return medicamentos;
	}



	public void setMedicamentos(List<Medicamento> medicamentos) {
		this.medicamentos = medicamentos;
	}



	public Double calcularPrecio() {
		Double resultado=this.precio;
		for (Medicamento medicamento : medicamentos) {
			resultado+=medicamento.getPrecio();
		}
		return resultado;
	}
	
	
	
	

}
