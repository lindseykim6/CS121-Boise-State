
public class TaskMaster {

	public static void main(String[] args) {
		//Test task1
		System.out.println("Task 1");
		Task task1=new Task("Finish Activity 14");
		task1.setCategory(Task.Category.WORK);
		System.out.println(task1);
		task1.setComplete(true);
		System.out.println("Task 1 is complete: "+ task1.isComplete());
		System.out.println(task1);
		
		System.out.println();
		
		//Test task2
		System.out.println("Task 2");
		Task task2=new Task("Give Tigger a bath", 10);
		task2.setCategory(Task.Category.PERSONAL);
		System.out.println(task2);
		task2.setPriority(20);
		System.out.println("Task 2 priority: " + task2.getPriority());
		System.out.println(task2);
		
		System.out.println();
		
		//Test task3
		Task task3=new Task("Finish Activity 14");
		task3.setCategory(Task.Category.NONE);
		System.out.println("Task 3");
		System.out.println(task3);
		
		System.out.println();
		
		//Test equals
		System.out.println("Checking if Task 1 and Task 3 are equal...");
		if (task1.equals(task3)) {
			System.out.println("Task 1 and Task 3 are equal.");
		} else {
			System.out.println("Task 1 and Task 3 are not equal.");
		}
		
		System.out.println();
		
		//Test compareTo
		System.out.println("Comparing Task 1 and Task 2...");
		if (task1.compareTo(task2)==0) {
			System.out.println("Task 1 and Task 2 are equal.");
		} else if (task1.compareTo(task2)<0) {
			System.out.println("Task 1 is less important than Task 2.");
		} else {
			System.out.println("Task 1 is more important than Task 2.");
		}
		
		System.out.println();
		
		//ToDoList
		ToDoList list=new ToDoList("Lindsey's TODOs");
		list.addTask(task1);
		list.addTask(task2);
		list.addTask(task3);
		list.addTask("Do work assignments", Task.Category.PERSONAL);
		list.sortTasks();
		System.out.println(list); //The above should have a Category of Personal
		
		
		//Test getWork on list
		Task maxTask=list.getWork();
		System.out.println(maxTask);//Should be task2
		
		//Test getWork on empty list
		ToDoList emptyList=new ToDoList("Empty list");
		System.out.println(emptyList.getWork());//should be null
		
		//Test getWork on list with one complete task
		ToDoList oneComplete=new ToDoList("Has one complete task");
		Task completeTask=new Task("Finish assignment 16");
		completeTask.setComplete(true);
		oneComplete.addTask(completeTask);
		System.out.println(oneComplete.getWork());//should be null
		
		
		
	} 
}
