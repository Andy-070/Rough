package backend.e_com.service;

import java.util.List;

import backend.e_com.dto.AddStudent;
import backend.e_com.dto.StudentDto;

public interface  StudentSer {
    List<StudentDto> getAllStudents();

    public StudentDto getStudentById(Long id);

    StudentDto createStu(AddStudent dto);

    void deleteStudent(Long id);

    StudentDto updateStu(Long id, AddStudent dto);

    StudentDto updateParStu(Long id, java.util.Map<String, Object> updates);
}
