package logica.objects;

import java.util.ArrayList;
import java.util.List;

import logica.objects.tablero.Casilla;

public class Tablero {

	public static final int DIMENSIONES = 3;
	public static final int NUMERO_MAX = 30;

	Casilla[][] tablero;

	/*
	 * FALTA QUE NO SEAN IGUALES LOS NUMEROS
	 */

	public Tablero() {
		tablero = new Casilla[DIMENSIONES][DIMENSIONES];
		inicializaTablero();
		rellenaTablero();
		eligeNumeroMagico();
		print();
	}

	private void eligeNumeroMagico() {
		int i = (int) ((Math.random() * 2) + 1);
		int j = (int) ((Math.random() * 2) + 1);

		tablero[i][j].setMagicNumber(true);

	}

	private void inicializaTablero() {
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				tablero[i][j] = new Casilla();
			}
		}

	}

	private void rellenaTablero() {

		int[] numeros1 = numerosUno();
		int[] numeros2 = numerosDos();
		int[] numeros3 = numerosTres();

		Casilla[][] complementario = new Casilla[DIMENSIONES][DIMENSIONES];

		// Rellena la primera columna

		for (int i = 0; i < complementario.length; i++) {
			complementario[i][0] = new Casilla(numeros1[i]);
		}

		// Rellena la segunda columna

		for (int i = 0; i < complementario.length; i++) {
			complementario[i][1] = new Casilla(numeros2[i]);
		}

		// Rellena la tercera columna

		for (int i = 0; i < complementario.length; i++) {
			complementario[i][2] = new Casilla(numeros3[i]);
		}

		tablero = complementario;
	}

	private int[] numerosTres() {
		int[] numeros = new int[3];
		int numero = 0;
		for (int i = 0; i < numeros.length; i++) {
			numero = validaNumerosTres(numeros);
			numeros[i] = numero;
		}
		return numeros;
	}

	private int[] numerosDos() {
		int[] numeros = new int[3];
		int numero = 0;
		for (int i = 0; i < numeros.length; i++) {
			numero = validaNumerosDos(numeros);
			numeros[i] = numero;
		}
		return numeros;
	}

	private int[] numerosUno() {
		int[] numeros = new int[3];
		int numero = 0;
		for (int i = 0; i < numeros.length; i++) {
			numero = validaNumerosUno(numeros);
			numeros[i] = numero;
		}
		return numeros;
	}

	private int validaNumerosTres(int[] numeros) {
		int numero = numeroAleatorioVeinteATreinta();
		int contador = 1;
		while (contador > 0) {
			if (isValid(numeros, numero)) {
				contador--;
			} else {
				numero = numeroAleatorioVeinteATreinta();
			}
		}
		return numero;
	}

	private int validaNumerosDos(int[] numeros) {
		int numero = numeroAleatorioDiezAVeinte();
		int contador = 1;
		while (contador > 0) {
			if (isValid(numeros, numero)) {
				contador--;
			} else {
				numero = numeroAleatorioDiezAVeinte();
			}
		}
		return numero;
	}

	private int validaNumerosUno(int[] numeros) {
		int numero = numeroAleatorioCeroADiez();
		int contador = 1;
		while (contador > 0) {
			if (isValid(numeros, numero)) {
				contador--;
			} else {
				numero = numeroAleatorioCeroADiez();
			}
		}
		return numero;
	}

	// Metodos para ayuda

	private boolean isValid(int[] numeros, int numero) {
		for (int n : numeros) {
			if (n == numero) {
				return false;
			}
		}
		return true;
	}

	private void print() {
	}

	public Casilla[][] getTablero() {
		return tablero;
	}

	public void setTablero(Casilla[][] tablero) {
		this.tablero = tablero;
	}

	private int numeroAleatorioCeroADiez() {
		return ((int) (Math.random() * 9) + 1);
	}

	private int numeroAleatorioDiezAVeinte() {
		return ((int) (Math.random() * 10) + 10);
	}

	private int numeroAleatorioVeinteATreinta() {
		return ((int) (Math.random() * 10) + 21);
	}

	public int getDimensiones() {
		int dimensiones = 0;
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				dimensiones++;
			}
		}
		return dimensiones;
	}

	public List<Integer> listaNumeros() {

		List<Integer> lista = new ArrayList<Integer>();
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				lista.add(tablero[i][j].getNumero());
			}
		}

		return lista;

	}

	public boolean isMagic(int i) {
		List<Casilla> cas = listaTablero();

		return cas.get(i).isMagicNumber();

	}

	private List<Casilla> listaTablero() {
		List<Casilla> cas = new ArrayList<Casilla>();

		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				cas.add(tablero[i][j]);
			}
		}

		return cas;
	}

	public int getNumero(Integer i) {
		List<Casilla> cas = listaTablero();

		return cas.get(i).getNumero();
	}

	public void marcarCasilla(Integer i) {
		List<Casilla> cas = listaTablero();
		cas.get(i).setMarcate(true);

	}

	public boolean isBingo() {
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				if (!tablero[i][j].isMarcate()) {
					return false;
				}
			}
		}
		return true;
	}

	public boolean esNumeroMagico() {
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				if (tablero[i][j].isMagicNumber() && tablero[i][j].isMarcate()) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean esLinea(int x) {
		List<Casilla> cas = listaTablero();
		if (x <= 2) {
			return compruebaPrimeraLinea(cas);
		} else if (x > 2 && x <= 5) {
			return compruebaSegundaLinea(cas);
		} else if (x > 5 && x <= 8) {
			return compruebaTerceraLinea(cas);
		}
		return false;
	}

	private boolean compruebaTerceraLinea(List<Casilla> cas) {
		for (int i = 6; i < cas.size(); i++) {
			if (cas.get(i).isMarcate() == false) {
				return false;
			}
		}
		return true;
	}

	private boolean compruebaSegundaLinea(List<Casilla> cas) {
		for (int i = 3; i < 6; i++) {
			if (cas.get(i).isMarcate() == false) {
				return false;
			}
		}
		return true;
	}

	private boolean compruebaPrimeraLinea(List<Casilla> cas) {
		for (int i = 0; i < 3; i++) {
			if (cas.get(i).isMarcate() == false) {
				return false;
			}
		}
		return true;
	}
	
	public boolean registro() {
		List<Casilla> cas = listaTablero();
		for(int i = 0; i<cas.size();i++) {
			if(cas.get(i).isMagicNumber() == true) {
				 return esLinea(i);
			}
		}
		
		return false;
	}
	
}
