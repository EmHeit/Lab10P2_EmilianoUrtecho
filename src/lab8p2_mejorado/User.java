package lab8p2_mejorado;
import java.time.LocalDate;
import java.time.Period;

public class User {
    private String nombreU;
    private String nombreOG;
    private String correo;
    private String pais;
    private String fecha;
    private String password;

    public User(String nombreU, String nombreOG, String correo, String pais, String fecha, String password) {
        this.nombreU = nombreU;
        this.nombreOG = nombreOG;
        this.correo = correo;
        this.pais = pais;
        this.fecha = fecha;
        this.password = password;
    }

    public String getNombreU() {
        return nombreU;
    }

    public String getNombreOG() {
        return nombreOG;
    }

    public String getCorreo() {
        return correo;
    }

    public String getPais() {
        return pais;
    }

    public String getFecha() {
        return fecha;
    }

    public String getPassword() {
        return password;
    }
    
    public int calcularEdad() {
        int añoActual = LocalDate.now().getYear();
        int añoNacimiento = Integer.parseInt(fecha);
        return añoActual - añoNacimiento;
    }

    @Override
    public String toString() {
        return "User: " + nombreU;
    }
}

