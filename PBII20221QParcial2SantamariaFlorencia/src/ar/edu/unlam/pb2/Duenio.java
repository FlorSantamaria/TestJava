package ar.edu.unlam.pb2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;


public class Duenio {
	private Integer dni;
	private String nombre;
	private Set<Mascota>mascotas;
	
	public Duenio(Integer dni, String nombre) {
		this.dni = dni;
		this.nombre = nombre;
		this.mascotas=new TreeSet<>();
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void agregarMascota(Mascota mascota) {
		this.mascotas.add(mascota);
		
	}

	public Integer obtenerCantidadDeMascotas() {
		return this.mascotas.size();
	}

	public Boolean sePudoagregarMascota(Mascota mascota, Mascota mascota2) throws mascotaDuplicadaException {
		if(mascota.compareTo(mascota2)==0){
			throw new mascotaDuplicadaException("Mascota duplicada");
			
		}
		return true;
		
		
	}

	public Mascota buscarMascota(Integer idMascota) throws MascotaNoEncontradaException {
		for (Mascota mascota : mascotas) {
			if(mascota.getId().equals(idMascota)){
				return mascota;
			}
		}
		throw new MascotaNoEncontradaException("No se encontró la mascota");
	}

	public TreeSet<Mascota> obtenerMascotasOrdenadasPorApodo() {
		TreeSet<Mascota> mascotasOrdenadas = new TreeSet<>(new OrdenPorApodo());
		for (Mascota mascota : mascotas) {
			if(mascota.getTipoMascota().equals(TipoMascota.DOMESTICA)){
				mascotasOrdenadas.addAll(mascotas);
			}
		}
		
		return mascotasOrdenadas;
	}
	
	
	
	

}
