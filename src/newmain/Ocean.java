/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newmain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Marvin
 */
public class Ocean {
        char continueFishing = 'n';
        Scanner keyboard = new Scanner(System.in);
        //int balance =0;
        int fishValue=0;
        int FishInOcean=1000000;
        int fishAmount=75000;
        int value = 100;
        int energy=6;
        String fishes[]={"Big fish","Small fish","Shark","Whale"};
        List<String> inv = new ArrayList<String>();
        Scanner choice = new Scanner(System.in);
        Scanner in = new Scanner(System.in);
        Random rand = new Random();
        
        
        
        System.out.println("Theres 1000000 fish in the sea right now");
        System.out.println("Do you feel like fishing? Please type yes or no");
        continueFishing=keyboard.nextLine().charAt(0);
        
        
        
        
        
            while (continueFishing == 'y'){
                System.out.println("Welcome to the ocean, you will get to fish a lot here. :)");
                
                boolean running = true;
                GAME:
                while (running){
                    System.out.println("-------------------------------------");
                    int amountFish = rand.nextInt(fishAmount);
                    int valueFish=rand.nextInt(value);
                    String fishType =fishes[rand.nextInt(fishes.length)];
                    
                    
                    while(energy >1){
                        System.out.println("\t# You caught: " +fishType);
                        energy-=1;
                        System.out.println("Your energy: " +energy);
                        System.out.println("Value of fish: " +valueFish+ "$");
                        System.out.println("Your balance: " +balance+ "$");
                        System.out.println("what would you like to do?");
                        System.out.println("1. Store " +fishType+ " in inventory?");
                        System.out.println("2. Nothing.");
                        
                        String input= in.nextLine();
                        if(input.equals("1")){
                            
                            System.out.println("you added: " +fishType+ " to your inventory!");
                            printInventory();
                        }
                        else if(input.equals("2")){
                            System.out.println("You continue to fish");
                            
                        }
                        
                        else{
                            System.out.println("That is not an option");
                            continue;
                        }
                        
                        System.out.println("Do you feel like fishing? Please type yes or no");
            continueFishing=keyboard.nextLine().charAt(0);}
                }
}
}