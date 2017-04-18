package pojo;

/**
 * Created by DrSwitch on 18.04.2017.
 */
public class Student {
    private int id;
    private String FIO;
    private String address;
    private int idCity;

    public Student(int id, String FIO, String address, int idCity) {
        this.id = id;
        this.FIO = FIO;
        this.address = address;
        this.idCity = idCity;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public String getaddress() {
        return address;
    }

    public void setaddress(String address) {
        this.address = address;
    }

    public int getidCity() {
        return idCity;
    }

    public void setidCity(int idCity) {
        this.idCity = idCity;
    }
}
