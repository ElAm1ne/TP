package com.ProjetIF.Demo.Controller;


import com.ProjetIF.Demo.Modele.Student;
import com.ProjetIF.Demo.Service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("students")
@AllArgsConstructor
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/addStudent")
    public String addStudent(@RequestBody Student student){
        studentService.saveStudent(student);
        return "Saved user Successfully";
    }

    @DeleteMapping("/deleteStudent")
    public String deleteStudent(@RequestBody Student student){
        studentService.deleteStudent(student);
        return "Student with id : " + student.getId().toString() + " has been deleted successfully";
    }

    @PutMapping("/updateStudentEmailById")
    public String updateStudentEmailById(@RequestParam Map<String,String> rqParam){
        studentService.updateStudentEmailById(rqParam.get("email"), Integer.valueOf(rqParam.get("id")));
        return "Successfully updated student with id : " + rqParam.get("id").toString();
    }

    @PutMapping("/updateStudentLnByEmail")
    public String updateStudentLnByEmail(@RequestParam Map<String,String> rqParam){
        studentService.updateStudentLastNameByEmail(rqParam.get("lastName"), rqParam.get("email"));
        return "Successfully updated student with email : " + rqParam.get("email");
    }

    @PutMapping("/incrementAllStudentsAgeBy1")
    public String incrementStudentAge1(){
        studentService.incrementStudentAgeBy1();
        return "Successfully incremented students age by 1";
    }

    @GetMapping("")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }
    @GetMapping("/getStudentById/{id}")
    public Optional<Student> getStudentById(@PathVariable Integer id){
        return studentService.getStudentById(id);
    }

    @GetMapping("/getStudentByAge/{age}")
    public Optional<Student> getStudentByAge(@PathVariable Integer age){
        return studentService.getStudentByAge(age);
    }

    @GetMapping("/getStudentByEmail/{email}")
    public Optional<Student> getStudentByEmail(@PathVariable String email){
        return studentService.getStudentByEmail(email);
    }

    @GetMapping("/getStudentByFnAndLn")
    public Optional<Student> getStudentByFirstNameAndLastName(@RequestParam Map<String,String> rqParam){
        return studentService.getStudentByFirstNameAndLastName(rqParam.get("firstName"),rqParam.get("lastName"));
    }

    @GetMapping("/getStudentByFirstName/{firstName}")
    public Optional<Student> getStudentByFirstName(@PathVariable String firstName){
        return studentService.getStudentByFirstName(firstName);
    }

    @GetMapping("/getStudentAgeGreaterThanAge/{age}")
    public List<Student> getStudentAgeGreaterThan(@PathVariable Integer age){
        return studentService.getByAgeGreaterThan(age);
    }
}
