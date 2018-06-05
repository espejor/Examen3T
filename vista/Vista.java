package vista;

import controlador.IMouseAdapter;
import modelo.IDibujo;

import javax.swing.*;
import java.awt.event.ActionListener;


public class Vista implements IVista{

    private final VentanaPrincipal ventanaPrincipal;
    private BarraDeMenu barraDeMenu;
    private Lienzo lienzo;

    public Vista() {
        ventanaPrincipal = VentanaPrincipal.getInstance();
        ventanaPrincipal.setJMenuBar(crearMenu());
        ventanaPrincipal.add(crearLienzo());
    }


    private JMenuBar crearMenu(){
        barraDeMenu = new BarraDeMenu();
        return barraDeMenu;
    }

    private JPanel crearLienzo(){
        lienzo = new Lienzo();
        return lienzo;
    }

    public void initVista(){
        ventanaPrincipal.verVentana();
    }

    @Override
    public void setDibujo(IDibujo dibujo) {
        this.lienzo.setDibujo(dibujo);
    }

    public void setControladorRaton(IMouseAdapter controlador){
        lienzo.setListener(controlador);
    }

    @Override
    public void setControladorMenu(ActionListener actionListener) {
        barraDeMenu.setListener(actionListener);
    }

    public void update() {
        lienzo.repaint();
    }
}
