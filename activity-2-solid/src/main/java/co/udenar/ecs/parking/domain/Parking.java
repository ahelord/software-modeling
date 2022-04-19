package co.udenar.ecs.parking.domain;

import java.util.Date;

public abstract class Parking {
	
	private VehicleEnum vehicle;
    private double minAmount;
    private double timeMinAmount;
    private double costAdditionalHour;
    
/*    public Parking(VehicleEnum vehicle, double minAmount, double timeMinAmount, double costAdditionalHour) {
		super();
		this.vehicle = vehicle;
		this.minAmount = minAmount;
		this.timeMinAmount = timeMinAmount;
		this.costAdditionalHour = costAdditionalHour;
	}*/

	public abstract double calculateCost(Date initialDate, Date finalDate);
    public double calculateHoursBetweenDates(Date initialDate, Date finalDate){
		double seconds = (finalDate.getTime() - initialDate.getTime()) / 1000;
		return seconds / 3600;
	}
	/**
	 * @return the vehicle
	 *//*
	public VehicleEnum getVehicle() {
		return vehicle;
	}
	*//**
	 * @param vehicle the vehicle to set
	 *//*
	public void setVehicle(VehicleEnum vehicle) {
		this.vehicle = vehicle;
	}
	*//**
	 * @return the minAmount
	 *//*
	public double getMinAmount() {
		return minAmount;
	}
	*//**
	 * @param minAmount the minAmount to set
	 *//*
	public void setMinAmount(double minAmount) {
		this.minAmount = minAmount;
	}
	*//**
	 * @return the timeMinAmount
	 *//*
	public double getTimeMinAmount() {
		return timeMinAmount;
	}
	*//**
	 * @param timeMinAmount the timeMinAmount to set
	 *//*
	public void setTimeMinAmount(double timeMinAmount) {
		this.timeMinAmount = timeMinAmount;
	}
	*//**
	 * @return the costAdditionalHour
	 *//*
	public double getCostAdditionalHour() {
		return costAdditionalHour;
	}
	*//**
	 * @param costAdditionalHour the costAdditionalHour to set
	 *//*
	public void setCostAdditionalHour(double costAdditionalHour) {
		this.costAdditionalHour = costAdditionalHour;
	}*/
}
