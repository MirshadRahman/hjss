package com.example;

import com.Learner;
import com.Lesson;
import com.SwimmingSystem;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;


public class SwimmingTest {


    @Test
    public void findLearnerTest()
    {
        System.out.println("=========Test to find a learner Started===========");
        SwimmingSystem s = new SwimmingSystem();
        s.addLearner(new Learner("Hero", "M", 6, "8902229292", 1));
        Learner findLearner = s.findLearner("Hero");
        Assertions.assertNotNull(findLearner);
        System.out.println("=========Test to find a learner Passed===========");

    }
    @Test
    public void addDefaultLessonsTest()
    {
        System.out.println("=========Test to add defaults Lessons Started===========");
        SwimmingSystem s = new SwimmingSystem();
        Assertions.assertTrue(s.getLessons().size()>0);
        System.out.println("=========Test to add defaults Lessons Passed===========");

    }
    @Test
    public void displayTimetableTest()
    {
        System.out.println("=========Test to Display Time Table Started===========");
        SwimmingSystem s = new SwimmingSystem();
        s.displayTimetable("day", "Monday");
        System.out.println("=========Test to Display Time Table Passed===========");
    }

    @Test
    public void cancelBookingTest()
    {
        System.out.println("=========Test to Cancel Booking Started===========");
        SwimmingSystem s = new SwimmingSystem();
        Learner learner = new Learner("Manish", "Male", 6, "1234567891", 2);
        Lesson lesson = new Lesson("Monday", "04:00-05:00", 1, "Doe");
        s.cancelBooking(learner, lesson);
        System.out.println("=========Test to  Cancel Booking Passed===========");
    }



}