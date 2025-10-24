package Main;
import java.util.HashMap;
import java.util.Map;

public class AppointmentService {
    private final Map<String, Appointment> appointments = new HashMap<>();
//The appointment service shall be able to add appointments with a unique appointment ID.
    public void addAppointment(Appointment appt) {
        if (appointments.containsKey(appt.getAppointmentID())) {
            throw new IllegalArgumentException("Appointment ID must be unique.");
        }
        appointments.put(appt.getAppointmentID(), appt);
    }
//The appointment service shall be able to delete appointments per appointment ID.
    public void deleteAppointment(String appointmentID) {
        if (!appointments.containsKey(appointmentID)) {
            throw new IllegalArgumentException("Appointment ID not found.");
        }
        appointments.remove(appointmentID);
    }

    //get appointments
    public Appointment getAppointment(String appointmentID) {
        return appointments.get(appointmentID);
    }
}
