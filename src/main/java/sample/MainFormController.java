package sample;
import BDConnection.StudentServiceImpl;
import BDConnection.CityServiceImpl;
import entity.CityEntity;
import entity.CountryEntity;
import entity.StudentEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import pojo.City;
import pojo.Student;

import java.util.List;

//логика взаимодействия с MainForm.fxml
public class MainFormController {

    @FXML
    private TextField tfFIO;
    @FXML
    private TextField tfAddress;
    @FXML
    private TextField tfIdCity;
    @FXML
    private TableView<Student> tvMainTableStudent;
    @FXML
    private TableColumn<Student, Integer> tcIdStudent;
    @FXML
    private TableColumn<Student, String> tcFIO;
    @FXML
    private TableColumn<Student, String> tcAddress;
    @FXML
    private TableColumn<Student, Integer> tcIdCity;
    @FXML
    private ComboBox<String> cbCity;


    private ObservableList<Student> userObservableList = FXCollections.observableArrayList();

    private ObservableList<String> cityNamesObservableList;
    private ObservableList<Integer> cityIdObservableList;

    private StudentServiceImpl studServ = new StudentServiceImpl();

    private CityServiceImpl cityServ = new CityServiceImpl();

    public MainFormController(){
       // select();
    }

    public void btnclick(ActionEvent actionEvent){
        select();
    }

    public  void Insertbtnclick(ActionEvent actionEvent){

        if ((tfFIO.getText().trim().length() > 0)
                && (tfAddress.getText().trim().length() > 0)) {
            StudentEntity student = new StudentEntity();
            student.setFio(tfFIO.getText());
            student.setAddress(tfAddress.getText());
            student.setIdcity(Integer.parseInt(tfIdCity.getText()));

            studServ.addStudent(student);
        } else {

        }

        btnclick(null);
    }


    public void select(){
        List<StudentEntity> lsStudent = studServ.getAllStudent();

        List<CityEntity> lsCity = cityServ.getAllcity();

        //инициация листа
        userObservableList = FXCollections.observableArrayList();
        cityNamesObservableList = FXCollections.observableArrayList();

        //заполняем обсерваблелист для студента
        for (StudentEntity student : lsStudent){
            userObservableList.add(new Student(student.getIdstudent(), student.getFio(), student.getAddress(), student.getIdcity()));
        }
        //заполняем обсерваблелисты для города
        for (CityEntity city : lsCity){
            cityNamesObservableList.add(city.getCityname());
        }
        //заполняем обсерваблелисты для города
        for (CityEntity city : lsCity){
            cityIdObservableList.add(city.getIdcity());
        }
        //заполняем элементы на форме из обсерваблелистов
        cbCity.getItems().addAll(cityNamesObservableList);

        tvMainTableStudent.setItems(userObservableList);
        tvMainTableStudent.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);


        tcIdStudent.setCellValueFactory(new PropertyValueFactory<Student, Integer>("ID_Student"));
        tcFIO.setCellValueFactory(new PropertyValueFactory<Student, String>("FIO"));
        tcAddress.setCellValueFactory(new PropertyValueFactory<Student, String>("Address"));
        tcIdCity.setCellValueFactory(new PropertyValueFactory<Student, Integer>("IdCity"));

    }

}