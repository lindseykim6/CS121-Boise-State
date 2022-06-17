
public class Task implements Comparable <Task>{
	
	public enum Category {PERSONAL,WORK, OTHER, NONE}
	
	private String description;
	private Category category;
	private int priority;
	private boolean complete;
	
	//constructs a task with a parameter description
	public Task(String description){
		this.description=description;
		priority=0;
		complete=false;
		category=Category.NONE;
	}
	
	//constructs a task with parameters description and priority
	public Task(String description, int priority) {
		this.description=description;
		this.priority=priority;
		complete=false;
		category=Category.NONE;
	}
	
	//checks if task is complete
	public boolean isComplete() {
		return complete;
	}
	
	//sets the instance variable complete to the parameter complete
	public void setComplete(boolean complete) {
		this.complete=complete;
	}
	
	//sees if one task is equal to another
	
	//gets the current description
	public String getDescription() {
		return description;
	}
	
	//sets the instance variable description to the parameter description
	public void setDescription(String description) {
		this.description=description;
	}
	
	//gets the current category
	public Category getCategory() {
		return category;
	}
	
	//sets the category
	public void setCategory(Category category) {
		this.category = category;
	}
	
	//gets the current priority
	public int getPriority() {
		return priority;
	}
	
	//sets the instance variable priority to the parameter priority
	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	
	//sees if a task equals another
	public boolean equals(Task task){
		if (this.description.equalsIgnoreCase(task.getDescription())&& this.category==task.getCategory()){
			return true;
		} else {
			return false;
		}
	}
	
	//
	public int compareTo(Task o) {
		if (this.complete==o.isComplete()){
			if (this.priority==o.getPriority()) {
				return 0;
			} else if(this.priority > o.getPriority()) {
				return -1;
			} else {
				return 1;
			}
		} else if (this.complete && !o.isComplete()) {
			return -1;
		} else {
			return 1;
		}
	}
		

	//prints the to string
	public String toString() {
		if (complete) {
			return "[X] " + description + ", " + category+ ", " + priority;
		} else {
			return "[ ] " + description + ", " + category + ", " + priority;
		}
	}




	
}
