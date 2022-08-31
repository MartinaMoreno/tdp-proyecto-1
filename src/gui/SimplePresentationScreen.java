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
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class SimplePresentationScreen extends JFrame {

	private JPanel contentPane;
	private JPanel box1;
	private JTabbedPane tabbedPane;
	private Student studentData;
	private JLabel lu;
	private JLabel githubURL;
	private JLabel apellido;
	private JLabel email;
	private JLabel nombre;
	private JTextField setLU;
	private JLabel foto;
	private JTextField setaApellido;
	private JTextField setNombre;
	private JTextField setEmail;
	private JTextField setURL;

	public SimplePresentationScreen(Student studentData) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(SimplePresentationScreen.class.getResource("/images/tdp.png")));
		this.studentData = studentData;
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
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
		tabbedPane.setBackground(Color.GREEN);
		tabbedPane.setForeground(Color.BLACK);
		tabbedPane.setBounds(5, 5, 430, 201);
		box1 = new JPanel();
		box1.setPreferredSize(new Dimension(425, 275));
		tabbedPane.addTab("Información del alumno", null, box1, "Muestra la información declarada por el alumno");
		box1.setLayout(null);
		
		lu = new JLabel("LU");
		lu.setBounds(0, 1, 206, 34);
		box1.add(lu);
		
		setLU = new JTextField();
		setLU.setBackground(Color.WHITE);
		setLU.setEditable(false);
		setLU.setBounds(107, 6, 308, 25);
		setLU.setForeground(new Color(0, 0, 0));
		box1.add(setLU);
		setLU.setColumns(5);
		String lu = ""+studentData.getId(); 
		setLU.setText(lu);
		
		apellido = new JLabel("Apellido");
		apellido.setBounds(0, 35, 125, 34);
		box1.add(apellido);
		
		nombre = new JLabel("Nombre");
		nombre.setBounds(0, 69, 206, 34);
		box1.add(nombre);
		
		email = new JLabel("E-mail");
		email.setBounds(0, 103, 206, 34);
		box1.add(email);
		
		githubURL = new JLabel("Github URL");
		githubURL.setBounds(0, 137, 206, 34);
		box1.add(githubURL);
		
		setaApellido = new JTextField();
		setaApellido.setBackground(Color.WHITE);
		setaApellido.setEditable(false);
		setaApellido.setForeground(Color.BLACK);
		setaApellido.setColumns(5);
		setaApellido.setBounds(107, 40, 308, 25);
		box1.add(setaApellido);
		setaApellido.setText(studentData.getLastName());
		
		setNombre = new JTextField();
		setNombre.setBackground(Color.WHITE);
		setNombre.setEditable(false);
		setNombre.setForeground(Color.BLACK);
		setNombre.setColumns(5);
		setNombre.setBounds(107, 74, 308, 25);
		box1.add(setNombre);
		setNombre.setText(studentData.getFirstName());
		
		setEmail = new JTextField();
		setEmail.setBackground(Color.WHITE);
		setEmail.setEditable(false);
		setEmail.setForeground(Color.BLACK);
		setEmail.setColumns(5);
		setEmail.setBounds(107, 108, 308, 25);
		box1.add(setEmail);
		setEmail.setText(studentData.getMail());
		
		setURL = new JTextField();
		setURL.setBackground(Color.WHITE);
		setURL.setEditable(false);
		setURL.setForeground(Color.BLACK);
		setURL.setColumns(5);
		setURL.setBounds(107, 142, 308, 25);
		box1.add(setURL);
		contentPane.add(tabbedPane);
		setURL.setText(studentData.getGithubURL());
		
		foto = new JLabel("New label");
		foto.setBounds(445, 37, 146, 166);
		contentPane.add(foto);
		
		ImageIcon imagen = new ImageIcon(getClass().getResource("/images/6356630.png"));
		ImageIcon tamaño = new ImageIcon(imagen.getImage().getScaledInstance(foto.getWidth(), foto.getHeight(), Image.SCALE_SMOOTH));
		foto.setIcon(tamaño);
		
		
		JLabel horaFecha = new JLabel("Esta ventana fue generada el "+fecha()+" a las: "+hora());
		horaFecha.setBounds(5, 210, 430, 14);
		contentPane.add(horaFecha);
		
	}
	
	//Metodos auxiliares para determinar fecha y hora
	private String fecha() {
		Calendar fecha = new GregorianCalendar();
		
		String year = Integer.toString(fecha.get(Calendar.YEAR));
		String month = Integer.toString(fecha.get(Calendar.MONTH));
		String day = Integer.toString(fecha.get(Calendar.DATE));
		
		return day+"/"+month+"/"+year;
	}
	
	private String hora() {
		Calendar hora = new GregorianCalendar();
		
		String hour = Integer.toString(hora.get(Calendar.HOUR_OF_DAY));
		String min = Integer.toString(hora.get(Calendar.MINUTE));
		String sec = Integer.toString(hora.get(Calendar.SECOND));
		
		return hour+":"+min+":"+sec;
	}
}
