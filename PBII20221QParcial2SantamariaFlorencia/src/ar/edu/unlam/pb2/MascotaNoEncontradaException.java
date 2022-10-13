package ar.edu.unlam.pb2;

public class MascotaNoEncontradaException extends Exception {
	private String mensaje;

	public MascotaNoEncontradaException(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	
	
	

}
