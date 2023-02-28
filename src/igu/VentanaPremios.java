package igu;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.objects.Premio;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Image;

import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class VentanaPremios extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private VentanaPrincipal vp;
	private JButton btRegistro;
	private JButton btContinuar;
	private JButton btCancelar;
	private JButton btAñadir;
	private JButton btEliminar;
	private JComboBox<Premio> cbPremios;
	private JScrollPane scPremios;
	private JList<Premio> listPremios;
	private DefaultListModel<Premio> modelListPremios;
	private JTextField txNumPremios;
	private JButton btPremioLinea;
	private JButton btPremioBingo;
	private JLabel lbImagen;

	/**
	 * Create the frame.
	 */
	public VentanaPremios(VentanaPrincipal vp) {
		setVp(vp);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 847, 530);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getBtRegistro());
		contentPane.add(getBtContinuar());
		contentPane.add(getBtCancelar());
		contentPane.add(getBtAñadir());
		contentPane.add(getBtEliminar());
		contentPane.add(getCbPremios());
		contentPane.add(getScPremios());
		contentPane.add(getTxNumPremios());
		contentPane.add(getBtPremioLinea());
		contentPane.add(getBtPremioBingo());
		contentPane.add(getLbImagen());
		localizar(getVp().isLocale());
		registro();
	}

	private void registro() {
		if (getVp().getBingo().hayRegistro()) {
			getBtRegistro().setEnabled(true);
			JOptionPane.showMessageDialog(this,
					"Has conseguido un premio en el que esta el numero magico, recuerda registrarte para obtener ese premio");
		}

	}

	private void localizar(Locale locale) {
		ResourceBundle textos = ResourceBundle.getBundle("rcs/textos", locale);

		// Boton añadir
		String btAñadir = textos.getString("btAñadir");
		getBtAñadir().setText(btAñadir);
		// Boton eliminar
		String btEliminar = textos.getString("btEliminar");
		getBtEliminar().setText(btEliminar);
		// Boton registro
		String btRegistro = textos.getString("btRegistro");
		getBtRegistro().setText(btRegistro);
		// Boton Continuar
		String btContinuar = textos.getString("btContinuar");
		getBtContinuar().setText(btContinuar);
		// Boton cancelar
		String btCancelar = textos.getString("btCancelar");
		getBtCancelar().setText(btCancelar);
		// Boton linea
		String btPremioLinea = textos.getString("btPremioLinea");
		getBtPremioLinea().setText(btPremioLinea);
		// Boton bingo
		String btPremioBingo = textos.getString("btPremioBingo");
		getBtPremioBingo().setText(btPremioBingo);		
		//Mnemonic btCancelar
		String mnBtCanc = textos.getString("mnBtCanc");
		getBtCancelar().setMnemonic(mnBtCanc.charAt(0));
		//Mnemonic Bt Eliminar
		String mnBtBorrar = textos.getString("mnBtBorrar");
		getBtEliminar().setMnemonic(mnBtBorrar.charAt(0));

	}
	
	private void setImagenAdaptada(JLabel label, String rutaImagen){
		 Image imgOriginal = new ImageIcon(getClass().getResource(rutaImagen)).getImage(); 
		 Image imgEscalada = imgOriginal.getScaledInstance(label.getWidth(),label.getHeight(), Image.SCALE_FAST);
		 ImageIcon icon = new ImageIcon(imgEscalada);
		 label.setIcon(icon);
	}
	
	private void botones() {
		if (!getVp().getPremios().hayPremios()) {
			getBtAñadir().setEnabled(false);
		} else {
			getBtAñadir().setEnabled(true);
		}

	}

	public VentanaPrincipal getVp() {
		return vp;
	}

	private void setVp(VentanaPrincipal vp) {
		this.vp = vp;
	}

	private void abrirVentanaRegistro() {
		VentanaRegistro v = new VentanaRegistro(getVp().isLocale(), getVp().getClientes());
		v.setLocationRelativeTo(this);
		v.setModal(true); // Metodo que dice si puedes seguir usando la aplicacion mientras estas en una
							// subventana, True no, false si
		v.setVisible(true);
		v.setResizable(false);
	}

	private JButton getBtRegistro() {
		if (btRegistro == null) {
			btRegistro = new JButton("Registro");
			btRegistro.setMnemonic('R');
			btRegistro.setEnabled(false);
			btRegistro.setBackground(new Color(0, 128, 0));
			btRegistro.setForeground(new Color(255, 255, 255));
			btRegistro.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					abrirVentanaRegistro();
				}
			});
			btRegistro.setBounds(111, 397, 139, 52);
		}
		return btRegistro;
	}

	private JButton getBtContinuar() {
		if (btContinuar == null) {
			btContinuar = new JButton("Aceptar");
			btContinuar.setMnemonic('C');
			btContinuar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					abrirVentanaFinalizar();
				}
			});
			btContinuar.setForeground(Color.WHITE);
			btContinuar.setBackground(new Color(0, 128, 0));
			btContinuar.setBounds(494, 397, 139, 52);
		}
		return btContinuar;
	}

	protected void abrirVentanaFinalizar() {
		VentanaFinalizar v = new VentanaFinalizar(this);
		v.setLocationRelativeTo(this);
		v.setModal(true); // Metodo que dice si puedes seguir usando la aplicacion mientras estas en una
							// subventana, True no, false si
		v.setVisible(true);
		v.setResizable(false);

	}

	private JButton getBtCancelar() {
		if (btCancelar == null) {
			btCancelar = new JButton("Cancelar");
			btCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					reinicializar();
				}
			});
			btCancelar.setForeground(Color.WHITE);
			btCancelar.setBackground(new Color(255, 0, 0));
			btCancelar.setBounds(657, 397, 139, 52);
		}
		return btCancelar;
	}

	protected void reinicializar() {
		if (confirmarCancelacion()) {
			dispose();
			getVp().reinicializar();
		}

	}

	private boolean confirmarCancelacion() {
		boolean yes = false;
		int resp = JOptionPane.showConfirmDialog(null, "¿Está seguro de finalizar el juego?", "Confirmando Salida",
				JOptionPane.YES_NO_OPTION);
		if (resp == JOptionPane.YES_OPTION) {
			yes = true;
		}
		return yes;
	}

	private JButton getBtAñadir() {
		if (btAñadir == null) {
			btAñadir = new JButton("A\u00F1adir");
			btAñadir.setMnemonic('A');
			btAñadir.setEnabled(false);
			btAñadir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					añadirPremio();
				}
			});
			btAñadir.setForeground(Color.WHITE);
			btAñadir.setBackground(new Color(0, 128, 0));
			btAñadir.setBounds(494, 58, 139, 52);
		}
		return btAñadir;
	}

	protected void añadirPremio() {
		// 1.LOGICA
		// 1.1 AÑADIR EL PREMIO
		Premio p = (Premio) getCbPremios().getSelectedItem();
		getVp().getPremios().addPremio(p);
		// 2.INTERFAZ
		// 2.1Limpiar la lista de premios
		modelListPremios.removeAllElements();
		// 2.2Enseñar en la lista los pedidos que haya
		for (int i = 0; i < getVp().getPremios().getPremiosFinalesDimension(); i++) {
			modelListPremios.add(i, getVp().getPremios().getPremiosF(i));
			// 2.3 comprobar botones
			botones();
			// 2.4 actualizar numero de premios
			getTxNumPremios().setText(getVp().getPremios().getNumeroPremios());
		}
	}

	protected void eliminarPremio() {
		// 1.LOGICA
		// 1.2 ELIMINAR EL PREMIO
		Premio p = (Premio) getCbPremios().getSelectedItem();
		getVp().getPremios().eliminarPremio(p);
		// 2.INTERFAZ
		// 2.1Limpiar la lista de premios
		modelListPremios.removeAllElements();
		// 2.2Enseñar en la lista los pedidos que haya
		for (int i = 0; i < getVp().getPremios().getPremiosFinalesDimension(); i++) {
			modelListPremios.add(i, getVp().getPremios().getPremiosF(i));
		}
		// 2.3 comprobar botones
		botones();
		// 2.4 actualizar numero de premios
		getTxNumPremios().setText(getVp().getPremios().getNumeroPremios());
	}

	private JButton getBtEliminar() {
		if (btEliminar == null) {
			btEliminar = new JButton("Eliminar");
			btEliminar.setEnabled(false);
			btEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					eliminarPremio();
				}
			});
			btEliminar.setForeground(Color.WHITE);
			btEliminar.setBackground(Color.RED);
			btEliminar.setBounds(657, 58, 139, 52);
		}
		return btEliminar;
	}

	private JComboBox<Premio> getCbPremios() {
		if (cbPremios == null) {
			cbPremios = new JComboBox<Premio>();
			cbPremios.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarImagen();
				}
			});
			cbPremios.setBounds(72, 58, 190, 52);
		}
		return cbPremios;
	}

	private JScrollPane getScPremios() {
		if (scPremios == null) {
			scPremios = new JScrollPane();
			scPremios.setBackground(new Color(255, 255, 255));
			scPremios.setBounds(72, 225, 329, 130);
			scPremios.setViewportView(getListPremios());
		}
		return scPremios;
	}

	private JList<Premio> getListPremios() {
		if (listPremios == null) {
			modelListPremios = new DefaultListModel<Premio>();
			listPremios = new JList<Premio>(modelListPremios);
		}
		return listPremios;
	}

	private JTextField getTxNumPremios() {
		if (txNumPremios == null) {
			txNumPremios = new JTextField();
			txNumPremios.setHorizontalAlignment(SwingConstants.CENTER);
			txNumPremios.setEditable(false);
			txNumPremios.setBounds(507, 262, 217, 52);
			txNumPremios.setColumns(10);
			txNumPremios.setText(getVp().getPremios().getNumeroPremios());
		}
		return txNumPremios;
	}
	
	private void mostrarImagen() {
		Premio p = (Premio)getCbPremios().getSelectedItem();
		setImagenAdaptada(getLbImagen(), p.getFoto());
	}
	
	private JButton getBtPremioLinea() {
		if (btPremioLinea == null) {
			btPremioLinea = new JButton("Premios Linea");
			btPremioLinea.setMnemonic('L');
			btPremioLinea.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarPremiosLinea();
				}
			});
			btPremioLinea.setBounds(96, 145, 124, 23);
		}
		return btPremioLinea;
	}

	protected void mostrarPremiosLinea() {
		// Si hay algun premio de linea, activar el boton
		if (getVp().getPremios().hayLineas()) {
			getBtAñadir().setEnabled(true);
			getBtEliminar().setEnabled(true);
		} else {
			getBtAñadir().setEnabled(false);
			getBtEliminar().setEnabled(false);
		}
		// mostrar los premios de linea
		getCbPremios()
				.setModel(new DefaultComboBoxModel<Premio>(getVp().getPremios().getPremiosLinea(getVp().isLocale())));
		
		//mostrar la foto
		Premio p = (Premio) getCbPremios().getSelectedItem();
		setImagenAdaptada(getLbImagen(), p.getFoto());

	}

	private JButton getBtPremioBingo() {
		if (btPremioBingo == null) {
			btPremioBingo = new JButton("Premios Bingo");
			btPremioBingo.setMnemonic('B');
			btPremioBingo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarPremioBingo();
				}
			});
			btPremioBingo.setBounds(253, 145, 124, 23);
		}
		return btPremioBingo;
	}

	protected void mostrarPremioBingo() {
		// Si hay algun premio de linea, activar el boton
		if (getVp().getPremios().isBingo()) {
			getBtAñadir().setEnabled(true);
			getBtEliminar().setEnabled(true);
		} else {
			getBtAñadir().setEnabled(false);
			getBtEliminar().setEnabled(false);
		}
		// mostrar los premios de linea
		getCbPremios()
				.setModel(new DefaultComboBoxModel<Premio>(getVp().getPremios().getPremiosBingo(getVp().isLocale())));
		//mostrar la foto
				Premio p = (Premio) getCbPremios().getSelectedItem();
				setImagenAdaptada(getLbImagen(), p.getFoto());

	}
	private JLabel getLbImagen() {
		if (lbImagen == null) {
			lbImagen = new JLabel("");
			lbImagen.setBounds(282, 39, 156, 95);
		}
		return lbImagen;
	}
}
