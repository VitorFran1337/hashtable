package AF;

import javax.swing.JOptionPane;

public class Hash {
    priority_list[] array;
    
    private int maxLen, arrayLen = 10;
    private static Hash instance = new Hash();

    private Hash(){
        array = new priority_list[arrayLen];
        for(int i = 0; i < arrayLen; i++){
            array[i] = new priority_list();
        }
    }

    public static Hash getInstance(){
        return instance;
    }

    public int getArrayLen(){
        return arrayLen;
    }
    public int getMaxLen() {
        maxLen=0;
        for(int i = 0; i < 10; i++){
            if(maxLen < array[i].len){
                maxLen = array[i].len;
            }
        }
		return maxLen;
	}
	public void setMaxLen(int maxLen) {
		this.maxLen = maxLen;
	}

    public void insertion(){
        Node nd = new Node();
        String name = JOptionPane.showInputDialog("Input a name to be added");
        nd.setName(name);
        nd.setKey(Node.assignKey(name));    
        int hashkey = nd.getKey() % 10;
        nd.setHash(hashkey);
        array[hashkey].insertion(nd);       
    }

    public void removal(){
        String target = JOptionPane.showInputDialog("Input the name to be removed");
        int key = Node.assignKey(target);
        int hashkey = key%10;
        array[hashkey].removal(target);
    }
}
