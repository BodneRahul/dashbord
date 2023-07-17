package Hotel.Manegment.demo.Service.impl;

import Hotel.Manegment.demo.Entity.Appointment;
import Hotel.Manegment.demo.Entity.Patient;
import Hotel.Manegment.demo.Exception.ResourceNotFoundException;
import Hotel.Manegment.demo.Paylod.AppointmentDto;
import Hotel.Manegment.demo.Repository.AppointmentRepository;
import Hotel.Manegment.demo.Repository.PatientRepository;
import Hotel.Manegment.demo.Service.AppointmentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppointmentServiceImpl implements AppointmentService {
     @Autowired
     private PatientRepository patientRepository;
     
     @Autowired
     private AppointmentRepository appointmentRepository;
     @Autowired
     private ModelMapper modelMapper;



    @Override
    public AppointmentDto createAppointment(long PatientId, AppointmentDto appointmentDto) {

        Patient patients = patientRepository.findById(PatientId).orElseThrow(
                () -> new ResourceNotFoundException("ABC", "ASD", PatientId)
       );
        Appointment appointments = mapToEntity(appointmentDto);
        appointments.setPatient(patients);
        Appointment save = appointmentRepository.save(appointments);
        AppointmentDto dto = mapToDto(save);

        return dto;
    }

    @Override
    public List<AppointmentDto> findByIdAll(long patientId) {
        List<Appointment> byPatientId = appointmentRepository.findByPatientId(patientId);
        List<AppointmentDto> dto = byPatientId.stream().map(S -> mapToDto(S)).collect(Collectors.toList());
        return dto;
    }

    @Override
    public AppointmentDto updateAppointment(long patientId, long id, AppointmentDto appointmentDto) {
         patientRepository.findById(patientId).orElseThrow(
                () -> new ResourceNotFoundException("Patinet", "patientId", patientId)
        );
        Appointment appointmentss = appointmentRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Appointment", "Appointment", id)
        );
        appointmentss.setPatientName(appointmentDto.getPatientName());
        appointmentss.setDoctorName(appointmentDto.getDoctorName());
        appointmentss.setDateTime(appointmentDto.getDateTime());
        appointmentss.setStatus(appointmentDto.getStatus());

        Appointment save = appointmentRepository.save(appointmentss);
        AppointmentDto appointmentDto1 = mapToDto(save);
        return appointmentDto1;
    }

    @Override
    public AppointmentDto GetById(long patientId, long id) {
        Patient patient = patientRepository.findById(patientId).orElseThrow(
                () -> new ResourceNotFoundException("Patient", "patientId", patientId)
        );
        Appointment appointment = appointmentRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Appointment ", "AppointmentId", id)
        );
        AppointmentDto dto = mapToDto(appointment);

        return dto;
    }

    @Override
    public void DeleteById(long patientId, long id) {
        Patient patient = patientRepository.findById(patientId).orElseThrow(
                () -> new ResourceNotFoundException("Patient", "PatientId", patientId)
        );
        Appointment appointment = appointmentRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Appointment", "AppointmentId", id)
        );

            appointmentRepository.delete(appointment);
    }



    private AppointmentDto mapToDto(Appointment appointment){
        AppointmentDto appointmentDto1 = modelMapper.map(appointment, AppointmentDto.class);
//        AppointmentDto appointmentDto = new AppointmentDto();
//        appointmentDto.setId(appointment.getId());
//        appointmentDto.setStatus(appointment.getStatus());
//        appointmentDto.setDateTime(appointment.getDateTime());
//        appointmentDto.setDoctorName(appointment.getDoctorName());
//        appointmentDto.setPatientName(appointment.getPatientName());
        return appointmentDto1;
    }
      private Appointment mapToEntity(AppointmentDto appointmentDto){
          Appointment appointment1 = modelMapper.map(appointmentDto, Appointment.class);
//          Appointment appointment=new Appointment();
//         appointment.setDateTime(appointmentDto.getDateTime());
//         appointment.setStatus(appointmentDto.getStatus());
//         appointment.setDoctorName(appointmentDto.getDoctorName());
//         appointment.setId(appointmentDto.getId());
//         appointment.setPatientName(appointmentDto.getPatientName());
         return appointment1;
           }
}
