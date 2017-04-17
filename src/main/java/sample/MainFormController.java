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

import java.sql.*;

//логика взаимодействия с MainForm.fxml
public class MainFormController {
    private static final String URL = "jdbc:mysql://localhost:3306/infostudent";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123";

    @FXML
    private Label LabelHello;
    @FXML
    private TableView MainTableStudent;
    @FXML
    private TableColumn IdStudent;
    @FXML
    private TableColumn FIO;
    @FXML
    private TableColumn IdCity;
    @FXML
    private TableColumn Address;

    private ObservableList userObservableList;

    public void btnclick(ActionEvent actionEvent)throws ClassNotFoundException, SQLException{


        Class.forName( "com.mysql.jdbc.Driver" );
        Connection connect = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        //selectAll(connect);
        Statement statement = connect.createStatement();

        ResultSet resultSet = statement.executeQuery("select ID_Student,FIO from infostudent.student");

        while( resultSet.next()) {
            String ID_Student = resultSet.getString("ID_Student");
            String FIO = resultSet.getString("FIO");


            System.out.println( "ID_Student: | FIO:" );
            System.out.println( ID_Student +" | "+ FIO );
        }

        connect.close();

        LabelHello.setText(LabelHello.getText()+"Hello World");
    }

    private static void selectAll( java.sql.Connection conn ) throws SQLException {


    }
}
