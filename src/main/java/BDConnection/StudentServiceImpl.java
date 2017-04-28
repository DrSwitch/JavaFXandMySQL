package BDConnection;

import entity.StudentEntity;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import java.util.List;

/**
 * Created by DrSwitch on 13.04.2017.
 */
public class StudentServiceImpl implements StudentService{

    private EntityManager entityManager = Persistence.createEntityManagerFactory("CRUD").createEntityManager();

    public StudentEntity getByIdStudent(long idstudent) {
        return null;
    }

    public StudentEntity addStudent(StudentEntity student) {
        entityManager.getTransaction().begin();
        StudentEntity studentAddDB = entityManager.merge(student);
        entityManager.getTransaction().commit();
        return studentAddDB;
    }

    public void updateStudent(StudentEntity student) {

    }

    public void deleteStudent(long idStudent) {
        entityManager.getTransaction().begin();
        entityManager.remove(getByIdStudent(idStudent));
        entityManager.getTransaction().commit();
    }

    public List<StudentEntity> getAllStudent(){
        TypedQuery<StudentEntity> studentTypedQuery = entityManager.createNamedQuery("StudentEntity.getAll", StudentEntity.class);
        return studentTypedQuery.getResultList();
    }
}
