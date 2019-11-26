/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newmain;

import java.util.ArrayList;

/**
 *
 * @author Marvin
 */
public class Fish {
    
    private String name;
    private ArrayList<Fish> fishinv;

    public Fish( String name) {
        
        this.name = name;
    }
  

    public String getName() {
        return name;
    }
}
