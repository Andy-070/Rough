package backend.e_com.service.imp;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import backend.e_com.dto.AddStudent;
import backend.e_com.dto.StudentDto;
import backend.e_com.entity.Students;
import backend.e_com.repo.StudentsRepo;
import backend.e_com.service.StudentSer;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentSerImp implements StudentSer {

    private final StudentsRepo studentsRepo;
    private final ModelMapper modelMapper;

    @Override
    public List<StudentDto> getAllStudents() {

        List<Students> students = studentsRepo.findAll();

        List<StudentDto> studentDtos = students.stream()
                // .map(student -> new StudentDto(student.getId(),student.getName(), student.getEmail()))
                .map(student -> modelMapper.map(student, StudentDto.class))
                .toList();

        return studentDtos;
    }

    @Override
    public StudentDto getStudentById(Long id) {
        Students student = studentsRepo.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));

        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public StudentDto createStu(AddStudent dto) {
        Students student = modelMapper.map(dto, Students.class);
        Students savedStudent = studentsRepo.save(student);
        return modelMapper.map(savedStudent, StudentDto.class);
    }

    @Override
    public void deleteStudent(Long id) {
        if(!studentsRepo.existsById(id)) {
            throw new RuntimeException("Student not found");
        }
        studentsRepo.deleteById(id);
    }

    @Override
    public StudentDto updateStu(Long id, AddStudent dto) {
        Students existingStudent = studentsRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        
        modelMapper.map(dto, existingStudent);
        return modelMapper.map(studentsRepo.save(existingStudent), StudentDto.class);
    }

    @Override
    public StudentDto updateParStu(Long id, java.util.Map<String, Object> updates) {
        Students existingStudent = studentsRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        
        updates.forEach((key, value) -> {
            switch (key) {
                case "name":
                    existingStudent.setName((String) value);
                    break;
                case "email":
                    existingStudent.setEmail((String) value);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid field: " + key);
            }
        });

        Students updatedStudent = studentsRepo.save(existingStudent);
        return modelMapper.map(updatedStudent, StudentDto.class);
    }

}
