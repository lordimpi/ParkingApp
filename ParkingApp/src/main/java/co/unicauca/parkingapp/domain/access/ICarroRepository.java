package co.unicauca.parkingapp.domain.access;

import co.unicauca.parkingapp.domain.Carro;
import java.util.List;

/**
 * Interfaz para ser implementada por un repositorio
 *
 * @author Santiago Acuña
 */
public interface ICarroRepository {

    /**
     * Declaracion para guardar un carro que sera implementada en un repositorio
     *
     * @param newCarro Carro a crear
     * @return Devuelve verdadero si puedo crear el camion, falso si fracaso.
     */
    boolean save(Carro newCarro);

    /**
     * Declaracion para crear una lista
     *
     * @return Devuelve una coleccion de carros
     */
    List<Carro> list();

}
