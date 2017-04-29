package entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by DrSwitch on 29.04.2017.
 */
@Entity
@Table(name = "city", schema = "infostudent2")
@NamedQuery(name = "CityEntity.getAll", query = "SELECT c from CityEntity c")
public class CityEntity {
    private int id;
    private String city;
    private int region;
    private Collection<StudentEntity> students;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "region")
    public int getRegion() {
        return region;
    }

    public void setRegion(int region) {
        this.region = region;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CityEntity that = (CityEntity) o;

        if (id != that.id) return false;
        if (region != that.region) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + region;
        return result;
    }

    public CityEntity() {
    }

    public CityEntity(int id, String city) {
        this.id = id;
        this.city = city;
    }

    @Override
    public String toString() {
        return city;
    }

    @OneToMany(mappedBy = "city")
    public Collection<StudentEntity> getStudents() {
        return students;
    }

    public void setStudents(Collection<StudentEntity> students) {
        this.students = students;
    }
}
