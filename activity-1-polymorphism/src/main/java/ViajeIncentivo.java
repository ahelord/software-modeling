import java.util.Date;

public class ViajeIncentivo extends Viaje {
    /**
     * Empresa que patrocina el viaje al empleado
     */
    private String empresa;
    private final double DIAS_OBSEQUIO = 4;

    public ViajeIncentivo(String origen, String destino, int costo, Date fechaSalida, Date fechaLlegada,String empresa) {
        super(origen, destino, costo, fechaSalida, fechaLlegada);
        this.empresa = empresa;
    }

    //Constructor, getters and setters
    @Override
    public String descripcion() {
        return "Viaje incentivo que te envia la empresa " + empresa;
    }
    public double cantidadDias() {
        long fechaInicialMs = this.fechaSalida.getTime();
        long fechaFinalMs = this.fechaLlegada.getTime();
        long diferencia = fechaFinalMs - fechaInicialMs;
        return Math.floor(diferencia / (1000 * 60 * 60 * 24))+ this.DIAS_OBSEQUIO;
    }

	/**
	 * @return the empresa
	 */
	public String getEmpresa() {
		return empresa;
	}

	/**
	 * @param empresa the empresa to set
	 */
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
}