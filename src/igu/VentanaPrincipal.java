package igu;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.play.Bingo;
import logica.play.Clientes;
import logica.play.Premios;
import logica.play.Tickets;
import java.awt.Toolkit;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.util.Locale;
import java.util.ResourceBundle;
import java.awt.event.InputEvent;
import javax.swing.JSeparator;
import java.awt.CardLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.FlowLayout;

import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.net.URL;

/**
 * 
 * @author Ricardo Marques Garay
 *
 */
public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel pnPrincipal;
	private Bingo bingo;
	private Tickets tickets;
	private Premios premios;
	private Clientes clientes;
	private JMenuBar menuBar;
	private JMenu mnArchivo;
	private JMenu mnAyuda;
	private JMenuItem mnItNuevo;
	private JMenuItem mnItSalir;
	private JSeparator spArchivo;
	private JMenuItem mnItContenitdos;
	private JMenuItem mnItAcercaDe;
	private JSeparator spAyuda;
	private JPanel pnInternacional;
	private JPanel pnVentanas;
	private JButton btEspañol;
	private JButton btIngles;
	private JPanel pnVPrincipal;
	private JPanel pnNorteVPrincipal;
	private JPanel pnCenterVPrincipal;
	private JLabel lbBienvenida;
	private JPanel pnNorthCVP;
	private JPanel pnCenterCVP;
	private JPanel pnSouthCVP;
	private JLabel lbJugar;
	private JPanel pnBtRegalo;
	private JPanel pnBtDatos;
	private JButton btRegalos;
	private JButton btnDatos;
	private JPanel pn1;
	private JPanel pnBTIMG;
	private JPanel pn2;
	private JPanel pnImg;
	private JPanel pnBT;
	private JLabel lbImg;
	private JButton btJugar;
	private JPanel pnVValidacion;
	private JPanel pnNorthVValidacion;
	private JPanel pnCenterVValidacion;
	private JPanel pnSouthVValidacion;
	private JPanel panel1;
	private JPanel pnBtsContAndFin;
	private JButton btContinuarVVal;
	private JButton btFinalizarVVal;
	private JLabel lbExplicacionValidacion;
	private JPanel pnValidar;
	private JPanel pnTextVali;
	private JPanel pnBtValid;
	private JButton btValidar;
	private JTextField txtIntroduzaAquiSu;
	private JPanel pnContentValid;
	private JPanel pnVBingo;
	private JPanel pnWestVBingo;
	private JPanel pnCenterVBingo;
	private JPanel pnEastVBingo;
	private JPanel pnSouthVBingo;
	private JLabel lnInfoNum;
	private JTextField txNum;
	private JPanel pnAyuda;
	private JPanel panel_1;
	private JButton btAyuda;
	private JPanel panel;
	private JPanel pnBtConfirVBingo;
	private JButton btContinuarVBing;
	private JButton btFinalizarVBing;
	private JButton btBingo0;
	private JButton btBingoMagic;
	private JPanel pnBtBingo;
	private JPanel panel_3;
	private JPanel pnBtLinea;
	private JPanel panel_5;
	private JButton btLinea;
	private JButton btBingo;
	private JButton btnSiguienteNmero;
	private ProcesaBotones pBts;

	private Locale locale;
	private JPanel panel_2;
	private JPanel panel_4;
	private JTextField txNumerosUsados;

	/**
	 * Constructor que crea la ventana
	 * 
	 * @param bingo    de tipo Bingo
	 * @param tickets  de tipo Tickets
	 * @param premios  de tipo Premios
	 * @param clientes de tipo Clientes
	 */
	public VentanaPrincipal(Bingo bingo, Tickets tickets, Premios premios, Clientes clientes) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if (confirmarCancelacionSalir()) {
					System.exit(0);
				}
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/img/BINGO.png")));
		setTitle("Bingo");
		setBingo(bingo);
		setTickets(tickets);
		setPremios(premios);
		setClientes(clientes);
		locale = getLocale();
		pBts = new ProcesaBotones();
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 879, 604);
		setJMenuBar(getMenuBar_1());
		setLocationRelativeTo(null);
		pnPrincipal = new JPanel();
		pnPrincipal.setBackground(new Color(255, 255, 255));
		pnPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pnPrincipal);
		pnPrincipal.setLayout(new BorderLayout(0, 0));
		pnPrincipal.add(getPnInternacional(), BorderLayout.NORTH);
		pnPrincipal.add(getPnVentanas());
		localizar(getLocale());
		cargarAyuda();
	}

	private void cargarAyuda() {
		URL hsURL;
		HelpSet hs;

		try {
			File fichero = new File("help/ayuda.hs");
			hsURL = fichero.toURI().toURL();
			hs = new HelpSet(null, hsURL);
		}

		catch (Exception e) {
			System.out.println("Ayuda no encontrada");
			return;
		}
		HelpBroker hb = hs.createHelpBroker();
		hb.enableHelp(getRootPane(),"introduccion", hs);//activa f1
		hb.enableHelpOnButton(getMnItContenitdos(), "introduccion", hs);
		hb.enableHelpOnButton(getBtAyuda(), "sacarbola", hs);
	}
	

	public Bingo getBingo() {
		return bingo;
	}

	private void setBingo(Bingo bingo) {
		this.bingo = bingo;
	}

	public Tickets getTickets() {
		return tickets;
	}

	private void setTickets(Tickets tickets) {
		this.tickets = tickets;
	}

	public Premios getPremios() {
		return premios;
	}

	private void setPremios(Premios premios) {
		this.premios = premios;
	}

	public Clientes getClientes() {
		return clientes;
	}

	private void setClientes(Clientes clientes) {
		this.clientes = clientes;
	}

	public Locale isLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnArchivo());
			menuBar.add(getMnAyuda());
		}
		return menuBar;
	}

	private JMenu getMnArchivo() {
		if (mnArchivo == null) {
			mnArchivo = new JMenu("Archivo");
			mnArchivo.setMnemonic('C');
			mnArchivo.add(getMnItNuevo());
			mnArchivo.add(getSpArchivo());
			mnArchivo.add(getMnItSalir());
		}
		return mnArchivo;
	}

	private JMenu getMnAyuda() {
		if (mnAyuda == null) {
			mnAyuda = new JMenu("Ayuda");
			mnAyuda.setMnemonic('Y');
			mnAyuda.add(getMnItContenitdos());
			mnAyuda.add(getSpAyuda());
			mnAyuda.add(getMnItAcercaDe());
		}
		return mnAyuda;
	}

	private JMenuItem getMnItNuevo() {
		if (mnItNuevo == null) {
			mnItNuevo = new JMenuItem("Nuevo");
			mnItNuevo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					reiniciar();
				}
			});
			mnItNuevo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
			mnItNuevo.setMnemonic('N');
		}
		return mnItNuevo;
	}

	private JMenuItem getMnItSalir() {
		if (mnItSalir == null) {
			mnItSalir = new JMenuItem("Salir");
			mnItSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					salir();
				}
			});
			mnItSalir.setMnemonic('S');
		}
		return mnItSalir;
	}

	protected void salir() {
		if (confirmarCancelacionSalir()) {
			System.exit(0);
		}

	}

	private JSeparator getSpArchivo() {
		if (spArchivo == null) {
			spArchivo = new JSeparator();
		}
		return spArchivo;
	}

	private JMenuItem getMnItContenitdos() {
		if (mnItContenitdos == null) {
			mnItContenitdos = new JMenuItem("Contenidos");
			mnItContenitdos.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
			mnItContenitdos.setMnemonic('C');
		}
		return mnItContenitdos;
	}

	private JMenuItem getMnItAcercaDe() {
		if (mnItAcercaDe == null) {
			mnItAcercaDe = new JMenuItem("Acerca de");
			mnItAcercaDe.setMnemonic('A');
			mnItAcercaDe.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null,
							"Aplicacion Bingo v1.0 \n " + "Prácticas CMP 20-21 \n EII Oviedo", "Acerca de Bingo",
							JOptionPane.INFORMATION_MESSAGE);
				}
			});
		}
		return mnItAcercaDe;
	}

	private JSeparator getSpAyuda() {
		if (spAyuda == null) {
			spAyuda = new JSeparator();
		}
		return spAyuda;
	}

	private JPanel getPnInternacional() {
		if (pnInternacional == null) {
			pnInternacional = new JPanel();
			pnInternacional.setBackground(new Color(255, 255, 255));
			FlowLayout flowLayout = (FlowLayout) pnInternacional.getLayout();
			flowLayout.setAlignment(FlowLayout.RIGHT);
			pnInternacional.add(getBtEspañol());
			pnInternacional.add(getBtIngles());
		}
		return pnInternacional;
	}

	private JPanel getPnVentanas() {
		if (pnVentanas == null) {
			pnVentanas = new JPanel();
			pnVentanas.setBackground(new Color(255, 255, 255));
			pnVentanas.setLayout(new CardLayout(0, 0));
			pnVentanas.add(getPnVPrincipal(), "VPrincipal");
			pnVentanas.add(getPnVValidacion(), "VValidacion");
			pnVentanas.add(getPnVBingo(), "VBingo");
		}
		return pnVentanas;
	}

	private JButton getBtEspañol() {
		if (btEspañol == null) {
			btEspañol = new JButton("ES");
			btEspañol.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					localizar(new Locale("es"));
				}
			});
			btEspañol.setFont(new Font("Arial", Font.PLAIN, 11));
			btEspañol.setToolTipText("Boton para el idioma Espa\u00F1ol");
			btEspañol.setMnemonic('e');
		}
		return btEspañol;
	}

	private JButton getBtIngles() {
		if (btIngles == null) {
			btIngles = new JButton("EN");
			btIngles.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					localizar(new Locale("en"));
				}
			});
			btIngles.setFont(new Font("Arial", Font.PLAIN, 11));
			btIngles.setToolTipText("Boton para el idioma Ingles");
			btIngles.setMnemonic('n');
		}
		return btIngles;
	}

	private JPanel getPnVPrincipal() {
		if (pnVPrincipal == null) {
			pnVPrincipal = new JPanel();
			pnVPrincipal.setBackground(new Color(255, 255, 255));
			pnVPrincipal.setLayout(new BorderLayout(0, 0));
			pnVPrincipal.add(getPnNorteVPrincipal(), BorderLayout.NORTH);
			pnVPrincipal.add(getPnCenterVPrincipal(), BorderLayout.CENTER);
		}
		return pnVPrincipal;
	}

	private JPanel getPnNorteVPrincipal() {
		if (pnNorteVPrincipal == null) {
			pnNorteVPrincipal = new JPanel();
			pnNorteVPrincipal.setBackground(new Color(255, 255, 255));
			FlowLayout fl_pnNorteVPrincipal = new FlowLayout(FlowLayout.CENTER, 5, 5);
			pnNorteVPrincipal.setLayout(fl_pnNorteVPrincipal);
			pnNorteVPrincipal.add(getLbBienvenida());
		}
		return pnNorteVPrincipal;
	}

	private JPanel getPnCenterVPrincipal() {
		if (pnCenterVPrincipal == null) {
			pnCenterVPrincipal = new JPanel();
			pnCenterVPrincipal.setBackground(new Color(255, 255, 255));
			pnCenterVPrincipal.setLayout(new BorderLayout(0, 0));
			pnCenterVPrincipal.add(getPnNorthCVP(), BorderLayout.NORTH);
			pnCenterVPrincipal.add(getPnCenterCVP(), BorderLayout.CENTER);
			pnCenterVPrincipal.add(getPnSouthCVP(), BorderLayout.SOUTH);
		}
		return pnCenterVPrincipal;
	}

	private JLabel getLbBienvenida() {
		if (lbBienvenida == null) {
			lbBienvenida = new JLabel("BIENVENIDOS AL BINGO, HAGAN UN JUEGO RESPONSABLE Y DISFRUTEN");
			lbBienvenida.setFont(new Font("Arial", Font.BOLD, 16));
			lbBienvenida.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lbBienvenida;
	}

	private JPanel getPnNorthCVP() {
		if (pnNorthCVP == null) {
			pnNorthCVP = new JPanel();
			pnNorthCVP.setBackground(new Color(255, 255, 255));
			pnNorthCVP.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 25));
			pnNorthCVP.add(getLbJugar());
		}
		return pnNorthCVP;
	}

	private JPanel getPnCenterCVP() {
		if (pnCenterCVP == null) {
			pnCenterCVP = new JPanel();
			pnCenterCVP.setBackground(new Color(255, 255, 255));
			pnCenterCVP.setLayout(new GridLayout(0, 3, 0, 0));
			pnCenterCVP.add(getPn1());
			pnCenterCVP.add(getPnBTIMG());
			pnCenterCVP.add(getPn2());
		}
		return pnCenterCVP;
	}

	private JPanel getPnSouthCVP() {
		if (pnSouthCVP == null) {
			pnSouthCVP = new JPanel();
			pnSouthCVP.setBackground(new Color(255, 255, 255));
			pnSouthCVP.setLayout(new GridLayout(0, 2, 0, 0));
			pnSouthCVP.add(getPnBtRegalo());
			pnSouthCVP.add(getPnBtDatos());
		}
		return pnSouthCVP;
	}

	private JLabel getLbJugar() {
		if (lbJugar == null) {
			lbJugar = new JLabel("HAGA CLICK PARA COMENZAR EL JUEGO");
			lbJugar.setLabelFor(getBtJugar());
			lbJugar.setBackground(new Color(255, 255, 255));
			lbJugar.setFont(new Font("Arial", Font.PLAIN, 24));
			lbJugar.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lbJugar;
	}

	private JPanel getPnBtRegalo() {
		if (pnBtRegalo == null) {
			pnBtRegalo = new JPanel();
			pnBtRegalo.setBackground(new Color(255, 255, 255));
			pnBtRegalo.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			pnBtRegalo.add(getBtRegalos());
		}
		return pnBtRegalo;
	}

	private JPanel getPnBtDatos() {
		if (pnBtDatos == null) {
			pnBtDatos = new JPanel();
			pnBtDatos.setBackground(new Color(255, 255, 255));
			pnBtDatos.add(getBtnDatos());
		}
		return pnBtDatos;
	}

	private JButton getBtRegalos() {
		if (btRegalos == null) {
			btRegalos = new JButton("Regalos");
			btRegalos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					abrirVentanaRegalos();
				}
			});
		}
		return btRegalos;
	}

	/**
	 * Metodo que abre la ventana de regalos
	 */
	protected void abrirVentanaRegalos() {
		VentanaRegalos v = new VentanaRegalos(locale, premios);
		v.setLocationRelativeTo(this);
		v.setModal(true); // Metodo que dice si puedes seguir usando la aplicacion mientras estas en una
							// subventana, True no, false si
		v.setVisible(true);
		v.setResizable(false);

	}

	private JButton getBtnDatos() {
		if (btnDatos == null) {
			btnDatos = new JButton("Datos");
			btnDatos.setMnemonic('D');
			btnDatos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					abrirVentanaDatos();
				}
			});
		}
		return btnDatos;
	}

	/**
	 * Metodo para abrir la ventana de datos
	 */
	protected void abrirVentanaDatos() {
		VentanaDatos v = new VentanaDatos(locale, clientes);
		v.setLocationRelativeTo(this);
		v.setModal(true); // Metodo que dice si puedes seguir usando la aplicacion mientras estas en una
							// subventana, True no, false si
		v.setVisible(true);
		v.setResizable(false);

	}

	private JPanel getPn1() {
		if (pn1 == null) {
			pn1 = new JPanel();
			pn1.setBackground(new Color(255, 255, 255));
		}
		return pn1;
	}

	private JPanel getPnBTIMG() {
		if (pnBTIMG == null) {
			pnBTIMG = new JPanel();
			pnBTIMG.setBackground(new Color(255, 255, 255));
			pnBTIMG.setLayout(new GridLayout(2, 1, 0, 0));
			pnBTIMG.add(getPnBT());
			pnBTIMG.add(getPnImg());
		}
		return pnBTIMG;
	}

	private JPanel getPn2() {
		if (pn2 == null) {
			pn2 = new JPanel();
			pn2.setBackground(new Color(255, 255, 255));
		}
		return pn2;
	}

	private JPanel getPnImg() {
		if (pnImg == null) {
			pnImg = new JPanel();
			pnImg.setBackground(new Color(255, 255, 255));
			pnImg.setLayout(new GridLayout(0, 1, 0, 0));
			pnImg.add(getLbImg());
		}
		return pnImg;
	}

	private JPanel getPnBT() {
		if (pnBT == null) {
			pnBT = new JPanel();
			pnBT.setLayout(new GridLayout(0, 1, 0, 0));
			pnBT.add(getBtJugar());
		}
		return pnBT;
	}

	private JLabel getLbImg() {
		if (lbImg == null) {
			lbImg = new JLabel("");
			lbImg.setBackground(new Color(255, 255, 255));
			lbImg.setHorizontalAlignment(SwingConstants.CENTER);
			lbImg.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/FotoVP.png")));
		}
		return lbImg;
	}

	private JButton getBtJugar() {
		if (btJugar == null) {
			btJugar = new JButton("");
			btJugar.setIcon(null);
			btJugar.setMnemonic('J');
			btJugar.setToolTipText("Boton para jugar");
			btJugar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					abrirPantallaValidacion();

				}
			});
		}
		return btJugar;
	}

	private JPanel getPnVValidacion() {
		if (pnVValidacion == null) {
			pnVValidacion = new JPanel();
			pnVValidacion.setLayout(new BorderLayout(0, 0));
			pnVValidacion.add(getPnNorthVValidacion(), BorderLayout.NORTH);
			pnVValidacion.add(getPnCenterVValidacion(), BorderLayout.CENTER);
			pnVValidacion.add(getPnSouthVValidacion(), BorderLayout.SOUTH);
		}
		return pnVValidacion;
	}

	private JPanel getPnNorthVValidacion() {
		if (pnNorthVValidacion == null) {
			pnNorthVValidacion = new JPanel();
			pnNorthVValidacion.setBackground(new Color(255, 255, 255));
			pnNorthVValidacion.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 150));
			pnNorthVValidacion.add(getLbExplicacionValidacion());
		}
		return pnNorthVValidacion;
	}

	private JPanel getPnCenterVValidacion() {
		if (pnCenterVValidacion == null) {
			pnCenterVValidacion = new JPanel();
			pnCenterVValidacion.setBackground(new Color(255, 255, 255));
			pnCenterVValidacion.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			pnCenterVValidacion.add(getPnContentValid());
		}
		return pnCenterVValidacion;
	}

	private JPanel getPnSouthVValidacion() {
		if (pnSouthVValidacion == null) {
			pnSouthVValidacion = new JPanel();
			pnSouthVValidacion.setBackground(new Color(255, 255, 255));
			pnSouthVValidacion.setLayout(new GridLayout(0, 2, 0, 0));
			pnSouthVValidacion.add(getPanel1());
			pnSouthVValidacion.add(getPnBtsContAndFin());
		}
		return pnSouthVValidacion;
	}

	/**
	 * Metodo para abrir la pantalla de validacion
	 */
	private void abrirPantallaValidacion() {

		CardLayout c = (CardLayout) getPnVentanas().getLayout();
		c.show(getPnVentanas(), "VValidacion");

	}

	private JPanel getPanel1() {
		if (panel1 == null) {
			panel1 = new JPanel();
			panel1.setBackground(new Color(255, 255, 255));
		}
		return panel1;
	}

	private JPanel getPnBtsContAndFin() {
		if (pnBtsContAndFin == null) {
			pnBtsContAndFin = new JPanel();
			pnBtsContAndFin.setBackground(new Color(255, 255, 255));
			FlowLayout flowLayout = (FlowLayout) pnBtsContAndFin.getLayout();
			flowLayout.setVgap(45);
			flowLayout.setHgap(25);
			pnBtsContAndFin.add(getBtContinuarVVal());
			pnBtsContAndFin.add(getBtFinalizarVVal());
		}
		return pnBtsContAndFin;
	}

	private JButton getBtContinuarVVal() {
		if (btContinuarVVal == null) {
			btContinuarVVal = new JButton("CONTINUAR");
			btContinuarVVal.setMnemonic('T');
			btContinuarVVal.setEnabled(false);
			btContinuarVVal.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					abrirBingo();
					inicializarBingo();
				}
			});
			btContinuarVVal.setFont(new Font("Arial", Font.BOLD, 11));
			btContinuarVVal.setBackground(new Color(0, 128, 0));
			btContinuarVVal.setForeground(new Color(255, 255, 255));
		}
		return btContinuarVVal;
	}

	/**
	 * Metodo que inicializa el tablero del bingo
	 */
	protected void inicializarBingo() {

		// CREAR NUEVOS BOTONES SEGÚN EL TABLERO
		for (int i = 0; i < bingo.getDimensiones(); i++) {
			if (bingo.isMagicNumber(i)) {
				getPnCenterVBingo().add(nuevoBotonBingoMagic(i));
			} else {
				getPnCenterVBingo().add(nuevoBotonBingo(i));
			}
		}

	}

	/**
	 * Metodo que abre la ventana Bingo
	 */
	private void abrirBingo() {
		CardLayout c = (CardLayout) getPnVentanas().getLayout();
		c.show(getPnVentanas(), "VBingo");
	}

	private JButton getBtFinalizarVVal() {
		if (btFinalizarVVal == null) {
			btFinalizarVVal = new JButton("FINALIZAR");
			btFinalizarVVal.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					reiniciar();
				}
			});
			btFinalizarVVal.setFont(new Font("Arial", Font.BOLD, 11));
			btFinalizarVVal.setForeground(new Color(255, 255, 255));
			btFinalizarVVal.setBackground(new Color(255, 0, 0));
		}
		return btFinalizarVVal;
	}

	private JLabel getLbExplicacionValidacion() {
		if (lbExplicacionValidacion == null) {
			lbExplicacionValidacion = new JLabel(
					"A CONTINUACION PROCEDERA A VERIFICAR SU TICKET, SI ES SUPERIOR AL IMPORTE MINIMO PODR\u00C1 PARTICIPAR");
			lbExplicacionValidacion.setFont(new Font("Arial", Font.BOLD, 13));
			lbExplicacionValidacion.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lbExplicacionValidacion;
	}

	private JPanel getPnValidar() {
		if (pnValidar == null) {
			pnValidar = new JPanel();
			pnValidar.setBackground(new Color(255, 255, 255));
			pnValidar.setLayout(new GridLayout(0, 2, 0, 25));
			pnValidar.add(getPnTextVali());
			pnValidar.add(getPnBtValid());
		}
		return pnValidar;
	}

	private JPanel getPnTextVali() {
		if (pnTextVali == null) {
			pnTextVali = new JPanel();
			pnTextVali.setLayout(new GridLayout(0, 1, 0, 0));
			pnTextVali.add(getTxtIntroduzaAquiSu());
		}
		return pnTextVali;
	}

	private JPanel getPnBtValid() {
		if (pnBtValid == null) {
			pnBtValid = new JPanel();
			pnBtValid.setLayout(new GridLayout(0, 1, 0, 0));
			pnBtValid.add(getBtValidar());
		}
		return pnBtValid;
	}

	private JButton getBtValidar() {
		if (btValidar == null) {
			btValidar = new JButton("VALIDAR");
			btValidar.setMnemonic('V');
			btValidar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					validarTicket();
				}
			});
		}
		return btValidar;
	}

	/**
	 * Metodo para validar si el ticket es correcto o no
	 */
	protected void validarTicket() {
		if (tickets.comprobarSiExisteYEsValido(getTxtIntroduzaAquiSu().getText())) {
			// Activamos el boton siguiente
			getBtContinuarVVal().setEnabled(true);
		} else {
			if (locale == getLocale()) {
				JOptionPane.showMessageDialog(this,
						"Lo siento, el código no es válido, intentelo de nuevo o salgase de la aplicación");
			} else {
				JOptionPane.showMessageDialog(this,
						"Sorry, the code is not valid, please try again or exit the application");
			}
		}

	}

	private JTextField getTxtIntroduzaAquiSu() {
		if (txtIntroduzaAquiSu == null) {
			txtIntroduzaAquiSu = new JTextField();
			txtIntroduzaAquiSu.setHorizontalAlignment(SwingConstants.CENTER);
			txtIntroduzaAquiSu.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) {
					getTxtIntroduzaAquiSu().setText("");
				}

				@Override
				public void focusLost(FocusEvent e) {
					if (getTxtIntroduzaAquiSu().getText().equals("")) {
						getTxtIntroduzaAquiSu().setText("N\u00BA Ticket");
					}
				}
			});
			txtIntroduzaAquiSu.setText("N\u00BA Ticket");
			txtIntroduzaAquiSu.setColumns(10);
		}
		return txtIntroduzaAquiSu;
	}

	private JPanel getPnContentValid() {
		if (pnContentValid == null) {
			pnContentValid = new JPanel();
			pnContentValid.setBackground(new Color(255, 255, 255));
			pnContentValid.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			pnContentValid.add(getPnValidar());
		}
		return pnContentValid;
	}

	private JPanel getPnVBingo() {
		if (pnVBingo == null) {
			pnVBingo = new JPanel();
			pnVBingo.setBackground(new Color(255, 255, 255));
			pnVBingo.setLayout(new BorderLayout(0, 0));
			pnVBingo.add(getPnWestVBingo(), BorderLayout.WEST);
			pnVBingo.add(getPnCenterVBingo(), BorderLayout.CENTER);
			pnVBingo.add(getPnEastVBingo(), BorderLayout.EAST);
			pnVBingo.add(getPnSouthVBingo(), BorderLayout.SOUTH);
		}
		return pnVBingo;
	}

	private JPanel getPnWestVBingo() {
		if (pnWestVBingo == null) {
			pnWestVBingo = new JPanel();
			pnWestVBingo.setBackground(Color.WHITE);
			pnWestVBingo.setLayout(new GridLayout(4, 1, 20, 0));
			pnWestVBingo.add(getLnInfoNum());
			pnWestVBingo.add(getTxNum());
			pnWestVBingo.add(getPanel_1());
			pnWestVBingo.add(getPnAyuda());
		}
		return pnWestVBingo;
	}

	private JPanel getPnCenterVBingo() {
		if (pnCenterVBingo == null) {
			pnCenterVBingo = new JPanel();
			pnCenterVBingo.setBackground(Color.WHITE);
			pnCenterVBingo.setLayout(new GridLayout(0, 3, 0, 0));
		}
		return pnCenterVBingo;
	}

	private JPanel getPnEastVBingo() {
		if (pnEastVBingo == null) {
			pnEastVBingo = new JPanel();
			pnEastVBingo.setBackground(Color.WHITE);
			pnEastVBingo.setLayout(new GridLayout(4, 0, 0, 0));
			pnEastVBingo.add(getPanel_3());
			pnEastVBingo.add(getPnBtLinea());
			pnEastVBingo.add(getPnBtBingo());
			pnEastVBingo.add(getPanel_5());
		}
		return pnEastVBingo;
	}

	private JPanel getPnSouthVBingo() {
		if (pnSouthVBingo == null) {
			pnSouthVBingo = new JPanel();
			pnSouthVBingo.setBackground(Color.WHITE);
			pnSouthVBingo.setLayout(new GridLayout(0, 2, 0, 0));
			pnSouthVBingo.add(getPanel());
			pnSouthVBingo.add(getPnBtConfirVBingo());
		}
		return pnSouthVBingo;
	}

	private JLabel getLnInfoNum() {
		if (lnInfoNum == null) {
			lnInfoNum = new JLabel("El siguiente numero es:");
			lnInfoNum.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lnInfoNum;
	}

	private JTextField getTxNum() {
		if (txNum == null) {
			txNum = new JTextField();
			txNum.setEditable(false);
			txNum.setFont(new Font("Arial", Font.BOLD, 34));
			txNum.setHorizontalAlignment(SwingConstants.CENTER);
			txNum.setText("");
			txNum.setBackground(Color.WHITE);
			txNum.setColumns(10);
		}
		return txNum;
	}

	private JPanel getPnAyuda() {
		if (pnAyuda == null) {
			pnAyuda = new JPanel();
			pnAyuda.setBackground(Color.WHITE);
			pnAyuda.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			pnAyuda.add(getBtAyuda());
		}
		return pnAyuda;
	}

	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setBackground(Color.WHITE);
			panel_1.setLayout(new GridLayout(0, 1, 0, 0));
			panel_1.add(getPanel_4());
			panel_1.add(getPanel_2());
		}
		return panel_1;
	}

	private JButton getBtAyuda() {
		if (btAyuda == null) {
			btAyuda = new JButton("");
			btAyuda.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/AYUDA22.png")));
			btAyuda.setToolTipText("BOTON AYUDA");
			btAyuda.setBackground(Color.WHITE);
		}
		return btAyuda;
	}

	/**
	 * Metodo para sacar un numero aleatorio y que sea el ultilizado en el bingo
	 */
	protected void tirar() {
		int numero = bingo.nuevoNumero();

		getTxNum().setText(String.valueOf(numero));
		// Mostrar los numeros ya usados
		getTxNumerosUsados().setText(bingo.getNumerosUsados());
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(Color.WHITE);
		}
		return panel;
	}

	private JPanel getPnBtConfirVBingo() {
		if (pnBtConfirVBingo == null) {
			pnBtConfirVBingo = new JPanel();
			pnBtConfirVBingo.setBackground(Color.WHITE);
			pnBtConfirVBingo.setLayout(new FlowLayout(FlowLayout.CENTER, 25, 2));
			pnBtConfirVBingo.add(getBtContinuarVBing());
			pnBtConfirVBingo.add(getBtFinalizarVBing());
		}
		return pnBtConfirVBingo;
	}

	private JButton getBtContinuarVBing() {
		if (btContinuarVBing == null) {
			btContinuarVBing = new JButton("CONTINUAR");
			btContinuarVBing.setMnemonic('C');
			btContinuarVBing.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					abrirVentanaPremios();
				}
			});
			btContinuarVBing.setEnabled(false);
			btContinuarVBing.setForeground(Color.WHITE);
			btContinuarVBing.setFont(new Font("Arial", Font.BOLD, 11));
			btContinuarVBing.setBackground(new Color(0, 128, 0));
		}
		return btContinuarVBing;
	}

	protected void abrirVentanaPremios() {
		VentanaPremios v = new VentanaPremios(this);
		v.setLocationRelativeTo(this);
		v.setModal(true); // Metodo que dice si puedes seguir usando la aplicacion mientras estas en una
							// subventana, True no, false si
		v.setVisible(true);
		v.setResizable(false);

	}

	/**
	 * Metodo que abre la ventana registro
	 */
	protected void abrirVentanaRegistro() {
		VentanaRegistro v = new VentanaRegistro(locale, clientes);
		v.setLocationRelativeTo(this);
		v.setModal(true); // Metodo que dice si puedes seguir usando la aplicacion mientras estas en una
							// subventana, True no, false si
		v.setVisible(true);
		v.setResizable(false);

	}

	private JButton getBtFinalizarVBing() {
		if (btFinalizarVBing == null) {
			btFinalizarVBing = new JButton("FINALIZAR");
			btFinalizarVBing.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					reiniciar();
				}
			});
			btFinalizarVBing.setForeground(Color.WHITE);
			btFinalizarVBing.setFont(new Font("Arial", Font.BOLD, 11));
			btFinalizarVBing.setBackground(Color.RED);
		}
		return btFinalizarVBing;
	}

	/**
	 * Metodo que crea los botones para el bingo
	 * 
	 * @param i de tipo int, posicion del boton
	 * @return btBingo0 de tipo JButton, el boton
	 */
	private JButton nuevoBotonBingo(int i) {
		btBingo0 = new JButton("");
		btBingo0.setActionCommand(String.valueOf(i));
		btBingo0.addActionListener(pBts);
		btBingo0.setText(bingo.numeroCorrespondiente(i));
		return btBingo0;
	}

	/**
	 * Metodo que crea el boton con numero magico
	 * 
	 * @param i de tipo int, posicion del boton
	 * @return btBingoMagic de tipo JButton, el boton
	 */
	private JButton nuevoBotonBingoMagic(int i) {
		btBingoMagic = new JButton("");
		btBingoMagic.setActionCommand(String.valueOf(i));
		btBingoMagic.addActionListener(pBts);
		btBingoMagic.setText(bingo.numeroCorrespondiente(i) + "*");
		return btBingoMagic;
	}

	private JPanel getPnBtBingo() {
		if (pnBtBingo == null) {
			pnBtBingo = new JPanel();
			pnBtBingo.setBackground(Color.WHITE);
			pnBtBingo.add(getBtBingo());
		}
		return pnBtBingo;
	}

	private JPanel getPanel_3() {
		if (panel_3 == null) {
			panel_3 = new JPanel();
			panel_3.setBackground(Color.WHITE);
		}
		return panel_3;
	}

	private JPanel getPnBtLinea() {
		if (pnBtLinea == null) {
			pnBtLinea = new JPanel();
			FlowLayout fl_pnBtLinea = (FlowLayout) pnBtLinea.getLayout();
			fl_pnBtLinea.setVgap(65);
			pnBtLinea.setBackground(Color.WHITE);
			pnBtLinea.add(getBtLinea());
		}
		return pnBtLinea;
	}

	private JPanel getPanel_5() {
		if (panel_5 == null) {
			panel_5 = new JPanel();
			panel_5.setBackground(Color.WHITE);
		}
		return panel_5;
	}

	private JButton getBtLinea() {
		if (btLinea == null) {
			btLinea = new JButton("LINEA");
			btLinea.setMnemonic('L');
			btLinea.setEnabled(false);
			btLinea.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cantarLinea();
				}
			});
			btLinea.setForeground(Color.BLACK);
			btLinea.setFont(new Font("Arial", Font.BOLD, 11));
			btLinea.setBackground(Color.WHITE);
		}
		return btLinea;
	}

	/**
	 * Metodo para cantar linea
	 */
	protected void cantarLinea() {
		// 1.LOGICA
		// 2.1 Añadir la linea a premios y a bingo
		premios.cantarLinea();
		bingo.cantarLinea();
		// 2.INTERFAZ
		// 2.1 Desactivar el boton linea
		getBtLinea().setEnabled(false);
	}

	private JButton getBtBingo() {
		if (btBingo == null) {
			btBingo = new JButton("BINGO");
			btBingo.setMnemonic('B');
			btBingo.setEnabled(false);
			btBingo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cantarBingo();
				}
			});
			btBingo.setForeground(Color.BLACK);
			btBingo.setFont(new Font("Arial", Font.BOLD, 11));
			btBingo.setBackground(Color.WHITE);
		}
		return btBingo;
	}

	/**
	 * Metodo para cantar bingo
	 */
	protected void cantarBingo() {

		// 1.LOGICA
		// 1.1 cantar bingo, si el caso es correcto
		bingo.cantarBingo();
		// 1.2 Añadir el bingo a la ventana premios
		premios.cantarBingo();
		// 2.INTERFAZ
		// 2.1 activar el boton siguiente, si el caso es correcto
		if (bingo.esBingo()) {
			getBtContinuarVBing().setEnabled(true);
		}
		// 2.2 desactivar el boton bingo
		getBtBingo().setEnabled(false);

	}

	private JButton getBtnSiguienteNmero() {
		if (btnSiguienteNmero == null) {
			btnSiguienteNmero = new JButton("Siguiente N\u00FAmero");
			btnSiguienteNmero.setMnemonic('N');
			btnSiguienteNmero.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					tirar();
					if (bingo.isEnd()) {
						activarBotonSiguienteVBingo();
					}
					if (getBtLinea().isEnabled()) {
						getBtLinea().setEnabled(false);
					}
					if (getBtBingo().isEnabled()) {
						getBtBingo().setEnabled(false);
					}
				}
			});
			btnSiguienteNmero.setToolTipText("");
			btnSiguienteNmero.setBackground(Color.WHITE);
		}
		return btnSiguienteNmero;
	}

	/**
	 * Metodo que activa el boton siguiente
	 */
	protected void activarBotonSiguienteVBingo() {
		getBtContinuarVBing().setEnabled(true);

	}

	/**
	 * Clase para procesar los clicks sobre los botones del bingo
	 * 
	 * @author Ricardo Marques Garay
	 *
	 */
	class ProcesaBotones implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			JButton boton = (JButton) e.getSource();
			juega(Integer.valueOf(boton.getActionCommand()));

		}

	}

	/**
	 * Metodo para jugar al bingo
	 * 
	 * @param i de tipo int, casilla sobre la que se hace el click
	 */
	public void juega(int i) {

		// 1.LOGICA
		// 1.1 Marcamos la casilla
		bingo.marcarCasilla(i);

		// 2.INTERFAZ
		// 2.1 Desactiva ese boton si coincide
		if (bingo.isValidNumber(i)) {
			getPnCenterVBingo().getComponents()[i].setEnabled(false);
		}
		// 2.2 si hay linea activar el boton linea
		if (bingo.esLinea(i)) {
			getBtLinea().setEnabled(true);
		}
		// 2.3 si hay bingo activar el boton bingo
		if (bingo.esBingo()) {
			getBtBingo().setEnabled(true);
		}

	}

	/**
	 * Metodo para internacionalizar una clase
	 * 
	 * @param localizacion de tipo Locale, idioma al que internazionalizar
	 */
	private void localizar(Locale localizacion) {
		locale = localizacion;

		ResourceBundle textos = ResourceBundle.getBundle("rcs/textos", localizacion);

		// Tooltip boton ingles
		String toolTipIngles = textos.getString("toolTipEng");
		getBtIngles().setToolTipText(toolTipIngles);

		// ToolTip boton español
		String toolTipEsp = textos.getString("toolTipEsp");
		getBtEspañol().setToolTipText(toolTipEsp);

		// Menu Nuevo
		String mnNuevo = textos.getString("mnNuevo");
		getMnItNuevo().setText(mnNuevo);
		// Menu Salir
		String mnSalir = textos.getString("mnSalir");
		getMnItSalir().setText(mnSalir);
		// Menu Acerca de
		String mnAcercaDe = textos.getString("mnAcercaDe");
		getMnItAcercaDe().setText(mnAcercaDe);
		// Menu Contenidos
		String mnContenidos = textos.getString("mnContenidos");
		getMnItContenitdos().setText(mnContenidos);
		// Menu archivo
		String mnArchivo = textos.getString("mnArchivo");
		getMnArchivo().setText(mnArchivo);
		// Menu ayuda
		String mnAyuda = textos.getString("mnAyuda");
		getMnAyuda().setText(mnAyuda);

		// Mn menu Nuevo
		String mnMenuNuevo = textos.getString("mnMenuNuevo");
		getMnItNuevo().setMnemonic(mnMenuNuevo.charAt(0));
		// Mn menu Salir
		String mnMenuSalir = textos.getString("mnMenuSalir");
		getMnItSalir().setMnemonic(mnMenuSalir.charAt(0));
		// Mn Ayuda
		String mnMenuAyuda = textos.getString("mnMenuAyuda");
		getMnAyuda().setMnemonic(mnMenuAyuda.charAt(0));

		localizaVP(localizacion);
		localizaVValid(localizacion);
		localizaVBingo(localizacion);

	}

	/**
	 * Metodo para internacionalizar la ventanaBingo
	 * 
	 * @param localizacion de tipo Locale, idioma al que internazionalizar
	 */
	private void localizaVBingo(Locale localizacion) {

		ResourceBundle textos = ResourceBundle.getBundle("rcs/textos", localizacion);

		// Boton continuar
		String btContinuar = textos.getString("btContinuar");
		getBtContinuarVBing().setText(btContinuar);

		// Boton cancelar
		String btCancelar = textos.getString("btCancelar");
		getBtFinalizarVBing().setText(btCancelar);

		// Boton siguiente numero
		String btNextNumber = textos.getString("btNextNumber");
		getBtnSiguienteNmero().setText(btNextNumber);

		// Etiqueta siguiente numero
		String lbNextNumber = textos.getString("lbNextNumber");
		getLnInfoNum().setText(lbNextNumber);

		// Boton ayuda
		String toolTipBtAyuda = textos.getString("toolTipBtAyuda");
		getBtAyuda().setToolTipText(toolTipBtAyuda);

		// Boton Linea
		String btLinea = textos.getString("btLinea");
		getBtLinea().setText(btLinea);

		// Boton Bingo
		String btBingo = textos.getString("btBingo");
		getBtBingo().setText(btBingo);

		// Mnemonic Finalizar
		String mnBtFinPrinc = textos.getString("mnBtFinPrinc");
		getBtFinalizarVBing().setMnemonic(mnBtFinPrinc.charAt(0));
	}

	/**
	 * Metodo para internacionalizar la ventana de validacion
	 * 
	 * @param localizacion de tipo Locale, idioma al que internazionalizar
	 */
	private void localizaVValid(Locale localizacion) {

		ResourceBundle textos = ResourceBundle.getBundle("rcs/textos", localizacion);

		// Mensaje informacion

		String mensajeInformacion = textos.getString("mensajeInformacion");
		getLbExplicacionValidacion().setText(mensajeInformacion);

		// Boton validar
		String btValidar = textos.getString("btValidar");
		getBtValidar().setText(btValidar);

		// Boton continuar
		String btContinuar = textos.getString("btContinuar");
		getBtContinuarVVal().setText(btContinuar);

		// Boton cancelar
		String btCancelar = textos.getString("btCancelar");
		getBtFinalizarVVal().setText(btCancelar);

		// MNBtFinalizar
		String mnBtFinPrinc = textos.getString("mnBtFinPrinc");
		getBtFinalizarVVal().setMnemonic(mnBtFinPrinc.charAt(0));
	}

	/**
	 * Metodo para internacionalizar la ventana principal
	 * 
	 * @param localizacion de tipo Locale, idioma al que internazionalizar
	 */
	private void localizaVP(Locale localizacion) {

		ResourceBundle textos = ResourceBundle.getBundle("rcs/textos", localizacion);

		// Mensaje Bienvenida
		String mensajeBienvenida = textos.getString("textoBienvenida");
		getLbBienvenida().setText(mensajeBienvenida);

		// Mensaje Juego
		String mensajeJuego = textos.getString("textoJuego");
		getLbJugar().setText(mensajeJuego);

		// ToolTip botonJugar
		String toolTipBtPlay = textos.getString("toolTipBtPlay");
		getBtJugar().setToolTipText(toolTipBtPlay);

		// Boton regalos
		String btRegalos = textos.getString("btRegalos");
		getBtRegalos().setText(btRegalos);

		// Boton Datos
		String btDatos = textos.getString("btDatos");
		getBtnDatos().setText(btDatos);

		// Mn Boton regalos
		String mnBtRegalos = textos.getString("mnBtRegalos");
		getBtRegalos().setMnemonic(mnBtRegalos.charAt(0));
	}

	/**
	 * Metodo para iniciar el reinicio de la aplicacion
	 */
	public void reiniciar() {
		if (confirmarCancelacionReiniciar()) {
			reinicializar();
		}
	}

	/**
	 * Metodo que reinicia la aplicaicon
	 */
	public void reinicializar() {

		// LOGICA

		premios.reiniciar();
		bingo.reiniciaBingo();
		clientes.reiniciar();
		tickets.reiniciar();

		// INTERFAZ
		// 1 Seleccionamos el idioma
		localizar(getLocale());
		// 2 nos ponemos en la primera ventana
		abrirVentanaInicio();
		// 2 preparamos la ventana registro
		prepararVentanaRegistro();
		// 4 preparamos la ventana bingo
		prepararVentanaBingo();

	}

	/**
	 * Metodo que reinicia la ventana Bingo
	 */
	private void prepararVentanaBingo() {
		// 1 vaciar el panel de bingo
		getPnCenterVBingo().removeAll();
		// 2 desactivar botones linea, bingo y continuar
		getBtLinea().setEnabled(false);
		getBtBingo().setEnabled(false);
		getBtContinuarVBing().setEnabled(false);
		// 3 nuevo num
		getTxNum().setText("");

	}

	/**
	 * Metodo que reinicia la ventana Registro
	 */
	private void prepararVentanaRegistro() {
		// 1 colocar el texto de nuevo
		getTxtIntroduzaAquiSu().setText("N\u00BA Ticket");
		// 2 desactivar el boton
		getBtContinuarVVal().setEnabled(false);

	}

	/**
	 * Metodo que abre la ventana de inicio
	 */
	private void abrirVentanaInicio() {
		CardLayout c = (CardLayout) getPnVentanas().getLayout();
		c.show(getPnVentanas(), "VPrincipal");

	}

	/**
	 * Metodo para confirmar la salida
	 * 
	 * @return yes de tipo boolean, si aceptamos o no
	 */
	private boolean confirmarCancelacionSalir() {
		boolean yes = false;
		int resp = JOptionPane.showConfirmDialog(null, "¿Está seguro de salir del juego?", "Confirmando Salida",
				JOptionPane.YES_NO_OPTION);
		if (resp == JOptionPane.YES_OPTION) {
			yes = true;
		}
		return yes;
	}

	/**
	 * Metodo para confirmar reinicio
	 * 
	 * @return yes de tipo boolean, si aceptamos o no
	 */
	private boolean confirmarCancelacionReiniciar() {
		boolean yes = false;
		int resp = JOptionPane.showConfirmDialog(null, "¿Está seguro de finalizar el juego?", "Confirmando Salida",
				JOptionPane.YES_NO_OPTION);
		if (resp == JOptionPane.YES_OPTION) {
			yes = true;
		}
		return yes;
	}

	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setBackground(Color.WHITE);
			panel_2.add(getBtnSiguienteNmero());
		}
		return panel_2;
	}

	private JPanel getPanel_4() {
		if (panel_4 == null) {
			panel_4 = new JPanel();
			panel_4.setBackground(Color.WHITE);
			panel_4.setLayout(new GridLayout(1, 0, 0, 0));
			panel_4.add(getTxNumerosUsados());
		}
		return panel_4;
	}

	private JTextField getTxNumerosUsados() {
		if (txNumerosUsados == null) {
			txNumerosUsados = new JTextField();
			txNumerosUsados.setColumns(10);
		}
		return txNumerosUsados;
	}
}