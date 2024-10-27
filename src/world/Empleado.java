package world;

public class Empleado {
    public static String ESTADO_ACTIVO = "ACTIVO  ";
    public static String ESTADO_INACTIVO = "INACTIVO";
    private String id;
    private String username;
    private String password;
    private double salario;
    private String estado;

    public Empleado(String id, String username, String password, double salario, String estado) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.salario = salario;
        this.estado = estado;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
