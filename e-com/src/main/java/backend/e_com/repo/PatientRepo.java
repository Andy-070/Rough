package backend.e_com.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import backend.e_com.entity.Patient;

public interface PatientRepo extends JpaRepository<Patient, Long>  {

}
