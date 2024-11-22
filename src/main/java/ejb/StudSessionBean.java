/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package ejb;

import entity.StudentMaster;
import entity.Subject;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Henil
 */
@Stateless
public class StudSessionBean implements StudSessionBeanLocal {

    @PersistenceContext(unitName = "my_per_unit")
    EntityManager em;

    @Override
    public Collection<StudentMaster> getAllStudentBySubject(int subjectid) {
        //    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Subject c = (Subject) em.find(Subject.class, subjectid);
        return c.getStudentMasterCollection();
    }

    @Override
    public Collection<StudentMaster> getAllStudent() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return em.createNamedQuery("StudentMaster.findAll", StudentMaster.class).getResultList();
    }
}
