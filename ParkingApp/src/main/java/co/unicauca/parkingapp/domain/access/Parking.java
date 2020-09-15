/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parkingapp.domain.access;

/**
 * Fabrica que se encarga de instanciar un Repository o cualquier otro que se
 * cree en el futuro.
 *
 * @author Santiago Acuña
 */
public class Parking {

    /**
     * Guarda la instancia de un parqueadero
     */
    private static Parking instance;

    /**
     * Clase singleton
     *
     * @return Retorna la instancia del parqueadero
     */
    public static Parking getInstance() {

        if (instance == null) {
            instance = new Parking();
        }
        return instance;
    }

    /**
     * Método que crea una instancia concreta de la jerarquia ICamionRepository
     *
     * @param type cadena que indica qué tipo de clase hija debe instanciar
     * @return una clase hija de la abstracción ICamionRepository
     */
    public ICamionRepository getRepositoryCm(String type) {

        ICamionRepository result = null;

        switch (type) {
            case "default":
                result = new CamionRepository();
                break;
        }
        return result;
    }

    /**
     * Método que crea una instancia concreta de la jerarquia ICarroRepository
     *
     * @param type cadena que indica qué tipo de clase hija debe instanciar
     * @return una clase hija de la abstracción ICarroRepository
     */
    public ICarroRepository getRepositoryCr(String type) {

        ICarroRepository result = null;

        switch (type) {
            case "default":
                result = new CarroRepository();
                break;
        }
        return result;
    }

    /**
     * Método que crea una instancia concreta de la jerarquia IMotoRepository
     *
     * @param type cadena que indica qué tipo de clase hija debe instanciar
     * @return una clase hija de la abstracción IMotoRepository
     */
    public IMotoRepository getRepositoryMt(String type) {

        IMotoRepository result = null;

        switch (type) {
            case "default":
                result = new MotoRepository();
                break;
        }
        return result;
    }
}
