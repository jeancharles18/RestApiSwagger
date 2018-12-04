package edu.mum.etudiant.serviceimpl;

import edu.mum.etudiant.model.Student;
import edu.mum.etudiant.repository.StudentRepository;
import edu.mum.etudiant.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;
    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return (List<Student>) studentRepository.findAll() ;
    }

    @Override
    public Student getStudentById(Integer id) {

        Optional<Student> student=studentRepository.findById(id);
        return student.orElse(null);

    }

    @Override
    public void deleteStudent(Integer id) {

        studentRepository.deleteById(id);

    }
}
