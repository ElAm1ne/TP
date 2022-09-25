package com.ProjetIF.Demo.Repository;

import com.ProjetIF.Demo.Modele.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface StudentEntityRepository extends JpaRepository<Student, Integer> {

    @Query("SELECT s FROM Student s")
    List<Student> findAll();
    Optional<Student> findById(Integer id);
    Optional<Student> findByFirstNameAndLastName(String firstName, String lastName);
    Optional<Student> findByEmail(String email);
    Optional<Student> findByAge(Integer age);
    Optional<Student> findByFirstName(String firstName);
    List<Student> findByAgeGreaterThan(Integer age);
    @Modifying()
    @Transactional
    @Query("update Student s set s.email = ?1 where s.id = ?2")
    public void updateEmailById(String email, Integer id);
    @Modifying()
    @Transactional
    @Query("update Student s set s.lastName = ?1 where s.email = ?2")
    public void updateLastNameByEmail(String lastName, String email);
    @Modifying()
    @Transactional
    @Query("update Student s set s.age = s.age + 1")
    public void incrementAgeBy1();
}
