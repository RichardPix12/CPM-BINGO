package logica.play;

import java.util.ArrayList;

import logica.objects.Tablero;
import logica.util.Bombo;

public class Bingo {
	private static final int NUM_DISPAROS =15;

	private Tablero tablero;
	private ArrayList<Integer> numerosUtilizados;
	private int disparos;
	private int ultimoNumero;
	private boolean bingo;
	private int lines;

	public Bingo() {
		reiniciaBingo();
	}

	public void reiniciaBingo() {
		setTablero(new Tablero());
		numerosUtilizados = new ArrayList<Integer>();
		disparos = NUM_DISPAROS;
		ultimoNumero = 0;
		bingo = false;

	}

	public Tablero getTablero() {
		return tablero;
	}

	public void setTablero(Tablero tablero) {
		this.tablero = tablero;
	}

	public int nuevoNumero() {

		while (disparos > 0) {

			int numero = Bombo.tirar();
			int contador = 1;

			while (contador > 0) {

				if (validarNumero(numero)) {
					contador--;
				} else {
					numero = Bombo.tirar();
				}

			}

			numerosUtilizados.add(numero);
			disparos--;
			ultimoNumero = numero;
			return numero;

		}
		return 0;

	}

	public boolean validarNumero(int numero) {

		for (int n : numerosUtilizados) {
			if (n == numero) {
				return false;
			}
		}
		return true;
	}

	public int getDimensiones() {
		return tablero.getDimensiones();
	}

	public String numeroCorrespondiente(int i) {
		String str = String.valueOf(tablero.listaNumeros().get(i));
		return str;
	}

	public boolean isMagicNumber(int i) {

		return tablero.isMagic(i);

	}

	public boolean isValidNumber(Integer i) {
		return ultimoNumero == tablero.getNumero(i);
	}

	public void marcarCasilla(Integer i) {
		tablero.marcarCasilla(i);

	}

	public boolean esBingo() {
		return tablero.isBingo();
	}

	public void cantarBingo() {
		if (esBingo()) {
			setBingo(true);
		}

	}

	private void setBingo(boolean b) {
		this.bingo = b;

	}

	public boolean isEnd() {
		return bingo == true || disparos == 0;
	}

	public boolean esLinea(int i) {
		return tablero.esLinea(i);
	}

	public boolean esNumeroMagico() {
		return tablero.esNumeroMagico();
	}

	public boolean hayPremios() {
		return numeroPremios() != 0;
	}

	private int numeroPremios() {
		int pr = lines;
		
		if (bingo == true) {
			pr++;
		}
		return pr;
	}

	public void cantarLinea() {
		if (lines < 2) {
			lines++;
		}
		
	}

	public boolean hayRegistro() {
		// TODO Auto-generated method stub
		return tablero.registro();
	}

	public String getNumerosUsados() {
		String str = "";
		for(int n: numerosUtilizados) {
			str += n+" ";
		}
		
		
		return str;
	}

}
