package igu;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.objects.Cliente;
import logica.play.Clientes;

import java.awt.Toolkit;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaRegistro extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btFinalizar;
	private JLabel lbNombre;
	private JLabel lbApellidos;
	private JLabel lblDni;
	private JTextField txDni;
	private JTextField txApellidos;
	private JTextField txNombre;
	private Clientes clientes;

	/**
	 * Create the frame.
	 */
	public VentanaRegistro(Locale locale, Clientes clientes) {
		this.clientes = clientes;
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaRegistro.class.getResource("/img/BINGO.png")));
		setTitle("Ventana Registro");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 864, 555);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getBtFinalizar());
		contentPane.add(getLbNombre());
		contentPane.add(getLbApellidos());
		contentPane.add(getLblDni());
		contentPane.add(getTxDni());
		contentPane.add(getTxApellidos());
		contentPane.add(getTxNombre());
		localizar(locale);
	}

	/**
	 * Metodo que internacionaliza la ventana
	 * 
	 * @param locale de tipo Locale, idioma al que internacionalizar
	 */
	private void localizar(Locale locale) {
		ResourceBundle textos = ResourceBundle.getBundle("rcs/textos", locale);

		// Boton finalizar
		String btFinalizar = textos.getString("btCancelar");
		getBtFinalizar().setText(btFinalizar);

		// Etiqueta DNI
		String lblDni = textos.getString("lblDni");
		getLblDni().setText(lblDni);

		// Etiqueta nombre
		String lbNombre = textos.getString("lbNombre");
		getLbNombre().setText(lbNombre);

		// Etiqueta Apellidos
		String lbSurname = textos.getString("lbSurname");
		getLbApellidos().setText(lbSurname);
		
		//Mnemonic BTFinalizar
		String mnBtCancAdd = textos.getString("mnBtCancAdd");
		getBtFinalizar().setMnemonic(mnBtCancAdd.charAt(0));
		
		//Mnemonico Nombre
		String mnNombreAdd = textos.getString("mnNombreAdd");
		getLbNombre().setDisplayedMnemonic(mnNombreAdd.charAt(0));
		
		//Mnemonic Apellido
		String mnApellidosAdd = textos.getString("mnApellidosAdd");
		getLbApellidos().setDisplayedMnemonic(mnApellidosAdd.charAt(0));
		
		//Mnemonic DNI
		String mnDniAdd = textos.getString("mnDniAdd");
		getLblDni().setDisplayedMnemonic(mnDniAdd.charAt(0));

	}

	private JButton getBtFinalizar() {
		if (btFinalizar == null) {
			btFinalizar = new JButton("Finalizar");
			btFinalizar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					grabarDatosEnFichero();
					dispose();
				}
			});
			btFinalizar.setForeground(Color.WHITE);
			btFinalizar.setBackground(new Color(0, 128, 0));
			btFinalizar.setBounds(314, 443, 218, 62);
		}
		return btFinalizar;
	}

	/**
	 * Metodo que graba los datos escritos en la ventana, en un fichero
	 */
	protected void grabarDatosEnFichero() {
		Cliente c = new Cliente(getTxDni().getText(), getTxNombre().getText(), getTxApellidos().getText(), 20);

		// ARREGLAR CLIENTE VALIDO
		if (clientes.existeCliente(c)) {
			clientes.añadirDinero(c);
		} else if (clientes.clienteValido(c)) {
			clientes.add(c);
		}
		clientes.grabarFicheros();

	}

	private JLabel getLbNombre() {
		if (lbNombre == null) {
			lbNombre = new JLabel("Su nombre");
			lbNombre.setLabelFor(getTxNombre());
			lbNombre.setHorizontalAlignment(SwingConstants.LEFT);
			lbNombre.setFont(new Font("Arial", Font.BOLD, 15));
			lbNombre.setBounds(37, 70, 341, 62);
		}
		return lbNombre;
	}

	private JLabel getLbApellidos() {
		if (lbApellidos == null) {
			lbApellidos = new JLabel("Sus apellidos");
			lbApellidos.setLabelFor(getTxApellidos());
			lbApellidos.setHorizontalAlignment(SwingConstants.LEFT);
			lbApellidos.setFont(new Font("Arial", Font.BOLD, 15));
			lbApellidos.setBounds(37, 194, 341, 62);
		}
		return lbApellidos;
	}

	private JLabel getLblDni() {
		if (lblDni == null) {
			lblDni = new JLabel("Su Dni");
			lblDni.setLabelFor(getTxDni());
			lblDni.setHorizontalAlignment(SwingConstants.LEFT);
			lblDni.setFont(new Font("Arial", Font.BOLD, 15));
			lblDni.setBounds(37, 322, 341, 62);
		}
		return lblDni;
	}

	private JTextField getTxDni() {
		if (txDni == null) {
			txDni = new JTextField();
			txDni.setColumns(10);
			txDni.setBounds(417, 322, 391, 62);
		}
		return txDni;
	}

	private JTextField getTxApellidos() {
		if (txApellidos == null) {
			txApellidos = new JTextField();
			txApellidos.setColumns(10);
			txApellidos.setBounds(417, 194, 391, 62);
		}
		return txApellidos;
	}

	private JTextField getTxNombre() {
		if (txNombre == null) {
			txNombre = new JTextField();
			txNombre.setColumns(10);
			txNombre.setBounds(417, 70, 391, 62);
		}
		return txNombre;
	}
}
