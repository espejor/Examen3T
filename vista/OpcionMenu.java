package vista;

import javax.swing.*;
import java.awt.event.ActionListener;

public class OpcionMenu extends JMenuItem implements IVistaActionListener {
    public OpcionMenu(String itemsName, int itemsMnemotecnico) {
        super(itemsName,itemsMnemotecnico);
    }

    @Override
    public void setListener(ActionListener listener) {
        addActionListener(listener);
    }
}
