package logica.objects.tablero;

public class Casilla {
	
	private int numero;
	private boolean magicNumber;
	private boolean marcate;
	
	
	public Casilla() {
		setNumero(0);
		setMagicNumber(false);
		setMarcate(false);
	}
	
	public Casilla(int numero) {
		setNumero(numero);
		setMagicNumber(false);
		setMarcate(false);
	}


	public int getNumero() {
		return numero;
	}


	private void setNumero(int numero) {
		this.numero = numero;
	}

	public boolean isMagicNumber() {
		return magicNumber;
	}

	public void setMagicNumber(boolean magicNumber) {
		this.magicNumber = magicNumber;
	}

	public boolean isMarcate() {
		return marcate;
	}

	public void setMarcate(boolean marcate) {
		this.marcate = marcate;
	}
	
	
	
	
}
