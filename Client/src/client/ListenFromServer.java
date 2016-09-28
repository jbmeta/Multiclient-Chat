/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import client.gui.ClientGUI;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author j
 */
class ListenFromServer implements Runnable {

    public ListenFromServer() {
    }

    String inString;

    @Override
    public void run() {
        try {
            while (true) {
                inString = Client.IN.readUTF();
                ClientGUI.convoArea.append("\n" + inString);
            }
        } catch (IOException ex) {
            Logger.getLogger(ListenFromServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Client.IN.close();
            Client.OUT.close();
            Client.client.close();
        } catch (IOException ex) {
            Logger.getLogger(ListenFromServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
