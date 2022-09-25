package com.ProjetIF.Demo.Service;

import com.ProjetIF.Demo.Modele.Student;
import com.ProjetIF.Demo.Repository.StudentEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentEntityRepository StudentRepository;

    public void saveStudent(Student student){
        StudentRepository.save(student);
    }

    public void deleteStudent(Student student){
        StudentRepository.delete(student);
    }


    public void updateStudentEmailById(String email, Integer id){
        StudentRepository.updateEmailById(email, id);
    }

    public void updateStudentLastNameByEmail(String lastName, String email){
        StudentRepository.updateLastNameByEmail(lastName,email);
    }

    public void incrementStudentAgeBy1(){
        StudentRepository.incrementAgeBy1();
    }

    public List<Student> getAllStudents(){
        return StudentRepository.findAll();
    }

    public Optional<Student> getStudentById(Integer id){
        return StudentRepository.findById(id);
    }

    public Optional<Student> getStudentByEmail(String email){
        return StudentRepository.findByEmail(email);
    }

    public Optional<Student> getStudentByFirstNameAndLastName(String firstName, String lastName){
        return StudentRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    public Optional<Student> getStudentByAge(Integer age){
        return StudentRepository.findByAge(age);
    }

    public Optional<Student> getStudentByFirstName(String firstName){
        return StudentRepository.findByFirstName(firstName);
    }

    public List<Student> getByAgeGreaterThan(Integer age){
        return StudentRepository.findByAgeGreaterThan(age);
    }

}
