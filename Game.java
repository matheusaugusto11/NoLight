import java.util.ArrayList;
import java.util.List;

/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */

public class Game 
{
    private Parser parser;
    private Room currentRoom;
    private Fuel fuelCount;

    private boolean finished = false;
    private boolean lose = false;

    private String printFinish = "\n";
        
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createRooms();
        fuelCount = new Fuel();
        parser = new Parser();
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        Room unknowAreaMain;
        
        Room northArea1, northArea2, northArea3, northArea4, northArea5, northArea6, 
        northArea7, northArea8, northArea9, northArea10, northArea11, northArea12, northArea13,
        northArea14, northArea15, northArea16, northArea17, northArea18;

        Room southArea1, southArea2, southArea3, southArea4, southArea5, southArea6, southArea7, 
        southArea8, southArea9, southArea10, southArea11, southArea12, southArea13, southArea14, 
        southArea15, southArea16, southArea17, southArea18;

        Room eastArea1, eastArea2, eastArea3, eastArea4, eastArea5, eastArea6, eastArea7, 
        eastArea8, eastArea9, eastArea10;

        Room westArea1, westArea2, westArea3, westArea4, westArea5, westArea6, westArea7,
        westArea8, westArea9, westArea10, westArea11, westArea12;

        Room outside;

        // create the rooms
        unknowAreaMain = new Room("Em algum lugar nas profundezas da caverna...", false);

        northArea1 = new Room("Parece ser uma área vazia... ", false);
        southArea1 = new Room("Parece ser uma área vazia...", false);
        eastArea1 = new Room("Parece ser uma área vazia...", false);
        westArea1 = new Room("Parece ser uma área vazia...", false);

        northArea2 = new Room("Parece ser uma área vazia...", false);
        northArea3 = new Room("Parece ser uma área vazia...", false);
        northArea4 = new Room("Parece ser uma área vazia...", false);
        northArea5 = new Room("Parece ser uma área vazia...", false);
        northArea6 = new Room("Parece haver algo aqui...", true);
        northArea7 = new Room("Parece ser uma área vazia...", false);
        northArea8 = new Room("Parece ser uma área vazia...", false);
        northArea9 = new Room("Parece ser uma área vazia...", false);
        northArea10 = new Room("Parece haver algo aqui...", true);
        northArea11 = new Room("Parece ser uma área vazia...", false);
        northArea12 = new Room("Parece ser uma área vazia...", false);
        northArea13 = new Room("Parece ser uma área vazia...", false);
        northArea14 = new Room("Parece ser uma área vazia...", false);
        northArea15 = new Room("Parece ser uma área vazia...", false);
        northArea16 = new Room("Parece ser uma área vazia...", false);
        northArea17 = new Room("Parece ser uma área vazia...", false);
        northArea18 = new Room("Parece haver algo aqui...", true);

        southArea2 = new Room("Parece ser uma área vazia...", false);
        southArea3 = new Room("Parece ser uma área vazia...", false);
        southArea4 = new Room("Parece ser uma área vazia...", false);
        southArea5 = new Room("Parece haver algo aqui...", true);
        southArea6 = new Room("Parece ser uma área vazia...", false);
        southArea7 = new Room("Parece ser uma área vazia...", false);
        southArea8 = new Room("Parece ser uma área vazia...", false);
        southArea9 = new Room("Parece ser uma área vazia...", false);
        southArea10 = new Room("Parece haver algo aqui...", true);
        southArea11 = new Room("Parece ser uma área vazia...", false);
        southArea12 = new Room("Parece ser uma área vazia...", false);
        southArea13 = new Room("Parece ser uma área vazia...", false);
        southArea14 = new Room("Parece haver algo aqui...", true);
        southArea15 = new Room("Parece ser uma área vazia...", false);
        southArea16 = new Room("Parece ser uma área vazia...", false);
        southArea17 = new Room("Parece ser uma área vazia...", false);
        southArea18 = new Room("Parece ser uma área vazia...", false);

