/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Henil
 */
@Entity
@Table(name = "student_master")
@NamedQueries({
    @NamedQuery(name = "StudentMaster.findAll", query = "SELECT s FROM StudentMaster s"),
    @NamedQuery(name = "StudentMaster.findByStudentid", query = "SELECT s FROM StudentMaster s WHERE s.studentid = :studentid"),
    @NamedQuery(name = "StudentMaster.findByStudentname", query = "SELECT s FROM StudentMaster s WHERE s.studentname = :studentname")})
public class StudentMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "studentid")
    private Integer studentid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "studentname")
    private String studentname;
    @JoinTable(name = "student_subject", joinColumns = {
        @JoinColumn(name = "stud_id", referencedColumnName = "studentid")}, inverseJoinColumns = {
        @JoinColumn(name = "subj_id", referencedColumnName = "subjectid")})
    @ManyToMany
    private Collection<Subject> subjectCollection;
    @JoinColumn(name = "stucourceid", referencedColumnName = "courceid")
    @ManyToOne(optional = false)
    private Course stucourceid;

    public StudentMaster() {
    }

    public StudentMaster(Integer studentid) {
        this.studentid = studentid;
    }

    public StudentMaster(Integer studentid, String studentname) {
        this.studentid = studentid;
        this.studentname = studentname;
    }

    public Integer getStudentid() {
        return studentid;
    }

    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    @JsonbTransient
    public Collection<Subject> getSubjectCollection() {
        return subjectCollection;
    }

    public void setSubjectCollection(Collection<Subject> subjectCollection) {
        this.subjectCollection = subjectCollection;
    }

    public Course getStucourceid() {
        return stucourceid;
    }

    public void setStucourceid(Course stucourceid) {
        this.stucourceid = stucourceid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studentid != null ? studentid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudentMaster)) {
            return false;
        }
        StudentMaster other = (StudentMaster) object;
        if ((this.studentid == null && other.studentid != null) || (this.studentid != null && !this.studentid.equals(other.studentid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.StudentMaster[ studentid=" + studentid + " ]";
    }

}
