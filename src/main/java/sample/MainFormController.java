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
    private TableView<Student> tvMainTableStudent;
    @FXML
    private TableColumn<Student, Integer> tcIdStudent;
    @FXML
    private TableColumn<Student, String> tcFIO;
    @FXML
    private TableColumn<Student, String> tcAddress;
    @FXML
    private TableColumn<Student, Integer> tcIdCity;

    private ObservableList<Student> userObservableList = FXCollections.observableArrayList();

    private StudentServiceImpl bdWork = new StudentServiceImpl();

    public void btnclick(ActionEvent actionEvent){

        List<StudentEntity> lsStudent = bdWork.getAllStudent();

        userObservableList = FXCollections.observableArrayList();

        for (StudentEntity student : lsStudent){
            userObservableList.add(new Student(student.getIdstudent(), student.getFio(), student.getAddress(), student.getIdcity()));
        }

        tvMainTableStudent.setItems(userObservableList);
        tvMainTableStudent.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        tcIdStudent.setCellValueFactory(new PropertyValueFactory<Student, Integer>("ID_Student"));
        tcFIO.setCellValueFactory(new PropertyValueFactory<Student, String>("FIO"));
        tcAddress.setCellValueFactory(new PropertyValueFactory<Student, String>("Address"));
        tcIdCity.setCellValueFactory(new PropertyValueFactory<Student, Integer>("IdCity"));
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