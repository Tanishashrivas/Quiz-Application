package QuizApplication;

//Problems: Prev button: Piche ja rha hai toh selected option visible nhi ho rha

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Quiz extends JFrame implements ActionListener{
    JButton next,prev,Submit;
    JLabel qno,question;
    JRadioButton opt1,opt2,opt3,opt4;
    ButtonGroup grpoptions;
    public static int Score=0;

    public static int timer = 15;
    public static int ans_given = 0;

    String questions[][] = new String[10][5];// 10 questions (rows)and then 1ques+ 4 options=5columns
    String answers[][] = new String[10][2];
    String user_ans[][]= new String[10][1];
    public static int count=0;//variable for useranswer tracking
    String pyname;

    Quiz(String pyname) {
        this.pyname=pyname;
        setBounds(50, 0, 1300, 800);// if nobody calls setbounds then it is by default called by jframe
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // IMAGE
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/quiz.jpg"));// to get image/icon from sourse
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1300, 370);// left,top,length,width
        add(image);

        qno = new JLabel();
        qno.setBounds(110, 430, 50, 30);
        qno.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(qno);

        question = new JLabel();
        question.setBounds(140, 430, 850, 30);
        question.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(question);

        questions[0][0] = "Which is used to find and fix bugs in the Java programs.?";
        questions[0][1] = "JVM";
        questions[0][2] = "JDB";
        questions[0][3] = "JDK";
        questions[0][4] = "JRE";

        questions[1][0] = "What is the return type of the hashCode() method in the Object class?";
        questions[1][1] = "int";
        questions[1][2] = "Object";
        questions[1][3] = "long";
        questions[1][4] = "void";

        questions[2][0] = "Which package contains the Random class?";
        questions[2][1] = "java.util package";
        questions[2][2] = "java.lang package";
        questions[2][3] = "java.awt package";
        questions[2][4] = "java.io package";

        questions[3][0] = "An interface with no fields or methods is known as?";
        questions[3][1] = "Runnable Interface";
        questions[3][2] = "Abstract Interface";
        questions[3][3] = "Marker Interface";
        questions[3][4] = "CharSequence Interface";

        questions[4][0] = "In which memory a String is stored, when we create a string using new operator?";
        questions[4][1] = "Stack";
        questions[4][2] = "String memory";
        questions[4][3] = "Random storage space";
        questions[4][4] = "Heap memory";

        questions[5][0] = "Which of the following is a marker interface?";
        questions[5][1] = "Runnable interface";
        questions[5][2] = "Remote interface";
        questions[5][3] = "Readable interface";
        questions[5][4] = "Result interface";

        questions[6][0] = "Which keyword is used for accessing the features of a package?";
        questions[6][1] = "import";
        questions[6][2] = "package";
        questions[6][3] = "extends";
        questions[6][4] = "export";

        questions[7][0] = "In java, jar stands for?";
        questions[7][1] = "Java Archive Runner";
        questions[7][2] = "Java Archive";
        questions[7][3] = "Java Application Resource";
        questions[7][4] = "Java Application Runner";

        questions[8][0] = "Which of the following is a mutable class in java?";
        questions[8][1] = "java.lang.StringBuilder";
        questions[8][2] = "java.lang.Short";
        questions[8][3] = "java.lang.Byte";
        questions[8][4] = "java.lang.String";

        questions[9][0] = "Which of the following option leads to the portability and security of Java?";
        questions[9][1] = "Bytecode is executed by JVM";
        questions[9][2] = "The applet makes the Java code secure and portable";
        questions[9][3] = "Use of exception handling";
        questions[9][4] = "Dynamic binding between objects";

        // Find below the Answers Array of the above Questions
        answers[0][1] = "JDB";
        answers[1][1] = "int";
        answers[2][1] = "java.util package";
        answers[3][1] = "Marker Interface";
        answers[4][1] = "Heap memory";
        answers[5][1] = "Remote interface";
        answers[6][1] = "import";
        answers[7][1] = "Java Archive";
        answers[8][1] = "java.lang.StringBuilder";
        answers[9][1] = "Bytecode is executed by JVM";

        opt1 = new JRadioButton();
        opt1.setBackground(Color.white);
        opt1.setFont(new Font("Dialog", Font.PLAIN, 15));
        opt1.setBounds(170,490,700,30);
        add(opt1);

        opt2 = new JRadioButton();
        opt2.setBackground(Color.white);
        opt2.setFont(new Font("Dialog", Font.PLAIN, 15));
        opt2.setBounds(170,530,700,30);
        add(opt2);

        opt3 = new JRadioButton();
        opt3.setBackground(Color.white);
        opt3.setFont(new Font("Dialog", Font.PLAIN, 15));
        opt3.setBounds(170,570,700,30);
        add(opt3);

        opt4 = new JRadioButton();
        opt4.setBackground(Color.white);
        opt4.setFont(new Font("Dialog", Font.PLAIN, 15));
        opt4.setBounds(170,610,700,30);
        add(opt4);

        grpoptions= new ButtonGroup();//Grouping the buttons so that we cant select all the radio options at once
        grpoptions.add(opt1);
        grpoptions.add(opt2);
        grpoptions.add(opt3);
        grpoptions.add(opt4);

        //Buttons
        next = new JButton("Next");
        next.setBounds(1005, 650, 90, 28);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Times new Roman", Font.PLAIN, 18));
        next.setBackground(new Color(68, 28, 179));
        next.addActionListener(this);
        add(next);

        prev = new JButton("Prev");
        prev.setBounds(885, 650, 90, 28);
        prev.setForeground(Color.WHITE);
        prev.setFont(new Font("Times new Roman", Font.PLAIN, 18));
        prev.setBackground(new Color(68, 28, 179));
        prev.addActionListener(this);
        add(prev);

        // //Submit button for last
        Submit = new JButton("Submit");
        Submit.setBounds(1125, 650, 90, 28);
        Submit.setForeground(Color.WHITE);
        Submit.setFont(new Font("Times new Roman", Font.PLAIN, 18));
        Submit.setBackground(new Color(68, 28, 179));
        Submit.addActionListener(this);
        Submit.setEnabled(false);
        add(Submit);

        start(count);

        
        setVisible(true);
    }
    public void paint(Graphics g){
        super.paint(g);

        String time= "Time left: " + timer + " seconds";
        g.setColor(Color.RED);
        g.setFont(new Font("Arial", Font.BOLD, 17));

        if(timer>0){
            g.drawString(time, 1120, 440);
        }
        else{
            g.drawString("Time's up!!", 1120, 440);
        }

        timer--;
        
        try{
            Thread.sleep(1000);//1 sec
            repaint();
        }
        catch(Exception e){
            e.printStackTrace();
        }

        if(ans_given==1){
            ans_given=0;
            timer= 15;
        }
        else if(timer<0){//next ques show in case time is up
            timer=15;

            if(count==8){//means 9th question
                next.setEnabled(false);
                Submit.setEnabled(true);
            }

            if(count==9){//submit button case (agar submit pr click nhi kiya and time up ho gya toh it should be submitted automatically)
                if(grpoptions.getSelection()==null){//if no option is selected by the user
                    user_ans[count][0]= "";
                }
                else{
                    user_ans[count][0]= grpoptions.getSelection().getActionCommand();//jo selected option hai uski value nikal kr deta hai getActionCommand
                }
                for(int i=0;i<user_ans.length;i++){//user answers
                    if(user_ans[i][0].equals(answers[i][1])){//ans sahi hai agar toh:
                        Score+=10;
                    }
                }
                setVisible(false);
                //score class call krenge
                new Score(pyname, Score);

            }else{
                if(grpoptions.getSelection()==null){//if no option is selected by the user
                    user_ans[count][0]= "";
                }
                else{
                    user_ans[count][0]= grpoptions.getSelection().getActionCommand();//jo selected option hai uski value nikal kr deta hai getActionCommand
                }
                count++;
                start(count);
            }
        }
    }

    public void start(int count){//Function that will insert values
        qno.setText(""+ (count+1) + ". ");//string to int
        question.setText(questions[count][0]);//first row ke first column se uthaega
        opt1.setText(questions[count][1]);
        opt1.setActionCommand(questions[count][1]);
        opt2.setText(questions[count][2]);
        opt2.setActionCommand(questions[count][2]);
        opt3.setText(questions[count][3]);
        opt3.setActionCommand(questions[count][3]);
        opt4.setText(questions[count][4]);
        opt4.setActionCommand(questions[count][4]);

        grpoptions.clearSelection();//taaki prev ques ka ans na reh jaye
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==next){
            repaint();

            ans_given=1;
            if(grpoptions.getSelection()==null){//if no option is selected by the user
                user_ans[count][0]= "";
            }
            else{
                user_ans[count][0]= grpoptions.getSelection().getActionCommand();//jo selected option hai uski value nikal kr deta hai getActionCommand
            }

            if(count==8){//means 9th question
                next.setEnabled(false);
                Submit.setEnabled(true);
            }


            count++;
            start(count);
        }
        else if(ae.getSource()==prev){//piche ja rha hai toh selected option visible nhi ho rha
            repaint();
            ans_given=1;
            if(grpoptions.getSelection()==null){//if no option is selected by the user
                user_ans[count][0]= "";
            }
            else{
                user_ans[count][0]= grpoptions.getSelection().getActionCommand();//jo selected option hai uski value nikal kr deta hai getActionCommand
            }
            count--;
            start(count);
        }
        else{//submit button agar press hua hai 
            ans_given=1;

            if(grpoptions.getSelection()==null){//if no option is selected by the user
                user_ans[count][0]= "";
            }
            else{
                user_ans[count][0]= grpoptions.getSelection().getActionCommand();//jo selected option hai uski value nikal kr deta hai getActionCommand
            }
            //score calculation
            for(int i=0;i<user_ans.length;i++){//user answers
                if(user_ans[i][0].equals(answers[i][1])){//ans sahi hai agar toh:
                    Score+=10;
                }
            }
            setVisible(false);
            new Score(pyname, Score);
        }
    }

    public static void main(String[] args) {
        new Quiz("User");
    }

}
