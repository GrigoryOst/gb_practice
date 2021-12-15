import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/*Написать на свинге графический интерфейс чата.*/

public class MyWindow extends JFrame {

    private final static String IP_ADRESS = "localhost";
    private final static int SERVER_PORT = 8283;

    private JTextArea textArea;
    private JTextField textMassage;

    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    PrintWriter printWriter;
    BufferedReader bufferedReader;

    public MyWindow() {
        try {
            openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        myWindow();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MyWindow();
            }
        });
    }

    public void openConnection() throws IOException{
        socket = new Socket(IP_ADRESS,SERVER_PORT);
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
        new Thread(() -> {
            while (true) {
                try {
                    String serverMessage = in.readUTF();
                    if (serverMessage.equalsIgnoreCase("/end")) {
                        break;
                    }
                    textArea.append(serverMessage + "\n");
                } catch (IOException ignored) {
                    ignored.printStackTrace();
                }
            }
            closeConnection(socket, in, out);
        }).start();
    }

    public void sendMessage() {
        if (!textMassage.getText().trim().isEmpty()) {
            try {
                String messageToServer = textMassage.getText();
                out.writeUTF(messageToServer);
                if (!messageToServer.equalsIgnoreCase("/end")) {
                    textArea.append(messageToServer + "\n");
                }
                textMassage.setText("");
            } catch (IOException ignored) {
            }
        }
    }

    public void myWindow() {
        setTitle("Chat");
        setBounds(1000, 400, 600, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel centerPanel = new JPanel();
        add(centerPanel, BorderLayout.CENTER);
        centerPanel.setLayout(new BorderLayout());

        JPanel bottonPanel = new JPanel();
        add(bottonPanel, BorderLayout.SOUTH);
        bottonPanel.setPreferredSize(new Dimension(20, 50));
        bottonPanel.setLayout(new BorderLayout());

        JButton startButton = new JButton("Enter");
        bottonPanel.add(startButton, BorderLayout.EAST);

        textArea = new JTextArea();
        JScrollPane textAreaScroll = new JScrollPane(textArea);
        centerPanel.add(textAreaScroll, BorderLayout.CENTER);
        textArea.setEditable(false);

        textMassage = new JTextField();
        bottonPanel.add(textMassage, BorderLayout.CENTER);

        startButton.addActionListener(e -> {
            sendMessage();
        });

        textMassage.addActionListener(e -> {
            sendMessage();
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                try {
                    out.writeUTF("/end");
                } catch (IOException ignored){
                }
            }
        });

        setVisible(true);

    }

    public void closeConnection(Socket s, DataInputStream in, DataOutputStream out) {
        try {
            out.flush();
        } catch (IOException ignored) {
        }
        try {
            in.close();
        } catch (IOException ignored) {
        }
        try {
            out.close();
        } catch (IOException ignored) {
        }
    }



}




