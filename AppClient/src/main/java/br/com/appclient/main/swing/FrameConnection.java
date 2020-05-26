package br.com.appclient.main.swing;

import br.com.appclient.main.connection.ConnectionService;
import br.com.appclient.main.factory.ServiceFactory;

import javax.swing.*;
import java.awt.event.*;

public class FrameConnection extends JFrame {




    public FrameConnection(ServiceFactory factory  )  {
        super("Teste Servidor TCP ");

        this.setSize(400, 500);
        this.setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JButton btnSearch = new JButton();
        JTextField textFieldSearch = new JTextField();


        JLabel labelHost = new JLabel("Host:");
        labelHost.setBounds(20,30,60,30);
        panel.add(labelHost);

        JTextField host = new JTextField("localhost");
        host.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent event) {

                String content = host.getText();
                if (!content.equals("")) {
                    btnSearch.setEnabled(true);
                } else {
                    btnSearch.setEnabled(false);
                }
            }
        });
        host.setBounds(60,30,200, 30);
        panel.add(host);

        JLabel labelPort = new JLabel("Port:");
        labelPort.setBounds(275,30,60,30);
        panel.add(labelPort);

        JTextField port = new JTextField("5551");
        port.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent event) {

                String content = port.getText();
                if (!content.equals("")) {
                    btnSearch.setEnabled(true);
                } else {
                    btnSearch.setEnabled(false);
                }
            }
        });
        port.setBounds(310,30,60, 30);
        panel.add(port);

        textFieldSearch.setBounds(20,80,280, 30);
        textFieldSearch.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent event) {

                String content = textFieldSearch.getText();
                if (!content.equals("")) {
                    btnSearch.setEnabled(true);
                } else {
                    btnSearch.setEnabled(false);
                }
            }
        });
        panel.add(textFieldSearch);


        JTextArea  resultSearch = new JTextArea();
        resultSearch.setEditable(false);
        resultSearch.setBounds(20,130,350,330);
        resultSearch.setWrapStyleWord(true);
        resultSearch.setLineWrap(true);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(20,130,350,330);
        scrollPane.getViewport().add(resultSearch);

        panel.add(scrollPane);



        btnSearch.setBounds(310,80,60,30);
        btnSearch.setIcon(new ImageIcon(getClass()
                .getResource("/images/Very-Basic-Search-icon.png")));
        btnSearch.setEnabled(false);
        btnSearch.addActionListener(e -> {
               try{

                       resultSearch.setText("");

                       factory.getConService().hostAndPort(host.getText(), new Integer(port.getText()));

                       String formattedText = factory.getLoadOut().mountPayLoadOutImdb(textFieldSearch.getText());

                       String result =  factory.getConService().connect(formattedText);

                       if(factory.getLoadIn().checkPayLoadImdb(result)){

                           result = factory.getLoadIn().formatListView(result);


                       }else{
                           result = "Response Incorreto";
                       }


                   resultSearch.setText(result);

               }catch (NumberFormatException ex ){

                   resultSearch.setText("O campo Port aceita apenas numeros");

               }catch (IllegalArgumentException ex){

                   resultSearch.setText("Conexao nao estabelecida.");
               }
        });

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

}
