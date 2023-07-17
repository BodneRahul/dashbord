package Hotel.Manegment.demo.Paylod;

import lombok.Data;

@Data
public class AppointmentDto {
    private Long id;
    private String patientName;
    private String doctorName;
    private String dateTime;
    private String status;
}
