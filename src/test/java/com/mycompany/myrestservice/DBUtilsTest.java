/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.myrestservice;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author hnd
 */
public class DBUtilsTest {
    
    public DBUtilsTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }


    /**
     * Test of addStudent method, of class DBUtils.
     */
    @Test
    public void testAddStudent() {
        System.out.println("addStudent");
        Student st = new Student("ST02", "Andrew", "Harris", "256V");
        DBUtils instance = new DBUtils();
        boolean expResult = true;
        boolean result = instance.addStudent(st);
        assertEquals(expResult, result);
      
        Student resStudent = instance.getStudent(st.getId());
        assertEquals(st.getId(), resStudent.getId());
        assertEquals(st.getFirstName(), resStudent.getFirstName());
        assertEquals(st.getLastName(), resStudent.getLastName());
        assertEquals(st.getNic(), resStudent.getNic());
    }

    /**
     * Test of updateStudent method, of class DBUtils.
     */
    @Test
    public void testUpdateStudent() {
        System.out.println("updateStudent");
        DBUtils instance = new DBUtils();
        Student st = new Student("ST03", "Andrew", "Harris", "256V");
        instance.addStudent(st);
        st = new Student("ST03", "Andrew2", "Harris2", "2562V");
        boolean expResult = true;
        boolean result = instance.updateStudent(st);
        assertEquals(expResult, result);
        
        Student resStudent = instance.getStudent(st.getId());
        assertEquals(st.getId(), resStudent.getId());
        assertEquals(st.getFirstName(), resStudent.getFirstName());
        assertEquals(st.getLastName(), resStudent.getLastName());
        assertEquals(st.getNic(), resStudent.getNic());
    }

    /**
     * Test of deleteStudent method, of class DBUtils.
     */
    @Test
    public void testDeleteStudent() {
        System.out.println("deleteStudent");
        DBUtils instance = new DBUtils();
        
        Student st = new Student("ST04", "Andrew", "Harris", "256V");
        instance.addStudent(st);
        
        boolean expResult = true;
        boolean result = instance.deleteStudent(st.getId());
        assertEquals(expResult, result);
    }
    
}
