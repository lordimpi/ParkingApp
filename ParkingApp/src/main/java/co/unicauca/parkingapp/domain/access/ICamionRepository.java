package co.unicauca.parkingapp.domain.access;

import co.unicauca.parkingapp.domain.Camion;
import java.util.List;

/**
 * Interfaz para ser implementada por un repositorio
 *
 * @author Santiago Acuña
 */
public interface ICamionRepository {

    /**
     * Declaracion para guardar un camion que sera implementada en un
     * repositorio
     *
     * @param newCamion Camion a crear
     * @return Devuelve verdadero si puedo crear el camion, falso si fracaso.
     */
    boolean save(Camion newCamion);

    /**
     * Declaracion para crear una lista
     *
     * @return Devuelve una coleccion de camiones
     */
    List<Camion> list();
}
