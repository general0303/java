import com.company.Doctor;
import com.company.DoctorRepository;
import com.company.DoctorService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class DoctorServiceTest {
    @Mock
    private DoctorRepository doctorRepository;
    @Captor
    ArgumentCaptor<Doctor> captor;
    @Test
    void getUsers() {
        Doctor doctor= new Doctor();
        doctor.setName("Vasya");
        Doctor doctor2 = new Doctor();
        doctor2.setName("Dima");
        Mockito.when(doctorRepository.findAll()).thenReturn(List.of(doctor,
                doctor2));
        DoctorService doctorService = new
                DoctorService();
        Assertions.assertEquals(2,
                doctorService.show_doctors().size());
        Assertions.assertEquals("Vasya",
                doctorService.show_doctors().get(0).getName());
    }
    @Test
    void saveOrUpdate() {
        Doctor doctor = new Doctor();
        doctor.setName("Vitya");
        DoctorService doctorService = new
                DoctorService();
        doctorService.addNewDoctor("Vitya", "Ivanov");
        Mockito.verify(doctorRepository).save(captor.capture());
        Doctor captured = captor.getValue();
        Assertions.assertEquals("Vitya", captured.getName());
    }
}
