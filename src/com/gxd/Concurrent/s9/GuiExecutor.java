package com.gxd.Concurrent.s9;

import javax.swing.*;

/**
 * Created by gxdgodgxd on 18/2/2.
 */
public class GuiExecutor {

    private static final GuiExecutor gui = new GuiExecutor();

    private GuiExecutor(){

    }

    public static GuiExecutor instance(){
        return gui;
    }

    public void execute(Runnable r) {
        if (SwingUtilities.isEventDispatchThread()) {
            r.run();
        }else {
            SwingUtilities.invokeLater(r);
        }
    }
}
