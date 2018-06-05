package modelo.figuras;

import vista.IVista;

public class FactoryFigura {
    public static Figura getFigura(String tipoFigura){
        if (tipoFigura.equals(IVista.RECTANGULO))
            return new Rectangulo();
        if (tipoFigura.equals(IVista.CIRCULO))
            return new Circulo();
        if (tipoFigura.equals(IVista.LINEA))
            return new Linea();
        return null;
    }
}
