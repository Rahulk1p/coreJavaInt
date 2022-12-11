package com.ars.overview;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Question4 {
	
	public static void main(String[] args) {
		
		SingletonList singletonListClass = new SingletonList();
		singletonListClass.initList();
		List<Integer> list = singletonListClass.getList();
		
		/*
		 * Single threaded scenario
		 */
		SThread sThread = new SThread("SingleThread");
		sThread.initList(list);
		Thread t1 = new Thread(sThread);
		t1.setName("SingleThread");
		t1.start();
		
		
		/*
		 * Multi threaded environment
		 */
		singletonListClass = new SingletonList();
		singletonListClass.initList();
		List<Integer> list2 = singletonListClass.getList();
		for(int i=1;i<=5;i++) {
			SThread st = new SThread("MultiThread-"+i);
			st.initList(list2);
			Thread t = new Thread(st);
			t.setName("MultiThread-"+i);
			t.start();
		}
	}
	
}
class SThread implements Runnable{
	
	private String threadName;
	private List<Integer> list ;
	
	public SThread(String threadName) {
		this.threadName = threadName;
	}
	
	public void initList(List<Integer> list) {
		this.list = list;
	}
	
	
	public void run() {
		Iterator<Integer> itr = list.iterator();
		System.out.println("Before Running the thread in "+this.threadName+" = "+list);
		for(;itr.hasNext();) {
			/*
			 *  The below statement is responsible for raising ConcurrentModificationException
			 *  for statement list.remove(itg), if we comment the Integer itg = itr.next(); 
			 *  code will go through. To overcome this problem we can use iterator.remove();
			 *  
			 *  If you run this code as it is then it will throw java.util.ConcurrentModificationException
			 *  but if you comment list.remove(itg) and un-comment itr.remove() it will go through and empty
			 *  the list.
			 */
							
			Integer itg = itr.next(); 
			//list.remove(itg);
			itr.remove();
			
			sleep(100);
		}
		System.out.println("After Running the thread in "+this.threadName+"= "+list);
	}
	
	public void sleep(int sleepTime) {
		try {
			Thread.sleep(sleepTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class SingletonList{
	private List<Integer> list ;
	
	public void initList() {
		list = new ArrayList<Integer>();
		for(int i= 1; i<= 10; i++) {
			list.add(i);
		}
	}
	
	public List<Integer> getList(){
		return this.list;
	}
}

