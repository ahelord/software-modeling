package co.udenar.ecs.parking.domain;

public class Raffle {
    private  int winnerNumber;
    public Raffle() {
        this.winnerNumber = (int) Math.floor(Math.random()*(1000-1+1)+1);
    }
    public int getWinnerNumber() {
        return winnerNumber;
    }
}
