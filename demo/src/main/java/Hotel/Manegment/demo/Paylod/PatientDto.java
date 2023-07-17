package Hotel.Manegment.demo.Paylod;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
public class PatientDto {
    private  Long id;
    @NotEmpty
    @Size(min = 3,message = "Patient name should have more than 5 charector")
    private String firstName;
    @NotEmpty
    @Size(min = 3,message = "Last name should have 3 charector")
    private String lastName;
    @NotEmpty
    private String dateOfBirth;
    @NotEmpty
    @Size(min = 3,message = "Adress must have 3 charector")
    private String address;
    @NotEmpty
    @Size(min = 10,message = "phone number have 10 digit")
    private String phoneNumber;
    @NotEmpty
    @Email(message = "Email not in @Gmail.com formate")
    private String email;
    @Size(min = 2,message = "minimum have two charector")
    @NotEmpty(message = "you can not take as empty")
    private String medicalHistory;
}
