package queue;


public class qnode<T> {
     private T value=null;
     private qnode<T> next=null;
     private qnode<T> back=null;
     private long index = 0;
     
     public long getIndex() {
		return index;
	}

	public void setIndex(long index) {
		this.index = index;
	}

	public qnode(){
		this.value = null;
    	 
     }
     
     public qnode(T value) {
    	 this.value = value;
     }
     
 	@Override
 	public String toString() {
 		// TODO Auto-generated method stub
 		return super.toString();
 	}
 	
 	@Override
 	public boolean equals(Object arg0) {
 		// TODO Auto-generated method stub
 		return super.equals(arg0);
 	}
 	
 	
 	
     
	public T getValue() {
		return value;
	}
	public void setValue(T value) {
		this.value = value;
	}
	public qnode<T> getNext() {
		return next;
	}
	public void setNext(qnode<T> next) {
		this.next = next;
	}
	public qnode<T> getBack() {
		return back;
	}
	public void setBack(qnode<T> back) {
		this.back = back;
	}
   
}
