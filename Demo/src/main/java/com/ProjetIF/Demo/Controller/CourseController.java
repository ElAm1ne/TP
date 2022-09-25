package com.ProjetIF.Demo.Controller;


import com.ProjetIF.Demo.Modele.Course;
import com.ProjetIF.Demo.Service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("Courses")
@AllArgsConstructor
public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping("/addCourse")
    public String addCourse(@RequestBody Course course){
        courseService.saveCourse(course);
        return "Saved Course successfully";
    }

    @DeleteMapping("/deleteCourse")
    public String deleteCourse(@RequestBody Course course){
        courseService.deleteCourse(course);
        return "Course with id : " + course.getId().toString() + " has been deleted successfully";
    }

    @GetMapping("")
    public List<Course> getAllCourse(){
        return courseService.getAllCourses();
    }

    @GetMapping("/getCourseById/{id}")
    public Optional<Course> getCourseById(@PathVariable Integer id){
        return courseService.getCoursesById(id);
    }

    @GetMapping("/getCourseByCode/{code}")
    public Optional<Course> getCourseByCode(@PathVariable String code){
        return courseService.getCoursesByCode(code);
    }

    @GetMapping("/getCourseByName/{name}")
    public Optional<Course> getCourseByName(@PathVariable String name){
        return courseService.getCoursesByName(name);
    }



}
