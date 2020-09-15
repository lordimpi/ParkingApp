package co.unicauca.parkingapp.domain.access;

import co.unicauca.parkingapp.domain.Carro;
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
public class CarroRepository implements ICarroRepository {

    /**
     * Variable para crear el string de conexion con la base de datos
     */
    private Connection conn;

    /**
     * Inicia una base de datos a partir de un constructor no parametrizado
     */
    public CarroRepository() {
        initDatabase();
    }

    /**
     * Guarda un carro en la base de datos
     *
     * @param newCarro Carro que sera guardado en la base de datos
     * @return Devuelve verdadero si puedo guardar el carro. false de lo
     * contrario
     */
    @Override
    public boolean save(Carro newCarro) {
        try {
            //Validate product
            if (newCarro == null || newCarro.getPlaca() == null) {
                return false;
            }
            //this.connect();

            String sql = "INSERT INTO Carro ( Placa, Marca, Modelo ) "
                    + "VALUES ( ?, ?, ? )";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(2, newCarro.getPlaca());
            pstmt.setString(2, newCarro.getMarca());
            pstmt.setInt(1, newCarro.getModelo());
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
     * @return Devuelve una coleccion de carros
     */
    @Override
    public List<Carro> list() {
        List<Carro> carros = new ArrayList<>();
        try {

            String sql = "SELECT Placa, Marca, Modelo FROM Carro";
            //this.connect();

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Carro newCarro = new Carro();
                newCarro.setPlaca(rs.getString("Placa"));
                newCarro.setMarca(rs.getString("Marca"));
                newCarro.setModelo(rs.getInt("Modelo"));

                carros.add(newCarro);
            }
            //this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return carros;
    }

    /**
     * Inicia la creacion de una base de datos
     */
    private void initDatabase() {
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS Carro (\n"
                + "	Placa text PRIMARY KEY,\n"
                + "	Marca text NOT NULL,\n"
                + "	Modelo integer\n"
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
