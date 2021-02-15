/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unpa.winforms.ferreteria.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbUtil {
    // private static DbUtil instance = null;

    private static DbUtil instance = new DbUtil();
    private Connection conexion = null;

    private DbUtil() {
        
    }

    public static DbUtil getInstance() {
        //if (instance == null) {
        //instance = new DbUtil();
        //}
        return instance;
    }

    // Devuelve true si se creo correctamente la conexion a la base de datos
    private boolean createConexion() {
        try {
            Properties prop = new Properties();
            
            String packName = new Object(){}.getClass().getPackage().getName();
           
            packName = packName.replace('.', '/') + "/";
            
            InputStream inputStream = DbUtil.class.getClassLoader().getResourceAsStream(packName+"db.properties");
            prop.load(inputStream);
            String driver = prop.getProperty("driver").trim();
            String url = prop.getProperty("url").trim();
            String user = prop.getProperty("user").trim();
            String database = prop.getProperty("database").trim();
            String password = prop.getProperty("password").trim();
            Class.forName(driver);
            conexion = DriverManager.getConnection(url+database, user, password);
            /*if (conexion!=null)
            {                
            	System.out.println("Conexión a base de datos lista");
            }*/
        } catch (ClassNotFoundException e) {	// La clase a la que se llama no funciona
            e.printStackTrace();
        } catch (SQLException e) { 				// Error al establecer conexion
            e.printStackTrace();
        } catch (FileNotFoundException e) { 	// Error al leer el archivo 
            e.printStackTrace();
        } catch (IOException e) { 				// Se ha producido un error en la entrada/salida
            e.printStackTrace();
        }
        return true;
        
    }

    public Connection getConnection() {
        if (conexion == null) {
            this.createConexion();
           // System.out.println("conexion == null");
        }
        return conexion;
    }
}
