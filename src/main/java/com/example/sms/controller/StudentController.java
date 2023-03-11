package com.example.sms.controller;

import com.example.sms.entity.Student;
import com.example.sms.service.StudentService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

//  Index Or Home Page
    @GetMapping("/")
    public String home(Model m){
        List<Student> student = studentService.getAllStudents();
        m.addAttribute("student",student);
        return "index";
    }

//  Add Student Page
    @GetMapping("/add")
    public String addStudentForm(){
        return "add_student";
    }

//  Logic for Adding Students
    @PostMapping("/register")
    public String studentRegister(@ModelAttribute Student s, HttpSession session){
        studentService.addStudent(s);
        session.setAttribute("msg","Student added Successfully...");
        return "redirect:/";
    }

//  Edit Page
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model m){
        Student s = studentService.getStudentById(id);
        m.addAttribute("student", s);
        return "edit";
    }

//  Logic for Updating Students
    @PostMapping("/update")
    public String updateStudent(@ModelAttribute Student s,HttpSession session){
        studentService.addStudent(s);
        session.setAttribute("msg","Student updated Successfully...");
        return "redirect:/";
    }

//  Logic for Deleting Students
    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable int id,HttpSession session){
        studentService.deleteStudentById(id);
        session.setAttribute("msg","Student deleted Successfully...");
        return "redirect:/";
    }
}
