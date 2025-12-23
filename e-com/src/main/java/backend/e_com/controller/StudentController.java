package backend.e_com.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import backend.e_com.dto.AddStudent;
import backend.e_com.dto.StudentDto;
import backend.e_com.service.StudentSer;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;



@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {

    // private final StudentRepo studentRepo;

    private final StudentSer studentSer;

    @GetMapping
    public ResponseEntity<List<StudentDto>> getStudent() {
        return ResponseEntity.ok(studentSer.getAllStudents());
    }

    @GetMapping("/{id}")
    public StudentDto getStudentById(@PathVariable Long id) {
        return studentSer.getStudentById(id);    
    }

    @PostMapping("/add")
    public ResponseEntity<StudentDto> addStudent(@RequestBody @Valid AddStudent dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(studentSer.createStu(dto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentSer.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable Long id, @RequestBody AddStudent dto) {
        // Implementation for updating a student would go here
        return ResponseEntity.ok(studentSer.updateStu(id,dto));
    }
    
    @PatchMapping("/partial-update/{id}")
    public ResponseEntity<StudentDto> partialUpdateStudent(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
        // Implementation for partially updating a student would go here
        return ResponseEntity.ok(studentSer.updateParStu(id,updates));
    }
}
