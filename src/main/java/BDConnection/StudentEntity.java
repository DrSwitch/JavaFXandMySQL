package BDConnection;

import javax.persistence.*;

/**
 * Created by DrSwitch on 20.04.2017.
 */
@Entity
@Table(name = "student", schema = "infostudent", catalog = "")
@NamedQuery(name = "StudentEntity.getAll", query = "SELECT c FROM StudentEntity  c")
public class StudentEntity {
    private int idStudent;
    private String fio;
    private String address;
    private  int IdCity;

    @Id
    @Column(name = "ID_Student")
    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    @Basic
    @Column(name = "FIO")
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
    @Column(name = "IdCity")
    public int getIdCity() {
        return IdCity;
    }

    public void setIdCity(int IdCity) {
        this.IdCity = IdCity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentEntity that = (StudentEntity) o;

        if (idStudent != that.idStudent) return false;
        if (fio != null ? !fio.equals(that.fio) : that.fio != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idStudent;
        result = 31 * result + (fio != null ? fio.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }
}
