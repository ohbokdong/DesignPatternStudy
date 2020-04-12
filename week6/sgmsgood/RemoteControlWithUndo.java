package week6.sgmsgood;

public class RemoteControlWithUndo {
	// �� ������ �ڵ忡���� �ϰ� ���� On, Off ����� ó���� �� �ֽ��ϴ�. �� ����� �迭�� ����˴ϴ�.
	Command[] onCommands;
	Command[] offCommands;
	Command undoCommand;
	
	//�����ڿ����� �� On, Off �迭�� �ν��Ͻ��� ����� �ʱ�ȭ�ϱ⸸ �ϸ� �˴ϴ�. 
	public RemoteControlWithUndo() {
		onCommands = new Command[7];
		offCommands = new Command[7];
		
		Command noCommand = new NoCommand();
		for ( int i = 0; i < 7; i++ ) {
			onCommands[i] = noCommand;
			offCommands[i] = noCommand;
		}
		
		undoCommand = noCommand;
	}
	
	//Command ����
	//�� Ŀ�ǵ� ��ü�� ���߿� ����� �� �ֵ��� �迭�� �����մϴ�.
	public void setCommand(int slot, Command onCommand, Command offCommand) {
		onCommands[slot] = onCommand;
		offCommands [slot] = offCommand;
	}
	
	// ����ڰ� On, Off ��ư�� ������ ������ �ϵ����� �� ��ư�� �����Ǵ� onButtonWasPushed() �Ǵ� offButtonWasPushed() �޼ҵ带 ȣ���մϴ�. 
	public void onButtonWasPushed (int slot) {
		onCommands[slot].execute();
		undoCommand = onCommands[slot];
	}
	
	public void offButtonWasPushed(int slot) {
		offCommands[slot].execute();
		undoCommand = offCommands[slot];
	}
	
	public void undoButtonWasPushed() {
		undoCommand.undo();
	}
	
	public String toString() {
		StringBuffer stringBuff = new StringBuffer();
		stringBuff.append("\n------ Remote Control ------\n");
		for (int i = 0; i < onCommands.length; i++) {
			stringBuff.append("[slot " + i + "] " + onCommands [i].getClass().getName() + "     " + offCommands[i].getClass().getName() + "\n");
		}
		
		return stringBuff.toString();
	}
}
