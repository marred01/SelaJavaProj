/**
 * Vehicle class for Part3.java car rental application
 */
package part3.vehicle;

import part3.customer.Customer;
/**
 * @author Mark Redden
 *
 */
public class Vehicle implements Comparable<Vehicle>{
	// Members, we're making them public to avoid a mass of getters and setters
	//  if more operations are required for any element, getter and setter will be implemented
	public String m_name;
	public String m_tagID;
	public boolean m_isAvailable = false;
	public int m_pricePerDay;
	public int m_period;
	public String m_customerName = "";
	public boolean m_isSmokeFree = false;
	public int m_seats;
	public boolean m_hasAirBags = false;
	public boolean m_hasAC = false;
	public boolean m_isAutomatic = false;
	public boolean m_hasPowerWindows = false;
	public boolean m_hasAMFMradio = false;
	public boolean m_hasPowerSteering = false;
	public boolean m_hasPowerBrakes = false;
	public VehicleType m_type;
	
	// Constructor
	public Vehicle(String i_name) {
		m_name = i_name;
	} // Constructor
	
	public VehicleType type() {
		return m_type;
	} // VehicleType
	
	public void rent(Customer i_customer, int i_period) {
		m_customerName = i_customer.name();
		m_isAvailable = false;
		i_customer.rentVehicle(this, i_period);
	} // rent
	
	public void returnIt() {
		m_customerName = "";
		m_isAvailable = true;
	} // returnIt

	public String toString() {
		return String.format("%-10s - %-6s - %-17s - Price: %3d", m_tagID,
				m_type, m_name, m_pricePerDay)
				+ "\n"
				+ String.format(
						"  - No Smoke: %-3s - Seats: %3d - Air Bags: %-3s - AC: %-3s",
						m_isSmokeFree ? "yes" : "no", m_seats,
						m_hasAirBags ? "yes" : "no", m_hasAC ? "yes" : "no")
				+ "\n"
				+ String.format(
						"  -     Auto: %-3s - AM/FM: %-3s - Pwr: Win:%1s Brk:%1s Str:%1s",
						m_isAutomatic ? "yes" : "no", m_hasAMFMradio ? "yes"
								: "no", m_hasPowerWindows ? "Y" : "N",
						m_hasPowerBrakes ? "Y" : "N",
						m_hasPowerSteering ? "Y" : "N");
	} // toString
	
	public int compareTo(Vehicle i_vehicle) {
		return m_tagID.compareTo(i_vehicle.m_tagID);
	} // compareTo
	
	public boolean equals(Vehicle i_vehicle) {
		return this.m_tagID.equals(i_vehicle.m_tagID);
	} // equals
	
	public int hashCode() {
		return Integer.parseInt(m_tagID.substring(4));
	} // hashCode
}
