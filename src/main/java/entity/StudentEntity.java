package entity;

import javax.persistence.*;

/**
 * Created by DrSwitch on 20.04.2017.
 */
@Entity
@Table(name = "student", schema = "infostudent2", catalog = "")
@NamedQuery(name = "StudentEntity.getAll", query = "SELECT c FROM StudentEntity  c")
public class StudentEntity {
    private int idstudent;
    private String fio;
    private String address;
    private int idcity;

    @Id
    @Column(name = "idstudent")
    public int getIdstudent() {
        return idstudent;
    }

    public void setIdstudent(int idstudent) {
        this.idstudent = idstudent;
    }

    @Basic
    @Column(name = "fio")
    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "idcity")
    public int getIdcity() {
        return idcity;
    }

    public void setIdcity(int idcity) {
        this.idcity = idcity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentEntity that = (StudentEntity) o;

        if (idstudent != that.idstudent) return false;
        if (idcity != that.idcity) return false;
        if (fio != null ? !fio.equals(that.fio) : that.fio != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idstudent;
        result = 31 * result + (fio != null ? fio.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + idcity;
        return result;
    }

    public StudentEntity() {
    }

    public StudentEntity(int idstudent, String fio, String address, int idcity) {
        this.idstudent = idstudent;
        this.fio = fio;
        this.address = address;
        this.idcity = idcity;
    }

}
