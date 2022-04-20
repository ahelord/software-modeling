package co.udenar.ecs.parking.domain;

import java.util.Date;

public abstract class Parking {
	static final double minimumCost = 2000;
	private double cost;

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public abstract void calculateCost(Date initialDate, Date finalDate);
    public double calculateHoursBetweenDates(Date initialDate, Date finalDate){
		double seconds = (finalDate.getTime() - initialDate.getTime()) / 1000;
		return seconds / 3600;
	}

}
