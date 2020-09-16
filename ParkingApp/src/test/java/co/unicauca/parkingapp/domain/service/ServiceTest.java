package co.unicauca.parkingapp.domain.service;

import co.unicauca.parkingapp.domain.Camion;
import co.unicauca.parkingapp.domain.Carro;
import co.unicauca.parkingapp.domain.Moto;
import co.unicauca.parkingapp.domain.access.CamionRepository;
import co.unicauca.parkingapp.domain.access.CarroRepository;
import co.unicauca.parkingapp.domain.access.ICamionRepository;
import co.unicauca.parkingapp.domain.access.ICarroRepository;
import co.unicauca.parkingapp.domain.access.IMotoRepository;
import co.unicauca.parkingapp.domain.access.MotoRepository;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Santiago Acuña
 */
public class ServiceTest {

    public ServiceTest() {
    }

    /**
     * Test of calculateRateCar method, of class Service.
     */
    @Test
    public void testCalculateRateCar() {
        System.out.println("calculateRateCar");
        ICarroRepository repo = new CarroRepository();
        Carro carro = new Carro("xkis", "kia", 2023);
        carro.setTiempo("0:12");
        Service instance = new Service(repo, null, null);
        double expResult = 2000;
        double result = instance.calculateRateCar(carro);
        assertEquals(expResult, result, 0.0);

        carro.setTiempo("4:0");
        expResult = 6000;
        result = instance.calculateRateCar(carro);
        assertEquals(expResult, result, 0.0);

        carro.setTiempo("4:30");
        expResult = 4000;
        result = instance.calculateRateCar(carro);
        assertEquals(expResult, result, 0.0);

        carro = null;
        expResult = 0;
        result = instance.calculateRateCar(carro);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of calculateRateCm method, of class Service.
     */
    @Test
    public void testCalculateRateCm() {
        System.out.println("calculateRateCm");

        ICamionRepository repo = new CamionRepository();
        Camion camion = new Camion("xkis", "kia", 2023);
        camion.setTiempo("0:13:0");
        Service instance = new Service(null, repo, null);
        double expResult = 15000;
        double result = instance.calculateRateCm(camion);
        assertEquals(expResult, result, 0.0);

        camion.setTiempo("4:0:0");
        expResult = 37500;
        result = instance.calculateRateCm(camion);
        assertEquals(expResult, result, 0.0);

        camion.setTiempo("0:11:32");
        expResult = 10000;
        result = instance.calculateRateCm(camion);
        assertEquals(expResult, result, 0.0);

        camion = null;
        expResult = 0;
        result = instance.calculateRateCm(camion);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of calculateRateMt method, of class Service.
     */
    @Test
    public void testCalculateRateMt() {
        System.out.println("calculateRateMt");

        IMotoRepository repo = new MotoRepository();
        Moto moto = new Moto("xkis", "kia", 2023);
        moto.setTiempo("0:13");
        Service instance = new Service(null, null, repo);
        double expResult = 1000;
        double result = instance.calculateRateMt(moto);
        assertEquals(expResult, result, 0.0);

        moto.setTiempo("1:30");
        expResult = 1250;
        result = instance.calculateRateMt(moto);
        assertEquals(expResult, result, 0.0);

        moto.setTiempo("3:32");
        expResult = 2500;
        result = instance.calculateRateMt(moto);
        assertEquals(expResult, result, 0.0);

        moto = null;
        expResult = 0;
        result = instance.calculateRateMt(moto);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of saveCarro method, of class Service.
     */
    @Test
    public void testSaveCarro() {
        System.out.println("saveCarro");

        ICarroRepository repo = new CarroRepository();
        Carro newCarro;
        Service instance = new Service(repo, null, null);
        boolean expResult = false;
        boolean result = instance.saveCarro(null);
        assertEquals(expResult, result);

        newCarro = new Carro("sx2s", "mazda", 2011);
        newCarro.setTiempo("4:59");
        expResult = true;
        result = instance.saveCarro(newCarro);
        assertEquals(expResult, result);
    }

    /**
     * Test of saveCamion method, of class Service.
     */
    @Test
    public void testSaveCamion() {
        System.out.println("saveCamion");

        ICamionRepository repo = new CamionRepository();
        Camion newCamion;
        Service instance = new Service(null, repo, null);
        boolean expResult = false;
        boolean result = instance.saveCamion(null);
        assertEquals(expResult, result);

        newCamion = new Camion("sx2s", "mazda", 2011);
        newCamion.setTiempo("4:59");
        expResult = true;
        result = instance.saveCamion(newCamion);
        assertEquals(expResult, result);
    }

    /**
     * Test of saveMoto method, of class Service.
     */
    @Test
    public void testSaveMoto() {
        System.out.println("saveMoto");

        IMotoRepository repo = new MotoRepository();
        Moto newMoto;
        Service instance = new Service(null, null, repo);
        boolean expResult = false;
        boolean result = instance.saveMoto(null);
        assertEquals(expResult, result);

        newMoto = new Moto("sx2s", "Yamaha", 2011);
        newMoto.setTiempo("4:59");
        expResult = true;
        result = instance.saveMoto(newMoto);
        assertEquals(expResult, result);
    }

    /**
     * Test of listCarros method, of class Service.
     */
    /* @Test
    public void testListCarros() {
        System.out.println("listCarros");
        
        ICarroRepository repo = new CarroRepository();
        Carro newCarro = new Carro("x8z-2s", "Hiundai", 2003);
        newCarro.setTiempo("9:43");
        Service instance = new Service(repo, null, null);
        instance.saveCarro(newCarro);
        List<Carro> expResult = new ArrayList<>();
        expResult.add(newCarro);
        List<Carro> result = instance.listCarros();
        assertEquals(expResult, result);
    }
     */
    /**
     * Test of listCamiones method, of class Service.
     */
    /*@Test
    public void testListCamiones() {
        ICamionRepository repo = new CamionRepository();
        Camion newCamion = new Camion("x8z-2s", "Hiundai", 2003);
        newCamion.setTiempo("9:43");
        Service instance = new Service(null, repo, null);
        instance.saveCamion(newCamion);
        List<Camion> expResult = new ArrayList<>();
        expResult.add(newCamion);
        List<Camion> result = instance.listCamiones();
        assertEquals(expResult, result);
    }
     */
    /**
     * Test of listMotos method, of class Service.
     */
    /*@Test
    public void testListMotos() {
        IMotoRepository repo = new MotoRepository();
        Moto newMoto = new Moto("x8z-2s", "AKT", 2003);
        newMoto.setTiempo("9:43");
        Service instance = new Service(null, null, repo);
        instance.saveMoto(newMoto);
        List<Moto> expResult = new ArrayList<>();
        expResult.add(newMoto);
        List<Moto> result = instance.listMotos();
        assertEquals(expResult, result);
    }
     */
}
