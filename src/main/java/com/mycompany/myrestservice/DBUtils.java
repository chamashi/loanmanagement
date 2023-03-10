/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.myrestservice;

/**
 *
 * @author Acer
 */
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hnd
 */
public class DBUtils {
    
    static List<Student> students = new ArrayList<>();
    
    public DBUtils() {

    }
    
    public List<Student> getStudents() {
        return students;
    }
    
    public Student getStudent(String id) {
        //Write the code to read from DB
        for(Student st : students) {
            if (st.getId().equals(id)) {
                return st;
            }
        }
        return null;
    }
    
    public boolean addStudent(Student st) {
        students.add(st);
        return true;
    }
    
    public boolean updateStudent(Student st) {
        students.stream().filter(st2 -> (st2.getId().equals(st.getId()))).map(st2 -> {
            st2.setFirstName(st.getFirstName());
            return st2;
        }).map(st2 -> {
            st2.setLastName(st.getLastName());
            return st2;
        }).forEachOrdered(st2 -> {
            st2.setNic(st.getNic());
        });
        return true;
    }
    
    public boolean deleteStudent(String id) {
        int i = 0;
        for(Student st : students) {
            if (st.getId().equals(id)) {
                students.remove(i);
                break;
            }
            i++;
        }
        return true;
    }
}
