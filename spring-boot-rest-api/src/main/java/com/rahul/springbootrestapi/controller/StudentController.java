package com.rahul.springbootrestapi.controller;

import com.rahul.springbootrestapi.bean.Student;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {

    @GetMapping("student")
    public ResponseEntity<Student> getStudent(){
        Student student = new Student(
                1, "Rahul", "Raj"
        );
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @GetMapping("students")
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Rahul", "Raj"));
        students.add(new Student(2, "Lionel", "Messi"));
        students.add(new Student(3, "Cristiano", "Ronaldo"));
        return ResponseEntity.ok(students);
    }

    @GetMapping("student/{id}/{first-name}/{last-name}")
    public Student getStudentPathVariable(@PathVariable int id,
                                          @PathVariable("first-name") String firstName,
                                          @PathVariable("last-name") String lastName){
        return new Student(id, "Rahul", "Raj");
    }

    //http://localhost:8080/students/query?id=8&firstName="Rahul"&lastName="Raj"
    @GetMapping("students/query")
    public Student studentQueryParameter(@RequestParam int id,
                                         @RequestParam String firstName,
                                         @RequestParam String lastName){
        return new Student(id, "Rahul", "Raj");
    }

    @PostMapping("students/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }

    @PutMapping("students/{id}/update")
    public Student updateStudent(@RequestBody Student student, @PathVariable int id){
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }

    @DeleteMapping("students/{id}/delete")
    public String deleteStudent(@PathVariable int id){
        return "Deleted";
    }
}
