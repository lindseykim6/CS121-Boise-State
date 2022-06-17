import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

/**
 * Lesson 18-19: Activity - Task Master GUI
 * 
 * This class represents the main TaskMaster JPanel. 
 * 
 * It contains a ToDoListPanel and the control sub-panel.
 * 
 * @author CS121 Instructors
 * @version [semester]
 * @author [your name]
 */
@SuppressWarnings("serial")
public class TaskMasterPanel extends JPanel
{	
	private JScrollPane toDoListScrollPane;
	private ToDoListPanel listPanel;
	private JTextField descriptionField;
	private JButton addTaskButton;
	private JButton setCategoryButton;
	private JButton deleteButton;
	private JButton getWorkButton;
	private JButton setPriorityButton;
	/**
	 * Creates a new TaskMasterPanel.
	 */
	public TaskMasterPanel()
	{
		setPreferredSize(new Dimension(500, 400));	
		setLayout(new BorderLayout());

		//ToDoListPanel
		listPanel=new ToDoListPanel("My ToDoList");
		add(listPanel, BorderLayout.CENTER);
		EmptyBorder toDoListBorder=new EmptyBorder(new Insets(15, 10, 0, 10));
		listPanel.setBorder(toDoListBorder);
		//listPanel.addTask(new Task("Task 1"));
		//listPanel.addTask(new Task("Task 2"));
		//listPanel.addTask(new Task("Task 3"));

		//Scroll Pane
		toDoListScrollPane=new JScrollPane(listPanel);
		toDoListScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		toDoListScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		add(toDoListScrollPane,BorderLayout.CENTER);
		
		//ControlPanel
		
		
		JPanel bottomPanel=new JPanel();
		this.add(bottomPanel, BorderLayout.SOUTH);
		BoxLayout bottom=new BoxLayout(bottomPanel, BoxLayout.PAGE_AXIS);
		bottomPanel.setLayout(bottom);
		
		JPanel formatPanel = new JPanel();
		FlowLayout format=new FlowLayout(FlowLayout.LEFT);
		formatPanel.setLayout(format);
		
		JLabel taskFormat=new JLabel("Add task format: task, category (optional), priority (optional)");
		taskFormat.setFont(new Font("Serif",Font.PLAIN, 16));
		
		JPanel defaultCPanel = new JPanel();
		FlowLayout defaultC=new FlowLayout(FlowLayout.LEFT);
		defaultCPanel.setLayout(defaultC);
		
		JLabel defaultCategory=new JLabel("Default category: None");
		defaultCategory.setFont(new Font("Serif",Font.PLAIN, 16));
		
		JPanel defaultPPanel = new JPanel();
		FlowLayout defaultP=new FlowLayout(FlowLayout.LEFT);
		defaultPPanel.setLayout(defaultP);
		
		JLabel defaultPriority=new JLabel("Default priority: 0");
		defaultPriority.setFont(new Font("Serif",Font.PLAIN, 16));
		
		JPanel examplePanel = new JPanel();
		FlowLayout example=new FlowLayout(FlowLayout.LEFT);
		examplePanel.setLayout(example);
		
		JLabel taskExample=new JLabel("Example: Wash dog, Personal, 1");
		taskExample.setFont(new Font("Serif",Font.PLAIN, 16));
		
		JPanel nullPanel = new JPanel();
		FlowLayout nullLayout=new FlowLayout(FlowLayout.LEFT);
		nullPanel.setLayout(nullLayout);
		
		JLabel nullLabel=new JLabel("                                         ");
		
		JPanel nullPanelTwo = new JPanel();
		nullPanel.setLayout(nullLayout);
		
		JLabel nullLabelTwo=new JLabel("                                         ");
		
		//JLabel taskNull=new JLabel("");
		
		nullPanelTwo.add(nullLabelTwo); 
		bottomPanel.add(nullPanelTwo);
		
		formatPanel.add(taskFormat); 
		bottomPanel.add(formatPanel);
		
		defaultCPanel.add(defaultCategory); 
		bottomPanel.add(defaultCPanel);
		
		defaultPPanel.add(defaultPriority); 
		bottomPanel.add(defaultPPanel);
		
		examplePanel.add(taskExample); 
		bottomPanel.add(examplePanel);
		
		nullPanel.add(nullLabel); 
		bottomPanel.add(nullPanel);
		
		//Add Task Text Field
		JPanel controlPanel=new JPanel();
		
		descriptionField=new JTextField(15);
		
		//Add Task Button
		addTaskButton=new JButton("Add Task");
	
		setCategoryButton=new JButton("Change Category");
		
		deleteButton=new JButton("Delete Button");
		
		getWorkButton=new JButton("Get Work");
		
		setPriorityButton=new JButton("Change Priority");
		
		controlPanel.add(descriptionField);
		controlPanel.add(addTaskButton);
		controlPanel.add(setCategoryButton);
		controlPanel.add(setPriorityButton);
		controlPanel.add(deleteButton);
		controlPanel.add(getWorkButton);
		
		bottomPanel.add(controlPanel);
		
		getWorkButton.addActionListener(new GetWorkButtonListener());
		addTaskButton.addActionListener(new AddTaskButtonListener());
		setCategoryButton.addActionListener(new ChangeCategoryButtonListener());
		deleteButton.addActionListener(new DeleteButtonListener());
		setPriorityButton.addActionListener(new ChangePriorityButtonListener());

	
		JPanel menuPanel=new JPanel();
		this.add(menuPanel, BorderLayout.EAST);
		BoxLayout menu=new BoxLayout(menuPanel, BoxLayout.PAGE_AXIS);
		menuPanel.setLayout(menu);
		EmptyBorder menuBorder=new EmptyBorder(new Insets(100, 10, 0, 10));
		menuPanel.setBorder(menuBorder);
		JLabel categoryMenu=new JLabel("Category Menu:");
		categoryMenu.setFont(new Font("Serif",Font.BOLD, 16));
		JLabel personal=new JLabel("Personal");
		personal.setFont(new Font("Serif",Font.PLAIN, 14));
		JLabel work=new JLabel("Work");
		work.setFont(new Font("Serif",Font.PLAIN, 14));
		JLabel other=new JLabel("Other");
		other.setFont(new Font("Serif",Font.PLAIN, 14));
		JLabel none=new JLabel("None");
		none.setFont(new Font("Serif",Font.PLAIN, 14));
		menuPanel.add(categoryMenu);
		menuPanel.add(personal);
		menuPanel.add(work);
		menuPanel.add(other);
		menuPanel.add(none);
		

	}
	
