package pojo;

/**
 * Created by DrSwitch on 18.04.2017.
 */
public class Student {
    private int ID_Student;
    private String FIO;
    private String Address;
    private int IdCity;

    public Student(int ID_Student, String FIO, String Address, int IdCity) {
        this.ID_Student = ID_Student;
        this.FIO = FIO;
        this.Address = Address;
        this.IdCity = IdCity;
    }

    public Student() {
    }

    public int getID_Student() {
        return ID_Student;
    }

    public void setID_Student(int ID_Student) {
        this.ID_Student = ID_Student;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public int getIdCity() {
        return IdCity;
    }

    public void setIdCity(int IdCity) {
        this.IdCity = IdCity;
    }
}
