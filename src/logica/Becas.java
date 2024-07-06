package logica;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Becas {
	private static final int MAX_ESTUDIANTES = 100;
    private ArrayList<Estudiantes> estudiantes;

    public Becas() {
        estudiantes = new ArrayList<>();
    }

    public void agregarEstudiante(Estudiantes estudiante) {
        if (estudiantes.size() < MAX_ESTUDIANTES) {
            estudiantes.add(estudiante);
        } else {
            System.out.println("No se puede agregar más estudiantes. Límite alcanzado.");
        }
    }

    public ArrayList<String> obtenerEstudiantesBecados() {
        ArrayList<String> estudiantesBecados = new ArrayList<>();

        for (Estudiantes estudiante : estudiantes) {
            if (estudiante.getIndiceAcademico() >= 2.0) {
                estudiantesBecados.add(estudiante.getNombre());
            }
        }

        return estudiantesBecados;
    }

    public void buscarcedula(String cedula) {
    	boolean band = false;
    	for(int i=0;i<estudiantes.size();i++) {
    		if(cedula.equals(estudiantes.get(i).getCedula())) {
    			JOptionPane.showMessageDialog(null, "Cedula: "+estudiantes.get(i).getCedula()
    					+"\nnombre del estudiante: "+estudiantes.get(i).getNombre()
    					+"\nindice del estudiantes: "+estudiantes.get(i).getIndiceAcademico());
    			band = true;
    			break;
    		}
    	}
    	if(band == false) {
    		JOptionPane.showMessageDialog(null, "no se encontro a un estudiante con dicha cedula");
    	}
    }
    
    public void mostrasporcarrear(JTextArea text) {	
    	StringBuilder sb = new StringBuilder();
        sb.append("Ingeniería Civil:\n");
        for (int i=0;i<estudiantes.size();i++) {
        	if(estudiantes.get(i).getCarrera().equals("Ingeniería Civil")) {
        		  sb.append(estudiantes.get(i).getNombre()).append("\n");
        	}
        }
        JOptionPane.showMessageDialog(null, sb.toString());
        sb.setLength(0);
        
        sb.append("Ingeniería Eléctrica:\n");
        for (int i=0;i<estudiantes.size();i++) {
        	if(estudiantes.get(i).getCarrera().equals("Ingeniería Eléctrica")) {
        		  sb.append(estudiantes.get(i).getNombre()).append("\n");
        	}
        }
        JOptionPane.showMessageDialog(null, sb.toString());
        sb.setLength(0);
        
        sb.append("Ingeniería Industrial:\n");
        for (int i=0;i<estudiantes.size();i++) {
        	if(estudiantes.get(i).getCarrera().equals("Ingeniería Industrial")) {
        		  sb.append(estudiantes.get(i).getNombre()).append("\n");
        	}
        }
        JOptionPane.showMessageDialog(null, sb.toString());
        sb.setLength(0);
        
        sb.append("Ingeniería en Sistemas:\n");
        for (int i=0;i<estudiantes.size();i++) {
        	if(estudiantes.get(i).getCarrera().equals("Ingeniería en Sistemas")) {
        		  sb.append(estudiantes.get(i).getNombre()).append("\n");
        	}
        }
        JOptionPane.showMessageDialog(null, sb.toString());
        sb.setLength(0);
        
        sb.append("Ingeniería Mecánica:\n");
        for (int i=0;i<estudiantes.size();i++) {
        	if(estudiantes.get(i).getCarrera().equals("Ingeniería Mecánica")) {
        		  sb.append(estudiantes.get(i).getNombre()).append("\n");
        	}
        }
        JOptionPane.showMessageDialog(null, sb.toString());
        sb.setLength(0);
        
        sb.append("Ingeniería Marítima:\n");
        for (int i=0;i<estudiantes.size();i++) {
        	if(estudiantes.get(i).getCarrera().equals("Ingeniería Marítima")) {
        		  sb.append(estudiantes.get(i).getNombre()).append("\n");
        	}
        }
        JOptionPane.showMessageDialog(null, sb.toString());
        sb.setLength(0);
    }
    
    public void mostrarporsexo() {
    	StringBuilder sb = new StringBuilder();
        sb.append("estudiantes Hombres:\n");
        for (int i=0;i<estudiantes.size();i++) {
        	if(estudiantes.get(i).getsexo().equals("Hombre")) {
        		  sb.append(estudiantes.get(i).getNombre()).append("\n");
        	}
        }
        JOptionPane.showMessageDialog(null, sb.toString());
        sb.setLength(0);
        
        sb.append("estudiantes Mujeres:\n");
        for (int i=0;i<estudiantes.size();i++) {
        	if(estudiantes.get(i).getsexo().equals("Mujer")) {
        		  sb.append(estudiantes.get(i).getNombre()).append("\n");
        	}
        }
        JOptionPane.showMessageDialog(null, sb.toString());
        sb.setLength(0);
        
        sb.append("estudiantes Helicoptero de guerra:\n");
        for (int i=0;i<estudiantes.size();i++) {
        	if(estudiantes.get(i).getsexo().equals("Helicoptero de guerra")) {
        		  sb.append(estudiantes.get(i).getNombre()).append("\n");
        	}
        }
        JOptionPane.showMessageDialog(null, sb.toString());
        sb.setLength(0);
    }
}
