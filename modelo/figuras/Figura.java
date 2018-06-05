package modelo.figuras;

import java.awt.*;
import java.io.Serializable;

public abstract class Figura implements IFigura,Serializable{
    Point inicio;
    Dimension dimension;

    /**
     * Setter de dimension
     * @param dimension del tipo java.awt.Dimension
     */
    protected void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }
    /**
     * Setter de inicio
     * @param inicio del tipo java.awt.Point
     */
    public void setPuntoInicial(Point inicio) {
        this.inicio = inicio;
    }


    public void setPuntoFinal(Point point){
        int ancho = point.x - inicio.x;
        int alto = point.y - inicio.y;
        setDimension(new Dimension(ancho,alto));
    }

    /**
     * Getter de inicio
     * @return inicio
     */
    public Point getInicio() {
        return inicio;
    }

    public abstract void pintar(Graphics g);

    public boolean esNula() {
        return dimension.width == 0 && dimension.height == 0;
    }

}
