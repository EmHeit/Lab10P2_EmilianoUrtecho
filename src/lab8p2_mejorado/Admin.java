package lab8p2_mejorado;

public class Admin {
    private String nombreU;
    private String correo;
    private String password;
    private String fecha;
    private String pais;

    public Admin(String nombreU, String correo, String password, String fecha, String pais) {
        this.nombreU = nombreU;
        this.correo = correo;
        this.password = password;
        this.fecha = fecha;
        this.pais = pais;
    }

    public String getNombreU() {
        return nombreU;
    }

    public String getCorreo() {
        return correo;
    }

    public String getPassword() {
        return password;
    }

    public String getFecha() {
        return fecha;
    }

    public String getPais() {
        return pais;
    }
}
