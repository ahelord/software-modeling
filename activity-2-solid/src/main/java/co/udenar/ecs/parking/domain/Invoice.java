package co.udenar.ecs.parking.domain;


public class Invoice {

	
	private VehicleEnum vehicle;
    private double timeHours;
    private double total;
    
    public Invoice(VehicleEnum vehicle, double timeHours, double total) {
		super();
		this.vehicle = vehicle;
		this.timeHours = timeHours;
		this.total = total;
	}
    
    /**
	 * @return the vehicle
	 */
	public VehicleEnum getVehicle() {
		return vehicle;
	}
	/**
	 * @param vehicle the vehicle to set
	 */
	public void setVehicle(VehicleEnum vehicle) {
		this.vehicle = vehicle;
	}
	/**
	 * @return the timeHours
	 */
	public double getTimeHours() {
		return timeHours;
	}
	/**
	 * @param timeHours the timeHours to set
	 */
	public void setTimeHours(double timeHours) {
		this.timeHours = timeHours;
	}
	/**
	 * @return the total
	 */
	public double getTotal() {
		return total;
	}
	/**
	 * @param total the total to set
	 */
	public void setTotal(double total) {
		this.total = total;
	}
	
    
	
}
