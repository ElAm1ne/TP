package com.ProjetIF.Demo.Repository;

import com.ProjetIF.Demo.Modele.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CourseEntityRepository extends JpaRepository<Course, Integer> {
    @Query("SELECT c FROM Course c")
    List<Course> findAll();

    Optional<Course> findById(Integer id);

    Optional<Course> findByCode(String code);

    Optional<Course> findByName(String name);


}
