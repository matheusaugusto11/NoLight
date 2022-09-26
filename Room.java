import java.util.Set;
import java.util.Vector;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  For each existing exit, the room 
 * stores a reference to the neighboring room.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */

public class Room 
{
    private String description;
    private HashMap<String, Room> exits;        // stores exits of this room.
    
    private boolean isFuel;

    private int addValue;

    private int H = 7;
    private int W = 13;

    //private char map[][] = new char[10][10];

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description, boolean isFuel) 
    {
        this.description = description;
        this.isFuel = isFuel;
        exits = new HashMap<>();
    }

    /**
     * Define an exit from this room.
     * @param direction The direction of the exit.
     * @param neighbor  The room to which the exit leads.
     */
    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }

    /**
     * @return The short description of the room
     * (the one that was defined in the constructor).
     */
    public String getShortDescription()
    {
        return description;
    }

    /**
     * Return a description of the room in the form:
     *     You are in the kitchen.
     *     Exits: north west
     * @return A long description of this room
     */
    public String getLongDescription()
    {
        String longDescription;

        if(!isFuel){
            longDescription = "" + description + ".\n" + getExitString();
        }
        else{
            longDescription = "" + description + ". +" + addValue +"%\n" + getExitString();
        }

        return longDescription;
    }

    public void changeValue(int addValue){
        this.addValue = addValue;
    }

    public String getLongDescriptionWelcome()
    {
        return "Cuidado jovem explorador você acaba de cair nessa caverna de total escuridão, agora cabe a você achar a saida.";
    }

    /**
     * Return a string describing the room's exits, for example
     * "Exits: north west".
     * @return Details of the room's exits.
     */
    private String getExitString()
    {
        String returnString = "Saidas:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    public void printRoom(){
        Set<String> keys = exits.keySet();

        char north = 1;
        char south = 1;
        char east = 2;
        char west = 2;

        for(String exit : keys){
            if(exit == "norte"){
                north = 0;
            }
            else if(exit == "sul"){
                south = 0;
            }
            else if(exit == "leste"){
                east = 0;
            }
            else if(exit == "oeste"){
                west = 0;
            }
        }

        char map[][] = {
            {1, 1, 1, 1, 1, north, north, north, 1, 1, 1, 1, 1},
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2},
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2},
            {west, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, east},
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2},
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2},
            {1, 1, 1, 1, 1, south, south, south, 1, 1, 1, 1, 1},
        };

        draw(map);
    }

    private void draw(char map[][]){
        String line = "";

        for(char i = 0; i < H; i++){
            for(char j = 0; j < W; j++){

                switch(map[i][j]){
                    case 0:
                        line += " ";
                        break;
                    case 1:
                        line += "=";
                        break;
                    case 2:
                        line += "|";
                        break;
                }
            }
            System.out.println(line);
            
            line = "";
        }
    }

    public void upRoom(){
        description = "Parece ser uma área vazia... ";
        isFuel = false;
    }

    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     * @param direction The exit's direction.
     * @return The room in the given direction.
     */
    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }

    public boolean getIsFuel(){
        return isFuel;
    }
}