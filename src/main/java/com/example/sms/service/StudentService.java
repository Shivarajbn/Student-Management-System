package com.example.sms.service;

import com.example.sms.entity.Student;
import com.example.sms.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public void addStudent(Student s){
        studentRepository.save(s);
    }

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public Student getStudentById(int id){
        Optional<Student> s =studentRepository.findById(id);
        if(s.isPresent())
            return s.get();
        return null;
    }

    public void deleteStudentById(int id){
        studentRepository.deleteById(id);
    }
}
