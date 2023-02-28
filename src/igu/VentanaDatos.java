package igu;


import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.objects.Cliente;
import logica.play.Clientes;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class VentanaDatos extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Clientes clientes;
	private JButton btFinalizar;
	private JPanel pnDatos;
	private JLabel lbDni;
	private JLabel lbNombre;
	private JLabel lblSusApellidos;
	private JLabel lbDinero;
	private JTextField txDni;
	private JButton btAceptar;
	private JTextField txNombre;
	private JTextField txApellido;
	private JTextField txDinero;

	/**
	 * Create the frame.
	 */
	public VentanaDatos(Locale locale,Clientes clientes) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaDatos.class.getResource("/img/BINGO.png")));
		setTitle("Ventana Datos");
		setClientes(clientes);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 870, 546);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getBtFinalizar());
		contentPane.add(getPnDatos());
		localizar(locale);
	}
	/**
	 * Metodo que internacionaliza la ventana
	 * @param locale de tipo Locale, idioma hacia el que internacionalizar
	 */
	private void localizar(Locale locale) {
		ResourceBundle textos = ResourceBundle.getBundle("rcs/textos",locale);
		
		//Boton finalizar
		String btFinalizar = textos.getString("btCancelar");
		getBtFinalizar().setText(btFinalizar);
		
		//Boton aceptar
		String btAceptar = textos.getString("btAceptar");
		getBtAceptar().setText(btAceptar);
		
		//Etiqueta DNI
		String lbDni = textos.getString("lblDni");
		getLbDni().setText(lbDni);
		
		//Etiqueta nombre
		String lbNombre = textos.getString("lbNombre");
		getLbNombre().setText(lbNombre);
		
		//Etiqueta Apellidos
		String lbSurname = textos.getString("lbSurname");
		getLblSusApellidos().setText(lbSurname);
		
		//Etiqueta Dinero
		String lbDinero = textos.getString("lbDinero");
		getLbDinero().setText(lbDinero);
		
		//MNEMONIC ETIQUETA
		String mnLbDni = textos.getString("mnLbDni");
		getLbDni().setDisplayedMnemonic(mnLbDni.charAt(0));
		
		//Mnemonic finalizar
		String mnBtCanc = textos.getString("mnBtCanc");
		getBtFinalizar().setMnemonic(mnBtCanc.charAt(0));
		
		
	}

	public Clientes getClientes() {
		return clientes;
	}

	public void setClientes(Clientes clientes) {
		this.clientes = clientes;
	}
	
	

	private JButton getBtFinalizar() {
		if (btFinalizar == null) {
			btFinalizar = new JButton("Finalizar");
			btFinalizar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btFinalizar.setForeground(Color.WHITE);
			btFinalizar.setBackground(new Color(0, 128, 0));
			btFinalizar.setBounds(361, 453, 114, 23);
		}
		return btFinalizar;
	}
	private JPanel getPnDatos() {
		if (pnDatos == null) {
			pnDatos = new JPanel();
			pnDatos.setBounds(39, 24, 772, 404);
			pnDatos.setLayout(null);
			pnDatos.add(getLbDni());
			pnDatos.add(getLbNombre());
			pnDatos.add(getLblSusApellidos());
			pnDatos.add(getLbDinero());
			pnDatos.add(getTxDni());
			pnDatos.add(getBtAceptar());
			pnDatos.add(getTxNombre());
			pnDatos.add(getTxApellido());
			pnDatos.add(getTxDinero());
		}
		return pnDatos;
	}
	private JLabel getLbDni() {
		if (lbDni == null) {
			lbDni = new JLabel("Introduce el DNI:");
			lbDni.setDisplayedMnemonic('i');
			lbDni.setLabelFor(getTxDni());
			lbDni.setHorizontalAlignment(SwingConstants.LEFT);
			lbDni.setFont(new Font("Arial", Font.BOLD, 15));
			lbDni.setBounds(20, 23, 341, 62);
		}
		return lbDni;
	}
	private JLabel getLbNombre() {
		if (lbNombre == null) {
			lbNombre = new JLabel("Su Nombre:");
			lbNombre.setFont(new Font("Arial", Font.BOLD, 15));
			lbNombre.setHorizontalAlignment(SwingConstants.LEFT);
			lbNombre.setBounds(20, 119, 341, 62);
		}
		return lbNombre;
	}
	private JLabel getLblSusApellidos() {
		if (lblSusApellidos == null) {
			lblSusApellidos = new JLabel("Sus apellidos:");
			lblSusApellidos.setFont(new Font("Arial", Font.BOLD, 15));
			lblSusApellidos.setBounds(20, 213, 341, 62);
		}
		return lblSusApellidos;
	}
	private JLabel getLbDinero() {
		if (lbDinero == null) {
			lbDinero = new JLabel("Dinero conseguido:");
			lbDinero.setFont(new Font("Arial", Font.BOLD, 15));
			lbDinero.setBounds(20, 304, 341, 62);
		}
		return lbDinero;
	}
	private JTextField getTxDni() {
		if (txDni == null) {
			txDni = new JTextField();
			txDni.setBounds(371, 23, 190, 62);
			txDni.setColumns(10);
		}
		return txDni;
	}
	private JButton getBtAceptar() {
		if (btAceptar == null) {
			btAceptar = new JButton("Aceptar");
			btAceptar.setMnemonic('A');
			btAceptar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrar();
				}
			});
			btAceptar.setBackground(new Color(0, 128, 0));
			btAceptar.setForeground(new Color(255, 255, 255));
			btAceptar.setBounds(578, 23, 184, 62);
		}
		return btAceptar;
	}
	/**
	 * Metodo para mostras o limpiar los datos
	 */
	protected void mostrar() {
		if(clientes.isValid(getTxDni().getText())) {
			mostrarDatos();
		}
		else {
			limpiarDatos();
		}
		
	}
	/**
	 * Metodo para limpiar los datos
	 */
	private void limpiarDatos() {
		//Limpiar Nombre
		getTxNombre().setText("");
		//Limpiar Apellidos
		getTxApellido().setText("");
		//Limpiar dinero
		getTxDinero().setText("");
		
	}
	/**
	 * Metodo donde se muestran los datos
	 */
	private void mostrarDatos() {
		
		Cliente c = clientes.getCliente(getTxDni().getText());
		
		//Mostrar Nombre
		getTxNombre().setText(c.getName());
		//Mostrar Apellidos
		getTxApellido().setText(c.getSurnames());
		//Mostrar dinero
		getTxDinero().setText(String.valueOf(c.getImporte()));
	}

	private JTextField getTxNombre() {
		if (txNombre == null) {
			txNombre = new JTextField();
			txNombre.setEditable(false);
			txNombre.setBounds(371, 119, 391, 62);
			txNombre.setColumns(10);
		}
		return txNombre;
	}
	private JTextField getTxApellido() {
		if (txApellido == null) {
			txApellido = new JTextField();
			txApellido.setEditable(false);
			txApellido.setColumns(10);
			txApellido.setBounds(371, 213, 391, 62);
		}
		return txApellido;
	}
	private JTextField getTxDinero() {
		if (txDinero == null) {
			txDinero = new JTextField();
			txDinero.setEditable(false);
			txDinero.setColumns(10);
			txDinero.setBounds(371, 304, 391, 62);
		}
		return txDinero;
	}
}
