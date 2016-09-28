/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.gui;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import server.Server;

/**
 *  This class works to make the Server MultiThreaded.
 *  @author j
 */
public class MyNewClientThread implements Runnable{
    Socket newClient;
    DataInputStream IN;
    DataOutputStream OUT;
    
        
   public MyNewClientThread(Socket s)
	{
            this.newClient = s;
	}
   
    @Override
    public void run() {
        try {
            try {
                IN = new DataInputStream(newClient.getInputStream());
                OUT = new DataOutputStream(newClient.getOutputStream());
                String hostName = newClient.getInetAddress().getHostName();
                Server.add(OUT);
                String str;
                try{
                    while((str = IN.readUTF())!=null)
                    {
                    ServerGUI.Conversations.append("\n"+hostName+"::"+str);
                    Server.sendToAll(hostName+"::"+str);
                    }
                }catch(Exception ex){System.out.println(ex);} 
                }catch (IOException ex) {
                Logger.getLogger(MyNewClientThread.class.getName())
                        .log(Level.SEVERE, null, ex);
            } 
        Server.remove(OUT);
                IN.close();
                OUT.close();
                newClient.close();
        } catch (IOException ex) {
            Logger.getLogger(MyNewClientThread.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
}