/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ServerGUI.java
 *
 * Created on Oct 31, 2012, 1:21:45 AM
 */
package server.gui;

/**
 *
 * @author Auroma
 */
public class ServerGUI extends javax.swing.JFrame {

    /** Creates new form ServerGUI */
    public ServerGUI() {
        setVisible(true);
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Conversations = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Server Running!");
        setName("Server"); // NOI18N
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel1.setText("Conversations");

        jScrollPane1.setAutoscrolls(true);

        Conversations.setColumns(20);
        Conversations.setEditable(false);
        Conversations.setFont(new java.awt.Font("MS Gothic", 0, 24)); // NOI18N
        Conversations.setLineWrap(true);
        Conversations.setRows(5);
        Conversations.setToolTipText("These are the current Conversations.");
        Conversations.setWrapStyleWord(true);
        jScrollPane1.setViewportView(Conversations);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 754, Short.MAX_VALUE)
                    .addComponent(jLabel1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(86, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextArea Conversations;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
