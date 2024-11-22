/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package cdi;

import client.StudClient;
import entity.StudentMaster;
import entity.Subject;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Collection;
import javax.annotation.PostConstruct;
import javax.ws.rs.core.GenericType;

/**
 *
 * @author Henil
 */
@Named(value = "studcdibeans")
@SessionScoped
public class Studcdibeans implements Serializable {

    private StudClient studclient;
    private Collection<StudentMaster> studentList;
//    private Collection<StudentMaster> studBySubject;

    int studid;
    String subjectName;

    private final GenericType<Collection<StudentMaster>> sgen = new GenericType<Collection<StudentMaster>>() {
    };

    public Studcdibeans() {
    }

    @PostConstruct
    public void init() {
        studclient = new StudClient();
        // Fetch all students initially
    }

    public void loadStudent() {
//        studentList = studclient.getAllStudent(sgen);
        
        studentList = studclient.getAllStudent(sgen);
        for (StudentMaster student : studentList) {
            System.out.println("Student: " + student.getStudentname());
            for (Subject subject : student.getSubjectCollection()) {
                System.out.println("Subject: " + subject.getSubjectname());
            }
        }
    }

    public String fetchStudentBySubject() {
        try {
            if (studid == 0) {
                loadStudent();
            } else {
                studentList = studclient.getAllStudentBySubject(sgen, studid);
            }
        } catch (ExceptionInInitializerError e) {
            e.printStackTrace();
        }
        return null;
    }

    // Getters and Setters
    public int getStudid() {
        return studid;
    }

    public void setStudid(int studid) {
        this.studid = studid;
    }

    public Collection<StudentMaster> getStudentList() {
        return studentList;
    }

    public void setStudentList(Collection<StudentMaster> studentList) {
        this.studentList = studentList;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
}
 