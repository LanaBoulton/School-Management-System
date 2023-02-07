package jpa.service;

import jpa.dao.CourseDAO;
import jpa.entitymodels.Course;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import javax.persistence.TypedQuery;
import java.util.List;

public class CourseService implements CourseDAO {
    @Override
    public List<Course> getAllCourses() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session s= factory.openSession();
        String hql = "FROM Course"; //to get all records of Course class
        TypedQuery query = s.createQuery(hql);
        List<Course> cList = query.getResultList();

        s.close();
        return cList;
    }

    //method to get all courses by Id
    public Course GetCourseById(int courseId){
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session s = factory.openSession();
        Course myCourse = s.get(Course.class, courseId);
        s.close();

        return myCourse;
    }
}
