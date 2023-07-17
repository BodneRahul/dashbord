package Hotel.Manegment.demo.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Appointment",
        uniqueConstraints = @UniqueConstraint(columnNames = {"dateTime"})

)
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "patientName")
    private String patientName;
    @Column(name = "doctorName")
    private String doctorName;
    @Column(name = "dateTime")
    private String dateTime;
    @Column(name = "status")
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PatientId",nullable = false)
    private  Patient patient;


}
