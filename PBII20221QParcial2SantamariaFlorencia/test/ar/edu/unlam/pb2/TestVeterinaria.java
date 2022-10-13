package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import java.util.Map;
import java.util.TreeSet;

import org.junit.Test;

public class TestVeterinaria {

	@Test
	public void queSePuedaInstanciarUnaVeterinariaConNombre() {
		Veterinaria veterinaria=new Veterinaria("VET");
		assertNotNull(veterinaria);
	}

	@Test
	public void queSePuedaCrearUnDuenioConDniYConNombre() {
		Duenio duenio= new Duenio(12345, "Florencia");
		assertNotNull(duenio);
	}
	
	@Test
	public void queSePuedaCrearUnaMascotaConNombreIdApodoYTipoDeMascota() {
		// El tipo de mascota puede ser solamente doméstica y exótica (enum)
		TipoMascota tipoMascota=TipoMascota.DOMESTICA;
		Mascota mascota=new Mascota("Arena",1,"Arenita",tipoMascota);
		assertNotNull(mascota);
	}
	
	@Test
	public void queSePuedaAgregarDosMascotasAUnDuenio() {
		TipoMascota tipoMascota=TipoMascota.DOMESTICA;
		Mascota mascota=new Mascota("Perro",1,"Arenita",tipoMascota);
		TipoMascota tipoMascota2=TipoMascota.DOMESTICA;
		Mascota mascota2=new Mascota("Gato",2,"Pepus",tipoMascota);
		Duenio duenio= new Duenio(12345, "Florencia");
		duenio.agregarMascota(mascota);
		duenio.agregarMascota(mascota2);
		Integer esperado=2;
		Integer obtenido=duenio.obtenerCantidadDeMascotas();
		assertEquals(esperado, obtenido);
		
		
	}
	
	@Test (expected = mascotaDuplicadaException.class)
	public void queAlAgregarDosMascotasConMismoIdParaUnMismoDuenioLanceUnaExcepcionMascotaDuplicadaException() throws mascotaDuplicadaException {
		TipoMascota tipoMascota=TipoMascota.DOMESTICA;
		Mascota mascota=new Mascota("Perro",1,"Arenita",tipoMascota);
		TipoMascota tipoMascota2=TipoMascota.DOMESTICA;
		Mascota mascota2=new Mascota("Gato",1,"Pepus",tipoMascota);
		Duenio duenio= new Duenio(12345, "Florencia");
		
		
		duenio.sePudoagregarMascota(mascota, mascota2);
		
		
	}
	
	@Test
	public void queSePuedaCrearUnMedicamentoConIdDescripcionYPrecio() {
		Medicamento medicamento=new Medicamento(1,"Analgesico",350.0);
		assertNotNull(medicamento);
		
	}
	
	@Test
	public void queSePuedanAgregarDueniosDeMascotasAUnaVeterinaria() {
		Veterinaria veterinaria=new Veterinaria("VET");
		Duenio duenio= new Duenio(12345, "Florencia");
		veterinaria.agregarDuenio(duenio);
		Integer esperado=1;
		Integer obtenido=veterinaria.obtenerDuenios();
		assertEquals(esperado, obtenido);
		
		
		
	}
	
