/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newmain;

/**
 *
 * @author Marvin
 */
public class Rod {
     boolean owned;
    String identifier;
    
    public Rod(String identifier) {
        owned = false;
        this.identifier = identifier;
    }
    
    /**
     * key is owned atm.
     */
    public boolean isOwned() {
        return owned;
    }
    
    /**
     * key is obtained, and is now owned.
     */
    public void claim() {
        owned = true;
    }
    
    public String toString() {
        return identifier;
    }
}