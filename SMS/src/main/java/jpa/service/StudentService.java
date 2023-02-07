package jpa.service;

import jpa.dao.StudentDAO;
import jpa.entitymodels.Course;
import jpa.entitymodels.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import javax.persistence.TypedQuery;
import java.util.List;


public class StudentService implements StudentDAO {

    @Override
    public List<Student> getAllStudents() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session s = factory.openSession();
        String hql = "FROM Student";
        TypedQuery query = s.createQuery(hql);
        List<Student> sList = query.getResultList();

        s.close();
        return sList;
    }

    @Override
    public Student getStudentByEmail(String studentEmail) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session s = factory.openSession();
        Student foundStudent = s.get(Student.class, studentEmail);

        s.close();
        return foundStudent;
    }

    @Override
    public boolean validateStudent(String studentEmail, String studentPassword) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session s = factory.openSession();
        Student student = s.get(Student.class, studentEmail);
        s.close();

        return student != null && student.getstudentPass().equals(studentPassword);
    }

    @Override
    public void registerStudentToCourse(Student student, Course course) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session s = factory.openSession();
        Transaction transaction = s.beginTransaction();
        student.getstudentCourses().add(course);

        s.update(student);
        transaction.commit();
        s.close();
    }

    @Override
    public List<Course> getStudentCourses(Student student) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session s = factory.openSession();
        List<Course> StudentCourseList = student.getstudentCourses();

        s.close();
        return StudentCourseList;
    }
}