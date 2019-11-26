package newmain;
import java.util.ArrayList;
import java.util.Random;
import java.util.Set;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.List;

public class Game{
    private Parser parser;
    private Timer timer;
    private ArrayList<Rod> keys;
    private Room currentRoom;
    private Room beamerRoom;
    ArrayList<Item> inventory= new ArrayList<Item>();
    ArrayList<Fish> fishInv=new ArrayList<Fish>();
    
    /**
     * Starts the game
     */
    public static void main(String[] args) {
        Game game = new Game();
        
        game.play(); 
    }
        
       
        
    /**
     * Create the game and initialise its internal map.
     */
    public Game() {
        createRooms();
        timer = new Timer(60, -1, 5);
        keys = new ArrayList<Rod>();
        parser = new Parser();
        
    }
    
    

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms() {
        Room market, livingroom, oceans, bedroom, shag;
        
        Rod oceanRod = new Rod("livingroom");
      
        // create the rooms
        market = new Room("in the market. You can sell your fishes here for money.");
        oceans = new Room("at the ocean, get your fishes here.");
        livingroom = new Room("In your livingroom");
        bedroom = new Room("in your bedroom, you sleep here.");
        shag = new Room ("in your shag, you keep your equipments here.");
        
       
        livingroom.setExit("Market", market);
        livingroom.setExit("Oceans", oceans);
        

        oceans.setExit("Livingroom", livingroom);
        oceans.setExit("Market", market);

        

        market.setExit("Livingroom", livingroom);
        market.setExit("Oceans", oceans);
        
        bedroom.setExit("Livingroom", livingroom);
        
        shag.setExit("Livingroom", livingroom);
        shag.setExit("bedroom", bedroom);
        shag.setExit("Oceans", oceans);

        
        
        

        currentRoom = bedroom;  // start game in bedroom
        inventory.add(new Item("Fishingrod"));
        fishInv.add(new Fish("big fish"));
        
       
        //shag.setItems(new Item ("FishingrodV2"));
        
        
        // create new fishes
        
        
        
        
       
                
        
            
            } 
           
    
        

        
        
         
        
        
    

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() {            
        printWelcome();
        
        
        
        
         char continueFishing = 'n';
        Scanner keyboard = new Scanner(System.in);
        Die die1=new Die(6);
        
        int balance =0;
        int fishValue=0;
        int FishInOcean=1000000;    
        String fishes[]={"Big fish","Small fish","Shark","Whale"};
        List<String> inv = new ArrayList<String>();
        Scanner choice = new Scanner(System.in);
        Scanner in = new Scanner(System.in);
        Random rand = new Random();
        int fishAmount=75000;
        int value = 100;
        int energy=6;
        
        
        
        continueFishing=keyboard.nextLine().charAt(0);
        System.out.println("Theres 1000000 fish in the sea right now");
        System.out.println("Do you feel like fishing? Please type yes or no");
        
        
        
        
            while (continueFishing == 'y'){
                System.out.println("Welcome to the ocean, you will get to fish a lot here. :)");
                
                boolean running = true;
                GAME:
                while (running){
                    System.out.println("-------------------------------------");
                    int amountFish = rand.nextInt(fishAmount);
                    int valueFish=rand.nextInt(value);
                    String fishType =fishes[rand.nextInt(fishes.length)];
                    System.out.println("\t# You caught: " +fishType);
                    
                    while(energy >1){
                        energy-=1;
                        System.out.println("Your energy: " +energy);
                        System.out.println("Value of fish: " +valueFish+ "$");
                        balance+=valueFish;
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
                            continue;
                        }
                        
                        else{
                        }
                        
                        System.out.println("Do you feel like fishing? Please type yes or no");
            continueFishing=keyboard.nextLine().charAt(0);
                        
                    }

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        while (!finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
                }
            }
    }
                
            

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome() {
        System.out.println();
        System.out.println("Welcome to Fish A Lot!");
        System.out.println("The objective is to stop overfishing");
        System.out.println("Type 'help' if you need help.");
        System.out.println("You have "+timer+"s to win.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) {
        boolean quitGame = false;
        boolean updateTimer = true;

        CommandWord commandWord = command.getCommandWord();

        switch (commandWord) {
            case UNKNOWN:
                System.out.println("Huh? I don't understand what you're talking about...");
                updateTimer = false;
                return false;

            case GO:
                goRoom(command);
                break;

            case HELP:
                printHelp();
                updateTimer = false; // this is metagaming, don't bother with the timer
                break;

            case QUIT:
                quitGame = quit(command);
                updateTimer = false;
                break;

            case TIME:
                System.out.println("You have "+timer+"s left...");
                break;
            case INVENTORY:
                printInventory();
                break;
            
            

        }
        if (updateTimer) {
            timer.updateTimer();
            if (timer.hasExpired()) {
                System.out.println("Time's up - you lost!");
                quitGame = true;
            } else if (timer.isLow()) {
                System.out.println("Time is running low!");
                System.out.println("You have "+timer+"s left...");
            }
        }
        return quitGame;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    
    
    private void getItem(Command command) {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Get what?");
            return;
        }

        String item = command.getSecondWord();

        // Try to leave current room.
        //Item newItem = currentRoom.getItem(item);

//        if (newItem == null) { // there's nothing in that direction
//            System.out.println("That item is not here!");
            
//        }
//        else{
//        inventory.add(newItem);
//        currentRoom.removeItem(item);
//            System.out.println("You picked up:" +item);
//        }
//    }
    }
    private void printHelp() {
        System.out.println("People are fishing too much");
        System.out.println("it is your duty to make people fish less");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }
    

    /** 
     * Try to in to one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     */
    
        
   
        
            
          
      
        
        
    
    /**
     * Retrieves room information.
     */
    
    
    /**
     * Waypoint (beamer) - allows you to "remember" this place.
     * This way, you can always go back to the place,
     * unless you mark a new point.
     */
    

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        return true;
    }

    private void printInventory() {
        String output= "";
        for (int i = 0; i < inventory.size(); i++) {
            output += inventory.get(i).getDescription()+ " ";
            
        }
        System.out.println("You have:");
        System.out.println(output);
    }
    
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
        }
    }
}