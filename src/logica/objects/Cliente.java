package logica.objects;

import java.text.DecimalFormat;

public class Cliente {

	private String name;
	private String surnames;
	private String dni;
	private float importe;
	
	
	public Cliente(String dni, String name, String surnames, float importe) {
		setName(name);
		setSurnames(surnames);
		setDni(dni);
		setImporte(importe);
	}
	
	
	public String getName() {
		return name;
	}
	private void setName(String name) {
		this.name = name;
	}
	public String getSurnames() {
		return surnames;
	}
	private void setSurnames(String surnames) {
		this.surnames = surnames;
	}
	public String getDni() {
		return dni;
	}
	private void setDni(String dni) {
		this.dni = dni;
	}
	public float getImporte() {
		return importe;
	}
	private void setImporte(float importe) {
		this.importe = importe;
	}


	public String serialize() {
		return dni+"@"+name+"@"+surnames+"@"+getImporteRedondeado();
	}


	private String getImporteRedondeado() {
		DecimalFormat format1 = new DecimalFormat("#");
		String str = format1.format(importe);
		System.out.print(str);
		return str;
	}


	public void addDinero() {
		importe = importe + 20;
		
	}
}
