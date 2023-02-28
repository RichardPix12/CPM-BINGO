package igu;


import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.DefaultListModel;
import javax.swing.JDialog;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.objects.Premio;
import logica.play.Premios;
import java.awt.Toolkit;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaRegalos extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Premios premios;
	private JScrollPane scRegalos;
	private JList<Premio> listRegalos;
	private DefaultListModel<Premio> modelListRegalos;
	private JButton btFinalizar;

	/**
	 * Create the frame.
	 */
	public VentanaRegalos(Locale locale, Premios premios) {
		setTitle("Ventana con los regalos");
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaRegalos.class.getResource("/img/BINGO.png")));
		setPremios(premios);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 854, 588);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getScRegalos());
		contentPane.add(getBtFinalizar());
		mostrarRegalos(locale);
		localizar(locale);
	}
	/**
	 * Metodo que internacionaliza la ventana
	 * @param locale de tipo Locale, idioma al que internacionalizar
	 */
	private void localizar(Locale locale) {
		ResourceBundle textos = ResourceBundle.getBundle("rcs/textos",locale);
		
		//Boton Finalizar
		String btFinalizar = textos.getString("btCancelar");
		getBtFinalizar().setText(btFinalizar);
		
		//Mnemonic btFinalizar
		String mnBtCanc = textos.getString("mnBtCanc");
		getBtFinalizar().setMnemonic(mnBtCanc.charAt(0));
		
	}
	/**
	 * Metodo que muestra los regalos 
	 */
	private void mostrarRegalos(Locale locale) {
		
		//MOSTRAR EN LA LIST LOS PREMIOS
		for(int i = 0; i< premios.getDimensions();i++) {
			modelListRegalos.addElement(premios.getElements(i,locale));
		}
		
	}

	public Premios getPremios() {
		return premios;
	}

	public void setPremios(Premios premios) {
		this.premios = premios;
	}
	private JScrollPane getScRegalos() {
		if (scRegalos == null) {
			scRegalos = new JScrollPane();
			scRegalos.setBounds(74, 31, 691, 441);
			scRegalos.setViewportView(getListRegalos());
		}
		return scRegalos;
	}
	private JList<Premio> getListRegalos() {
		if (listRegalos == null) {
			modelListRegalos = new DefaultListModel<Premio>();
			listRegalos = new JList<Premio>(modelListRegalos);
		}
		return listRegalos;
	}
	private JButton getBtFinalizar() {
		if (btFinalizar == null) {
			btFinalizar = new JButton("Finalizar");
			btFinalizar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btFinalizar.setForeground(new Color(255, 255, 255));
			btFinalizar.setBackground(new Color(0, 128, 0));
			btFinalizar.setBounds(333, 500, 154, 38);
		}
		return btFinalizar;
	}
}
