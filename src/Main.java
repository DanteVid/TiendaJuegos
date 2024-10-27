import services.GestorAdministrador;
import userInterface.PestanaLogin;
import world.Administrador;

public class Main {
    public static void main(String[] args) {
        /*PestanaLogin pestanaLogin = new PestanaLogin();
        pestanaLogin.setVisible(true);
        pestanaLogin.pack();
        pestanaLogin.setLocationRelativeTo(null);*/

        GestorAdministrador gestorAdministrador = new GestorAdministrador();
        Administrador admin = new Administrador("124567890","DanielRuiz124567890", "dan", 1200000, Administrador.ESTADO_ACTIVO);
        gestorAdministrador.addAdmin(admin);
    }
}