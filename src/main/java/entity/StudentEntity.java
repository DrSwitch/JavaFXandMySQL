package entity;

import javax.persistence.*;

/**
 * Created by DrSwitch on 29.04.2017.
 */
@Entity
@Table(name = "student", schema = "infostudent2")
@NamedQuery(name = "StudentEntity.getAll", query = "SELECT c from StudentEntity c")
public class StudentEntity {
    private int id;
    private String fio;
    private String address;
    private int cityId;
    private CityEntity city;

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

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentEntity that = (StudentEntity) o;

        if (id != that.id) return false;
        if (city != that.city) return false;
        if (fio != null ? !fio.equals(that.fio) : that.fio != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = fio != null ? fio.hashCode() : 0;
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + id;
        result = 31 * result + cityId;
        return result;
    }

    public StudentEntity() {
    }

    public StudentEntity(int id, String fio, String address, CityEntity city) {
        this.id = id;
        this.fio = fio;
        this.address = address;
        this.city = city;
    }


    @ManyToOne
    @JoinColumn(name = "city")
    public CityEntity getCity() {
        return city;
    }

    public void setCity(CityEntity city) {
        this.city = city;
    }


}
