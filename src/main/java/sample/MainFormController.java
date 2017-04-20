package sample;
import BDConnection.BDWork;
import BDConnection.StudentEntity;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import pojo.Student;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.sql.*;
import java.util.List;

//логика взаимодействия с MainForm.fxml
public class MainFormController {

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

    private BDWork bdWork = new BDWork();

    public void btnclick(ActionEvent actionEvent){

        List<StudentEntity> lsStudent = bdWork.getAllStudent();

        userObservableList = FXCollections.observableArrayList();

        for (StudentEntity student : lsStudent){
            userObservableList.add(new Student(student.getIdStudent(), student.getFio(), student.getAddress(), student.getIdCity()));
        }

        MainTableStudent.setItems(userObservableList);
        MainTableStudent.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        IdStudentCol.setCellValueFactory(new PropertyValueFactory<Student, Integer>("ID_Student"));
        FIOCol.setCellValueFactory(new PropertyValueFactory<Student, String>("FIO"));
        AddressCol.setCellValueFactory(new PropertyValueFactory<Student, String>("Address"));
        IdCityCol.setCellValueFactory(new PropertyValueFactory<Student, Integer>("IdCity"));
    }

}