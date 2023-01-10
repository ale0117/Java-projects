package labs.lab7;

import java.util.PriorityQueue;

public class EmergencyRoom {

	private PriorityQueue<Patient> patients;


	public EmergencyRoom() {
		patients = new PriorityQueue<>();
	}


	/**
	 * Adds a patient to the ER queue with the given injury and description
	 * 
	 * @param injury
	 * @param description
	 */
	public void addPatient(Injury injury, String description) {
		patients.add(new Patient(injury, description));
	}


	/**
	 * Gets the next highest priority patient
	 */
	public Patient nextPatient() {
		if (patients.size() == 0) {
			return null;
		}
		else {
			return patients.remove();
		}
	}
}