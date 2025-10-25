import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        User[] users = new User[5];
        int userCount = 0;

        while (true) {
            System.out.println("=== TO DO LIST MANAGER ===");
            System.out.println("1. Create user");
            System.out.println("2. Add task");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    if (userCount >= users.length) {
                        System.out.println("Users limit reached.");
                        break;
                    }
                    System.out.print("Enter user name: ");
                    String name = input.nextLine();
                    if (findUser(users, userCount, name) != null) {
                        System.out.println("User already exists!");
                        break;
                    }
                    users[userCount++] = new User(name);
                    System.out.println("User " + name + " created successfully!");
                    break;

                case 2:
                    System.out.print("Enter user name: ");
                    name = input.nextLine();
                    User user = findUser(users, userCount, name);
                    if (user == null) {
                        System.out.println("User not found.");
                        break;
                    }
                    System.out.print("Enter task description: ");
                    String desc = input.nextLine();
                    user.addTask(desc);
                    System.out.println("Task added successfully!");
                    break;

                case 3:
                    System.out.print("Enter user name: ");
                    name = input.nextLine();
                    user = findUser(users, userCount, name);
                    if (user == null) {
                        System.out.println("User not found.");
                        break;
                    }
                    System.out.print("Enter task description to mark completed: ");
                    desc = input.nextLine();
                    user.markTaskCompleted(desc);
                    break;

                case 4:
                    System.out.println("Exiting program...");
                    input.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static User findUser(User[] users, int count, String name) {
        for (int i = 0; i < count; i++) {
            if (users[i].getName().equalsIgnoreCase(name)) {
                return users[i];
            }
        }
        return null;
    }
}