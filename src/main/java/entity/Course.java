/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Henil
 */
@Entity
@Table(name = "course")
@NamedQueries({
    @NamedQuery(name = "Course.findAll", query = "SELECT c FROM Course c"),
    @NamedQuery(name = "Course.findByCourceid", query = "SELECT c FROM Course c WHERE c.courceid = :courceid"),
    @NamedQuery(name = "Course.findByCourcename", query = "SELECT c FROM Course c WHERE c.courcename = :courcename")})
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "courceid")
    private Integer courceid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "courcename")
    private String courcename;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "courceid")
    private Collection<Subject> subjectCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stucourceid")
    private Collection<StudentMaster> studentMasterCollection;

    public Course() {
    }

    public Course(Integer courceid) {
        this.courceid = courceid;
    }

    public Course(Integer courceid, String courcename) {
        this.courceid = courceid;
        this.courcename = courcename;
    }

    public Integer getCourceid() {
        return courceid;
    }

    public void setCourceid(Integer courceid) {
        this.courceid = courceid;
    }

    public String getCourcename() {
        return courcename;
    }

    public void setCourcename(String courcename) {
        this.courcename = courcename;
    }

    @JsonbTransient
    public Collection<Subject> getSubjectCollection() {
        return subjectCollection;
    }

    public void setSubjectCollection(Collection<Subject> subjectCollection) {
        this.subjectCollection = subjectCollection;
    }

    @JsonbTransient
    public Collection<StudentMaster> getStudentMasterCollection() {
        return studentMasterCollection;
    }

    public void setStudentMasterCollection(Collection<StudentMaster> studentMasterCollection) {
        this.studentMasterCollection = studentMasterCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (courceid != null ? courceid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Course)) {
            return false;
        }
        Course other = (Course) object;
        if ((this.courceid == null && other.courceid != null) || (this.courceid != null && !this.courceid.equals(other.courceid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Course[ courceid=" + courceid + " ]";
    }

}
