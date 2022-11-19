package AF;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import java.awt.*;


public class ShowTable{
    Hash hash = Hash.getInstance();
    JFrame frame = new JFrame();
    ShowTable(){
        
        frame.setTitle("Hashtable");
	    frame.setSize(640,640);
        frame.setLayout(new GridLayout());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        frame.getContentPane().setBackground(new Color(158,158,158));
        JPanel head = new JPanel();
        for(int i = 0; i < hash.getArrayLen(); i++){
            head = headConfig(i);
            frame.add(head);
        } 
    }

    public JPanel headConfig(int hashcode){
        JPanel head = new JPanel();
        head.setLayout(new BoxLayout(head,BoxLayout.Y_AXIS));
        JLabel headLabel = new JLabel();
        headLabel.setText(hashcode+"");
        headLabel.setBounds(200,1,50,50);
        head.add(headLabel);

        Node aux = hash.array[hashcode].getStart();
        for(int i = 0; i < hash.array[hashcode].len;i++){
            JPanel body = new JPanel();
            body.setLayout(new BoxLayout(body,BoxLayout.Y_AXIS));
            Border border = BorderFactory.createLineBorder(Color.black,1);
            body.setBorder(border);

            head.add(body);

            JLabel name = new JLabel();
            name.setText("Name: "+ aux.getName());
            body.add(name);

            JLabel key = new JLabel();
            key.setText("Key: "+aux.getKey());
            body.add(key);

            JLabel priority = new JLabel();
            priority.setText("Priority: "+aux.getPriority());
            body.add(priority);

            JLabel hashKey = new JLabel();
            hashKey.setText("Hash: "+aux.getHash());
            body.add(hashKey);
            
            aux = aux.getNext();
        }
        return head;
    }
}
