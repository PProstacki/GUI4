package gui4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Window extends JFrame implements ActionListener{

    Operations o = new Operations();
    JLabel lVerificated;
    JTextField tfPeselNr;
    JButton bCheckPesel;
    
    Window(){
          setTitle("PESEL Verification");
          setLocation(500, 500);
          setSize(330, 105);
          setDefaultCloseOperation(EXIT_ON_CLOSE);
          setLayout(null);
          setResizable(false);
          
          tfPeselNr = new JTextField("Podaj nr PESEL");
          tfPeselNr.setSize(200, 25);
          tfPeselNr.setLocation(10, 10);
          tfPeselNr.addActionListener(this);
          add(tfPeselNr);
          
          bCheckPesel = new JButton("Sprawdź");
          bCheckPesel.setSize(100, 60);
          bCheckPesel.setLocation(220, 10);
          bCheckPesel.addActionListener(this);
          add(bCheckPesel);
          
          lVerificated = new JLabel("");
          lVerificated.setSize(200, 25);
          lVerificated.setLocation(15, 40);
          add(lVerificated);
          
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String peselNr = tfPeselNr.getText().trim();
        
        if (peselNr.matches("^[0-9]{11}$")) {     
             if (o.checkPesel(peselNr) == true) {
                 lVerificated.setText("PESEL jest poprawny");
                 o.writeToFile(peselNr);
             } else {
                 lVerificated.setText("PESEL nie jest poprawny");
             }
         }else{
             lVerificated.setText("PESEL ma błędny format");
         }

    }
    
}
