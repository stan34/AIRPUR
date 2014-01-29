/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionMateriel;

import java.util.ArrayList;

/**
 *
 * @author stan
 */
public abstract class Modele {
    
    public abstract Modele find(int _id);
    
    public abstract ArrayList<Modele> getAll();
    
    public abstract Modele insert(Modele objet);
    
    public abstract Modele delete(Modele objet);
    
    public abstract Modele modify(Modele objet);
}