	@Test
	public void queSePuedaCrearUnaAtencionConUnDuenioUnaMascotaYPrecio() throws DuenioInexistenteException, MascotaNoEncontradaException{
		Veterinaria veterinaria=new Veterinaria("VET");
		Duenio duenio= new Duenio(12345, "Florencia");
		TipoMascota tipoMascota=TipoMascota.DOMESTICA;
		Mascota mascota=new Mascota("Perro",1,"Arenita",tipoMascota);
		veterinaria.agregarDuenio(duenio);
		duenio.agregarMascota(mascota);
		Atencion atencion= veterinaria.registrarAtencion(duenio.getDni(), mascota.getId(),2000.0);
		assertNotNull(atencion);
		
		}
	
	
	
	
	@Test
	public void queSePuedaAsignarVariosMedicamentosAUnaAtencion() {
		Duenio duenio= new Duenio(12345, "Florencia");
		TipoMascota tipoMascota=TipoMascota.DOMESTICA;
		Mascota mascota=new Mascota("Perro",1,"Arenita",tipoMascota);
		
		Atencion atencion= new Atencion(1,duenio,mascota, 2000.0);
		Medicamento medicamento=new Medicamento(1,"Analgesico",350.0);
		Medicamento medicamento2=new Medicamento(2,"Jarabe",500.0);
		atencion.agregarMedicamento(medicamento);
		atencion.agregarMedicamento(medicamento2);
		Integer esperado=2;
		Integer obtenido=atencion.obtenerMedicamentos();
		assertEquals(esperado, obtenido);
	}
	
	@Test
	public void queSePuedaCalcularElPrecioTotalDeUnaAtencion() throws DuenioInexistenteException, MascotaNoEncontradaException {
		// El precio total de la atencion será la suma 
		//del precio de la atencion mas la suma del precio de todos los medicamentos
		Veterinaria veterinaria=new Veterinaria("VET");
		Duenio duenio= new Duenio(12345, "Florencia");
		TipoMascota tipoMascota=TipoMascota.DOMESTICA;
		Mascota mascota=new Mascota("Perro",1,"Arenita",tipoMascota);
		veterinaria.agregarDuenio(duenio);
		duenio.agregarMascota(mascota);
		Atencion atencion= veterinaria.registrarAtencion(duenio.getDni(), mascota.getId(),2000.0);
		Medicamento medicamento=new Medicamento(1,"Analgesico",350.0);
		Medicamento medicamento2=new Medicamento(2,"Jarabe",500.0);
		atencion.agregarMedicamento(medicamento);
		atencion.agregarMedicamento(medicamento2);
		Double esperado=2850.0;
		Double obtenido=atencion.calcularPrecio();
		assertEquals(esperado, obtenido);
	}
	
	@Test
	public void queSePuedaObtenerDeUnDuenioUnaListaDeMascotasDomesticasOrdenadasPorApodo() {
		Veterinaria veterinaria=new Veterinaria("VET");
		Duenio duenio= new Duenio(12345, "Florencia");
		TipoMascota tipoMascota=TipoMascota.DOMESTICA;
		Mascota mascota=new Mascota("Perro",1,"Arenita",tipoMascota);
		Mascota mascota2=new Mascota("Perro",2,"Alma",tipoMascota);
		veterinaria.agregarDuenio(duenio);
		duenio.agregarMascota(mascota);
		duenio.agregarMascota(mascota2);
		TreeSet<Mascota> mascotas= duenio.obtenerMascotasOrdenadasPorApodo();
		String obtenido= mascotas.first().getApodo();
		String obtenido2= mascotas.last().getApodo();
		assertEquals("Alma", obtenido);
		assertEquals("Arenita", obtenido2);
	}
	
	@Test
	public void queSePuedaObtenerUnMapaConIdDeAtencionYIdDeMascota() throws DuenioInexistenteException, MascotaNoEncontradaException {
		Veterinaria veterinaria=new Veterinaria("VET");
		Duenio duenio= new Duenio(12345, "Florencia");
		TipoMascota tipoMascota=TipoMascota.DOMESTICA;
		Mascota mascota=new Mascota("Perro",1,"Arenita",tipoMascota);
		veterinaria.agregarDuenio(duenio);
		duenio.agregarMascota(mascota);
		Atencion atencion= veterinaria.registrarAtencion(duenio.getDni(), mascota.getId(),2000.0);
		Map <Integer, Integer> mapaObtenido= veterinaria.obtenerMapa(atencion.getId(),mascota.getId());
		assertTrue(mapaObtenido.containsKey(atencion.getId()));
		assertTrue(mapaObtenido.containsValue(mascota.getId()));
		
		
	}
	
}
