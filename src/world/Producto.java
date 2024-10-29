package world;

public class Producto {
    public static String ESTADO_ACTIVO = "ACTIVO  ";
    public static String ESTADO_INACTIVO = "INACTIVO";
    private String id;
    private String nombre;
    private double valor;
    private int unidadesDisponibles;
    private String estado;


    public Producto( String id,String nombre, double valor, int unidadesDisponibles, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.valor = valor;
        this.unidadesDisponibles = unidadesDisponibles;
        this.estado = estado;

    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public static String getEstadoInactivo() {
        return ESTADO_INACTIVO;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public static void setEstadoInactivo(String estadoInactivo) {
        ESTADO_INACTIVO = estadoInactivo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getUnidadesDisponibles() {
        return unidadesDisponibles;
    }

    public void setUnidadesDisponibles(int unidadesDisponibles) {
        this.unidadesDisponibles = unidadesDisponibles;
    }

    public static String getEstadoActivo() {
        return ESTADO_ACTIVO;
    }

    public static void setEstadoActivo(String estadoActivo) {
        ESTADO_ACTIVO = estadoActivo;
    }
}
