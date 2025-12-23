package backend.e_com.service.imp;

import org.springframework.stereotype.Service;

import backend.e_com.entity.Patient;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PatientSer {
    private final backend.e_com.repo.PatientRepo patientRepo;

    @Transactional
    public Patient getPatient(Long id) {
        return patientRepo.findById(id).orElseThrow(() -> new RuntimeException("Patient not found"));
    }

}
