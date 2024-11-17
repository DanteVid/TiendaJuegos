package world;

public class Cliente {

    private String cedula;
    private String celular;
    private String correo;

    public Cliente(String cedula, String celular, String correo) {
        this.cedula = cedula;
        this.celular = celular;
        this.correo = correo;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
