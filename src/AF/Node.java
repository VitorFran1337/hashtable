package AF;

public class Node {
	
	private int key, priority, hash;
	private String name;
	private Node next, prev;
	
	public static int assignKey(String name) {
		int key = 0, slen;
		slen = name.length();
		for(int i = 0; i<slen; i++){
			char chara = name.charAt(i);
			key += (int) chara;
		}
		return key;
	}

	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	public Node getPrev() {
		return prev;
	}
	public void setPrev(Node prev) {
		this.prev = prev;
	}

	public int getHash() {
		return hash;
	}

	public void setHash(int hash) {
		this.hash = hash;
	}
	
	

}
