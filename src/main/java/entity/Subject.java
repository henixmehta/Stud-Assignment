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
@Table(name = "subject")
@NamedQueries({
    @NamedQuery(name = "Subject.findAll", query = "SELECT s FROM Subject s"),
    @NamedQuery(name = "Subject.findBySubjectid", query = "SELECT s FROM Subject s WHERE s.subjectid = :subjectid"),
    @NamedQuery(name = "Subject.findBySubjectname", query = "SELECT s FROM Subject s WHERE s.subjectname = :subjectname")})
public class Subject implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "subjectid")
    private Integer subjectid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "subjectname")
    private String subjectname;
    @ManyToMany(mappedBy = "subjectCollection")
    private Collection<StudentMaster> studentMasterCollection;
    @JoinColumn(name = "courceid", referencedColumnName = "courceid")
    @ManyToOne(optional = false)
    private Course courceid;

    public Subject() {
    }

    public Subject(Integer subjectid) {
        this.subjectid = subjectid;
    }

    public Subject(Integer subjectid, String subjectname) {
        this.subjectid = subjectid;
        this.subjectname = subjectname;
    }

    public Integer getSubjectid() {
        return subjectid;
    }

    public void setSubjectid(Integer subjectid) {
        this.subjectid = subjectid;
    }

    public String getSubjectname() {
        return subjectname;
    }

    public void setSubjectname(String subjectname) {
        this.subjectname = subjectname;
    }

    @JsonbTransient
    public Collection<StudentMaster> getStudentMasterCollection() {
        return studentMasterCollection;
    }

    public void setStudentMasterCollection(Collection<StudentMaster> studentMasterCollection) {
        this.studentMasterCollection = studentMasterCollection;
    }

    public Course getCourceid() {
        return courceid;
    }

    public void setCourceid(Course courceid) {
        this.courceid = courceid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (subjectid != null ? subjectid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subject)) {
            return false;
        }
        Subject other = (Subject) object;
        if ((this.subjectid == null && other.subjectid != null) || (this.subjectid != null && !this.subjectid.equals(other.subjectid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Subject[ subjectid=" + subjectid + " ]";
    }

}
