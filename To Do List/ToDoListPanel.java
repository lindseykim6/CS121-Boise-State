
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ToDoListPanel extends JPanel{
	private ToDoList list;
	private String name;

	public ToDoListPanel(String name) {
		this.name=name;
		list=new ToDoList(this.name);
		setTitle();
	}

	public void updateCategory(){
		try {
			String selectedTask=selectTask();
			
			Task chosenTask=null;
			for (Task t: list.getTaskList()) {
				if(selectedTask.equals(t.getDescription())) {
					chosenTask=t;
				}
			}	
			
				Task.Category c=Task.Category.valueOf(selectCategory());

				chosenTask.setCategory(c);

				for(Task t: list.getTaskList()) {
					if(chosenTask.equals(t)) {
						t=chosenTask;
					} 
				}

				this.removeAll();
				setTitle();

				for(Task t: list.getTaskList()) {
					TaskButton newTasks=new TaskButton(t);
					this.add(newTasks);
					if (t.isComplete()) {
						newTasks.setForeground(Color.GRAY);
					} else {
						newTasks.setForeground(Color.BLACK);
					}


				}

		} catch (Exception e){
			if (list.getTaskList().size()==0) {
				JOptionPane.showMessageDialog(null,"Empty ToDoList!", "Alert" , JOptionPane.PLAIN_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(null,"Cancelled!", "Alert" , JOptionPane.PLAIN_MESSAGE);
			}
		}


		this.revalidate();
	}
	
	public void updatePriority(){
		try {
			String selectedTask=selectTask();
			
			Task chosenTask=null;
			for (Task t: list.getTaskList()) {
				if(selectedTask.equals(t.getDescription())) {
					chosenTask=t;
				}
			}	
			
				int priorityNumber= changePriority();
				
				if (priorityNumber!=-1) {
					chosenTask.setPriority(priorityNumber);
				
				for(Task t: list.getTaskList()) {
					if(chosenTask.equals(t)) {
						t=chosenTask;
					} 
				}

				this.removeAll();
				setTitle();

				for(Task t: list.getTaskList()) {
					TaskButton newTasks=new TaskButton(t);
					this.add(newTasks);
					if (t.isComplete()) {
						newTasks.setForeground(Color.GRAY);
					} else {
						newTasks.setForeground(Color.BLACK);
					}


				}
				
				} else {
					JOptionPane.showMessageDialog(null,"Invalid priority number!", "Alert" , JOptionPane.PLAIN_MESSAGE);
				}

		} catch (Exception e){
			if (list.getTaskList().size()==0) {
				JOptionPane.showMessageDialog(null,"Empty ToDoList!", "Alert" , JOptionPane.PLAIN_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(null,"Cancelled!", "Alert" , JOptionPane.PLAIN_MESSAGE);
			}
		}
		
		this.revalidate();
	}


	public void deleteTask() {
		try {
			String s=selectTask();
			for (Task t: list.getTaskList()) {
				if(s.equals(t.getDescription())) {
					list.deleteTask(t);
				}
			}	
		

			this.removeAll();
			setTitle();

			for(Task task: list.getTaskList()) {
				TaskButton newTasks=new TaskButton(task);
				this.add(newTasks);
				if (task.isComplete()) {
					newTasks.setForeground(Color.GRAY);
				} else {
					newTasks.setForeground(Color.BLACK);
				}


			}
			this.revalidate();
		} catch (Exception e){
			JOptionPane.showMessageDialog(null,"Cancelled!", "Alert" , JOptionPane.PLAIN_MESSAGE);
		}
	}

	public void reset() {
		list.sortTasks();

		ArrayList<Task> sortedCopy=list.getTaskList();

		this.removeAll();
		list.clearList();

		setTitle();

		for (Task sortedTask: sortedCopy) {
			list.addTask(sortedTask);
		}

		for(Task t: list.getTaskList()) {
			TaskButton newTasks=new TaskButton(t);
			this.add(newTasks);
			if (t.isComplete()) {
				newTasks.setForeground(Color.GRAY);
			} else {
				newTasks.setForeground(Color.BLACK);
			}
		}

		this.revalidate();

	}

	public void addTask(Task t) {

		list.addTask(t);
		this.add(new TaskButton(t));
		this.revalidate();

	}

	public void showWorkDialog() {
		Task nextTask=list.getWork();
		if(nextTask==null) {
			JOptionPane.showMessageDialog(null,"No work to do!", "Get Work" , JOptionPane.PLAIN_MESSAGE);
		} else {	
			JOptionPane.showMessageDialog(null,nextTask.toString(), "Get Work" , JOptionPane.PLAIN_MESSAGE);
		}
	}
	public void showErrorDialog() {
		JOptionPane.showMessageDialog(null,"Invalid Task! Did not input a valid category or priority number.", "ERROR" , JOptionPane.PLAIN_MESSAGE);
	}

	private int changePriority() {
		try {
		String s=JOptionPane.showInputDialog("Enter new priority number: ");
		String descriptionInput=(s.replaceAll("\\s",""));

		int priorityNumber=Integer.parseInt(descriptionInput);
		return priorityNumber;
		} 
		catch (Exception e) {
			return -1;
		}

	}
	private String selectCategory() {
		String [] categories = new String[]{"WORK", "PERSONAL", "OTHER", "NONE"};
		String s=(String) JOptionPane.showInputDialog(null, "Select a Category", "Category Selection", JOptionPane.QUESTION_MESSAGE, null, categories, categories[0]);
		return s;

	}

	private String selectTask() {
		ArrayList<String> taskDescriptionArrayList=new ArrayList<>();
		for(Task t: list.getTaskList()) {
			taskDescriptionArrayList.add(t.getDescription());
		}
		System.out.println("Array List: "+ taskDescriptionArrayList);
		
		Object[] taskDescription = taskDescriptionArrayList.toArray();
		String[] stringArray = Arrays.copyOf(taskDescription, taskDescription.length, String[].class);
		String t=(String) JOptionPane.showInputDialog(null, "Select a Task", "Task Selection", JOptionPane.QUESTION_MESSAGE, null, stringArray, stringArray[0]);
		return t;

	}
	
	
	private void setTitle() {
		JLabel labelName=new JLabel(name);
		this.add(labelName);
		labelName.setFont(new Font("Serif",Font.BOLD, 20));
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}
}