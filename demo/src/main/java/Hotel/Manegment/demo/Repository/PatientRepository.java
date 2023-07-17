package Hotel.Manegment.demo.Repository;

import Hotel.Manegment.demo.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {
}
