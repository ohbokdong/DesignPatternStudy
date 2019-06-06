package command;

public interface Command extends Comparable<Command> {
	void execute();
}
