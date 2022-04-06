import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import java.awt.Color;

import javax.swing.JFrame;

import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class Ventana  implements ActionListener{

    JFrame caja;
    JButton boton1;
    JButton boton2;
    JButton boton3;
   
    int toque =0;

    public Ventana(){
    
        caja = new JFrame("Ventana");
        caja.setLocation(400,400);
        caja.setLayout(new BorderLayout());
        caja.setResizable(false);

        caja.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        caja.setPreferredSize(new Dimension(300,300));
        caja.pack();
        addComponentes();
     
        addActionListener( this );

        
    }

    public void addActionListener(ActionListener listener){
        boton1.addActionListener(listener);
        boton2.addActionListener(listener);
        boton3.addActionListener(listener);
    }

    public void addComponentes(){

        boton1=new JButton("Boton 1");
        boton1.setBackground(Color.green);
        boton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        caja.add(boton1,BorderLayout.WEST);
        
        boton2=new JButton("Boton 2");
        boton2.setBackground(Color.yellow);
        boton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        caja.add(boton2,BorderLayout.CENTER);
        
        boton3=new JButton("Boton 3");
        boton3.setBackground(Color.red);
        boton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        caja.add(boton3,BorderLayout.EAST);
       
    }


    public void validar(int consecuente){
        try{
            if(toque !=consecuente){
                throw new Exception();
            }else{
                toque=(toque+1)%3; // toque=0,1,2 -> 0,1,2
            }
        }catch(Exception e){
            toque =0;
            JOptionPane.showMessageDialog(caja,"Error, no siguio el orden de los botones, comienza de nuevo");
        }
    }
      
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(boton1)){
            validar(0);
            
        }
        if(e.getSource().equals(boton2)){
            validar(1);
        }
        if(e.getSource().equals(boton3)){
            validar(2);
        }
    }
    
    
   

    
}

   
   


