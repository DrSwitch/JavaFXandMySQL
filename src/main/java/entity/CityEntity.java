package entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by DrSwitch on 20.04.2017.
 */
@Entity
@Table(name = "city", schema = "infostudent2", catalog = "")
@NamedQuery(name = "CityEntity.getAll", query = "SELECT c FROM CityEntity c")
public class CityEntity {
    private int idcity;
    private String cityname;
    private int idregion;


    public CityEntity(int idcity, String cityname) {
        this.idcity = idcity;
        this.cityname = cityname;
    }

    public CityEntity() {

    }

    @Id
    @Column(name = "idcity")
    public int getIdcity() {
        return idcity;
    }

    public void setIdcity(int idcity) {
        this.idcity = idcity;
    }

    @Basic
    @Column(name = "cityname")
    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

    @Basic
    @Column(name = "idregion")
    public int getIdregion() {
        return idregion;
    }

    public void setIdregion(int idregion) {
        this.idregion = idregion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CityEntity that = (CityEntity) o;

        if (idcity != that.idcity) return false;
        if (idregion != that.idregion) return false;
        if (cityname != null ? !cityname.equals(that.cityname) : that.cityname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idcity;
        result = 31 * result + (cityname != null ? cityname.hashCode() : 0);
        result = 31 * result + idregion;
        return result;
    }

    @Override
    public String toString() {
        return cityname;
    }

}
