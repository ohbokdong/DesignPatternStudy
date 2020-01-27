package week6.younggeun0.second;

import week6.younggeun0.first.Command;

public class MacroCommand implements Command {
	Command[] commands;

	public MacroCommand(Command[] commands) {
		this.commands = commands;
	}
	
	@Override
	public void execute() {
		for(int i=0; i<commands.length; i++) {
			commands[i].execute();
		}
	}
	
	@Override
	public void undo() {
		for(int i=0; i<commands.length; i++) {
			commands[i].undo();
		}
	}
}
