package Hotel.Manegment.demo.Repository;

import Hotel.Manegment.demo.Entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AppointmentRepository extends JpaRepository<Appointment,Long> {

    List<Appointment> findByPatientId(long PatientId);

    Appointment findBydateTime(String dateTime);





}
