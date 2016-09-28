/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import server.gui.MyNewClientThread;
import server.gui.ServerGUI;

/**
 *  This is the Server Class its main functions are to:-
 *  1) Start the Server GUI Screen
 *  2) Listen for New Connections from new Clients
 *  3) Start a new Thread for each newly connected Client
 * @author j
 */
public class Server {

  
    Socket individualServer = null;
    static String portNumber = null;
    /**
     * OUTALL is an Array which holds DataOutputStream Objects, which are 
     * O/p streams of the connected clients
     */
    public static List<DataOutputStream> OUTALL 
            = new ArrayList<DataOutputStream>();
    

    
    synchronized public static void add(DataOutputStream opStream){
        OUTALL.add(opStream);
    }
    
     synchronized public static void remove(DataOutputStream opStream) {
        OUTALL.remove(opStream);
    }
    synchronized  public static void sendToAll(String msg){
        for(DataOutputStream dop:OUTALL)
        {
            try {
                dop.writeUTF(msg);
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE,
                        null, ex);
            }
        }    
    }
    
    @SuppressWarnings("ResultOfObjectAllocationIgnored")
    public static void main(String[] args) {
        // TODO code application logic here
        Server listener = new Server();  
        listener.setUp();
       	new ServerGUI();  // Start server window
        listener.Conversations(Integer.parseInt(portNumber));
        
    }

    /* Functions for continuously listen for new clients and start their 
     * threads */
    private void setUp() {
         portNumber = JOptionPane.showInputDialog("Enter the port number "
                 + "to start the server: ");
    }
    
    private void Conversations(int port) {
        try {
            ServerSocket ss = new ServerSocket(port);
            ServerGUI.Conversations.setText("Server listening @ portNumber :- "
                    +port+"\n\n");
            while(true)
                    {
                    individualServer = ss.accept();
                    Thread clientThread = new Thread
                            (new MyNewClientThread(individualServer));
                    clientThread.start();
                    }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }   
}
