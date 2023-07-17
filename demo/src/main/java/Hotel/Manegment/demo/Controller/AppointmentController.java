package Hotel.Manegment.demo.Controller;

import Hotel.Manegment.demo.Paylod.AppointmentDto;
import Hotel.Manegment.demo.Service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;
    @RequestMapping("/patient/{PatientId}/appointment")
    public ResponseEntity<AppointmentDto> createAppo(@PathVariable("PatientId") long PatientId, @RequestBody AppointmentDto appointmentDto){
        AppointmentDto dto = appointmentService.createAppointment(PatientId, appointmentDto);
    return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @GetMapping("/patient/{PatientId}/appointment")
    public List<AppointmentDto>GetAllfindIdByPatientId(@PathVariable("PatientId")long patientId) {
        List<AppointmentDto> all = appointmentService.findByIdAll(patientId);
    return  all;

    }
    @PutMapping("/patient/{PatientId}/appointment/{id}")
  public  ResponseEntity<AppointmentDto> updateAppointment(@PathVariable("PatientId")long patientId,
                                                           @PathVariable("id")long id,
                                                           @RequestBody AppointmentDto appointmentDto){

        AppointmentDto appointmentDto1 = appointmentService.updateAppointment(patientId, id, appointmentDto);
return  new ResponseEntity<>(appointmentDto1,HttpStatus.OK);
    }
   @GetMapping("/patient/{PatientId}/appointment/{id}")
     public ResponseEntity<AppointmentDto> getById(@PathVariable("PatientId")long patientId,
                                                   @PathVariable("id")long id){
       AppointmentDto dto = appointmentService.GetById(patientId, id);
  return new ResponseEntity<>(dto,HttpStatus.OK);
   }
    @DeleteMapping("/patient/{PatientId}/appointment/{id}")
    public ResponseEntity<String> DeleteByID(@PathVariable("PatientId")long patientId,
                                             @PathVariable("id")long id){
        appointmentService.DeleteById(patientId,id);
        return  new ResponseEntity<>("Appoiment Get Deleted ",HttpStatus.OK);
    }

    }


