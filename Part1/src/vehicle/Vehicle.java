/**
 * Vehicle class for Part1.java vehicle display application
 */
package vehicle;

public abstract class Vehicle implements Comparable<Vehicle> {

	// Members
	protected String m_id;
	protected String m_name;
	protected int m_odometer;
	protected int m_engineCC;
	protected VehicleType m_type; 

	// Constructor, vehicle object
	public Vehicle(String i_id, String i_name, int i_odometer, int i_cc) {
		m_id = i_id;
		m_name = i_name;
		m_odometer = i_odometer;
		m_engineCC = i_cc;
		setType();
	} // method Vehicle
	
	// force child classes to set their Type
	protected abstract void setType();

	public VehicleType type() {
		return m_type;
	} // VehicleType
	
	public void setID(String i_id) {
		m_id = i_id;
	} // setID
	
	public String ID() {
		return m_id;
	} // ID
	
	@Override
	public String toString() {
		return "ID: " + m_id + " Name: " + m_name + " Odometer: "
				+ m_odometer + " Engine Capacity: " + m_engineCC;
	} // toString

	public int compareTo(Vehicle i_vehicle) {
		return m_id.compareTo(i_vehicle.m_id);
	} // compareTo
	
	public boolean equals(Vehicle i_vehicle) {
		return this.m_id.equals(i_vehicle.m_id);
	} // equals
	
	public int hashCode() {
		int base = ( m_id.charAt(0) == 't' ? 100 : m_id.charAt(0) == 'b' ? 200 : 0 );
		return  base + Integer.parseInt(m_id.substring(1));
	} // hashCode
}