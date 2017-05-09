package dbconnection.impl;

import dao.impl.StudentDAOServiceImpl;
import dbconnection.intface.StudentService;
import entity.StudentEntity;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import java.util.List;

/**
 * Created by DrSwitch on 13.04.2017.
 */
public class StudentServiceImpl implements StudentService {

    private EntityManager entityManager = Persistence.createEntityManagerFactory("CRUD").createEntityManager();
    private StudentDAOServiceImpl studentDAOService = new StudentDAOServiceImpl();

    public StudentEntity getByIdStudent(int idstudent) {
        return this.entityManager.find(StudentEntity.class, idstudent);
    }

    public StudentEntity addStudent(StudentEntity student) {

     /*   this.entityManager.getTransaction().begin();
        this.entityManager.clear();
        this.entityManager.merge(student);
        this.entityManager.getTransaction().commit();*/
        studentDAOService.add(student);
        return student;
    }

    public void updateStudent(StudentEntity student) {
       /* this.entityManager.getTransaction().begin();
        this.entityManager.clear();
        this.entityManager.merge(student);
        this.entityManager.getTransaction().commit();*/
       studentDAOService.update(student);
    }

    public void deleteStudent(int idStudent) {
      /*  this.entityManager.getTransaction().begin();
        this.entityManager.clear();
        this.entityManager.remove(getByIdStudent(idStudent));
        this.entityManager.getTransaction().commit();*/
      studentDAOService.delete(idStudent);

    }

    public List<StudentEntity> getAllStudent(){
     //   TypedQuery<StudentEntity> studentTypedQuery = entityManager.createNamedQuery("StudentEntity.getAll", StudentEntity.class);
        return studentDAOService.getAll();
    }
}
