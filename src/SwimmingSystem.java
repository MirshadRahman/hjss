import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SwimmingSystem {
    private List<Lesson> lessons;
    private List<Coach> coaches;
    private List<Learner> learners;

    public SwimmingSystem() {
        this.lessons = new ArrayList<>();
        this.coaches = new ArrayList<>();
        this.learners = new ArrayList<>();
    }

    public void addLesson(Lesson lesson) {
        lessons.add(lesson);
    }

    public void addCoach(Coach coach) {
        coaches.add(coach);
    }

    public void addLearner(Learner learner) {
        learners.add(learner);
    }

    public void displayTimetableByGradeLevel(int gradeLevel) {
        System.out.println("Available Lessons for Grade Level " + gradeLevel + ":");
        for (Lesson lesson : lessons) {
            if (lesson.getGradeLevel() == gradeLevel) {
                System.out.println("Day: " + lesson.getDay() + ", Time: " + lesson.getTime() +
                        ", Coach: " + lesson.getCoach() + ", Capacity: " + lesson.getCapacity());
            }
        }
    }

    public void bookLesson(String learnerName, int gradeLevel) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Available Lessons for Grade Level " + gradeLevel + ":");
        displayTimetableByGradeLevel(gradeLevel);
        System.out.println("Enter the time (e.g., 4-5pm) of the lesson you want to book:");
        String lessonTime = scanner.nextLine();

        Lesson selectedLesson = findLessonByGradeLevelAndTime(gradeLevel, lessonTime);
        if (selectedLesson != null) {
            Learner learner = findLearner(learnerName);
            if (learner != null) {
                if (selectedLesson.addLearner(learner)) {
                    learner.bookLesson(selectedLesson);
                    System.out.println(learnerName + " has successfully booked the lesson.");
                } else {
                    System.out.println("The lesson is already full. Booking failed.");
                }
            } else {
                System.out.println("Learner not found.");
            }
        } else {
            System.out.println("Lesson not found.");
        }
    }

    private Lesson findLessonByGradeLevelAndTime(int gradeLevel, String lessonTime) {
        for (Lesson lesson : lessons) {
            if (lesson.getGradeLevel() == gradeLevel && lesson.getTime().equalsIgnoreCase(lessonTime)) {
                return lesson;
            }
        }
        return null;
    }

    private Learner findLearner(String learnerName) {
        for (Learner learner : learners) {
            if (learner.getName().equalsIgnoreCase(learnerName)) {
                return learner;
            }
        }
        return null;
    }

    public void displayTimetable(String day, String filterValue) {
    }
}
