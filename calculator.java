
///////////////   BASIC CALCULATOR ///////////////////////

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;


class inner extends JFrame implements ActionListener
{
    JFrame f=new JFrame();    //CREATING FRAME
    Container c=f.getContentPane();
    JTextField txt=new JTextField();
    JButton b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,bm,ba,bs,bd,bc,bdot,beql,bon,boff,bexit;

    String s0,s1,s2;
    inner()      //CONSTRUCTOR
    {
        f.setTitle("Calculator");
        s0=s1=s2="";
        f.setBounds(400,190,400,350);   //FRAME BOUNDS
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c.setLayout(null);  //LAYOUT
        c.setBackground(new Color(153, 204, 255));    //BACKGROUND

        txt.setBounds(45,30,300,50);    //SETTING TEXTFIELD
        f.add(txt);
        txt.setEditable(false);
        
        /// CLEAR BUTTON        
        bc=new JButton("C");
        bc.setBounds(45,110,55,30);
        bc.addActionListener(this);
        f.add(bc);
        bc.setBackground(new Color(153, 153, 153));
        bc.setForeground(Color.BLACK);
        
        //exit button
        bexit=new JButton("EXIT");
        bexit.setBounds(220,270,120,30);
        bexit.addActionListener(this);
        f.add(bexit);
        bexit.setBackground(new Color(255, 51, 51));
        bexit.setForeground(Color.WHITE);

       //ON BUTTON
        bon=new JButton("ON");
        bon.setBounds(45,150,59,30);
        f.add(bon);
        bon.addActionListener(this);
        bon.setBackground(new Color(51, 51, 255));
        bon.setForeground(Color.WHITE);
        
        //OFF BUTTON
        boff=new JButton("OFF");
        boff.setBounds(45,190,59,30);
        f.add(boff);
        boff.addActionListener(this);
        boff.setBackground(new Color(255, 51, 51));
        boff.setForeground(Color.WHITE);

        b1=new JButton("1");
        b1.setBounds(110,110,50,30);
        b1.addActionListener(this);
        f.add(b1);

        b2=new JButton("2");
        b2.setBounds(165,110,50,30);
        b2.addActionListener(this);
        f.add(b2);

        b3=new JButton("3");
        b3.setBounds(220,110,50,30);
        b3.addActionListener(this);
        f.add(b3);

        ba=new JButton("+");
        ba.setBounds(280,110,60,30);
        ba.addActionListener(this);
        f.add(ba);
        ba.setBackground(new Color(102, 102, 102));
        ba.setForeground(Color.WHITE);


        b4=new JButton("4");
        b4.setBounds(110,150,50,30);
        b4.addActionListener(this);
        f.add(b4);

        b5=new JButton("5");
        b5.setBounds(165,150,50,30);
        b5.addActionListener(this);
        f.add(b5);

        b6=new JButton("6");
        b6.setBounds(220,150,50,30);
        b6.addActionListener(this);
        f.add(b6);

        bs=new JButton("-");
        bs.setBounds(280,150,60,30);
        bs.addActionListener(this);
        f.add(bs);
        bs.setBackground(new Color(102, 102, 102));
        bs.setForeground(Color.WHITE);


        b7=new JButton("7");
        b7.setBounds(110,190,50,30);
        b7.addActionListener(this);
        f.add(b7);

        b8=new JButton("8");
        b8.setBounds(165,190,50,30);
        b8.addActionListener(this);
        f.add(b8);

        b9=new JButton("9");
        b9.setBounds(220,190,50,30);
        b9.addActionListener(this);
        f.add(b9);

        bm=new JButton("*");
        bm.setBounds(280,190,60,30);
        bm.addActionListener(this);
        f.add(bm);
        bm.setBackground(new Color(102, 102, 102));
        bm.setForeground(Color.WHITE);


        beql=new JButton("=");
        beql.setBounds(110,230,50,30);
        beql.addActionListener(this);
        f.add(beql);
        


        b0=new JButton("0");
        b0.setBounds(165,230,50,30);
        b0.addActionListener(this);
        f.add(b0);

        bdot=new JButton(".");
        bdot.setBounds(220,230,50,30);
        bdot.addActionListener(this);
        f.add(bdot);

        bd=new JButton("/");
        bd.setBounds(280,230,60,30);
        bd.addActionListener(this);
        f.add(bd);
        bd.setBackground(new Color(102, 102, 102));
        bd.setForeground(Color.WHITE);

        f.setResizable(false);
        c.revalidate();
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
            String s=e.getActionCommand();
            
            if((s.charAt(0) >= '0'&& s.charAt(0)<='9')||s.charAt(0)=='.')   //NUMBERS
            {
                if(s1.equals(""))
                    s0=s0+s;
                else
                    s2=s2+s;
                     
                txt.setText(s0+s1+s2);
            }
            else if(s.charAt(0)=='C')   //CLEAR C
            {
                s0=s1=s2="";
                txt.setText("");
            }
            else if(s.charAt(0)=='=') // when equal to operator  is pressed 
            {
                Double d;
                if(s1.equals("+"))
                {
                    d=Double.parseDouble(s0)+Double.parseDouble(s2);
                    txt.setText(s0+s1+s2+"  = "+d);
                }
                else if(s1.equals("-"))
                {
                    d=Double.parseDouble(s0)-Double.parseDouble(s2);
                    txt.setText(s0+s1+s2+"  = "+d);
                }
                else if(s1.equals("*"))
                {
                    d=Double.parseDouble(s0)*Double.parseDouble(s2);
                    txt.setText(s0+s1+s2+"  = "+d);
                }
                else if(s1.equals("/"))
                {
                     double a=Double.parseDouble(s0);
                     double b=Double.parseDouble(s2);
                     
                    try
                    {
                        if(b==0&&(a!=0))
                        throw new ArithmeticException(" Division by zero");
                        else if(b==0&&a==0)
                            txt.setText("0");
                        else
                        {
                        d=Double.parseDouble(s0)/Double.parseDouble(s2);
                        txt.setText(s0+s1+s2+"  = "+d);
                          }
                    }
                    catch(ArithmeticException exe)
                    {
                        String s3=exe.getMessage();
                        txt.setText(s3);
                    }
                }
            }
            //ON and OFF function
            else if(s.equals("OFF"))    //OFF function
            {
                s0=s1=s2="";
                 txt.setText("");
                 bc.setEnabled(false);
                 b1.setEnabled(false);
                 b2.setEnabled(false);
                 b3.setEnabled(false);
                 b4.setEnabled(false);
                 b5.setEnabled(false);
                 b6.setEnabled(false);
                 b7.setEnabled(false);
                 b8.setEnabled(false);
                 b9.setEnabled(false);
                 b0.setEnabled(false);
                 ba.setEnabled(false);
                 bs.setEnabled(false);
                 bd.setEnabled(false);
                 beql.setEnabled(false);
                 bdot.setEnabled(false);
                 bm.setEnabled(false);
                 bon.setEnabled(true);
                 boff.setEnabled(false);
                 
            }  
             else if(s.equals("ON"))    //ON function
            {
                 s0=s1=s2="";
                 txt.setText("");
                 bc.setEnabled(true);
                 b1.setEnabled(true);
                 b2.setEnabled(true);
                 b3.setEnabled(true);
                 b4.setEnabled(true);
                 b5.setEnabled(true);
                 b6.setEnabled(true);
                 b7.setEnabled(true);
                 b8.setEnabled(true);
                 b9.setEnabled(true);
                 b0.setEnabled(true);
                 ba.setEnabled(true);
                 bs.setEnabled(true);
                 bd.setEnabled(true);
                 beql.setEnabled(true);
                 bdot.setEnabled(true);
                 bm.setEnabled(true);
                 bon.setEnabled(false);
                 boff.setEnabled(true);
            }
             //exit function
             else if(s.equals("EXIT"))
             {
                 System.exit(0);
             }
                     
            ///////////////////
             //  storing  the operator in s1
            else
            {
                if(s1.equals(""))   
                s1=s;        
                txt.setText(s0+s1+s2);       
            }        
    }
}

class cal
{
    public static void main(String arg[])   //MAIN FUNCTION STARTS HERE
    {
        inner in=new inner();   //OBJECT CREATED
    }
}