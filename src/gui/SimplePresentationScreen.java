package gui;

import java.awt.Dimension;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import entities.Student;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class SimplePresentationScreen extends JFrame {
	private JPanel contentPane;
	private JPanel box1;
	private JTabbedPane tabbedPane;
	private Student studentData;
	private JLabel horaFecha;
	private JLabel lu;
	private JLabel githubURL;
	private JLabel apellido;
	private JLabel email;
	private JLabel nombre;
	private JLabel foto;
	private JTextField setLU;
	private JTextField setaApellido;
	private JTextField setNombre;
	private JTextField setEmail;
	private JTextField setURL;

	public SimplePresentationScreen(Student studentData) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(SimplePresentationScreen.class.getResource("/images/tdp.png")));
		this.studentData = studentData;
		
		/* Crea y establece atributos del panel principal */
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		/* Establece los valores de los atributos */
		setTitle("TdP-DCIC-UNS 2021 :: Pantalla de presentación");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(617, 274));
		setResizable(false);
		setContentPane(contentPane);
		
		init();
	}
	
	private void init() {
		contentPane.setLayout(null);
		// Tabbed Pane to student personal data
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.WHITE);
		tabbedPane.setForeground(Color.BLACK);
		tabbedPane.setBounds(5, 5, 430, 201);
		
		/* Crea y establece atributos del panel contenedor de la información del alumno */
		box1 = new JPanel();
		box1.setPreferredSize(new Dimension(425, 275));
		tabbedPane.addTab("Información del alumno", null, box1, "Muestra la información declarada por el alumno");
		box1.setLayout(null);
		
		/* Crea y establece atributos del label que establece la hora y fecha actual */
		horaFecha = new JLabel("Esta ventana fue generada el "+fecha()+" a las: "+hora());
		horaFecha.setBounds(5, 210, 430, 14);
		contentPane.add(horaFecha);
		
		/* Creación e implementación de labels que muestran la información del alumno*/ 
		lu = new JLabel("LU");
		lu.setBounds(12, 6, 206, 20);
		box1.add(lu);
		
		apellido = new JLabel("Apellido");
		apellido.setBounds(12, 40, 125, 20);
		box1.add(apellido);
		
		nombre = new JLabel("Nombre");
		nombre.setBounds(12, 74, 206, 20);
		box1.add(nombre);
		
		email = new JLabel("E-mail");
		email.setBounds(12, 108, 206, 20);
		box1.add(email);
		
		githubURL = new JLabel("Github URL");
		githubURL.setBounds(12, 142, 206, 20);
		box1.add(githubURL);
		
		foto = new JLabel("New label");
		foto.setBounds(445, 37, 146, 166);
		contentPane.add(foto);
		
		//Foto de presentación, asegura que la escala de la misma coincida con el  tamaño del label
		ImageIcon imagen = new ImageIcon(getClass().getResource("/images/6356630.png"));
		ImageIcon tamaño = new ImageIcon(imagen.getImage().getScaledInstance(foto.getWidth(), foto.getHeight(), Image.SCALE_SMOOTH));
		foto.setIcon(tamaño);
		
		/* Creación e implementación de textFields */
		setLU = new JTextField();
		setLU.setBackground(Color.WHITE);
		setLU.setEditable(false);
		setLU.setBounds(85, 6, 330, 20);
		setLU.setForeground(new Color(0, 0, 0));
		box1.add(setLU);
		setLU.setColumns(5);
		String lu = ""+studentData.getId(); //El id del alumno pasa de ser int a String
		setLU.setText(lu);
		
		setaApellido = new JTextField();
		setaApellido.setBackground(Color.WHITE);
		setaApellido.setEditable(false);
		setaApellido.setForeground(Color.BLACK);
		setaApellido.setColumns(5);
		setaApellido.setBounds(85, 40, 330, 20);
		box1.add(setaApellido);
		setaApellido.setText(studentData.getLastName());
		
		setNombre = new JTextField();
		setNombre.setBackground(Color.WHITE);
		setNombre.setEditable(false);
		setNombre.setForeground(Color.BLACK);
		setNombre.setColumns(5);
		setNombre.setBounds(85, 74, 330, 20);
		box1.add(setNombre);
		setNombre.setText(studentData.getFirstName());
		
		setEmail = new JTextField();
		setEmail.setBackground(Color.WHITE);
		setEmail.setEditable(false);
		setEmail.setForeground(Color.BLACK);
		setEmail.setColumns(5);
		setEmail.setBounds(85, 108, 330, 20);
		box1.add(setEmail);
		setEmail.setText(studentData.getMail());
		
		setURL = new JTextField();
		setURL.setBackground(Color.WHITE);
		setURL.setEditable(false);
		setURL.setForeground(Color.BLACK);
		setURL.setColumns(5);
		setURL.setBounds(85, 142, 330, 20);
		box1.add(setURL);
		contentPane.add(tabbedPane);
		setURL.setText(studentData.getGithubURL());
		
	}
	
	//Metodos auxiliares para determinar fecha y hora
	private String fecha() {
		//Determina el formato en que se quiere mostrar la fecha actual, utiliza clase brindada por java
        SimpleDateFormat editFormat = new SimpleDateFormat("dd/MM/yyyy");
		
        //Utiliza clase Date brindada por java
		Date fecha = new Date();
		
		//Retorna la fecha con el formato establecido
		return editFormat.format(fecha);
	}
	
	private String hora() {
		//Determina el formato en que se quiere mostrar la hora actual, utiliza clase brindada por java
		SimpleDateFormat editFormat = new SimpleDateFormat("HH:mm:ss");
		
		//Utiliza clase Date brindada por java
		Date hora = new Date();
		
		//Retorna la hora con el formato establecido
		return editFormat.format(hora);
	}
}
