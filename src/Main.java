
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SwimmingSystem swimmingSystem = new SwimmingSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Main Menu:");
            System.out.println("1. Book a swimming lesson");
            System.out.println("2. Change/Cancel a booking");
            System.out.println("3. Attend a swimming lesson");
            System.out.println("4. Monthly learner report");
            System.out.println("5. Monthly coach report");
            System.out.println("6. Register a new learner");
            System.out.println("7. Exit");
            System.out.println("Enter your choice from 1 to 7: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    bookLesson(swimmingSystem, scanner);
                    break;
                case 2:
                    // Code to handle changing/canceling a booking
                    System.out.println("Enter learner's name:");
                    String learnerName = scanner.nextLine();
                    swimmingSystem.changeOrCancelBooking(learnerName);
                    break;
                case 3:
                    // Code to handle attending a swimming lesson
                    System.out.println("Enter learner's name:");
                    String learnerName1 = scanner.nextLine();
                    swimmingSystem.attendSwimmingLesson(learnerName1);
                    break;
                case 4:
                    System.out.println("Enter Month Number (from 1 - 12:)");
                    int month = scanner.nextInt();
                    scanner.nextLine();
                    // Code to handle generating monthly learner report
                    swimmingSystem.generateMonthlyReport(month);
                    break;
                case 5:
                    System.out.println("Enter Month Number (from 1 - 12:)");
                    int month1 = scanner.nextInt();
                    scanner.nextLine();
                    // Code to handle generating monthly coach report
                    swimmingSystem.generateMonthlyReportForCoach(month1);
                    break;
                case 6:
                    // Code to handle registering a new learner
                    swimmingSystem.registerNewLearner();
                    break;

                case 7:
                    System.out.println("Exiting program. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void bookLesson(SwimmingSystem swimmingSystem, Scanner scanner) {
        System.out.println("Enter your name:");
        String learnerName = scanner.nextLine();
        Learner learner = swimmingSystem.findLearner(learnerName);
        if (learner == null) {
            System.out.println("Learner Not registered");
            return;
        }
        System.out.println("----------------------------------------------");
        System.out.println("1. View timetable by day");
        System.out.println("2. View timetable by grade level");
        System.out.println("3. View timetable by coach");
        System.out.println("----------------------------------------------");
        System.out.println("Select filter option from 1 to 3:");
        int filterOption = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        String filterValue;
        switch (filterOption) {
            case 1:
                System.out.println("Enter day (for ex: Monday) :");
                filterValue = scanner.nextLine();
                swimmingSystem.displayTimetable("day", filterValue);
                swimmingSystem.askForBooking(scanner,learnerName);
                break;
            case 2:
                System.out.println("Enter grade levelform 1 to 5 (for ex: 1):");
                int gradeLevel = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                swimmingSystem.displayTimetable("grade level", String.valueOf(gradeLevel));
                swimmingSystem.askForBooking(scanner,learnerName);
                break;
            case 3:
                System.out.println("Enter coach(for ex: Helen):");
                filterValue = scanner.nextLine();
                swimmingSystem.displayTimetable("coach", filterValue);
                swimmingSystem.askForBooking(scanner,learnerName);
                break;
            default:
                System.out.println("Invalid filter option.");
                return;
        }

    }
}