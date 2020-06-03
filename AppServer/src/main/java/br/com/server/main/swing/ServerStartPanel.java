package br.com.server.main.swing;

import br.com.server.main.factory.ServiceFactory;

import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerStartPanel extends JFrame {

    private static final Logger LOG = Logger.getLogger(ServerStartPanel.class.getName());

    public ServerStartPanel( ServiceFactory factory){
        super("Start Server");
        this.setSize(400, 150);
        this.setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(null);



        JButton buttonStart = new JButton("Start Server");
        buttonStart.setBounds(150,30,150,30);


        JLabel showConected = new JLabel();
        showConected.setBounds(20,70,220,30);
        panel.add(showConected);

        JLabel labelPort = new JLabel("Port:");
        labelPort.setBounds(20,30,60,30);
        panel.add(labelPort);

        JTextField port = new JTextField("5551");
        port.setBounds(60,30,50, 30);
        port.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent event) {

                if ((!port.getText().equals(""))) {
                    buttonStart.setEnabled(true);
                } else {
                    buttonStart.setEnabled(false);
                }

                if (event.getKeyChar() >= '0' && event.getKeyChar() <= '9') {
                    port.setEditable(true);

                } else {
                    port.setText("");
                    buttonStart.setEnabled(false);

                }

            }
        });


        executeButton( factory, showConected, port, buttonStart);

        panel.add(port);
        panel.add(buttonStart);

        this.add(panel);

        this.setLocationRelativeTo(null);
        this.setVisible(true);


        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

    }


    private void executeButton( ServiceFactory factory, JLabel showConected, JTextField port, JButton buttonStart){


        Runnable task = () -> {
            try {
                factory.getServidor().start(factory);
            } catch (NumberFormatException | IOException o) {

            }
        };


        buttonStart.addActionListener(e -> {
          try{
              factory.getServidor().port(Integer.parseInt(port.getText()));
              showConected.setText(" Conected PORT ====>  " + port.getText());
              if(buttonStart.getText().equals("Disconnect")){
                  System.exit(0);
              }
              buttonStart.setText("Disconnect");

              Thread thread = new Thread(task);
              thread.start();
              thread.sleep(500);

          }catch(Exception ex) {
              LOG.log(Level.SEVERE, "Erro ao iniciar o servidor", ex);
          }
      });

    }
}
