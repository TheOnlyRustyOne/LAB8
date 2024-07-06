package grafico;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;


import logica.Becas;
import logica.Estudiantes;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Reportes extends JFrame {
	private JTextArea textAreaBecados;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox buscar;
	private JTextArea texbuscar;
	private Becas becasbuscar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reportes frame = new Reportes();
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
	public Reportes() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 666, 483);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout());
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Reportes");
		lblNewLabel.setBounds(238, 10, 149, 46);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 32));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Estudiantes Becados:");
		lblNewLabel_1.setBounds(52, 106, 221, 35);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblNewLabel_1);
		
		textAreaBecados = new JTextArea();
		textAreaBecados.setLineWrap(true);
		textAreaBecados.setEditable(false);
		textAreaBecados.setBounds(52, 151, 184, 220);
	    contentPane.add(textAreaBecados);
		
		
		JLabel lblNewLabel_1_1 = new JLabel("buscar estudiantes:");
		lblNewLabel_1_1.setBounds(400, 100, 221, 35);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblNewLabel_1_1);
		
		JButton botonbuscar = new JButton("BUSCAR");
		botonbuscar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		botonbuscar.setBounds(440, 165, 100, 50);
		contentPane.add(botonbuscar);
		
		botonbuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para guardar la información
                switch(buscar.getSelectedIndex()) {
                case 0: 
                	String cedula = JOptionPane.showInputDialog("ingrese cedula a buscar");
                	becasbuscar.buscarcedula(cedula);break;
                case 1: 
                	becasbuscar.mostrasporcarrear(textAreaBecados);break;
                case 2:
                	becasbuscar.mostrarporsexo();break;
                default: 
                	JOptionPane.showMessageDialog(null, "error");break;
                }
            }
        });
		
		buscar = new JComboBox();
		buscar.setModel(new DefaultComboBoxModel(new String[] {"buscar por cedula","mostras becados por carrea","mostras becados por sexo"}));
		buscar.setBounds(400, 140, 180, 21);
		buscar.setSelectedIndex(-1);
		contentPane.add(buscar);

		
	}
	void mostrarBecados(Becas becas) {
		this.becasbuscar = becas;
        System.out.println("Estudiantes becados obtenidos: " + becas.obtenerEstudiantesBecados().size());

        StringBuilder sb = new StringBuilder();
        sb.append("Nombres de los Estudiantes:\n");

        for (String nombre : becas.obtenerEstudiantesBecados()) {
            sb.append(nombre).append("\n");
        }

        textAreaBecados.setText(sb.toString());
    }
}
