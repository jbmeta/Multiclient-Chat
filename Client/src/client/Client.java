/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import client.gui.ClientGUI;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/** 
 * This class forms the basis of the Client side creates connection with 
 * the Server and starts ClientGUI
 * @author j
 */
public class Client {
   public static DataOutputStream OUT = null;
          static Socket client = null;
          static DataInputStream IN = null;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Client chatter = new Client();
        
      	chatter.setUp();
	chatter.letsChat();
    }

    private void setUp() {
        try {
            String ipOfserver = JOptionPane.showInputDialog("Enter the IP address of the Server :- ");
            String portNo = JOptionPane.showInputDialog("Enter the port number:- ");
                        
            client = new Socket(ipOfserver,Integer.parseInt(portNo));
            OUT = new DataOutputStream(client.getOutputStream());
            IN = new DataInputStream(client.getInputStream());
        } catch (UnknownHostException ex) {
            Logger.getLogger(Client.class.getName()).
                    log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }

    private void letsChat() {
        new ClientGUI();
        Thread listenFromServer = new Thread(new ListenFromServer());
        listenFromServer.start();
        }
}
