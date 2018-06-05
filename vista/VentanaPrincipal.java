package vista;

import javax.swing.*;

public class VentanaPrincipal extends JFrame {
    // Instancia de la misma clase VentanaPrincipal
    private static final VentanaPrincipal ourInstance = new VentanaPrincipal("Examen 3� Trimestre. JER");

    // �nico punto de creaci�n de una instancia de VentanaPrincipal
    public static VentanaPrincipal getInstance() {
        return ourInstance;
    }

    // Constructor privado de VentanaPrincipal
    private VentanaPrincipal(String titulo) {
        super(titulo);
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setSize( 600, 400 );
        setLocationRelativeTo(null);
    }

    public void verVentana(){
        ourInstance.setVisible(true);
    }
}
