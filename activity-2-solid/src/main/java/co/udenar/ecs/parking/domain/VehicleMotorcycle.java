package co.udenar.ecs.parking.domain;

public class VehicleMotorcycle extends Vehicle {

	public VehicleMotorcycle(VehicleEnum vehicle, double minAmount, double timeMinAmount, double costAdditionalHour) {
		super(vehicle, minAmount, timeMinAmount, costAdditionalHour);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double totalPago(double time) {
		
		if (time <= 3) return 3000;
		else {
			double extra = time-3;
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
