import java.util.ArrayList;
import java.util.Collections;

public class ToDoList implements ToDoListInterface{
	private String name;
	private ArrayList<Task> tasks;

	private final String BORDER="-----------------\n";


	public ToDoList(String name) {
		this.name=name;
		tasks=new ArrayList<>();
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void addTask(Task task) {
		tasks.add(task);
	}

	@Override
	public void addTask(String description) {
		tasks.add(new Task(description));
	}
	
	public void addTask(String description, Task.Category category) {
		Task t=new Task(description);
		t.setCategory(category);
		tasks.add(t);
	}

	@Override
	public Task getWork() {
		if (tasks.isEmpty()) {
			return null;
		} else {
			Task maxTask=Collections.max(tasks);
			if (maxTask.isComplete()) {
				return null;
			} else {
				return maxTask;
			}
		}
	}

	@Override
	public ArrayList<Task> getTaskList() {
		ArrayList<Task> copy=new ArrayList<>();
		for(Task t: tasks) {
			copy.add(t);
		}
		return copy;
	}

	@Override
	public String toString() {
		String header=BORDER + name + "\n" + BORDER;
		for(Task t: tasks) {
			header+=(t+"\n");
		}
		return header;
	}
	
	public void sortTasks(){
		Collections.sort(tasks);
		ArrayList<Task> descendingOrder=new ArrayList<>();
		for(int i=(tasks.size()-1);i>=0; i--) {
			descendingOrder.add(tasks.get(i));
		}
		tasks=descendingOrder;
		
	}
	public ArrayList<Task> clearList() {
		tasks.clear();
		return tasks;
		
	}
	
	public void deleteTask(Task t) {
		for (int i=0; i<tasks.size(); i++) {
			if (tasks.get(i).equals(t)) {
				tasks.remove(i);
			}
		
		}
	}
}
