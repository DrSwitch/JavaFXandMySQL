package entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by DrSwitch on 20.04.2017.
 */
@Entity
@Table(name = "region", schema = "infostudent2", catalog = "")
public class RegionEntity {
    private int idregion;
    private String regionname;
    private int idcountry;

    @Id
    @Column(name = "idregion")
    public int getIdregion() {
        return idregion;
    }

    public void setIdregion(int idregion) {
        this.idregion = idregion;
    }

    @Basic
    @Column(name = "regionname")
    public String getRegionname() {
        return regionname;
    }

    public void setRegionname(String regionname) {
        this.regionname = regionname;
    }

    @Basic
    @Column(name = "idcountry")
    public int getIdcountry() {
        return idcountry;
    }

    public void setIdcountry(int idcountry) {
        this.idcountry = idcountry;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RegionEntity that = (RegionEntity) o;

        if (idregion != that.idregion) return false;
        if (idcountry != that.idcountry) return false;
        if (regionname != null ? !regionname.equals(that.regionname) : that.regionname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idregion;
        result = 31 * result + (regionname != null ? regionname.hashCode() : 0);
        result = 31 * result + idcountry;
        return result;
    }

}
