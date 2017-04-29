package entity;

import javax.persistence.*;

/**
 * Created by DrSwitch on 29.04.2017.
 */
@Entity
@Table(name = "country", schema = "infostudent2", catalog = "")
public class CountryEntity {
    private int idcountry;
    private String countryname;

    @Id
    @Column(name = "idcountry")
    public int getIdcountry() {
        return idcountry;
    }

    public void setIdcountry(int idcountry) {
        this.idcountry = idcountry;
    }

    @Basic
    @Column(name = "countryname")
    public String getCountryname() {
        return countryname;
    }

    public void setCountryname(String countryname) {
        this.countryname = countryname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CountryEntity that = (CountryEntity) o;

        if (idcountry != that.idcountry) return false;
        if (countryname != null ? !countryname.equals(that.countryname) : that.countryname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idcountry;
        result = 31 * result + (countryname != null ? countryname.hashCode() : 0);
        return result;
    }
}
