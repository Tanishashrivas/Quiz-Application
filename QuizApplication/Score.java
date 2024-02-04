package QuizApplication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Score extends JFrame implements ActionListener {
    JLabel sc,uscore;
    JButton btn;
    String pyname;
    Score(String pyname, int score) {
        this.pyname= pyname;

        setBounds(400, 150, 750, 550);// if nobody calls setbounds then it is by default called by jframe
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // IMAGE
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/scimg.png"));// to get image/icon from sourse
        Image i2= i1.getImage().getScaledInstance(300,250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 90, 300, 250);// left,top,length,width
        add(image);

        sc = new JLabel("THANK YOU  "+ pyname + " for playing Tech Brains!");
        sc.setForeground(Color.BLUE);
        sc.setBounds(45, 30, 700, 30);
        sc.setFont(new Font("Viner Hand ITC", Font.BOLD, 30));
        add(sc);

        uscore = new JLabel("Your Score is  " + score);
        uscore.setForeground(Color.BLUE);
        uscore.setBounds(350, 200, 300, 30);
        uscore.setFont(new Font("Viner Hand ITC", Font.BOLD, 30));
        add(uscore);

        btn = new JButton("Play Again");
        btn.setBounds(400, 270, 120, 25);
        btn.setBackground(new Color(68, 28, 179));
        btn.setFont(new Font("Times new Roman", Font.PLAIN, 18));
        btn.setForeground(Color.WHITE);
        btn.addActionListener(this);
        add(btn);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Login();
    }

    public static void main(String[] args) {
        new Score("User", 0);
    }
}
