package edu.mum.etudiant.model;


import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(value = "A id generate automatic by Student")
    private int id ;

    @ApiModelProperty(value = "A student Number for Student")
    @Column(name = "studentNumber")
    private Integer studentNumber;

    @ApiModelProperty(value = "first Name for Student")
    @Column(name = "firstName")
    private String firstName;
    @ApiModelProperty(value = "A last name for Student")
    @Column(name = "lastName")
    private String lastName;

    public Student() {

    }

    public Student(Integer studentNumber, String firstName, String lastName) {
        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName=firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
