import java.util.Date;

public class ViajeFamiliar extends Viaje {
    /**
     * Cantidad de integrantes de la familia
     */
    private int familia;
    private final double DIAS_OBSEQUIO = 2;

    public ViajeFamiliar(String origen, String destino, int costo, Date fechaSalida, Date fechaLlegada, int familia) {
        super(origen, destino, costo, fechaSalida, fechaLlegada);
        this.familia = familia;
    }

    //Constructor getters and setters
    @Override
    public String descripcion() {
        return "Viaje para disfrutar con toda tu familia";
    }

    @Override
    public double cantidadDias() {
        long fechaInicialMs = this.fechaSalida.getTime();
        long fechaFinalMs = this.fechaLlegada.getTime();
        long diferencia = fechaFinalMs - fechaInicialMs;
        return Math.floor(diferencia / (1000 * 60 * 60 * 24))+ this.DIAS_OBSEQUIO;
    }
}