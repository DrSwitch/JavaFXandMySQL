package pojo;

/**
 * Created by DrSwitch on 22.04.2017.
 */
public class City {
    private int idcity;
    private String cityname;
    private int idregion;

    public City(int idcity, String cityname, int idregion) {
        this.idcity = idcity;
        this.cityname = cityname;
        this.idregion = idregion;
    }

    public int getidcity() {
        return idcity;
    }

    public void setidcity(int idcity) {
        this.idcity = idcity;
    }

    public String getcityname() {
        return cityname;
    }

    public void setcityname(String FIO) {
        this.cityname = cityname;
    }

    public int getidregion() {
        return idregion;
    }

    public void setidregion(int idregion) {
        this.idregion = idregion;
    }

}
