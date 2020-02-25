/**
 * @(#)ProcessQueue.java
 *
 *
 * @author Osman Burak ÝNTÝÞAH
 * @version 1.00 2017/12/19
 */


public class ProcessQueue {
	
	//properties
    MyProcess queue;
    MyProcess tail;
    int speed;
    
    //constructor
    public ProcessQueue (int speed){
    	this.speed = speed;
    	queue = null ;		//front of the queue
		tail = null;		//end of the queue
    }
    
    //methods
    public boolean isEmpty(){
    	if ( queue == null ) {
    		return true;
    	}
    	else 
    		return false;
    }
    
    public void enqueue (String name, int time){
    	MyProcess created = new MyProcess ();
    	created.name = name;
    	created.cost = time;
    	created.next = null ;
    	if( isEmpty() ){
    		queue = created;
    	}
    	else {
    		MyProcess temp = queue;
    		while(temp.next != null){
				 temp = temp.next;
    		}		
    		temp.next = created ;
    		created.next = null;
    	}
    	System.out.println("Process " + name + "(" + time + ") enqueued."); 		   	
    }
   
    public void enqueue(MyProcess process){	
    	if( isEmpty()){
    		queue = process;
    		process.next = null;
    	}
    	else {
    		MyProcess temp = queue;
    		while(temp.next != null){
				 temp = temp.next;	
    		}		
    		temp.next = process ;
    		process.next = null;
    	}
    	System.out.println("Process " + process.name + "(" + process.cost + ") enqueued.");
    	
    }
    
    public MyProcess dequeue(){
    	MyProcess taken = queue;
    	System.out.println("Process " + queue.name + "(" + queue.cost + ") dequeued.");
    	queue = queue.next;
    	return taken;
    }
    
    public int size(){
    	MyProcess temp = queue;
    	int count = 0;
    	while(temp != null){
    		count++;
    		temp = temp.next;
    	}
    	return count;
    }
    
    public String toString(){
    	if (queue == null)
    	{
    		return "EMPTY";
    	}
    	String result = "";
		for (MyProcess temp = queue; temp != null; temp = temp.next ) {
			result += temp.name + "(" + temp.cost + ")" + " -> " ;
		}
		result = "Queue: " + result.substring(0,result.length() - 3);
    	return result;
    }
    
    public int totalCost(MyProcess process){
    	int total;
    	if(process == null)
    		return 0;
    	else{
    		return process.cost + totalCost(process.next);
    	}
    }
    
    public void run(int time){
    	System.out.println ("Running for " + time + " seconds...");
    	
    	int totalCost = time*speed ;
    	System.out.println(totalCost);
    	MyProcess temp = queue;
    	while ( temp.next != null && totalCost > 0 ){
    		temp = this.dequeue();
    		totalCost = totalCost - temp.cost ;	
    		System.out.println(totalCost);
    	}
    	if (totalCost < 0 ){
    		System.out.println("Done.");
    		System.out.println("Enqueuing remaining process");
    		this.enqueue (temp.name,(0-totalCost));
    	}
 
    }

    public ProcessQueue split(){
    	int total = this.totalCost(this.queue);
    	System.out.println("assad"+total);
    	int half = total / 2 ;
    	
    	ProcessQueue type2 = new ProcessQueue(this.speed);
    	
    	MyProcess temp = queue;
    	/*
    	 while (temp != null && total > half){
    		System.out.println(this);
    		System.out.println(type2);
    		System.out.println("*********************");
    		if ((total - temp.cost) >= half ) {
    			temp = this.dequeue();
    			type2.enqueue(temp);
    			temp.next = null;
    			temp = queue;
    			total = total - temp.cost;
    		}
    		else {
    			temp = queue;
    			type2.enqueue(temp.name,(total-half));
    			temp.cost = temp.cost - (total - half ) ;
    			break;
    		}
    	}
    	 */
    	
    	temp = queue;
    	while (temp != null && total > half){
    		if ((total - temp.cost) >= half ) 
    		{
    			this.dequeue();
    			type2.enqueue(temp);
    			total = total - temp.cost;
    			temp = queue;
    		}
    		else {
    			type2.enqueue(temp.name,(total-half));
    			temp.cost = temp.cost - (total - half ) ;
    			break;
    		}
    	}
    	
    	return type2;
    }


     
     
    
    
}