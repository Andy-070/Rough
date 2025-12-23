package backend.e_com.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import backend.e_com.entity.Students;

@Repository
public interface StudentsRepo extends JpaRepository<Students, Long> {

}