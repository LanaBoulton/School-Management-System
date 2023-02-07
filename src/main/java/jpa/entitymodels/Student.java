package jpa.entitymodels;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Student {
    @Id
    @Column(name = "email", nullable = false, length = 50)
    private String studentEmail;
    @Column(name = "name", nullable = false, length = 50)
    private String studentName;
    @Column(name = "password", nullable = false, length = 50)
    private String studentPass;

    //connection between two tables
    @ManyToMany(targetEntity = Course.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Course> studentCourses;

    /**creating POJO*/

    public Student() {
    }
    public Student(String studentEmail, String studentName, String studentPass) {
        this.studentEmail = studentEmail;
        this.studentName = studentName;
        this.studentPass = studentPass;
        this.studentCourses = new ArrayList<>();
    }
    public String getstudentEmail() {
        return studentEmail;
    }

    public void setstudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getstudentName() {
        return studentName;
    }

    public void setstudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getstudentPass() {
        return studentPass;
    }

    public void setstudentPass(String studentPass) {
        this.studentPass = studentPass;
    }

    public List<Course> getstudentCourses() {
        return studentCourses;
    }
    public void setsCourses(List<Course> sCourses) {
        this.studentCourses = studentCourses;
    }
}
