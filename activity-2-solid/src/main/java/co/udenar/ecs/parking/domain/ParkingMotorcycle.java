package co.udenar.ecs.parking.domain;

import java.util.Date;

public class ParkingMotorcycle extends Parking {
	private static final double priceForThreeHoursOrLess = 3000;
	private static final double priceHour = 1000;
	@Override
	public void calculateCost(Date initialDate, Date finalDate) {
		double hours = this.calculateHoursBetweenDates(initialDate,finalDate);

 		if (hours <= 3) this.setCost(priceForThreeHoursOrLess);
		else {
			double extra = hours-3;
			if (extra % 1 == 0) {
				this.setCost(priceForThreeHoursOrLess + (extra*priceHour));
			}
			else {
				long integerPart = (long)extra;
				this.setCost(priceForThreeHoursOrLess + (integerPart * priceHour) + ((extra - integerPart)*priceHour));
			}			
		}
	}

}
