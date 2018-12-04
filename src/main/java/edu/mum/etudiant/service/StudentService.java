package edu.mum.etudiant.service;

import edu.mum.etudiant.model.Student;

import java.util.List;

public interface StudentService {

    public Student addStudent(Student student);

    public List<Student> getAllStudents();

    public Student getStudentById(Integer id);

    public void deleteStudent(Integer id);
}
