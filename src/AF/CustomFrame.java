package AF;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class CustomFrame extends JFrame implements ActionListener {
    static JButton printButton, addButton, delButton;
    //this.setLayout(new GridLayout()); //seems perfect for print purposes

    CustomFrame(){
        this.setTitle("Hashtable");
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setSize(640,640);
        this.setLocationRelativeTo(null); 
        this.setLayout(null);
	    this.setVisible(true);
        this.getContentPane().setBackground(new Color(158,158,158));

        printButton = new JButton();
        printButton = buttonConfig(printButton);
        printButton.addActionListener(this);
        this.add(printButton);

        addButton = new JButton();
        addButton = buttonConfig(addButton);
        addButton.addActionListener(this);
        this.add(addButton);

        delButton = new JButton();
        delButton = buttonConfig(delButton);
        delButton.addActionListener(this);
        delButton.setEnabled(false);
        this.add(delButton);
    
        JLabel label = labelConfig();
        this.add(label);
        //this.pack(); set size to accomodate all components, has to be done after all components are added
    }


    
    public static JLabel labelConfig(){
        Border border = BorderFactory.createLineBorder(Color.black,3);
        JLabel label = new JLabel("Hashtable");
        label.setBounds(200, 5, 250, 80);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setFont(new Font("Times New Roman",Font.BOLD,24));
        label.setBackground(Color.white);
        label.setOpaque(true);
        label.setBorder(border);
        return label;
            
    }

    public static JButton buttonConfig(JButton button){
        button.setFocusable(false); 
        button.setPreferredSize(new Dimension(100,100));
        if(button == printButton){
            button.setText("Show Table");
            button.setBounds(200, 100, 250, 80);

        }
        if(button == addButton){
            button.setText("Insertion");
            button.setBounds(200, 200, 250, 80);
        }
        if(button == delButton){
            button.setText("Removal");
            button.setBounds(200, 300, 250, 80);

        }
        return button;
        //button.setEnabled(false); disable a button, useful for when the list is empty?
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Hash hash = Hash.getInstance();
        if(e.getSource()== addButton){
            hash.insertion();
            if(hash.getMaxLen()>0){
                delButton.setEnabled(true);
            }
        }
        else if(e.getSource()== delButton){
                hash.removal();
                if(hash.getMaxLen()==0){
                    delButton.setEnabled(false);
                }
        }
        else if(e.getSource() == printButton){
            new ShowTable();
             

        }
        
    }
}