        eastArea2 = new Room("Parece ser uma área vazia...", false);
        eastArea2 = new Room("Parece ser uma área vazia...", false);
        eastArea3 = new Room("Parece ser uma área vazia...", false);
        eastArea4 = new Room("Parece ser uma área vazia...", false);
        eastArea5 = new Room("Parece ser uma área vazia...", false);
        eastArea6 = new Room("Parece haver algo aqui...", true);
        eastArea7 = new Room("Parece ser uma área vazia...", false);
        eastArea8 = new Room("Parece ser uma área vazia...", false);
        eastArea9= new Room("Parece ser uma área vazia...", false);
        eastArea10 = new Room("Parece haver algo aqui...", true);

        westArea2 = new Room("Parece ser uma área vazia...", false);
        westArea3 = new Room("Parece ser uma área vazia...", false);
        westArea4 = new Room("Parece ser uma área vazia...", false);
        westArea5 = new Room("Parece ser uma área vazia...", false);
        westArea6 = new Room("Parece haver algo aqui...", true);
        westArea7 = new Room("Parece ser uma área vazia...", false);
        westArea8 = new Room("Parece ser uma área vazia...", false);
        westArea9 = new Room("Parece ser uma área vazia...", false);
        westArea10 = new Room("Parece ser uma área vazia...", false);
        westArea11 = new Room("Parece ser uma área vazia...", false);
        westArea12 = new Room("Parece haver algo aqui...", true);

        outside = new Room("Até que enfim luz...", false);
        
        // initialise room exits
        unknowAreaMain.setExit("norte", northArea1);
        unknowAreaMain.setExit("sul", southArea1);
        unknowAreaMain.setExit("leste", eastArea1);
        unknowAreaMain.setExit("oeste", westArea1);

        // Ala norte 1
        northArea1.setExit("norte", northArea3);
        northArea1.setExit("sul", unknowAreaMain);
        northArea1.setExit("oeste", northArea2);
        // Ala norte 2
        northArea2.setExit("norte", northArea4);
        northArea2.setExit("leste", northArea1);
        northArea2.setExit("oeste", northArea5);
        // Ala norte 3
        northArea3.setExit("norte", northArea7);
        northArea3.setExit("sul", northArea1);
        northArea3.setExit("leste", northArea8);
        northArea3.setExit("oeste", northArea4);
        // Ala norte 4
        northArea4.setExit("sul", northArea2);
        northArea4.setExit("leste", northArea3);
        // Ala norte 5
        northArea5.setExit("leste", northArea2);
        northArea5.setExit("oeste", northArea6);
        // Ala norte 6 FUEL
        northArea6.setExit("leste", northArea5);
        // Ala norte 7
        northArea7.setExit("norte", northArea9);
        northArea7.setExit("sul", northArea3);
        // Ala norte 8
        northArea8.setExit("leste", northArea10);
        northArea8.setExit("oeste", northArea3);
        // Ala norte 9
        northArea9.setExit("sul", northArea7);
        northArea9.setExit("leste", northArea12);
        northArea9.setExit("oeste", northArea11);
        // Ala norte 10 FUEL
        northArea10.setExit("norte", northArea14);
        northArea10.setExit("oeste", northArea8);
        // Ala norte 11
        northArea11.setExit("leste", northArea9);
        northArea11.setExit("oeste", northArea13);
        // Ala norte 12
        northArea12.setExit("leste", northArea14);
        northArea12.setExit("oeste", northArea9);
        // Ala norte 13
        northArea13.setExit("sul", northArea17);
        northArea13.setExit("leste", northArea11);
        northArea13.setExit("oeste", westArea11);
        // Ala norte 14
        northArea14.setExit("sul", northArea15);
        northArea14.setExit("leste", northArea16);
        northArea14.setExit("oeste", northArea12);
        // Ala norte 15
        northArea15.setExit("norte", northArea14);
        northArea15.setExit("sul", northArea10);
        // Ala norte 16
        northArea16.setExit("oeste", northArea14);
        // Ala norte 17
        northArea17.setExit("norte", northArea13);
        northArea17.setExit("sul", northArea18);
        // Ala norte 18 FUEL
        northArea18.setExit("norte", northArea17);



