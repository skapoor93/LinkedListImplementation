/**
 * Simple implementation of LinkedList data structure for Integer type data only.
 * 
 * @author Shivam Kapoor
 *
 */
public class LinkedListClass<E extends Comparable<E>> {

	/**
	 * Object for creating a node.
	 */
	Node<E> head;

	/**
	 * To make a node head of the LinkedList.
	 * 
	 * @param head
	 */
	public void addFirst(Node<E> head){
		if(this.head!=null){
			Node<E> temp = this.head;
			this.head = head;
			this.head.setNext(temp);
		}else{
			System.out.println("List is empty");
		}
	}

	/**
	 * Method to add a Node at the end of LinkedList.
	 * 
	 * @param data
	 */
	public void addLast(E data){
		if(this.head==null){
			this.head = new Node<E>(data);
		}else{
			Node<E> newNode = new Node<E>(data);
			Node<E> temp = this.head;
			while(temp.getNext()!=null)
				temp = temp.getNext();
			temp.setNext(newNode);
		}
	}

	/**
	 * Method to add a Node in between a specific node which is already present in LinkedList.
	 * 
	 * @param oldData
	 * @param newData
	 */
	public void addInBetween(E oldData, E newData){
		Node<E> temp = this.head;
		boolean flag = false;
		while(temp.getNext()!=null){
			if(temp.getData().compareTo(oldData)==0){
				flag = true;
				break;
			}
			temp = temp.getNext();
		}
		if(flag){
			temp = this.head;
			while(temp.getNext()!=null){
				if(temp.getData().compareTo(oldData)==0){
					Node<E> tempData = temp.getNext();
					Node<E> newNode = new Node<>(newData);
					newNode.setNext(tempData);
					temp.setNext(newNode);
					return;
				}
				temp = temp.getNext();
			}
		}else{
			System.out.println("Data is not present in the linked list");
		}
	}

	/**
	 * Method to search a node in the LinkedList.
	 * 
	 * @param data
	 * @return
	 */
	public int search(E data){
		Node<E> temp = this.head;
		int index = 0;
		while(temp!=null){
			if(temp.getData().compareTo(data)==0){   //temp.getData()==data
				return index+1; 
			}
			index += 1;
			temp = temp.getNext();
		}
		return 0;
	}

	/**
	 * Method to print all the nodes of LinkedList.
	 */
	public void printLinkedList(){
		Node<E> temp = this.head;
		while(temp != null){
			System.out.println(temp.getData());
			temp = temp.getNext();
		}
	}
}

/**
 * Inner java class for making a node in LinkedList.
 * 
 * @author Shivam Kapoor
 *
 */
class Node<E extends Comparable<E>>{

	//Pointer to the next node in the LinkedList.
	private Node<E> next;

	//Integer type data to be stored in every Node.
	private E data;

	/**
	 * Constructor to initialize a node.
	 * 
	 * @param data
	 */
	Node(E data){
		this.data = data;
		next = null;
	}

	/**
	 * Getter and Setter methods for next node and data of LinkedList.
	 */

	/** 
	 * @return
	 */
	public E getData() {
		return data;
	}

	/**
	 * 
	 * @return
	 */
	public Node<E> getNext() {
		return next;
	}

	/**
	 * 
	 * @param next
	 */
	public void setNext(Node<E> next) {
		this.next = next;
	}
}