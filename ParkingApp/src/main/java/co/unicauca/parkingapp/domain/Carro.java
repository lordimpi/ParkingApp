/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parkingapp.domain;

/**
 * Clase hija que hereda de una clase base vehiculo
 *
 * @author Santiago Acuña
 */
public class Carro extends Vehiculo {

    /**
     * Constructor parametrizado para crear un carro
     *
     * @param placa Placa del carro a crear
     * @param marca Marca del carro a crear
     * @param modelo Modelo del carro a crear
     */
    public Carro(String placa, String marca, int modelo) {
        super(placa, marca, modelo);
    }

    public Carro() {
        super();
    }

    /**
     * Metodo que sobrescribe a toString()
     *
     * @return
     */
    @Override
    public String toString() {
        return "Carro{" + "placa=" + placa + ", marca=" + marca + ", modelo=" + modelo + '}';
    }
}
