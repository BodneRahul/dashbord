package Hotel.Manegment.demo.Service;

import Hotel.Manegment.demo.Paylod.AppointmentDto;

import java.util.List;

public interface AppointmentService {

     public AppointmentDto createAppointment( long PatientId , AppointmentDto appointmentDto);

      List<AppointmentDto> findByIdAll(long patientId);

    AppointmentDto updateAppointment(long patientId, long id, AppointmentDto appointmentDto);

    AppointmentDto GetById(long patientId, long id);

    void DeleteById(long patientId, long id);


}
