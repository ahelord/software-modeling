package co.udenar.ecs.parking.domain;

import java.util.Date;

public class ParkingTruck extends Parking {
    private Raffle raffle;
    private int drawNumber;
    private static final double priceHour = 625;
    private static final double priceLessThanOneDay = 10000;

    public ParkingTruck(Raffle raffle, int drawNumber) {
        this.raffle = raffle;
        this.drawNumber = drawNumber;
    }

    public int getDrawNumber() {
        return drawNumber;
    }

    public void setDrawNumber(int drawNumber) {
        this.drawNumber = drawNumber;
    }


    public Raffle getRaffle() {
        return raffle;
    }

    public void setRaffle(Raffle raffle) {
        this.raffle = raffle;
    }


    @Override
    public void calculateCost(Date initialDate, Date finalDate) {

        if (this.raffle.getWinnerNumber() == this.getDrawNumber()) {
            setCost(minimumCost);
        } else {
            double hours = this.calculateHoursBetweenDates(initialDate, finalDate);
            if (hours < 24) {
                this.setCost(priceLessThanOneDay);
            } else {
                this.setCost(hours * priceHour);
            }
        }
    }
}
