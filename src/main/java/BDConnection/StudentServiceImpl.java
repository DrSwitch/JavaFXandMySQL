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

    public StudentEntity getByIdStudent(int idstudent) {
        return entityManager.find(StudentEntity.class, idstudent);
    }

    public StudentEntity addStudent(StudentEntity student) {
        entityManager.getTransaction().begin();
        StudentEntity studentAddDB = entityManager.merge(student);
        entityManager.getTransaction().commit();
        return studentAddDB;
    }

    public void updateStudent(StudentEntity student) {
        entityManager.getTransaction().begin();
        entityManager.merge(student);
        entityManager.getTransaction().commit();
    }

    public void deleteStudent(int idStudent) {
        entityManager.getTransaction().begin();
        entityManager.remove(getByIdStudent(idStudent));
        entityManager.getTransaction().commit();
    }

    public List<StudentEntity> getAllStudent(){
        TypedQuery<StudentEntity> studentTypedQuery = entityManager.createNamedQuery("StudentEntity.getAll", StudentEntity.class);
        return studentTypedQuery.getResultList();
    }
}
