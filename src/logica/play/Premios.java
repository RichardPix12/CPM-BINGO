package logica.play;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import logica.objects.Premio;
import logica.util.FileUtil;

public class Premios {

	private static final String FICHERO_PREMIOS = "files/premios.dat";
	private static final String FICHERO_GIFTS = "files/gifts.dat";
	private List<Premio> listaPremios;
	private List<Premio> listaGifts;
	private int lines;
	private boolean bingo;
	private List<Premio> premiosFinales;

	public Premios() {
		reiniciar();
	}

	public void reiniciar() {
		listaPremios = new ArrayList<Premio>();
		listaGifts = new ArrayList<Premio>();
		premiosFinales = new ArrayList<Premio>();
		cargarPremios();
		setBingo(false);
		setLines(0);
	}

	private void cargarPremios() {
		FileUtil.loadFilePremio(FICHERO_PREMIOS, listaPremios);
		FileUtil.loadFilePremio(FICHERO_GIFTS, listaGifts);
	}

	public Premio[] getPremios() {
		Premio[] premios = listaPremios.toArray(new Premio[listaPremios.size()]);
		return premios;
	}

	private List<Premio> getLineasPremios(Locale locale) {
		String idioma = String.valueOf(locale);
		List<Premio> pr = new ArrayList<Premio>();
		if (idioma.equals("en")) {
			for (Premio p : listaGifts) {
				if (p.getType().equals("l")) {
					pr.add(p);
				}
			}
		} else {
			for (Premio p : listaPremios) {
				if (p.getType().equals("l")) {
					pr.add(p);
				}
			}
		}
		return pr;
	}

	public Premio[] getPremiosLinea(Locale locale) {
		List<Premio> pr = getLineasPremios(locale);
		Premio[] premios = pr.toArray(new Premio[pr.size()]);
		return premios;
	}

	public Premio[] getPremiosBingo(Locale locale) {
		List<Premio> pr = getBingoPremios(locale);
		Premio[] premios = pr.toArray(new Premio[pr.size()]);
		return premios;
	}
	// METODOS PARA AYUDA

	private List<Premio> getBingoPremios(Locale locale) {
		String idioma = String.valueOf(locale);
		List<Premio> pr = new ArrayList<Premio>();
		if (idioma.equals("en")) {
			for (Premio p : listaGifts) {
				if (p.getType().equals("b")) {
					pr.add(p);
				}
			}
		} else {
			for (Premio p : listaPremios) {
				if (p.getType().equals("b")) {
					pr.add(p);
				}
			}
		}

		return pr;
	}

	public int getLines() {
		return lines;
	}

	public List<Premio> getPremiosFinales() {
		return premiosFinales;
	}

	public void setPremiosFinales(List<Premio> premiosFinales) {
		this.premiosFinales = premiosFinales;
	}

	public void setLines(int lines) {
		this.lines = lines;
	}

	public boolean isBingo() {
		return bingo;
	}

	public void setBingo(boolean bingo) {
		this.bingo = bingo;
	}

	public int getDimensions() {
		int dimensiones = 0;
		for (Premio p : listaPremios) {
			if (p.getName() != null) {
				dimensiones++;
			}
		}
		return dimensiones;
	}

	public Premio getElements(int i, Locale locale) {
		String idioma = String.valueOf(locale);
		if (idioma.equals("en")) {
			return listaGifts.get(i);
		}
		return listaPremios.get(i);
	}

	public void cantarBingo() {
		this.bingo = true;
	}

	public void addPremio(Premio p) {
		int contador = 0;
		for (Premio pr : premiosFinales) {
			if (pr.getCode().equals(p.getCode()))
				contador++;
		}
		if (contador <= 0) {
			premiosFinales.add(p);
			if (p.getType().equals("l")) {
				lines--;
			} else if (p.getType().equals("b")) {
				bingo = false;
			}
		}

	}

	public void eliminarPremio(Premio p) {
		for (int i = 0; i < premiosFinales.size(); i++) {
			if (premiosFinales.get(i).getCode() == p.getCode()) {
				premiosFinales.remove(i);
				if (p.getType().equals("l")) {
					lines++;
				} else if (p.getType().equals("b")) {
					bingo = true;
				}
			}
		}

	}

	public int getPremiosFinalesDimension() {
		int dimensiones = 0;
		for (Premio p : premiosFinales) {
			if (p.getName() != null) {
				dimensiones++;
			}
		}
		return dimensiones;
	}

	public Premio getPremiosF(int i) {
		return premiosFinales.get(i);
	}

	public String getNumeroPremios() {
		String str = "";

		if (bingo == true) {
			str += "1 bingo + ";
		}
		str += getLines() + " lines";

		if (numberPremios() == 0) {
			str = "0";
		}

		return str;

	}

	public int numberPremios() {
		int premios = lines;
		if (bingo == true) {
			premios++;
		}

		return premios;
	}

	public boolean hayPremios() {
		return numberPremios() != 0;
	}

	public void cantarLinea() {
		if (lines < 2) {
			lines++;
		}
	}

	public boolean hayLineas() {
		return lines > 0;
	}

	public String getPremiosConseguidos() {
		String str = "";
		for (Premio p : premiosFinales) {
			str += p.getName() + " ";
		}
		return str;
	}

}
