package co.edu.unicauca.submission.microservice.repository;

import co.edu.unicauca.submission.microservice.model.FormatA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormatARepository extends JpaRepository<FormatA, Long> {
}
