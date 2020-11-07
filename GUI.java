import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.*;  
import java.awt.event.*;
import java.io.*;
import javax.swing.*;


public class GUI extends JFrame implements ActionListener{

   JFrame frame;
   JPanel panel;

   public GUI() {
      frame = new JFrame();
      JButton button1 = new JButton("Select file");
      button1.addActionListener(this);
      JButton button2 = new JButton("Process");



      panel = new JPanel();
      panel.setBorder(BorderFactory.createEmptyBorder(300,300,100,300));
      panel.setLayout(new GridLayout(0,1));

      panel.add(button1);
      panel.add(button2);
      frame.add(panel, BorderLayout.CENTER);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setTitle("GUI");
      frame.pack();
      frame.setVisible(true);
      

      
   }

   public static void main(String[] args) {
      new GUI();
   }

   public void actionPerformed(ActionEvent e){

   }
   
}