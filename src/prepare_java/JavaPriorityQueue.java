package prepare_java;

import java.util.*;

public class JavaPriorityQueue {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st : students) {
                System.out.println(st.getName());
            }
        }
    }
}

class Student {
    private int id;
    private String name;
    private double cgpa;

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCgpa() {
        return cgpa;
    }
}

class Priorities {

    enum Priority {
        ENTER,
        SERVED,
    }

    List<Student> getStudents(List<String> events) {
        var comparator = Comparator.comparingDouble(Student::getCgpa).reversed()
                .thenComparing(Student::getName)
                .thenComparing(Student::getId);

        var priorityQueue = new PriorityQueue<>(comparator);

        for (String string : events) {
            String[] parameters = string.split(" ");
            Priority priority = Priority.valueOf(parameters[0]);
            switch (priority) {
                case ENTER -> priorityQueue.add(newStudent(parameters));
                case SERVED -> priorityQueue.poll();
            }
        }

        List<Student> list = new ArrayList<>(priorityQueue);
        list.sort(comparator);

        return list;
    }

    private static Student newStudent(String[] parameters) {
        return new Student(Integer.parseInt(parameters[3]),
                parameters[1],
                Double.parseDouble(parameters[2]));
    }
}