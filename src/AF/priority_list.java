package AF;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class priority_list {
	
	private Node start = null, aux;
	int len;
	Scanner sc = new Scanner(System.in);
	

	public Node getStart(){
		return start;
	}

	public void insertion(Node nd) {
		int c = JOptionPane.showConfirmDialog(null, "Do they have priority?", null, JOptionPane.YES_NO_OPTION);
		nd.setPriority(c);

		if(start == null){
			start = nd;
			start.setNext(nd);
			start.setPrev(nd);

		}else if(nd.getPriority()==1){
			nd.setNext(start);
			nd.setPrev(start.getPrev());
			start.getPrev().setNext(nd);
			start.setPrev(nd);

		}else if(start.getPriority() == 1){
			nd.setNext(start);
			nd.setPrev(start.getPrev());
			start.getPrev().setNext(nd);
			start.setPrev(nd);
			start = nd;

		}else{
			aux = start;
			for(int i = 0; i < len; i++){
				if(aux.getNext().getPriority()==0){
					aux = aux.getNext();
				}
			}
			nd.setNext(aux.getNext());
			nd.setPrev(aux);
			aux.getNext().setPrev(nd);
			aux.setNext(nd);

		}
		JOptionPane.showMessageDialog(null,"Name: "+nd.getName()+
		"\nKey: "+nd.getKey()+
		"\nPriority: "+nd.getPriority()+
		"\nHashcode: "+nd.getHash());
		len++;
	}
		
	public void removal(int remKey){
		aux = this.getStart();
		for(int i = 0; i < len; i++){
			if(aux.getKey() == remKey){
				if(len == 2){
					start = aux.getPrev();
					aux.setPrev(aux.getPrev());
					aux.setNext(aux.getNext());
					
				}else{
				aux.getNext().setPrev(aux.getPrev());
				aux.getPrev().setNext(aux.getNext());
				JOptionPane.showMessageDialog(null,aux.getName()+" successfully removed.");
				}
				len--;

				break;
			}
			aux = aux.getNext();
		}
		if(len == 0){
			start = null;
		}
	}
	
}