	private class AddTaskButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String taskDescription=descriptionField.getText();

			Scanner l=new Scanner(taskDescription);
			l.useDelimiter(",");
			try {
				String description=l.next();
				Task userInputTask=new Task(description);
				if (l.hasNext()) {
					String category=l.next().replaceAll("\\s","");

					try {
						userInputTask.setCategory(Task.Category.valueOf(category.toUpperCase()));

						if (l.hasNext())  {
							String priority=l.next().replaceAll("\\s","");
							System.out.println(priority);	

							int priorityNumber=Integer.parseInt(priority);
							userInputTask.setPriority(priorityNumber);
						}

						listPanel.addTask(userInputTask);
						listPanel.reset();
						listPanel.repaint();


					} catch(Exception ex) {
						try {	
							int priorityNumber=Integer.parseInt(category);
							userInputTask.setPriority(priorityNumber);

							listPanel.addTask(userInputTask);
							listPanel.reset();
							listPanel.repaint();
						}

						catch (Exception exc) {
							System.out.println("Invalid task! " + category + " s not a valid category or priority number!");
							listPanel.showErrorDialog();
							System.out.println(userInputTask);
						}
					}

					l.close();
				} else {
					listPanel.addTask(userInputTask);
					listPanel.reset();
					listPanel.repaint();
				}
			} catch (Exception exception) {
				JOptionPane.showMessageDialog(null,"No element!", "Alert" , JOptionPane.PLAIN_MESSAGE);
			}
		}
	}

	private class GetWorkButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			listPanel.showWorkDialog();

		}		
	}

	private class ChangeCategoryButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			listPanel.updateCategory();
			listPanel.repaint();
		}		
	}
	
	private class ChangePriorityButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			listPanel.updatePriority();
			listPanel.repaint();
		}		
	}

	private class DeleteButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			listPanel.deleteTask();
			listPanel.repaint();
		}		
	}

}


