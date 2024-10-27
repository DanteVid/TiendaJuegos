package services;

public class GestorVendedor {

    public static final int TAM_MAX_NOMBRE = 20;
    public static final int TAM_MAX_MEDIO = 10;
    public static final int TAM_REGISTRO = 12 + (TAM_MAX_NOMBRE + TAM_MAX_MEDIO + 4 + 10);
    private String path = "data\\vendedor.txt";
}
