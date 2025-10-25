public class User {
    private String name;
    private TaskList toDoList;

    public User(String name) {
        this.name = name;
        this.toDoList = new TaskList();
    }

    public String getName() {
        return name;
    }

    public void addTask(String description) {
        toDoList.addTask(description);
    }

    public void markTaskCompleted(String description) {
        boolean found = toDoList.markTaskCompleted(description);
        if (found)
            System.out.println("Task " + description + " marked as completed");
        else
            System.out.println("Task not found for" + name + ".");
    }

    public void printAllTasks() {
        System.out.println("Tasks for " + name + ":");
        toDoList.printTasks();
    }
}