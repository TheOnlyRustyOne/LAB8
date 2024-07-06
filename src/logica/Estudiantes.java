package logica;



public class Estudiantes {
	private String nombre;
    private String cedula;
    private String carrera;
    private String sexo;
    private double indiceAcademico;

    public Estudiantes(String nombre, String cedula, String carrera,String sexo, double indiceAcademico) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.carrera = carrera;
        this.sexo = sexo;
        this.indiceAcademico = indiceAcademico;
    }

    public double getIndiceAcademico() {
        return indiceAcademico;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCedula() {
    	return cedula;
    }
    
    public String getCarrera() {
    	return carrera;
    }
    
    public String getsexo() {
    	return sexo;
    }
}
