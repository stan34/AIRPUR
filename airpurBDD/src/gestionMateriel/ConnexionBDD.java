/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionMateriel;

import java.sql.*;

/**
 *
 * @author stan
 */
public class ConnexionBDD {
    
    private static Connection cx= null;
    private static final String url="";
    private static final String login="";
    private static final String password="";
    
    /**
     * Sert à faire une requete de selection sur la BDD
     * @param query
     * @return 
     */
    public ResultSet selectBDD(String query){
        Connection maCx= getCx();
        ResultSet retour= null;
        
        try{
            Statement stm= maCx.createStatement();
            retour =stm.executeQuery(query);
        }catch(SQLException exception){
            System.out.println("Une erreur s'est produite : "+exception.getMessage());
            
        }
        return retour;
    }
    
    /**
     * Sert à faire une requete de modification sur la BDD
     * @param query 
     */
    public void treatmentBDD(String query){
        Connection maCx= getCx();
        
        try{
            Statement stm= maCx.createStatement();
            stm.executeUpdate(query);
        }catch(SQLException exception){
            System.out.println("Une erreur s'est produite : "+exception.getMessage());
        }
    }
    
    /**
     * getCx sert à tester si la connexion est ok. Si elle ne l'est pas elle va l'initialiser.
     * @return connexion
     */
    public Connection getCx(){
        if (ConnexionBDD.cx==null){
            connect();
        }
        return ConnexionBDD.cx;
    }
    
    /**
     * Connect() sert à affecter une connexion à cx.
     */
    public void connect(){
        try{
            ConnexionBDD.cx=DriverManager.getConnection(ConnexionBDD.url, ConnexionBDD.login, ConnexionBDD.password);
        }catch(SQLException exception){
            System.out.println("Une erreur s'est produite : "+exception.getMessage());
        }
    }
}
