import java.math.BigInteger; 
import java.security.MessageDigest; 
import java.security.NoSuchAlgorithmException;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.*;  
import java.awt.event.*;
import java.io.*;
import javax.swing.*;


public class GUI extends JFrame implements ActionListener{

   JFrame frame;
   JPanel panel;
   JButton button1;
   JButton button2;
   JFileChooser fc;
   JTable j;
   File file;

   public static String getMd5(String input) 
	{ 
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] messageDigest = md.digest(input.getBytes());
			BigInteger no = new BigInteger(1, messageDigest);
			String hashtext = no.toString(16); 
			while (hashtext.length() < 32) { 
				hashtext = "0" + hashtext; 
			} 
			return hashtext; 
		}
		catch (NoSuchAlgorithmException e) { 
			throw new RuntimeException(e); 
		} 
	}

   public GUI() {
      frame = new JFrame();
      button1 = new JButton("Select file");
      button1.addActionListener(this);
      button2 = new JButton("Process");
      button2.addActionListener(this);
      fc = new JFileChooser();




      panel = new JPanel();
      panel.setBorder(BorderFactory.createEmptyBorder(300,300,100,300));
      panel.setLayout(new GridLayout(0,1));

      panel.add(button1);
      panel.add(button2);
      frame.setSize(1000,1000);
      frame.add(panel, BorderLayout.PAGE_START);

      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setTitle("GUI");
      frame.pack();
      frame.setVisible(true);
      

      
   }

   public static void main(String[] args)  throws Exception {
      new GUI();
   }

   public void actionPerformed(ActionEvent e){
      if (e.getSource() == button1) {
         int returnVal = fc.showOpenDialog(GUI.this); 
         if (returnVal == JFileChooser.APPROVE_OPTION) {
            file = fc.getSelectedFile();
             //This is where a real application would open the file.
         }
      }
      if (e.getSource() == button2){
         try {
            int i=0;
            String st; 
            BufferedReader br = new BufferedReader(new FileReader(file));

            while ((st = br.readLine()) != null){
               i+=1;
            }
            br.close();
            String[][] disp = new String[i][2];            
            br = new BufferedReader(new FileReader(file));
            i=0;
            while ((st = br.readLine()) != null){               
               String[] array=st.split("\t-\t");
               if(getMd5(array[0]).equals(array[1])){
                  disp[i][0]=array[0];
                  disp[i][1]="verified";
                  // System.out.println("verified");
               }
               else{
                  disp[i][0]=array[0];
                  disp[i][1]="not verified";
                  // System.out.println("not verified");
               }
               i++;
            }               
            br.close();
            String[] columnNames = { "plain-text", "result"};
            j = new JTable(disp, columnNames);
            j.setBounds(30, 40, 200, 200);      
            // adding it to JScrollPane 
            JScrollPane sp = new JScrollPane(j);
            javax.swing.SwingUtilities.invokeLater(new Runnable() {
               public void run() { 
                   sp.getVerticalScrollBar().setValue(0);
               }
            });
            frame.setSize(1000,1000);
            frame.add(sp, BorderLayout.CENTER);
            frame.setVisible(true);
         } catch (Exception handlethis) {
            //TODO: handle exception
         }
      }

   }
   
}