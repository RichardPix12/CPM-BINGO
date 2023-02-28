package logica.play;

import java.util.ArrayList;
import java.util.List;

import logica.objects.Cliente;
import logica.util.FileUtil;

public class Clientes {

	private static final String FICHERO_CLIENTES = "files/clientes.dat";
	private List<Cliente> listaClientes;

	public Clientes() {
		reiniciar();
	}

	public void reiniciar() {
		listaClientes = new ArrayList<Cliente>();
		cargarClientes();
	}

	private void cargarClientes() {
		FileUtil.loadFileCliente(FICHERO_CLIENTES, listaClientes);

	}

	@SuppressWarnings("unused")
	private Cliente[] getClientes() {
		Cliente[] clientes = listaClientes.toArray(new Cliente[listaClientes.size()]);
		return clientes;
	}

	// METODOS DE AYUDA

	public boolean isValid(String text) {

		for (Cliente c : listaClientes) {
			if (c.getDni().equals(text)) {
				return true;
			}
		}

		return false;
	}

	public Cliente getCliente(String text) {
		Cliente c = null;
		for (Cliente cli : listaClientes) {
			if (cli.getDni().equals(text)) {
				c = new Cliente(cli.getDni(), cli.getName(), cli.getSurnames(), cli.getImporte());
			}
		}

		return c;
	}

	public void add(Cliente c) {
		listaClientes.add(c);

	}

	public void grabarFicheros() {
		FileUtil.saveToFile(FICHERO_CLIENTES, listaClientes);

	}

	public boolean clienteValido(Cliente c) {
		return !(c.getDni().equals("") && c.getName().equals("") && c.getSurnames().equals(""));
	}

	public boolean existeCliente(Cliente c) {
		for (Cliente cl : listaClientes) {
			if (cl.getDni().equals(c.getDni())) {
				return true;
			}
		}
		return false;
	}

	public void añadirDinero(Cliente c) {
		for (int i = 0; i < listaClientes.size(); i++) {
			if (c.getDni().equals(listaClientes.get(i).getDni())) {
				listaClientes.get(i).addDinero();
			}
		}

	}

}
