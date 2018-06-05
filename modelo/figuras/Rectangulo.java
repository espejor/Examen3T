package modelo.figuras;

import java.awt.*;

public class Rectangulo extends FiguraSeleccionable {

    @Override
    public void pintar(Graphics g) {
        int nuevoInicioX = dimension.width > 0 ? inicio.x : inicio.x + dimension.width;
        int nuevoInicioY = dimension.height > 0 ? inicio.y : inicio.y + dimension.height;
        int nuevaDimWidth = Math.abs(dimension.width);
        int nuevaDimHeight = Math.abs(dimension.height);

        if (!relleno)
            g.drawRect (nuevoInicioX,nuevoInicioY,nuevaDimWidth,nuevaDimHeight);
        else
            g.fillRect (nuevoInicioX,nuevoInicioY,nuevaDimWidth,nuevaDimHeight);
    }

    @Override
    public boolean contiene(Point punto) {
        return contains(punto.x, inicio.x, dimension.width) && contains(punto.y, inicio.y, dimension.height);
    }
     private boolean contains(int punto, int coordenada, int distancia){
        boolean contiene;
        if (distancia > 0)
            contiene = punto > coordenada && punto < coordenada + distancia;
        else
            contiene = punto < coordenada && punto > coordenada + distancia;
        return contiene;
     }

}
