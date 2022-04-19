package co.udenar.ecs.parking.domain;

import java.util.Date;

public class ParkingCar extends Parking {

	@Override
	public double calculateCost(Date initialDate, Date finalDate) {
		double hours = this.calculateHoursBetweenDates(initialDate,finalDate);

		if (hours <= 1) return 2000;
		else {
			double extra = hours-1;
			if (extra < 1) return 2000+1000;
			
			if (extra % 1 == 0) {
				return 2000 + (extra*2000);
			}
			else {
				long iPart = (long)extra;
				return 2000 + (iPart*2000) + 1000;
			}			
		}
	}

}
