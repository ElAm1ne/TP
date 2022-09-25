package com.ProjetIF.Demo.Service;


import com.ProjetIF.Demo.Modele.Course;
import com.ProjetIF.Demo.Repository.CourseEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseEntityRepository CourseRepository;

    public void saveCourse(Course course){
        CourseRepository.save(course);
    }

    public void deleteCourse(Course course){
        CourseRepository.delete(course);
    }

    public List<Course> getAllCourses(){
       return CourseRepository.findAll();
    }

    public Optional<Course> getCoursesById(Integer id){
        return CourseRepository.findById(id);
    }

    public Optional<Course> getCoursesByCode(String code){
         return CourseRepository.findByCode(code);
    }

    public Optional<Course> getCoursesByName(String name){
        return CourseRepository.findByName(name);
    }



}
