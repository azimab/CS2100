//Azim Abdulmajeeth
//zwf8qy@virginia.edu
//HW 12 - Priority Queue
//Resources: none
public class Task implements Comparable<Task> {
    private String taskName;
    private int priority;
    //creates a new task, default priority is 1
    public Task(String taskName) {
        this.taskName = taskName;
        this.priority = 1;
    }
    //creates a new task with a set priority.
    public Task(String taskName, int priority) {
        this.taskName = taskName;
        this.priority = priority;
    }
    //accessor method for the name of the task
    public String getName() {
        return taskName;
    }
    //mutator method for changing the name of the task
    public void setName(String newName) {
        this.taskName = newName;
    }
    //accessor method for getting the priority of a task
    public int getPriority() {
        return priority;
    }
    //mutator method for changing the priority of a task
    public void setPriority(int newPriority) {
        this.priority = newPriority;
    }
    //compares the priorities of tasks, higher numbers are higher in priority and must be completed first.
    public int compareTo(Task o) {
        return Integer.compare(o.priority, this.priority);
    }
    //returns the name and priority of task in [name, priority] format
    public String toString() {
        return "[ " + taskName + ", " + priority + " ]";
    }
    //returns true if both name and priority are equal
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Task)) {
            return false;
        }
        Task otherTask = (Task) obj;
        return this.taskName.equals(otherTask.taskName) && this.priority == otherTask.priority;
    }
}
