package ar.edu.unlam.pb2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Veterinaria {
	private String nombre;
	private List<Duenio> duenios;
	private List<Mascota> mascotas;
	private List<Atencion> atenciones;

	public Veterinaria(String nombre) {
		this.nombre = nombre;
		this.duenios = new ArrayList<>();
		this.mascotas = new ArrayList<>();
		this.atenciones = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void agregarDuenio(Duenio duenio) {
		this.duenios.add(duenio);

	}

	public Integer obtenerDuenios() {
		return this.duenios.size();
	}

	public Atencion registrarAtencion(Integer dniDuenio, Integer idMascota, Double precio)
			throws DuenioInexistenteException, MascotaNoEncontradaException {
		Duenio duenio = this.buscarDuenioPorId(dniDuenio);
		Mascota mascota = duenio.buscarMascota(idMascota);
		Integer idAtencion = atenciones.size() + 1;
		Atencion atencion = new Atencion(idAtencion, duenio, mascota, precio);
		this.agregarAtencion(atencion);
		return atencion;

	}

	private Mascota buscarMascotaPorId(Integer idMascota) {
		for (Mascota mascota : mascotas) {
			if (mascota.getId() == idMascota) {
				return mascota;
			}
		}
		return null;

	}

	private Duenio buscarDuenioPorId(Integer id) throws DuenioInexistenteException {
		for (Duenio duenio : duenios) {
			if (duenio.getDni().equals(id)) {
				return duenio;
			}
		}
		throw new DuenioInexistenteException("No se encontro el dueño");

	}

	public void agregarAtencion(Atencion atencion) {
		this.atenciones.add(atencion);

	}

	public Map obtenerMapa(Integer idAtencion, Integer idMascota) {
		Atencion atencion = buscarAtencion(idAtencion);
		Mascota mascota = atencion.getMascota();
		Map<Integer, Integer> atencionMapa = new HashMap<>();
		if (atencion.getId().equals(idAtencion) && mascota.getId().equals(idMascota)) {
			atencionMapa.put(idAtencion, idMascota);
		}
		return atencionMapa;

	}

	private Atencion buscarAtencion(Integer id) {
		for (Atencion atencion : atenciones) {
			if (atencion.getId().equals(id)) {
				return atencion;
			}
		}
		return null;
	}

}
