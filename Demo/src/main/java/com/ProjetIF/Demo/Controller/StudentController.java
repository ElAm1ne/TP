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

    @PostMapping("/addStudent") //../students/addStudent -> POST request + put Student object in Body
    public String addStudent(@RequestBody Student student){
        studentService.saveStudent(student);
        return "Saved student with id : "+ student.getId().toString() +" Successfully";
    }

    @DeleteMapping("/deleteStudent") //../students/deleteStudent -> DELETE request + put Student object in Body
    public String deleteStudent(@RequestBody Student student){
        studentService.deleteStudent(student);
        return "Student with id : " + student.getId().toString() + " has been deleted successfully";
    }

    @PutMapping("/updateStudentEmailById") //../students/updateStudentEmailById?email=[email]&id=[id] -> PUT request + put email and id without brackets
    public String updateStudentEmailById(@RequestParam Map<String,String> rqParam){
        studentService.updateStudentEmailById(rqParam.get("email"), Integer.valueOf(rqParam.get("id")));
        return "Successfully updated student with id : " + rqParam.get("id").toString();
    }

    @PutMapping("/updateStudentLnByEmail") //../students/updateStudentLnByEmail?lastName=[lastName]&email=[email] -> PUT request + put lastName and email without brackets
    public String updateStudentLnByEmail(@RequestParam Map<String,String> rqParam){
        studentService.updateStudentLastNameByEmail(rqParam.get("lastName"), rqParam.get("email"));
        return "Successfully updated student with email : " + rqParam.get("email");
    }

    @PutMapping("/incrementAllStudentsAgeBy1") //../students/incrementAllStudentsAgeBy1 -> PUT request
    public String incrementStudentAge1(){
        studentService.incrementStudentAgeBy1();
        return "Successfully incremented students age by 1";
    }

    @GetMapping("") //../students -> GET request
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }
    @GetMapping("/getStudentById/{id}") //../students/getStudentById/[id] -> GET request + put id without brackets
    public Optional<Student> getStudentById(@PathVariable Integer id){
        return studentService.getStudentById(id);
    }

    @GetMapping("/getStudentByAge/{age}") //../students/getStudentByAge/[age] -> GET request + put age without brackets
    public Optional<Student> getStudentByAge(@PathVariable Integer age){
        return studentService.getStudentByAge(age);
    }

    @GetMapping("/getStudentByEmail/{email}") //../students/getStudentByEmail/[email] -> GET request + put email without brackets
    public Optional<Student> getStudentByEmail(@PathVariable String email){
        return studentService.getStudentByEmail(email);
    }

    @GetMapping("/getStudentByFnAndLn") //../students/getStudentByFnAndLn?firstName=[firstName]&lastName=[lastName] -> GET request + put firstName and lastName without brackets
    public Optional<Student> getStudentByFirstNameAndLastName(@RequestParam Map<String,String> rqParam){
        return studentService.getStudentByFirstNameAndLastName(rqParam.get("firstName"),rqParam.get("lastName"));
    }

    @GetMapping("/getStudentByFirstName/{firstName}") //../students/getStudentByFirstName/[firstName] -> GET request + put firstName without brackets
    public Optional<Student> getStudentByFirstName(@PathVariable String firstName){
        return studentService.getStudentByFirstName(firstName);
    }

    @GetMapping("/getStudentAgeGreaterThanAge/{age}") //../students/getStudentAgeGreaterThanAge/[age] -> GET request + put age without brackets
    public List<Student> getStudentAgeGreaterThan(@PathVariable Integer age){
        return studentService.getByAgeGreaterThan(age);
    }
}
