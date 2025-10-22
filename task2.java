import java.util.*;

class Student {
    private int id;
    private String name;
    private double marks;

    public Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getMarks() {
        return marks;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    public String toString() {
        return "ID: " + id + " | Name: " + name + " | Marks: " + marks;
    }
}

public class task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        while (true) {
            System.out.println("\n1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Marks: ");
                    double marks = sc.nextDouble();
                    students.add(new Student(id, name, marks));
                    System.out.println("Student Added");
                    break;

                case 2:
                    if (students.isEmpty()) System.out.println("No Students Found");
                    else for (Student s : students) System.out.println(s);
                    break;

                case 3:
                    System.out.print("Enter ID to Update: ");
                    int uid = sc.nextInt();
                    sc.nextLine();
                    boolean found = false;
                    for (Student s : students) {
                        if (s.getId() == uid) {
                            System.out.print("Enter New Name: ");
                            String newName = sc.nextLine();
                            System.out.print("Enter New Marks: ");
                            double newMarks = sc.nextDouble();
                            s.setName(newName);
                            s.setMarks(newMarks);
                            System.out.println("Student Updated");
                            found = true;
                            break;
                        }
                    }
                    if (!found) System.out.println("Student Not Found");
                    break;

                case 4:
                    System.out.print("Enter ID to Delete: ");
                    int did = sc.nextInt();
                    Iterator<Student> it = students.iterator();
                    boolean deleted = false;
                    while (it.hasNext()) {
                        if (it.next().getId() == did) {
                            it.remove();
                            System.out.println("Student Deleted");
                            deleted = true;
                            break;
                        }
                    }
                    if (!deleted) System.out.println("Student Not Found");
                    break;

                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}
