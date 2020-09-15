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
public class Moto extends Vehiculo {

    /**
     * Constructor parametrizado para crear una moto
     *
     * @param placa Placa de la moto a crear
     * @param marca Marca de la moto a crear
     * @param modelo Modelo de la moto a crear
     */
    public Moto(String placa, String marca, int modelo) {
        super(placa, marca, modelo);
    }

    public Moto(){
        super();
    }
    
    /**
     * Metodo que sobrescribe a toString()
     *
     * @return
     */
    @Override
    public String toString() {
        return "Moto{" + "placa=" + placa + ", marca=" + marca + ", modelo=" + modelo + '}';
    }
}
