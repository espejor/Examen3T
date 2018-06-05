package controlador;

import modelo.IModelo;

public interface IControlador {

    IModelo getModelo();

    void updateVista();
    void guardarDibujo();
    void abrirDibujo();
    void creaNuevoDibujo();
    void creaDialogoAyuda();
}
