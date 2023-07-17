package Hotel.Manegment.demo.Service.impl;

import Hotel.Manegment.demo.Entity.Patient;
import Hotel.Manegment.demo.Exception.ResourceNotFoundException;
import Hotel.Manegment.demo.Paylod.PatientDto;
import Hotel.Manegment.demo.Repository.PatientRepository;
import Hotel.Manegment.demo.Service.PatientService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.stream.Collectors;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
     private PatientRepository patientRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PatientDto createRegistration(PatientDto patientDto) {
        Patient patient = mapToEntity(patientDto);
        Patient DTO = patientRepository.save(patient);
        PatientDto dto = mapToDto(DTO);
        return dto;
    }

    @Override
    public List<PatientDto> getAllRegistration(int pageNo , int pageSize) {

        Pageable pageable = PageRequest.of(pageNo,pageSize);

        Page<Patient> patients = patientRepository.findAll(pageable);
        List<Patient> content = patients.getContent();
        List<PatientDto> abc = content.stream().map(S -> mapToDto(S)).collect(Collectors.toList());

        return abc;
    }

    @Override
    public PatientDto getByPatientId(long id) {
        Patient patient = patientRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("hbhb", "bubu", id)
        );
        PatientDto patientDto = mapToDto(patient);

        return patientDto;
    }

//    @Override
//    public PatientDto getById(long id) {
//        Patient patient = patientRepository.findById(id).orElseThrow(
//                () -> new ResourceNotFoundException("Patiest", "id", id)
//
//        );
//        PatientDto toDto = mapToDto(patient);
//
//        return toDto;
//    }

    @Override
    public void deletebyid(long id) {
        Patient patient = patientRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("ygjh", "gvgv", id)
        );
        patientRepository.delete(patient);
    }

    @Override
    public PatientDto updatePatient(PatientDto patientDto, long id) {
        Patient patient = patientRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("jay", "yugu", id)
        );

        patient.setPhoneNumber(patientDto.getPhoneNumber());
        patient.setAddress(patientDto.getAddress());
        patient.setEmail(patientDto.getEmail());
        patient.setLastName(patientDto.getLastName());
        patient.setFirstName(patientDto.getFirstName());
        patient.setMedicalHistory(patientDto.getMedicalHistory());
        patient.setDateOfBirth(patientDto.getDateOfBirth());
        Patient save = patientRepository.save(patient);
           return mapToDto(save);
    }


    PatientDto mapToDto(Patient patient){
//        PatientDto patientDto1 = modelMapper.map(patient, PatientDto.class);
        PatientDto patientDto = new PatientDto();
        patientDto.setId(patient.getId());
         patientDto.setAddress(patient.getAddress());
         patientDto.setEmail(patient.getEmail());
         patientDto.setLastName(patient.getLastName());
         patientDto.setMedicalHistory(patient.getMedicalHistory());
         patientDto.setDateOfBirth(patient.getDateOfBirth());
         patientDto.setPhoneNumber(patient.getPhoneNumber());
         patientDto.setFirstName(patient.getFirstName());
        return patientDto;
    }
       Patient mapToEntity(PatientDto patientDto){
//           Patient patient1 = modelMapper.map(patientDto, Patient.class);
           Patient patient = new Patient();
           patient.setId(patientDto.getId());
           patient.setAddress(patientDto.getAddress());
           patient.setEmail(patientDto.getEmail());
           patient.setDateOfBirth(patientDto.getDateOfBirth());
           patient.setLastName(patientDto.getLastName());
           patient.setFirstName(patientDto.getFirstName());
           patient.setMedicalHistory(patientDto.getMedicalHistory());
           patient.setPhoneNumber(patientDto.getPhoneNumber());
        return patient;
      }


}
