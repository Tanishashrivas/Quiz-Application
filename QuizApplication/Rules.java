package QuizApplication;
import java.awt.Color;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Rules extends JFrame implements ActionListener{
String pyname;
JButton start,back;

    Rules(String pyname){
        this.pyname= pyname;
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel heading = new JLabel("Hi " + pyname + "!  Welcome to Tech Brains");
        heading.setBounds(50, 20, 700, 30);
        heading.setFont(new Font("Viner Hand ITC", Font.BOLD, 30));
        heading.setForeground(Color.BLUE);
        add(heading);

        JLabel rules = new JLabel();
        rules.setBounds(20, 90, 700, 350);
        rules.setFont(new Font("Tahoma", Font.PLAIN, 16));
        rules.setText(
            "<html>"+ 
                "1. You are trained to be a programmer and not a story teller, answer point to point" + "<br><br>" +
                "2. Do not unnecessarily smile at the person sitting next to you, they may also not know the answer" + "<br><br>" +
                "3. You may have lot of options in life but here all the questions are compulsory" + "<br><br>" +
                "4. Crying is allowed but please do so quietly." + "<br><br>" +
                "5. Only a fool asks and a wise answers (Be wise, not otherwise)" + "<br><br>" +
                "6. Do not get nervous if your friend is answering more questions, may be he/she is doing Jai Mata Di" + "<br><br>" +
                "7. Brace yourself, this paper is not for the faint hearted" + "<br><br>" +
                "8. May you know more than what John Snow knows, Good Luck" + "<br><br>" +
            "<html>"
);
        add(rules);

        back = new JButton("Back");
        back.setBounds(250, 500, 100, 30);
        back.setBackground(new Color(68, 28, 179));
        back.setFont(new Font("Times new Roman", Font.PLAIN, 18));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        start = new JButton("Start");
        start.setBounds(400, 500, 100, 30);
        start.setForeground(Color.WHITE);
        start.setFont(new Font("Times new Roman", Font.PLAIN, 18));
        start.setBackground(new Color(68, 28, 179));
        start.addActionListener(this);
        add(start);

    setSize(800,650);
    setLocation(350,85);
    setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==start){
            setVisible(false);
            new Quiz(pyname);
        }
        else{
            setVisible(false);
            new Login();
        }
    }
    public static void main(String[] args) {
        new Rules("User");//in case someone enters nothing, by default user will be shown
    }
}