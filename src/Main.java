import services.GestorAdministrador;
import userInterface.PestanaLogin;
import world.Administrador;

public class Main {
    public static void main(String[] args) {
        PestanaLogin pestanaLogin = new PestanaLogin();
        pestanaLogin.setVisible(true);
        pestanaLogin.pack();
        pestanaLogin.setLocationRelativeTo(null);
    }
}