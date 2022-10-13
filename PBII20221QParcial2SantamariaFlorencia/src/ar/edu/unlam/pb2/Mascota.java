package ar.edu.unlam.pb2;

public class Mascota implements Comparable <Mascota>{
	private String nombre;
	private Integer id;
	private String apodo;
	private TipoMascota tipoMascota;
	
	public Mascota(String nombre, Integer id, String apodo, TipoMascota tipoMascota) {
		this.nombre = nombre;
		this.id = id;
		this.apodo = apodo;
		this.tipoMascota = tipoMascota;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getApodo() {
		return apodo;
	}

	public void setApodo(String apodo) {
		this.apodo = apodo;
	}

	public TipoMascota getTipoMascota() {
		return tipoMascota;
	}

	public void setTipoMascota(TipoMascota tipoMascota) {
		this.tipoMascota = tipoMascota;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mascota other = (Mascota) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public int compareTo(Mascota o) {
		
		return this.getId().compareTo(o.getId());
	}
	
	
	
	

}
