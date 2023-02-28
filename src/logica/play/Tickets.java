package logica.play;

import java.util.ArrayList;
import java.util.List;

import logica.objects.Ticket;
import logica.util.FileUtil;

public class Tickets {
	
	public static final float PRECIO_MINIMO = 30;
	private static final String FICHERO_TICKETS = "files/tickets.dat";
	private List<Ticket> listaTickets;
	
	public Tickets() {
		reiniciar();
	}
	
	public void reiniciar() {
		listaTickets = new ArrayList<Ticket>();
		cargarTickets();
	}

	private void cargarTickets() {
		FileUtil.loadFileTicket(FICHERO_TICKETS, listaTickets);
		
	}

	@SuppressWarnings("unused")
	private Ticket[] getTickets() {
		Ticket[] tickets = listaTickets.toArray(new Ticket[listaTickets.size()]);
		return tickets;
	}
	
	
	
	//METODOS PARA AYUDA	

	public boolean comprobarSiExisteYEsValido(String code) {
		for(Ticket t : listaTickets) {
			if( t.getCode().equals(code) && t.getImporte()>= PRECIO_MINIMO) {
				return true;
			}
		}
		return false;
	}
}
