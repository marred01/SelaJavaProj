
package company;

import java.io.*;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Iterator;


import vehicle.*;/**
 * 
 */

/**
 * @author marred01
 *
 */
public class Company {
	
		private static final int VEHICLE_MAX = 10;
		
		private int m_totalCars = 0;
		private int m_totalTrucks = 0;
		private int m_totalBikes = 0;
		HashSet<Vehicle> m_vehiclesHashSet = new HashSet<Vehicle>();
		TreeSet<Vehicle> m_vehicles; // new TreeSet<Vehicle>(foo);
		
		
		public Company(String inputFile) {
			readInputFile(inputFile);
			m_vehicles = new TreeSet<Vehicle>(m_vehiclesHashSet);
			m_vehiclesHashSet = null;
		} // Constructor
		
		private void readInputFile(String file) {
			FileReader input = null;
			BufferedReader bufIn = null;
			try {
				input = new FileReader(file);
				bufIn = new BufferedReader(input);
				
				String line;
				while ((line = bufIn.readLine()) != null) {
					parseData(line);
				}
			}
			catch (IOException io) {
				System.out.println(io);
			}
			finally {
				try {
					bufIn.close();
					input.close();
				}
				catch (IOException io) {
					System.out.print(io);
				}
			}
		} // readInputFile
		
		private void parseData(String data) { // called from readInputFile method
			String[] d = data.split(",");
			if (d[0].equals("Car") && m_totalCars < VEHICLE_MAX) {
				m_vehiclesHashSet.add(new Car(d[1],d[2],Integer.parseInt(d[3]),Integer.parseInt(d[4]),d[5].equals("yes") ? true : false));
				m_totalCars++;
			}
			if (d[0].equals("Truck") && m_totalTrucks < VEHICLE_MAX) {
				m_vehiclesHashSet.add(new Truck(d[1],d[2],Integer.parseInt(d[3]),Integer.parseInt(d[4]),Integer.parseInt(d[5])));
				m_totalTrucks++;
			}
			if (d[0].equals("Bike") && m_totalBikes < VEHICLE_MAX) {
				m_vehiclesHashSet.add(new Bike(d[1],d[2],Integer.parseInt(d[3]),Integer.parseInt(d[4])));
				m_totalBikes++;
			}
		} // parseData
		
		public void printVehicles() {
			Iterator<Vehicle> I = m_vehicles.iterator();
			while (I.hasNext()) {
				System.out.println(I.next());
			}
		} // printVehicles
} // class