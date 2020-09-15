package co.unicauca.parkingapp.domain.service;

import co.unicauca.parkingapp.domain.Camion;
import co.unicauca.parkingapp.domain.Carro;
import co.unicauca.parkingapp.domain.Moto;
import co.unicauca.parkingapp.domain.access.ICarroRepository;
import co.unicauca.parkingapp.domain.access.IMotoRepository;
import co.unicauca.parkingapp.domain.access.ICamionRepository;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Santiago Acuña
 */
public class Service {

    // Ahora hay una dependencia de una abstracción, no es algo concreto,
    // no sabe cómo está implementado.
    private ICarroRepository repositoryCr;
    private ICamionRepository repositoryCm;
    private IMotoRepository repositoryMt;
    String[] parts;

    /**
     * Inyección de dependencias en el constructor.Ya no conviene que el mismo
     * servicio cree un repositorio concreto
     *
     * @param repositoryCr Una clase hija de ICarroRepository
     * @param repositoryCm Una clase hija de ICamionRepository
     * @param repositoryMt Una clase hija de IMotoRepository
     */
    public Service(ICarroRepository repositoryCr,
            ICamionRepository repositoryCm,
            IMotoRepository repositoryMt) {
        this.repositoryCr = repositoryCr;
        this.repositoryCm = repositoryCm;
        this.repositoryMt = repositoryMt;
    }

    // Metodos para calcular tarifa de Carros, Camiones y Motos
    public double calculateRateCar(Carro carro) {
        if (carro == null) {
            return 0;
        }
        parts = carro.getTiempo().split(":");
        if (Integer.parseInt(parts[0]) == 0) {
            return 2000;
        }
        var res = 1000 + ((Integer.parseInt(parts[0]) * 1000));
        if (Integer.parseInt(parts[1]) <= 30) {
            res += Integer.parseInt(parts[0]) * 500;
            return Math.round(res);
        }
        res += 1000;
        return Math.round(res);
    }

    public double calculateRateCm(Camion camion) {
        if (camion == null) {
            return 0;
        }
        parts = camion.getTiempo().split(":");
        if (Integer.parseInt(parts[0]) == 0 && Integer.parseInt(parts[1]) <= 12) {
            return 10000;
        }
        var res = 7500 + ((Integer.parseInt(parts[0]) * 7500));
        var n1 = Math.random() * 1000 + 1;
        var n2 = Math.random() * 1000 + 1;
        if (n1 == n2) {
            return 0;
        }
        return Math.round(res);
    }

    public double calculateRateMt(Moto moto) {
        if (moto == null) {
            return 0;
        }
        parts = moto.getTiempo().split(":");
        if (Integer.parseInt(parts[0]) == 0) {
            return 1000;
        }
        var res = 1000 + ((Integer.parseInt(parts[0]) * 500));
        if (Integer.parseInt(parts[1]) <= 30) {
            res += Integer.parseInt(parts[0]) * 250;
            return Math.round(res);
        }
        res += 500;
        return Math.round(res);
    }

    // Metodos que sirven para Guardar Carros, Camiones y Motos
    public boolean saveCarro(Carro newCarro) {

        //Valida un Carro
        if (newCarro == null || newCarro.getPlaca() == null) {
            return false;
        }
        repositoryCr.save(newCarro);
        return true;

    }

    public boolean saveCamion(Camion newCamion) {

        //Valida un Camion
        if (newCamion == null || newCamion.getPlaca() == null) {
            return false;
        }
        repositoryCm.save(newCamion);
        return true;

    }

    public boolean saveMoto(Moto newMoto) {

        //Valida una Moto
        if (newMoto == null || newMoto.getPlaca() == null) {
            return false;
        }
        repositoryMt.save(newMoto);
        return true;

    }

    // Metodos para Listar Carros, Camiones y Motos
    public List<Carro> listCarros() {
        List<Carro> carros = new ArrayList<>();
        carros = repositoryCr.list();
        return carros;
    }

    public List<Camion> listCamiones() {
        List<Camion> camiones = new ArrayList<>();
        camiones = repositoryCm.list();
        return camiones;
    }

    public List<Moto> listMotos() {
        List<Moto> motos = new ArrayList<>();
        motos = repositoryMt.list();
        return motos;
    }
}
