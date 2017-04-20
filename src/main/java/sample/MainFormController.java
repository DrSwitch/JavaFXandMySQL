package sample;
import BDConnection.StudentServiceImpl;
import entity.StudentEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import pojo.Student;

import java.util.List;

//логика взаимодействия с MainForm.fxml
public class MainFormController {

    @FXML
    private TextField tfID_Student;
    @FXML
    private TextField tfFIO;
    @FXML
    private TextField tfAddress;
    @FXML
    private TextField tfIdCity;
    @FXML
    private TableView<Student> MainTableStudent;
    @FXML
    private TableColumn<Student, Integer> IdStudentCol;
    @FXML
    private TableColumn<Student, String> FIOCol;
    @FXML
    private TableColumn<Student, String> AddressCol;
    @FXML
    private TableColumn<Student, Integer> IdCityCol;

    private ObservableList<Student> userObservableList = FXCollections.observableArrayList();

    private StudentServiceImpl bdWork = new StudentServiceImpl();

    public void btnclick(ActionEvent actionEvent){

        List<StudentEntity> lsStudent = bdWork.getAllStudent();

        userObservableList = FXCollections.observableArrayList();

        for (StudentEntity student : lsStudent){
            userObservableList.add(new Student(student.getIdstudent(), student.getFio(), student.getAddress(), student.getIdcity()));
        }

        MainTableStudent.setItems(userObservableList);
        MainTableStudent.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        IdStudentCol.setCellValueFactory(new PropertyValueFactory<Student, Integer>("ID_Student"));
        FIOCol.setCellValueFactory(new PropertyValueFactory<Student, String>("FIO"));
        AddressCol.setCellValueFactory(new PropertyValueFactory<Student, String>("Address"));
        IdCityCol.setCellValueFactory(new PropertyValueFactory<Student, Integer>("IdCity"));
    }

    public  void Insertbtnclick(ActionEvent actionEvent){

        if ((tfID_Student.getText().trim().length() > 0)
                && (tfFIO.getText().trim().length() > 0)
                && (tfAddress.getText().trim().length() > 0)
                && (tfIdCity.getText().trim().length() > 0)) {
            StudentEntity student = new StudentEntity();


        } else {

        }


        btnclick(null);
    }

}