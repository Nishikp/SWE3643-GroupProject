import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SkeletonFilesTest {

    private SkeletonFiles tester = new SkeletonFiles();

    /**
     * Tests for school searches via different criteria
     */
    @Test
    public void searchSchoolsByZip() {
        String[] checkString = {"Life University", "Chattahooche Tech", "Kennesaw State - Marietta", "Georgia Highlands College"};
        int zip = 30060;
        String[] schools = tester.searchSchoolsByZip(zip);

        assertArrayEquals(checkString, schools);
    }

    @Test
    public void searchSchoolsByName() {
        String[] checkString = {"Kennesaw State University"};
        String name = "Kennesaw";
        String[] schools = tester.searchSchoolsByName(name);

        assertArrayEquals(checkString, schools);
    }

    @Test
    public void searchSchoolsByState() {
        String[] checkString = {"Kennesaw State University", "University of Georgia", "Georgia Tech", "Georgia State", "Georgia Southern", "Georgia Highlands College", "Georgia Military College"};
        String state = "GA";
        String[] schools = tester.searchSchoolsByState(state);

        assertArrayEquals(checkString, schools);
    }

    @Test
    public void searchSchoolsByCounty() {
        String[] checkString = {"Fortis College", "Kennesaw State University", "Chattahoochee Technical Institute", "Life University", "Georgia Highlands College"};
        String county = "cobb";
        String[] schools = tester.searchSchoolsByCounty(county);

        assertArrayEquals(checkString, schools);
    }

    @Test
    public void searchSchoolsByKeyword() {
        String[] checkString = {"Kennesaw State University", "Georgia Tech"};
        String keyword = "engineering";
        String[] schools = tester.searchSchoolsByKeyword(keyword);

        assertArrayEquals(checkString, schools);
    }

    /**
     * Various methods of searching for specific classes
     */
    @Test
    public void searchClassByTitle() {
        String[] checkString = {"Introduction to Software Engineering", "Software Engineering", "Software Engineering Project"};
        String title = "engineering";
        String[] classes = tester.searchClassByTitle(title);

        assertArrayEquals(checkString, classes);
    }

    @Test
    public void searchClassBySubject() {
        String[] checkString = {"Principles of Physics 1", "Principles of Physics 2", "Mathematical Physics"};
        String subject = "physics";
        String[] classes = tester.searchClassBySubject(subject);

        assertArrayEquals(checkString, classes);
    }

    @Test
    public void searchClassByDuration() {
        String[] checkString = {"Principles of Physics 1", "Principles of Physics 2", "Mathematical Physics"};
        String duration = "00:50:00";
        String[] classes = tester.searchClassByDuration(duration);

        assertArrayEquals(checkString, classes);
    }

    @Test
    public void searchClassByProfessor() {
        String[] checkString = {"Principles of Physics 1", "Principles of Physics 2", "Mathematical Physics"};
        String prof = "Dr Fakeman";
        String[] classes = tester.searchClassByProfessor(prof);

        assertArrayEquals(checkString, classes);
    }

    @Test
    public void searchClassBySchool() {
        String[] checkString = {"Fortis College", "Kennesaw State University", "Chattahoochee Technical Institute", "Life University", "Georgia Highlands College"};
        String school = "Physics 1";
        String[] classes = tester.searchClassBySchool(school);

        assertArrayEquals(checkString, classes);
    }

    /**
     * Various methods of searching of through research projects
     */
    @Test
    public void searchResearchByName() {
        String[] checkString = {"Fake Project: An Analysis in FakeStuff"};
        String name = "Fake Project: An Analysis in FakeStuff";
        String[] research = tester.searchResearchByName(name);

        assertArrayEquals(checkString, research);
    }

    @Test
    public void searchResearchByTopic() {
        String[] checkString = {"Fake Project: An Analysis in FakeStuff"};
        String topic = "FakeStuff";
        String[] research = tester.searchResearchByTopic(topic);

        assertArrayEquals(checkString, research);
    }

    @Test
    public void searchResearchByProfessor() {
        String[] checkString = {"Fake Project: An Analysis in FakeStuff"};
        String prof = "Dr. Vincent Adultman";
        String[] research = tester.searchResearchByProfessor(prof);

        assertArrayEquals(checkString, research);
    }

    @Test
    public void searchResearchBySchool() {
        String[] checkString = {"Fake Project: An Analysis in FakeStuff"};
        String school = "Kennesaw State University";
        String[] research = tester.searchClassBySchool(school);

        assertArrayEquals(checkString, research);
    }

    /**
     * Displays for school & research information
     */
    @Test
    public void displaySchoolInfo() {
        String name = "Kennesaw State University";
        Object schoolInfo = tester.displaySchoolInfo(name);

        assertEquals(name, schoolInfo);
    }

    @Test
    public void displayResearchInfo() {
        int research_id = 1234;
        Object resInfo = tester.displayResearchInfo(research_id);

        assertEquals(research_id, resInfo);
    }

    /**
     * Void methods for adding courses, students, etc
     */
    @Test
    public void addCourse() {
        tester.addCourse("Fake Stuff 101");

        Object s = tester.searchClassByTitle("Fake Stuff 101");

        assertEquals("Fake Stuff 101", s);
    }

    @Test
    public void addProject() {
        tester.addProject("Fake Project: An Analysis in FakeStuff");
        Object s = tester.searchResearchByName("Fake Project: An Analysis in FakeStuff");

        assertEquals("Fake Project: An Analysis in FakeStuff", s);
    }

    @Test
    public void addStudentToProject() {
        tester.addStudentToProject("No Body");
        Object s = tester.getStudent("No Body");

        assertEquals("No Body", s);
    }

    @Test
    public void addStaffToProject() {
        tester.addStaffToProject("Maddie Up");
        Object s = tester.getStaff("Maddie Up");

        assertEquals("Maddie Up", s);
    }

    @Test
    public void addFacultyToProject() {
        tester.addFacultyToProject("Dr Vincent Adultman");
        Object s = tester.getFaculty("Dr Vincent Adultman");

        assertEquals("Dr Vincent Adultman", s);
    }

    @Test
    public void getStudent() {
        Object s = tester.getStudent("No Body");

        assertEquals("No Body", s);
    }

    @Test
    public void getStaff() {
        Object s = tester.getStaff("Maddie Up");

        assertEquals("Maddie Up", s);
    }

    @Test
    public void getFaculty() {
        Object s = tester.getFaculty("Dr Vincent Adultman");

        assertEquals("Dr Vincent Adultman", s);
    }

    @Test
    public void matchStudent() {
        String[] checkString = {"Proj 1", "Proj 2", "Proj 3"};
        String[] projects = tester.matchStudent("No Body");

        assertArrayEquals(checkString, projects);
    }

    @Test
    public void getTotalNetFunding() {
        int total = 1000000;
        Object s = tester.getTotalNetFunding(1234);

        assertEquals(total, s);
    }

    @Test
    public void getPercentages() {
        int per = 15;
        Object s = tester.getPercentages("Fake Project: An Analysis in FakeStuff");

        assertEquals(per, s);
    }

    @Test
    public void createTextFile() {
        tester.createTextFile();
    }
}
