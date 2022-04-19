package co.udenar.ecs.parking.domain;

import java.util.Date;

public class ParkingMotorcycle extends Parking {

	//private final double numberOfWinner = Math.random(1,1000)
	//public double calculateCost(Date initialDate, Date finalDate, int selectedNumber) {
	// public double checkIfWinner(int selectedNumber) {
	@Override
	public double calculateCost(Date initialDate, Date finalDate) {
		double hours = this.calculateHoursBetweenDates(initialDate,finalDate);

 		if (hours <= 3) return 3000;
		else {
			double extra = hours-3;
			if (extra % 1 == 0) {
				return 3000 + (extra*1000);
			}
			else {
				long iPart = (long)extra;
				return 3000 + ((iPart + 1)*1000);
			}			
		}
	}

}
