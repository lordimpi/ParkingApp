package co.unicauca.parkingapp.domain;

/**
 * Clase hija que hereda de una clase base vehiculo
 *
 * @author Santiago Acuña
 */
public class Carro extends Vehiculo {

    /**
     * Horas que estuvo el carro en el parqueadero
     */
    private String tiempo;
    private String tipo;

    /**
     * Constructor parametrizado para crear un carro
     *
     * @param placa Placa del carro a crear
     * @param marca Marca del carro a crear
     * @param modelo Modelo del carro a crear
     */
    public Carro(String placa, String marca, int modelo) {
        super(placa, marca, modelo);
        this.tipo = "Carro";
    }

    public Carro() {
        super();
        this.tipo = "Carro";
    }

    // Getters and Setters
    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Metodo que sobrescribe a toString()
     *
     * @return
     */
    @Override
    public String toString() {
        return " placa: " + placa + " tipo: " + tipo + ", marca: " + marca + ", modelo: " + modelo + " horas: " + tiempo;
    }
}
