package co.unicauca.parkingapp.domain.access;

import co.unicauca.parkingapp.domain.Moto;
import co.unicauca.parkingapp.domain.service.Service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Es una implementación que tiene libertad de hacer una implementación del
 * contrato. Lo puede hacer con Sqlite, postgres, mysql, u otra tecnología
 *
 * @author Santiago Acuña
 */
public class MotoRepository implements IMotoRepository {

    /**
     * Variable para crear el string de conexion con la base de datos
     */
    private Connection conn;

    /**
     * Inicia una base de datos a partir de un constructor no parametrizado
     */
    public MotoRepository() {
        initDatabase();
    }

    /**
     * Guarda una moto en la base de datos
     *
     * @param newMoto Moto que sera guardada en la base de datos
     * @return Devuelve verdadero si puedo guardar la moto. false de lo
     * contrario
     */
    @Override
    public boolean save(Moto newMoto) {
        try {
            //Validate product
            if (newMoto == null || newMoto.getPlaca() == null) {
                return false;
            }
            //this.connect();

            String sql = "INSERT INTO Moto ( Placa, Tipo, Marca, Modelo, Horas ) "
                    + "VALUES ( ?, ?, ?, ?, ? )";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, newMoto.getPlaca());
            pstmt.setString(2, newMoto.getTipo());
            pstmt.setString(3, newMoto.getMarca());
            pstmt.setInt(4, newMoto.getModelo());
            pstmt.setString(5, newMoto.getTiempo());
            pstmt.executeUpdate();
            //this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    /**
     * Crea una lista
     *
     * @return Devuelve una coleccion de motos
     */
    @Override
    public List<Moto> list() {
        List<Moto> Motos = new ArrayList<>();
        try {

            String sql = "SELECT Placa, Tipo, Marca, Modelo, Horas FROM Moto";
            //this.connect();

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Moto newMoto = new Moto();
                newMoto.setPlaca(rs.getString("Placa"));
                newMoto.setTipo(rs.getString("Tipo"));
                newMoto.setMarca(rs.getString("Marca"));
                newMoto.setModelo(rs.getInt("Modelo"));
                newMoto.setTiempo(rs.getString("Horas"));
                Motos.add(newMoto);
            }
            //this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Motos;
    }

    /**
     * Inicia la creacion de una base de datos
     */
    private void initDatabase() {
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS Moto (\n"
                + "	Placa text PRIMARY KEY,\n"
                +"                 Tipo text,\n"
                + "	Marca text,\n"
                + "	Modelo integer,\n"
                +"                 Horas text NOT NULL\n"
                + ");";

        try {
            this.connect();
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            //this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Crea la conexion a la base de datos
     */
    public void connect() {
        // SQLite connection string
        //String url = "jdbc:sqlite:./mydatabase.db";
        String url = "jdbc:sqlite::memory:";

        try {
            conn = DriverManager.getConnection(url);

        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Cierra la conexion a la base de datos
     */
    public void disconnect() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

}
