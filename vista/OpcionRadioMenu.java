package vista;

import javax.swing.*;
import java.awt.event.ActionListener;

public class OpcionRadioMenu extends JRadioButtonMenuItem implements IVistaActionListener {

    public OpcionRadioMenu(String itemsName) {
        super(itemsName);
    }

    @Override
    public void setListener(ActionListener listener) {
        addActionListener(listener);
    }
}
