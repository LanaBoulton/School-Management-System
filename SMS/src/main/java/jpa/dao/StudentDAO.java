package jpa.dao;

import jpa.entitymodels.Course;
import jpa.entitymodels.Student;

import java.util.List;

public interface StudentDAO {

    List<Student> getAllStudents();

    Student getStudentByEmail(String studentEmail);

    boolean validateStudent(String studentEmail, String studentPass);

    void registerStudentToCourse(Student student, Course course);

    List<Course> getStudentCourses(Student student);
}
