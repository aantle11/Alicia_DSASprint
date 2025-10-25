public class TaskList {
    private class Node {
        Task task;
        Node next;

        Node(Task task) {
            this.task = task;
            this.next = null;
        }
    }

    private Node head;

    public TaskList() {
        head = null;
    }

    public void addTask(String description) {
        Task newTask = new Task(description);
        Node newNode = new Node(newTask);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public boolean markTaskCompleted(String description) {
        Node current = head;
        while (current.next != null) {
            if (current.task.getDescription().equals(description)) {
                current.task.markCompleted();
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void printTasks() {
        if (head == null) {
            System.out.println("No tasks found");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.println("-" + current.task);
            current = current.next;
        }
    }
}