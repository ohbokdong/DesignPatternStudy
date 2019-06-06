package command;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) {
		
		PriorityQueue<Command> queue = new PriorityQueue<>();
	
		queue.add(new StringPrintCommand("A"));
		queue.add(new StringPrintCommand("ABCD"));
		queue.add(new StringPrintCommand("ABC"));
		queue.add(new StringPrintCommand("AB"));
		
		for (Command command : queue) {
			command.execute();
		}
		
	}
}
