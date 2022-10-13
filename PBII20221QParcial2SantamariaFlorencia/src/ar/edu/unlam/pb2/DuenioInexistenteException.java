package ar.edu.unlam.pb2;

public class DuenioInexistenteException extends Exception {
	private String mensaje;

	public DuenioInexistenteException(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	
	
	

}
