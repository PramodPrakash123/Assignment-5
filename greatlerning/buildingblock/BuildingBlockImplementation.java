package com.greatlerning.buildingblock;

import java.util.Scanner;

import com.greatlerning.treeinorder.AscendingOrderBST.Node;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class BuildingBlockImplementation {
	
	static void FrontToLast(Queue<Integer> q,
            int qsize)
{

if (qsize <= 0)
return;


q.add(q.peek());
q.remove();

FrontToLast(q, qsize - 1);
}

static void pushInQueue(Queue<Integer> q,
            int temp, int qsize)
{


if (q.isEmpty() || qsize == 0)
{
q.add(temp);
return;
}

else if (temp >= q.peek())
{

q.add(temp);

FrontToLast(q, qsize);
}
else
{

q.add(q.peek());
q.remove();

pushInQueue(q, temp, qsize - 1);
}
}

static void sortQueue(Queue<Integer> q)
{

if (q.isEmpty())
return;

int temp = q.peek();

q.remove();

sortQueue(q);

pushInQueue(q, temp, q.size());
}

	

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Queue<Integer> queue = new LinkedList<Integer>();
		int floorSize;
		

		BuildingBlockImplementation obj = new BuildingBlockImplementation();
		System.out.println("enter the total no of floors in the building");
		int size = sc.nextInt();
		for (int i = 1; i <= size; i++) {
			System.out.println("enter the floor size given on day :" + i);
			 floorSize = sc.nextInt();
			queue.add(floorSize);
			
		}
		
		System.out.println("order of construction as follows");
		for(int i=1;i<=size;i++) {
			System.out.println("\nday :"+i); 
			
			sortQueue(queue);
		
		 while (!queue.isEmpty())
		    {
		        System.out.print(queue.peek() + " ");
		        queue.remove();
		    }

		

	}

	}
}
