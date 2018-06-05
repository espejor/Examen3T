package modelo;


import modelo.ficheros.CargarDibujoDeFichero;
import modelo.ficheros.GuardarDibujoEnFichero;
import modelo.figuras.IFigura;

import java.io.IOException;

public class Modelo implements IModelo{
    private IDibujo dibujo = new Dibujo();

    public IDibujo getDibujo() {
        return dibujo;
    }

    public void agregarFigura(IFigura figura) {
        dibujo.agregarFigura(figura);
    }

    public void eliminarFigura(IFigura figura) {
        dibujo.eliminarFigura(figura);
    }

    @Override
    public IDibujo nuevoDibujo() {
        dibujo = new Dibujo();
        return dibujo;
    }

    @Override
    public IDibujo abrirDibujo() throws IOException {
        dibujo = new CargarDibujoDeFichero().getDibujo();
        return dibujo;
    }

    @Override
    public void guardarDibujo() throws IOException {
        new GuardarDibujoEnFichero(getDibujo());
    }

}
