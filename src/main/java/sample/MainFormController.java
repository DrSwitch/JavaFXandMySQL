package sample;
import BDConnection.StudentServiceImpl;
import BDConnection.CityServiceImpl;
import entity.CityEntity;
import entity.StudentEntity;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

//логика взаимодействия с MainForm.fxml
public class MainFormController  implements Initializable {

    @FXML
    private Label lbText;
    @FXML
    private TextField tfFIO;
    @FXML
    private TextField tfAddress;
    @FXML
    private TextField tfIdCity;
    @FXML
    private TableView<StudentEntity> tvMainTableStudent;
    @FXML
    private TableColumn<StudentEntity, Integer> tcIdStudent;
    @FXML
    private TableColumn<StudentEntity, String> tcFIO;
    @FXML
    private TableColumn<StudentEntity, String> tcAddress;
    @FXML
    private TableColumn<StudentEntity, Integer> tcIdCity;
    @FXML
    private ComboBox<CityEntity> cbCity;


    private ObservableList<StudentEntity> userObservableList = FXCollections.observableArrayList();

    private ObservableList<CityEntity> cityNamesObservableList= FXCollections.observableArrayList();

    private StudentServiceImpl studServ = new StudentServiceImpl();

    private CityServiceImpl cityServ = new CityServiceImpl();

    public MainFormController(){
       // select();
    }

    //эта хрень запускается и делает код во время загруски формы или типа того
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        select();

    }

    public void btnclick(ActionEvent actionEvent){
        select();
    }

    public void select(){
        List<StudentEntity> lsStudent = studServ.getAllStudent();
        List<CityEntity> lsCity = cityServ.getAllcity();

        //инициация листа
        userObservableList = FXCollections.observableArrayList();
        cityNamesObservableList = FXCollections.observableArrayList();

        //заполняем обсерваблелист для студента
        for (StudentEntity student : lsStudent){
            userObservableList.add(new StudentEntity(student.getIdstudent(), student.getFio(), student.getAddress(), student.getIdcity()));
        }
        //заполняем обсерваблелисты для города
        for (CityEntity city : lsCity) {
            cityNamesObservableList.add(new CityEntity(city.getIdcity(),city.getCityname()));
        }

        //заполняем кобобох из обсерваблелиста
        cbCity.setItems(cityNamesObservableList);
        //Заполняем таблевью из обсерваблелиста
        tvMainTableStudent.setItems(userObservableList);

        tvMainTableStudent.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        // хз что это но без него не работает
        tcIdStudent.setCellValueFactory(new PropertyValueFactory<StudentEntity, Integer>("idstudent"));
        tcFIO.setCellValueFactory(new PropertyValueFactory<StudentEntity, String>("fio"));
        tcAddress.setCellValueFactory(new PropertyValueFactory<StudentEntity, String>("Address"));
        tcIdCity.setCellValueFactory(new PropertyValueFactory<StudentEntity, Integer>("idcity"));
    }



    public  void Insertbtnclick(ActionEvent actionEvent){

        StudentEntity student = new StudentEntity();

        student.setFio(tfFIO.getText());
        student.setAddress(tfAddress.getText());
        student.setIdcity(cbCity.getSelectionModel().getSelectedItem().getIdcity());

        studServ.addStudent(student);

  //      lbText.setText("name City = " + cbCity.getSelectionModel().getSelectedItem().getCityname()
     //           +"\nid City = " + cbCity.getSelectionModel().getSelectedItem().getIdcity());

        System.out.println(student);

        select();
    }

    public  void  Deletebtnclick(ActionEvent actionEvent){

       // lbText.setText("ID = "+tvMainTableStudent.getSelectionModel().getSelectedItem().getID_Student());

        studServ.deleteStudent(tvMainTableStudent.getSelectionModel().getSelectedItem().getIdstudent());

        select();
        tvMainTableStudent.refresh();
    }
}