package QuizApplication;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login implements ActionListener{
    JFrame f = new JFrame();
    JButton rules,exit;
    JTextField tf;

    Login() {
        f.getContentPane().setBackground(Color.white);// this method picks the whole frame

        // IMAGE
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.jpeg"));// to get image/icon from sourse
        JLabel image = new JLabel(i1);
        f.setLayout(null);
        image.setBounds(0, -10, 600, 500);// left,top,length,width
        f.add(image);

        // WRITING ON FRAME
        JLabel heading = new JLabel("Tech  Brains");
        heading.setBounds(767, 50, 300, 45);
        heading.setFont(new Font("Viner Hand ITC", Font.BOLD, 45));
        heading.setForeground(Color.BLUE);
        f.add(heading);

        JLabel name = new JLabel("Enter Your Name");
        name.setBounds(820, 165, 300, 20);
        name.setFont(new Font("Mongolian Baiti", Font.BOLD, 18));
        name.setForeground(Color.BLACK);
        f.add(name);

        // textfield for name
        tf = new JTextField();
        tf.setBounds(735, 200, 300, 25);
        tf.setFont(new Font("Times new Roman", Font.PLAIN, 18));
        f.add(tf);

        // buttons
        rules = new JButton("Rules");
        rules.setBounds(755, 250, 100, 28);
        rules.setBackground(new Color(68, 28, 179));
        rules.setFont(new Font("Times new Roman", Font.PLAIN, 18));
        rules.setForeground(Color.WHITE);
        rules.addActionListener(this);
        f.add(rules);

        exit = new JButton("Exit");
        exit.setBounds(925, 250, 100, 28);
        exit.setForeground(Color.WHITE);
        exit.setFont(new Font("Times new Roman", Font.PLAIN, 18));
        exit.setBackground(new Color(68, 28, 179));
        exit.addActionListener(this);
        f.add(exit);

        f.setSize(1200, 500);// length and width
        f.setLocation(100, 100);// left,top
        f.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==rules){
            String pyname= tf.getText();
            f.setVisible(false);
            new Rules(pyname);
        }
        else if(ae.getSource()==exit){
            f.setVisible(false);
        }
    }
    public static void main(String[] args) {
        new Login();
    }
}