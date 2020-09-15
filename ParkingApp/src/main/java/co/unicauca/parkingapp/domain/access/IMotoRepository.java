/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parkingapp.domain.access;

import co.unicauca.parkingapp.domain.Moto;
import java.util.List;

/**
 * Interfaz para ser implementada por un repositorio
 *
 * @author Santiago Acuña
 */
public interface IMotoRepository {

    /**
     * Declaracion para guardar una moto que sera implementada en un repositorio
     *
     * @param newMoto Moto a crear
     * @return Devuelve verdadero si puedo crear el camion, falso si fracaso.
     */
    boolean save(Moto newMoto);

    /**
     * Declaracion para crear una lista
     *
     * @return Devuelve una coleccion de motos
     */
    List<Moto> list();

}
