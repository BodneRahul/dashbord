package Hotel.Manegment.demo.Controller;

import Hotel.Manegment.demo.Paylod.PatientDto;
import Hotel.Manegment.demo.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/patient")
public class PatientController {

    @Autowired
    PatientService patientService;
  @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    ResponseEntity<Object> createRegistration (@Valid @RequestBody PatientDto patientDto, BindingResult bindingResult){
    if (bindingResult.hasErrors()){
       return new ResponseEntity<>(bindingResult.getFieldError().getDefaultMessage(),HttpStatus.INTERNAL_SERVER_ERROR);

    }
        PatientDto dto = patientService.createRegistration(patientDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }
    @GetMapping
    List<PatientDto> getAllReg(@RequestParam(value =  "pageNo", defaultValue = "0", required = false)  int pageNo,
                               @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize
                               ){
        List<PatientDto> dtos = patientService.getAllRegistration(pageNo,pageSize);
        return (dtos);
    }
    @GetMapping("/{id}")
    ResponseEntity<PatientDto> getBy(@PathVariable("id") long id){
        return new ResponseEntity<>(patientService.getByPatientId(id),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> DeleteReg(@PathVariable("id") long id){
         patientService.deletebyid(id);
         return new ResponseEntity<>("succesfully",HttpStatus.OK);

    }
    @PutMapping("/{id}")
    public  ResponseEntity<PatientDto> updatePetient(@RequestBody PatientDto patientDto ,@PathVariable ("id")long id){
        PatientDto updatePatient = patientService.updatePatient(patientDto, id);
       return new ResponseEntity<>(updatePatient,HttpStatus.OK);

    }



}
