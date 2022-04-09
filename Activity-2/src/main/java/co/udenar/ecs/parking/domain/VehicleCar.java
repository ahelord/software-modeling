package co.udenar.ecs.parking.domain;

public class VehicleCar extends Vehicle {

	public VehicleCar(VehicleEnum vehicle, double minAmount, double timeMinAmount, double costAdditionalHour) {
		super(vehicle, minAmount, timeMinAmount, costAdditionalHour);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double totalPago(double time) {
		
		if (time <= 1) return 2000;
		else {
			double extra = time-1;
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
