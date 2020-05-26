package br.com.server.main.swing;

import br.com.server.main.factory.ServiceFactory;
import com.sun.javafx.logging.JFRInputEvent;

import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;

public class ServerStartPanel extends JFrame {


    public ServerStartPanel( ServiceFactory factory){
        super("Start Server");
        this.setSize(400, 150);
        this.setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(null);



        JButton btnSearch = new JButton("Start Server");
        btnSearch.setBounds(150,30,150,30);


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
                    btnSearch.setEnabled(true);
                } else {
                    btnSearch.setEnabled(false);
                }

                if (event.getKeyChar() >= '0' && event.getKeyChar() <= '9') {
                    port.setEditable(true);

                } else {
                    port.setText("");
                    btnSearch.setEnabled(false);

                }

            }
        });


        executeButton( factory, showConected, port, btnSearch);

        panel.add(port);
        panel.add(btnSearch);

        this.add(panel);

        this.setLocationRelativeTo(null);
        this.setVisible(true);


        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

    }


    private void executeButton( ServiceFactory factory, JLabel showConected, JTextField port, JButton btnSearch){

        Runnable task1 = () -> {

            showConected.setText(" Conected PORT ====>  " + port.getText());
            if(btnSearch.getText().equals("Disconnect")){
                System.exit(0);
            }
            btnSearch.setText("Disconnect");
            port.setEditable(false);

        };
        Runnable task2 = () -> {
            try {
                factory.getServidor().start(factory);
            } catch (NumberFormatException | IOException o) {

            }
        };

        btnSearch.addActionListener(e -> {
            Thread thread = new Thread(task1);
            thread.start();
            Thread thread2 = new Thread(task2);
            thread2.start();

        });

    }
}
