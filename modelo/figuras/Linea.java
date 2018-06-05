package modelo.figuras;

import java.awt.*;

public class Linea extends Figura {


    @Override
    public void pintar(Graphics g) {
        int finx = dimension.width + inicio.x;
        int finy = dimension.height + inicio.y;
        g.drawLine (inicio.x,inicio.y,finx,finy);
    }
}
