package logica.util;

import logica.objects.Tablero;

public class Bombo {

	public static int tirar()
	{ 
		return ((int) (Math.random() * Tablero.NUMERO_MAX) + 1);
	}
}
