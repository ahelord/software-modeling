package co.udenar.ecs.parking.domain;

import java.util.Date;

public class ParkingCar extends Parking {
	private static final double priceHour = 2000;
	private static final double priceLessThanOneHour = 1000;
	@Override
	public void calculateCost(Date initialDate, Date finalDate) {
		double hours = this.calculateHoursBetweenDates(initialDate,finalDate);

		if (hours <= 1) this.setCost(priceHour);
		else {
			double extra = hours-1;
			if (extra < 1) this.setCost(priceHour+priceLessThanOneHour);
			
			if (extra % 1 == 0) {
				this.setCost(priceHour + (extra*priceHour));
			}
			else {
				long integerPart = (long)extra;
				this.setCost(priceHour + (integerPart*priceHour) + priceLessThanOneHour);
			}			
		}
	}

}
