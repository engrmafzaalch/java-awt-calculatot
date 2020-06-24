package com.rigrex;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.awt.event.*;
import java.awt.*;
import java.util.Arrays;

class Calculator extends Frame implements ActionListener{
    Frame f;
    String s1, s2, s3;
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16, b17, b18;
    TextField tf;
    Calculator(){
        f = new Frame();

        f = new Frame("Key Adapter");
        f.setBackground(Color.lightGray);
        f.setSize(320, 500);
        f.setLayout(null);
        f.setVisible(true);

        tf = new TextField();
        tf.setBounds(20, 30, 280, 80);
        tf.setFont(new Font("Serif", Font.PLAIN, 32));
        tf.setEditable(false);

        f.add(tf);

        b1 = new Button("9");
        b1.addActionListener(this);
        b2 = new Button("8");
        b2.addActionListener(this);
        b3 = new Button("7");
        b3.addActionListener(this);
        b4 = new Button("/");
        b4.addActionListener(this);

        b1.setBounds(20, 120, 70, 70);
        b2.setBounds(90, 120, 70, 70);
        b3.setBounds(160, 120, 70, 70);
        b4.setBounds(230, 120, 70, 70);

        b5 = new Button("6");
        b5.addActionListener(this);
        b6 = new Button("5");
        b6.addActionListener(this);
        b7 = new Button("4");
        b7.addActionListener(this);
        b8 = new Button("*");
        b8.addActionListener(this);

        b5.setBounds(20, 190, 70, 70);
        b6.setBounds(90, 190, 70, 70);
        b7.setBounds(160, 190, 70, 70);
        b8.setBounds(230, 190, 70, 70);


        b9 = new Button("3");
        b9.addActionListener(this);
        b10 = new Button("2");
        b10.addActionListener(this);
        b11 = new Button("1");
        b11.addActionListener(this);
        b12 = new Button("-");
        b12.addActionListener(this);


        b9.setBounds(20, 260, 70, 70);
        b10.setBounds(90, 260, 70, 70);
        b11.setBounds(160, 260, 70, 70);
        b12.setBounds(230, 260, 70, 70);


        b13 = new Button(".");
        b13.addActionListener(this);
        b14 = new Button("0");
        b14.addActionListener(this);

        b16 = new Button("+");
        b16.addActionListener(this);

        b13.setBounds(20, 330, 70, 70);
        b14.setBounds(90, 330, 70, 70);
        b16.setBounds(160, 330, 140, 70);

        b17 = new Button("=");
        b17.addActionListener(this);
        b15 = new Button("DEL");
        b15.addActionListener(this);
        b18 = new Button("CE");
        b18.addActionListener(this);
        b18.setBounds(160, 400, 70, 70);
        b15.setBounds(230, 400, 70, 70);
        b17.setBounds(20, 400, 140, 70);



        for (Button b : Arrays.asList(b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14, b15, b16, b17, b18)) {
            b.setBackground(Color.BLACK);
            b.setForeground(Color.WHITE);
            b.setFont(new Font("Serif", Font.PLAIN, 22));

        }
        b18.setBackground(Color.red);
        f.add(b1);f.add(b2);f.add(b3);f.add(b4);
        f.add(b5);f.add(b6);f.add(b7);f.add(b8);
        f.add(b9);f.add(b10);f.add(b11);f.add(b12);
        f.add(b13);f.add(b14);f.add(b15);f.add(b16); f.add(b17);f.add(b18);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()!=b17 && e.getSource()!=b15 && e.getSource()!=b18 ){
            s1 = e.paramString().split(",")[1].split("=")[1];
            s2 = tf.getText();
            s3 = s2+s1;
            tf.setText(s3);

        }else if (e.getSource()==b17){
            ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
            ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("JavaScript");
            try {
                System.out.println(tf.getText());
                Object result = scriptEngine.eval(tf.getText());
                tf.setText(result.toString());
            } catch (ScriptException scriptException) {
                scriptException.printStackTrace();
            }
        }else if (e.getSource() == b15 ){
            s2 = tf.getText();
            System.out.println(s2);
            s2 = s2.substring(0, s2.length()-1);
            System.out.println(s2);
            tf.setText(s2);
        }else {
            tf.setText("");
        }
    }
}

public class Main{
    public static void main(String args[]){
        Calculator c = new Calculator();
    }
}