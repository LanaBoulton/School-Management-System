package jpa.entitymodels;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int courseId;
    @Column(name = "name", nullable = false, length = 100)
    private String courseName;
    @Column(name = "instructor", nullable = false, length = 100)
    private String courseInstructorName;

    /**creating POJO*/

    public Course() {
    }

    public Course(String courseName, String courseInstructorName) {
        this.courseName = courseName;
        this.courseInstructorName = courseInstructorName;
    }

    public int getcourseId() {
        return courseId;
    }

    public void setcourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getcourseName() {
        return courseName;
    }

    public void setcourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getcourseInstructorName() {
        return courseInstructorName;
    }

    public void setcourseInstructorName(String courseInstructorName) {

        this.courseInstructorName = courseInstructorName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return courseId == course.courseId && courseName.equals(course.courseName) && courseInstructorName.equals(course.courseInstructorName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseId, courseName, courseInstructorName);
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", courseInstructorName='" + courseInstructorName + '\'' +
                '}';
    }
}
