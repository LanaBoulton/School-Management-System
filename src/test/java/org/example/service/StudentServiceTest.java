package org.example.service;

import jpa.entitymodels.Student;
import jpa.service.StudentService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StudentServiceTest {

    @Test

    void getStudentByEmailTest() {

        // given
        StudentService studentService = new StudentService();
        String expectedStudentName = "Alexandra Iannitti";
        String studentEmail = "aiannitti7@is.gd";

        // when
        Student actualStudent = studentService.getStudentByEmail(studentEmail);

        // then
        assertEquals(expectedStudentName, actualStudent.getstudentName());
    }

    @Test
    void validateStudentTest(){
        StudentService studentService = new StudentService();
        String studentEmail = "aiannitti7@is.gd";
        String studentPassword = "TWP4hf5j";
        assertTrue(studentService.validateStudent(studentEmail, studentPassword));
    }

}