        // Ala sul 1
        southArea1.setExit("norte", unknowAreaMain);
        southArea1.setExit("sul", southArea11);
        southArea1.setExit("oeste", southArea2);
        // Ala sul 2
        southArea2.setExit("sul", southArea3);
        southArea2.setExit("leste", southArea1);
        southArea2.setExit("oeste", southArea4);
        // Ala sul 3
        southArea3.setExit("norte", southArea2);
        southArea3.setExit("sul", southArea6);
        // Ala sul 4
        southArea4.setExit("sul", southArea5);
        southArea4.setExit("leste", southArea2);
        // Ala sul 5 FUEL
        southArea5.setExit("norte", southArea4);
        // Ala sul 6
        southArea6.setExit("norte", southArea3);
        southArea6.setExit("sul", southArea7);
        southArea6.setExit("leste", southArea8);
        // Ala sul 7
        southArea7.setExit("norte", southArea6);
        southArea7.setExit("oeste", southArea9);
        // Ala sul 8
        southArea8.setExit("norte", southArea11);
        southArea8.setExit("leste", southArea12);
        southArea8.setExit("oeste", southArea6);
        // Ala sul 9
        southArea9.setExit("leste", southArea7);
        southArea9.setExit("oeste", southArea10);
        // Ala sul 10 FUEL
        southArea10.setExit("leste", southArea9);
        // Ala sul 11
        southArea11.setExit("norte", southArea1);
        southArea11.setExit("sul", southArea8);
        southArea11.setExit("leste", southArea13);
        // Ala sul 12
        southArea12.setExit("sul", southArea14);
        southArea12.setExit("leste", southArea15);
        southArea12.setExit("oeste", southArea8);
        // Ala sul 13
        southArea13.setExit("oeste", southArea11);
        // Ala sul 14 FUEL
        southArea14.setExit("norte", southArea12);
        // Ala sul 15
        southArea15.setExit("leste", southArea16);
        southArea15.setExit("oeste", southArea12);
        // Ala sul 16
        southArea16.setExit("norte", southArea17);
        southArea16.setExit("leste", southArea18);
        southArea16.setExit("oeste", southArea15);
        // Ala sul 17
        southArea17.setExit("sul", southArea16);
        // Ala sul 18
        southArea18.setExit("sul", outside);
        southArea18.setExit("oeste", southArea16);



        // Ala leste 1
        eastArea1.setExit("norte", eastArea2);
        eastArea1.setExit("oeste", unknowAreaMain);
        // Ala leste 2
        eastArea2.setExit("sul", eastArea1);
        eastArea2.setExit("leste", eastArea3);
        // Ala leste 3
        eastArea3.setExit("norte", eastArea4);
        eastArea3.setExit("leste", eastArea5);
        eastArea3.setExit("oeste", eastArea2);
        // Ala leste 4
        eastArea4.setExit("sul", eastArea3);
        // Ala leste 5
        eastArea5.setExit("norte", eastArea6);
        eastArea5.setExit("sul", eastArea7);
        eastArea5.setExit("oeste", eastArea3);
        eastArea5.setExit("leste", eastArea8);
        // Ala leste 6 FUEL
        eastArea6.setExit("sul", eastArea5);
        // Ala leste 7
        eastArea7.setExit("norte", eastArea5);
        // Ala leste 8
        eastArea8.setExit("sul", eastArea9);
        eastArea8.setExit("oeste", eastArea5);
        // Ala leste 9
        eastArea9.setExit("norte", eastArea8);
        eastArea9.setExit("sul", eastArea10);
        // Ala leste 10 FUEL
        eastArea10.setExit("norte", eastArea9);



