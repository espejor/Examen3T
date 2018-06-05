package modelo.figuras;

import java.awt.*;

public interface IFigura {
    void setPuntoInicial(Point inicio);

    void setPuntoFinal(Point point);

    Point getInicio();

    void pintar(Graphics g);

    boolean esNula();

}
