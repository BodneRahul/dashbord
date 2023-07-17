package Hotel.Manegment.demo.Service;

import Hotel.Manegment.demo.Paylod.PatientDto;

import java.util.List;

public interface PatientService {

    PatientDto createRegistration (PatientDto patientDto);

    List<PatientDto> getAllRegistration (int pageNo,int pageSize);

   // PatientDto getById(long id);
         PatientDto getByPatientId(long id);
    void deletebyid(long id);

    PatientDto updatePatient(PatientDto patientDto, long id);
}
