package sample;
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

import java.sql.*;
import java.util.List;

//логика взаимодействия с MainForm.fxml
public class MainFormController {
    private static final String URL = "jdbc:mysql://localhost:3306/infostudent";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123";

    @FXML
    private Label LabelHello;
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

    private ObservableList<Student> userObservableList = FXCollections.observableArrayList();;

    public void btnclick(ActionEvent actionEvent)throws ClassNotFoundException, SQLException{

        Class.forName( "com.mysql.jdbc.Driver" );
        Connection connect = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        //selectAll(connect);
        Statement statement = connect.createStatement();

        ResultSet resultSet = statement.executeQuery("select ID_Student,FIO,Address,idcity from infostudent.student");

        // устанавливаем тип и значение которое должно хранится в колонке
        IdStudentCol.setCellValueFactory(new  PropertyValueFactory<Student, Integer>("ID_Student"));
        FIOCol.setCellValueFactory(new  PropertyValueFactory<Student, String>("FIO"));
        AddressCol.setCellValueFactory(new  PropertyValueFactory<Student, String>("Address"));
        IdCityCol.setCellValueFactory(new  PropertyValueFactory<Student, Integer>("IdCity"));

        //чистим обсерваблелист перед заполнением
        userObservableList.clear();

        while( resultSet.next()) {
          // System.out.println(resultSet.getInt("ID_Student")+"  "+ resultSet.getString("FIO"));
            //заполняется обсерваблелист, что бы его потом вывести в tableview
            userObservableList.add(new Student(resultSet.getInt("ID_Student"),
                    resultSet.getString("FIO"),
                    resultSet.getString("Address"),
                    resultSet.getInt("IdCity")));
        }

        // выводим обсерваблелист в tableview
        MainTableStudent.setItems(userObservableList);

        connect.close();
      //  LabelHello.setText(LabelHello.getText()+"Hello World");
    }

}
