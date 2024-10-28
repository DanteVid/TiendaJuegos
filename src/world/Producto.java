package world;

public class Producto {
    public static String ESTADO_ACTIVO = "ACTIVO  ";
    public static String ESTADO_INACTIVO = "INACTIVO";
    private double valor;
    private String id;
    private int unidadesDisponibles;

    public Producto(double valor, String id, int unidadesDisponibles) {
        this.valor = valor;
        this.id = id;
        this.unidadesDisponibles = unidadesDisponibles;
    }

    public static String getEstadoInactivo() {
        return ESTADO_INACTIVO;
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
