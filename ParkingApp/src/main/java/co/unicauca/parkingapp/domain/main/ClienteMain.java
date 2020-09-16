package co.unicauca.parkingapp.domain.main;

import co.unicauca.parkingapp.domain.Camion;
import co.unicauca.parkingapp.domain.Carro;
import co.unicauca.parkingapp.domain.Moto;
import co.unicauca.parkingapp.domain.access.ICamionRepository;
import co.unicauca.parkingapp.domain.access.ICarroRepository;
import co.unicauca.parkingapp.domain.access.IMotoRepository;
import co.unicauca.parkingapp.domain.access.Parking;
import co.unicauca.parkingapp.domain.service.Service;

/**
 *
 * @author Santiago Acuña
 */
public class ClienteMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Le decimos al parqueadero que nos de el repositorio por defecto
        ICarroRepository repositoryCr = Parking.getInstance().getRepositoryCr("default");
        ICamionRepository repositoryCm = Parking.getInstance().getRepositoryCm("default");
        IMotoRepository repositoryMt = Parking.getInstance().getRepositoryMt("default");
        Service service = new Service(repositoryCr, repositoryCm, repositoryMt);

        Carro newCarro = new Carro("xb2f", "mazda", 2012);
        newCarro.setTiempo("8:30");
        service.saveCarro(newCarro);

        Camion newCamion = new Camion("jske23", "toyota", 2015);
        newCamion.setTiempo("1:14:35");
        service.saveCamion(newCamion);

        Moto newMoto = new Moto("ax34ls", "akt", 2020);
        newMoto.setTiempo("4:20");
        service.saveMoto(newMoto);

        for (Carro cr : service.listCarros()) {
            System.out.println(cr);
            System.out.println("Total a pagar: $ " + service.calculateRateCar(cr) + "\n");
        }

        for (Camion cm : service.listCamiones()) {
            System.out.println(cm);
            System.out.println("Total a pagar: $ " + service.calculateRateCm(cm) + "\n");
        }

        for (Moto mt : service.listMotos()) {
            System.out.println(mt);
            System.out.println("Total a pagar: $ " + service.calculateRateMt(mt) + "\n");
        }

    }

}
