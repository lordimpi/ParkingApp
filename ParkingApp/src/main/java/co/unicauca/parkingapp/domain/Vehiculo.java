package co.unicauca.parkingapp.domain;

/**
 * Clase base para crear un objeto polimorfico
 *
 * @author Santiago Acuña
 */
public abstract class Vehiculo {

    /**
     * Indica la placa del vehiculo
     */
    protected String placa;
    /**
     * Indica la marca del vehiculo
     */
    protected String marca;
    /**
     * Indica el modelo de fabricacion del vehiculo
     */
    protected int modelo;

    /**
     * Constructor parametrizado para crear un vehiculo
     *
     * @param placa Placa del vehiculo a crear
     * @param marca Marca del vehiculo a crear
     * @param modelo Modelo del vehiculo a crear
     */
    public Vehiculo(String placa, String marca, int modelo) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
    }
    
    public Vehiculo()
    {
    }
    
    // Getters and Setters
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getModelo() {
        return modelo;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

}
