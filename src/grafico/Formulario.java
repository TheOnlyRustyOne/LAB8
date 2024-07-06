package grafico;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


//importar clases del paquete
import logica.Estudiantes;
import logica.Becas;

//Importar elementos de diseño 
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
public class Formulario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textIndice;
	private JTextField textCedula;
	private Estudiantes estudiante;
	private JComboBox comboBoxCarreras;
	private JComboBox comboBoxsexo;
	private ArrayList<Estudiantes> estudiantes;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Formulario frame = new Formulario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Formulario() {
		setResizable(false);
		 estudiantes = new ArrayList<>();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 932, 552);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		 
		JLabel lblNewLabel = new JLabel("Información de estudiantes");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel.setBounds(277, 10, 271, 62);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(21, 97, 95, 22);
		contentPane.add(lblNewLabel_1);
		
		textNombre = new JTextField();
		textNombre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textNombre.setBounds(141, 102, 153, 19);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Indice:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(21, 239, 95, 22);
		contentPane.add(lblNewLabel_1_1);
		
		textIndice = new JTextField();
		textIndice.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textIndice.setColumns(10);
		textIndice.setBounds(141, 240, 153, 19);
		contentPane.add(textIndice);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Cédula:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1_1.setBounds(21, 166, 95, 22);
		contentPane.add(lblNewLabel_1_1_1);
		
		textCedula = new JTextField();
		textCedula.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textCedula.setColumns(10);
		textCedula.setBounds(141, 167, 153, 19);
		contentPane.add(textCedula);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("sexo:");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1_1_1.setBounds(21, 310, 95, 22);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		comboBoxsexo = new JComboBox();
		comboBoxsexo.setModel(new DefaultComboBoxModel(new String[] {"Hombre","Mujer","Helicoptero de guerra"}));
		comboBoxsexo.setBounds(141, 310, 153, 21);
		comboBoxsexo.setSelectedIndex(-1);
		contentPane.add(comboBoxsexo);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Carrera:");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1_2.setBounds(21, 378, 95, 22);
		contentPane.add(lblNewLabel_1_1_2);
		
		comboBoxCarreras = new JComboBox();
		comboBoxCarreras.setModel(new DefaultComboBoxModel(new String[] {"Ingeniería Civil", "Ingeniería Eléctrica", "Ingeniería Industrial", "Ingeniería en Sistemas", "Ingeniería Mecánica", "Ingeniería Marítima"}));
		comboBoxCarreras.setBounds(141, 378, 153, 21);
		comboBoxCarreras.setSelectedIndex(-1);
		contentPane.add(comboBoxCarreras);
		
		JButton btnGuardar = new JButton("Guardar Datos");
		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnGuardar.setBounds(460, 163, 184, 34);
		contentPane.add(btnGuardar);
		
		JButton btnReportes = new JButton("Mostrar Reportes");
		btnReportes.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnReportes.setBounds(700, 361, 184, 34);
		contentPane.add(btnReportes);
		// Agregar ActionListener para el botón "Guardar Datos"
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para guardar la información
                guardarDatos();
            }
        });
        btnReportes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Cierra la ventana actual
                dispose();
                // Crear una instancia de la clase Becas
                Becas becas = new Becas();

                // Agregar todos los estudiantes del formulario a la instancia de Becas
                for (Estudiantes estudiante : estudiantes) {
                    becas.agregarEstudiante(estudiante);
                }
                // Abre la ventana de reportes
                Reportes reportes = new Reportes();
                reportes.setVisible(true);
                reportes.mostrarBecados(becas);
            }
        });
	}
	 private void guardarDatos() {
		 double indice=-1;
		 boolean band=true;
		 
	if(textCedula.getText().isEmpty() == false) {
		try {
			  indice = Double.parseDouble(textIndice.getText());
		   }catch(NumberFormatException e) {
			   JOptionPane.showMessageDialog(null, "inserte un valor valido para el indice");
		   }
		 }
    if(textNombre.getText().isEmpty() || textCedula.getText().isEmpty() || textIndice.getText().isEmpty() || comboBoxsexo.getSelectedItem() == null || comboBoxCarreras.getSelectedItem() == null) {
			JOptionPane.showMessageDialog(null, "lleno todos los campos");
		}
	else if(indice < 0 || indice > 3){
			JOptionPane.showMessageDialog(null, "ingrese un indice valido(de 0 a 3)");
		}
		else {  	
			for(int i=0;i<estudiantes.size();i++) {
				if(textCedula.getText().equals(estudiantes.get(i).getCedula())) {
					band = false;
				}
			}
			     if(band != false) {	                 
		                      // Obtener los datos ingresados por el usuario
		                      String nombre = textNombre.getText();
		                      String cedula = textCedula.getText();
		                      String carrera = (String) comboBoxCarreras.getSelectedItem();
                              String sexo = (String) comboBoxsexo.getSelectedItem();
		       
		                     Estudiantes estudiante = new Estudiantes(nombre, cedula, carrera, sexo, indice);
		                     // Impresión en consola
		                     System.out.println("Información del estudiante guardada: " + estudiante.toString());
		                     estudiantes.add(estudiante);
	           
		                     // Mostrar un mensaje de confirmación al usuario final 
		                     JOptionPane.showMessageDialog(this, "Información guardada correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);

		      
		                     textNombre.setText("");
		                     textCedula.setText("");
		                     textIndice.setText("");
		                     comboBoxsexo.setSelectedIndex(-1); 
		                     comboBoxCarreras.setSelectedIndex(-1); 
		   }
			else {
				JOptionPane.showMessageDialog(null, "la cedula ingresada ya existe en el sistema");
			}
		}
	 }
}
