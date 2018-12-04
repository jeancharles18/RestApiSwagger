package edu.mum.etudiant.controller;

import edu.mum.etudiant.model.Student;
import edu.mum.etudiant.repository.StudentRepository;
import edu.mum.etudiant.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@Api(value = "studentOnline")
public class StudentController {
    @Autowired
    private  StudentService studentService;

    @ApiOperation(value = "View list of student", response = Iterable.class)

    @ApiResponses(
            value={
                    @ApiResponse(code = 200, message = "Successfully retrieved list"),
                    @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
                    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
                    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
            }
    )


    @GetMapping("/all")
    public List<Student> getStudents(){

        return studentService.getAllStudents();
    }


    @ApiOperation(value = "Search a student by id", response = Student.class)
    @GetMapping("/{id}")
    public @ResponseBody Student getStudentById(@PathVariable Integer id){

        return studentService.getStudentById(id);
    }

    @ApiOperation(value = "Add a new student ", response = Student.class)

    @PostMapping("/student")
    public Student addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    @ApiOperation(value = "delete a student by id", response = Student.class)


    @DeleteMapping("/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable Integer id,  @RequestBody Student student){
        Student studentDetail= studentService.getStudentById(id);
        if (studentDetail==null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        studentService.deleteStudent(id);
        return new ResponseEntity<Student>(HttpStatus.NO_CONTENT);
    }


    @ApiOperation(value = "update a student by id", response = Student.class)

    @PutMapping("/id")
    public  ResponseEntity<Student> updateStudent(@PathVariable Integer id, @RequestBody Student student) {
        Student studentDetail= studentService.getStudentById(id);
        if (studentDetail==null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        studentDetail.setStudentNumber(student.getStudentNumber());
        studentDetail.setFirstName(student.getFirstName());
        studentDetail.setLastName(student.getLastName());
        studentDetail = studentService.addStudent(student);
        return new ResponseEntity<Student>(studentDetail, HttpStatus.OK);

    }

}



