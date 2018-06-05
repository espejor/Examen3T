package modelo.figuras;

import java.awt.*;

public class Circulo extends FiguraSeleccionable {


    @Override
    public void pintar(Graphics g) {
        int nuevoInicioX = dimension.width > 0 ? inicio.x : inicio.x + dimension.width;
        int nuevoInicioY = dimension.height > 0 ? inicio.y : inicio.y + dimension.height;
        int nuevaDimWidth = Math.abs(dimension.width);
        int nuevaDimHeight = Math.abs(dimension.height);
        if (!relleno)
            g.drawOval (nuevoInicioX,nuevoInicioY,nuevaDimWidth,nuevaDimHeight);
        else
            g.fillOval (nuevoInicioX,nuevoInicioY,nuevaDimWidth,nuevaDimHeight);
    }

    @Override
    public boolean contiene(Point punto) {
        Point centro = new Point(inicio.x + (dimension.width/2),inicio.y + (dimension.height/2));
        int radio = Math.abs(dimension.width)/2;
        double dx = Math.pow(punto.x - centro.x,2);
        double dy = Math.pow(punto.y - centro.y,2);
        double d = Math.sqrt(dx + dy);

        return d < radio;
    }

    /**
     * Setter de dimension
     * @param dimension del tipo java.awt.Dimension
     */
    @Override
    protected void setDimension(Dimension dimension) {
        int max = Math.abs(dimension.width) > Math.abs(dimension.height) ? Math.abs(dimension.width):Math.abs(dimension.height);
        int ancho = dimension.width > 0 ? max : -max;
        int alto = dimension.height > 0 ? max : -max;
        this.dimension = new Dimension(ancho,alto);
    }

}
