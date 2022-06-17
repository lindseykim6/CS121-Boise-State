import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class TaskButton extends JButton{
	private Task task;
	
	public TaskButton(Task task) {
		this.task=task;
		setText(task.toString());
		addActionListener(new TaskButtonListener());
	}
	private class TaskButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Clicked!");
			
			TaskButton source=((TaskButton)e.getSource());
			
			if (task.isComplete()) {
				task.setComplete(false);
				source.setForeground(Color.BLACK);
				source.setText(task.toString());
			} else {
				task.setComplete(true);
				source.setForeground(Color.GRAY);
				source.setText(task.toString());
			}
		}
	}
}
		
	

