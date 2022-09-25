package com.ProjetIF.Demo.Repository;

import com.ProjetIF.Demo.Modele.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseEntityRepository extends JpaRepository<Course, Integer> {
}
