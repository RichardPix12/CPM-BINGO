package logica.objects;

public class Ticket {

	private String code;
	private float importe;
	
	public Ticket(String code, float importe) {
		setCode(code);
		setImporte(importe);
	}

	public String getCode() {
		return code;
	}

	private void setCode(String code) {
		this.code = code;
	}

	public float getImporte() {
		return importe;
	}

	private void setImporte(float importe) {
		this.importe = importe;
	}
	
}
