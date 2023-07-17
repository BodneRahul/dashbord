package Hotel.Manegment.demo.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "patient",

    uniqueConstraints =@UniqueConstraint(columnNames = {"email"})
)
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "date_Of_Birth")
    private String dateOfBirth;
    @Column(name = "address")
    private String address;
    @Column(name = "phone_Number")
    private String phoneNumber;
    @Column(name = "email")
    private String email;
    @Column(name = "medicalHistory")
    private String medicalHistory;



   @OneToMany(mappedBy = "patient",cascade = CascadeType.ALL,orphanRemoval = true)
   Set<Appointment> sets = new HashSet<>();
}
