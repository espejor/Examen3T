package vista;

import controlador.IMouseAdapter;
import modelo.IDibujo;

import javax.swing.*;
import java.awt.*;



public class Lienzo extends JPanel implements IVistaMouseListener,ILienzo {
    private IDibujo dibujo;
    /**
     * Create a new buffered JPanel with the specified layout manager
     */
    public Lienzo() {
        super(null);
        setBackground(Color.WHITE);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        dibujo.dibujar(g);
    }

    /**
     * Setter de controlador
     * @param listener del tipo controlador.Controlador
     */
    public void setListener(IMouseAdapter listener) {
        this.addMouseListener( listener);
        this.addMouseMotionListener(listener);
    }


    /**
     * Setter de dibujo
     * @param dibujo del tipo modelo.Drawable
     */
    public void setDibujo(IDibujo dibujo) {
        this.dibujo = dibujo;
    }
}
