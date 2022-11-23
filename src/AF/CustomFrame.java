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
import javax.swing.*;

public class CustomFrame extends JFrame implements ActionListener {
    static JButton printButton, addButton, delButton, quitButton, creditButton;
    //this.setLayout(new GridLayout()); //seems perfect for print purposes

    CustomFrame(){
        this.setTitle("Hashtable");
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setSize(640,640);
	    this.setResizable(false);
        this.setLocationRelativeTo(null); 
        this.setLayout(null);
	    this.setVisible(true);
        this.getContentPane().setBackground(new Color(0,128,0));

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
    
        quitButton = new JButton();
        quitButton = buttonConfig(quitButton);
        quitButton.addActionListener(this);
        this.add(quitButton);
        
        creditButton = new JButton();
        creditButton = buttonConfig(creditButton);
        creditButton.addActionListener(this);
        this.add(creditButton);



        JLabel label = labelConfig();
        this.add(label);
    }


    
    public static JLabel labelConfig(){
        Border border = BorderFactory.createLineBorder(Color.black,3);
        JLabel label = new JLabel("Hashtable");
        label.setBounds(200, 5, 250, 80);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setFont(new Font("Arial",Font.BOLD,24));
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
        if(button == quitButton){
            button.setText("Sair");
            button.setBounds(200, 400, 250, 80);

        }
        if(button == creditButton){
            button.setText("Créditos");
            button.setBounds(200, 500, 250, 80);

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
        }else 
            if(e.getSource()== delButton){
                hash.removal();
                if(hash.getMaxLen()==0){
                    delButton.setEnabled(false);
                }
        }else 
            if(e.getSource() == printButton){
            new ShowTable();
        }else
            if (e.getSource() == quitButton) {
            System.exit(FRAMEBITS);
        }else
            if (e.getSource() == creditButton) {
                JOptionPane.showMessageDialog(creditButton, "INTEGRANTES:\nHigor Gabriel Ferreira Silva - 2101910\nJonas Gonçalves D'angelo Moreira - 2101852\nVitor Pereira Francisco - 2101830");
        }
        
    }
}