        // Ala oeste 1
        westArea1.setExit("leste", unknowAreaMain);
        westArea1.setExit("oeste", westArea2);
        //Ala oeste 2
        westArea2.setExit("sul", westArea3);
        westArea2.setExit("leste", westArea1);
        westArea2.setExit("oeste", westArea4);
        //Ala oeste 3
        westArea3.setExit("norte", westArea2);
        westArea3.setExit("oeste", westArea5);
        //Ala oeste 4
        westArea4.setExit("norte", westArea6);
        westArea4.setExit("leste", westArea2);
        //Ala oeste 5 FUEL
        westArea5.setExit("leste", westArea3);
        //Ala oeste 6
        westArea6.setExit("norte", westArea7);
        westArea6.setExit("sul", westArea4);
        //Ala oeste 7
        westArea7.setExit("norte", westArea8);
        westArea7.setExit("sul", westArea6);
        //Ala oeste 8
        westArea8.setExit("sul", westArea7);
        westArea8.setExit("leste", westArea9);
        //Ala oeste 9
        westArea9.setExit("norte", westArea10);
        westArea9.setExit("oeste", westArea8);
        //Ala oeste 10
        westArea10.setExit("norte", westArea11);
        westArea10.setExit("sul", westArea9);
        //Ala oeste 11
        westArea11.setExit("sul", westArea10);
        westArea11.setExit("leste", northArea13);
        westArea11.setExit("oeste", westArea12);
        //Ala oeste 12 FUEL
        westArea12.setExit("leste", westArea11);

        currentRoom = unknowAreaMain;  // start game outside
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
        while (!finished) {
            if(!lose){
                Command command = parser.getCommand();
                finished = processCommand(command);
            }
            else{
                finished = true;
            }
        }
        System.out.println(printFinish + "Obrigado por jogar No Light. Tchau.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("\nBem vindo a No Light!");
        System.out.println("No Light é um jogo que você terá encontrar a saída de uma caverna assustadora, mas cuidado, a luz pode acabar...\n");
        System.out.println("Digite '" + CommandWord.HELP + "' se você precisar de ajuda.\n");
        System.out.println("=================================================================================");
        System.out.println(currentRoom.getLongDescriptionWelcome());
        System.out.println(currentRoom.getLongDescription() + fuelCount.printFuel());
        System.out.println("");
        currentRoom.printRoom();
        System.out.println("");
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        switch (commandWord) {
            case UNKNOWN:
                System.out.println("Eu não estendi oque você quer fazer...");
                break;

            case HELP:
                printHelp();
                break;

            case GO:
                goRoom(command);
                break;

            case QUIT:
                wantToQuit = quit(command);
                break;
        }
        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("Está perdido? Está só?");
        System.out.println();
        System.out.println("Você pode usar estes comandos:");
        parser.showCommands();
    }

    /** 
     * Try to go in one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Ir pra onde?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("Por aqui não tem saida!");
        }
        else {
            currentRoom = nextRoom;

            if(currentRoom.getShortDescription() != "Até que enfim luz..."){
                boolean isReduce = true;

                if(currentRoom.getIsFuel()){
                    fuelCount.addFuel();
                    currentRoom.changeValue(fuelCount.valueAcc());

                    isReduce = false;
                }

                if(isReduce) fuelCount.reduceFuel();
    
                System.out.println(currentRoom.getLongDescription() + fuelCount.printFuel());
                System.out.println("");
                currentRoom.printRoom();
                System.out.println("");
    
                if(currentRoom.getIsFuel()){
                    fuelCount.upRoomStats(currentRoom);
                }
    
                if(fuelCount.getFuel() == 0){
                    youLost();
                }
            }
            else{
                System.out.println(currentRoom.getShortDescription());

                youWon();
            }
        }
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Sair daonde?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }

    private void youLost(){
        printFinish = "\nVocê perdeu! ";

        lose = true;
    }

    private void youWon(){
        printFinish = "\nParabéns! Parece que você escapou da caverna! ";

        lose = true;
    }
}
