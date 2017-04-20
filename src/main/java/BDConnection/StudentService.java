package BDConnection;

import java.util.List;

/**
 * Created by DrSwitch on 20.04.2017.
 */
public interface StudentService {
    StudentEntity getByIdStudent(long idStudent);

    StudentEntity addStudent(StudentEntity student);

    void updateStudent(StudentEntity student);

    void deleteStudent(long idStudent);

    List<StudentEntity> getAllStudent();
}
