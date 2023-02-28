package igu;


import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import java.awt.Font;

public class VentanaFinalizar extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private VentanaPremios ventanaPremios;
	private JButton btFinalizar;
	private JTextField txFinal;
	private JScrollPane scrollPane;


	/**
	 * Create the frame.
	 * @param ventanaPremios 
	 */
	public VentanaFinalizar(VentanaPremios ventanaPremios) {
		this.ventanaPremios = ventanaPremios;
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 705, 509);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getBtFinalizar());
		contentPane.add(getScrollPane());
		localizar(getVentanaPremios().getVp().isLocale());
	}


	private void localizar(Locale locale) {
		ResourceBundle textos = ResourceBundle.getBundle("rcs/textos", locale);
		
		//TEXTO FINAL
		String agradecimiento = textos.getString("agradecimiento");
		String enhorabuena = textos.getString("enhorabuena");
		
		String str = agradecimiento;
		if(getVentanaPremios().getVp().getBingo().hayPremios()) {
			str += enhorabuena;
			str += getVentanaPremios().getVp().getPremios().getPremiosConseguidos();
		}
		str += ".";
		getTxFinal().setText(str);
		
		// Boton finalizar
		String btCancelar = textos.getString("btCancelar");
		getBtFinalizar().setText(btCancelar);
		
		//MN BtFinalizar
		String mnBtCanc = textos.getString("mnBtCanc");
		getBtFinalizar().setMnemonic(mnBtCanc.charAt(0));
	}


	public VentanaPremios getVentanaPremios() {
		return ventanaPremios;
	}


	public void setVentanaPremios(VentanaPremios ventanaPremios) {
		this.ventanaPremios = ventanaPremios;
	}
	private JButton getBtFinalizar() {
		if (btFinalizar == null) {
			btFinalizar = new JButton("Finalizar");
			btFinalizar.setForeground(new Color(255, 255, 255));
			btFinalizar.setBackground(new Color(0, 128, 0));
			btFinalizar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					finalizar();
				}
			});
			btFinalizar.setBounds(268, 378, 148, 43);
		}
		return btFinalizar;
	}


	protected void finalizar() {
		//Eliminar esta ventana
		dispose();
		//eliminar la ventana premios
		ventanaPremios.dispose();
		//reiniciar la ventana principal
		ventanaPremios.getVp().reinicializar();
		
	}
	private JTextField getTxFinal() {
		if (txFinal == null) {
			txFinal = new JTextField();
			txFinal.setFont(new Font("Arial", Font.BOLD, 12));
			txFinal.setHorizontalAlignment(SwingConstants.CENTER);
			txFinal.setBackground(Color.WHITE);
			txFinal.setEditable(false);
			txFinal.setColumns(10);
		}
		return txFinal;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 52, 669, 255);
			scrollPane.setViewportView(getTxFinal());
		}
		return scrollPane;
	}
}
