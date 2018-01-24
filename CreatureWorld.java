import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import javax.swing.JOptionPane;
import java.util.List;

/**
 * Name: ChukwuDalu Onwuekwe
 * Course: CS20S
 * Teacher: Mr. Hardman
 * Lab #2, Program #1
 * Date Last Modified: 12/14/17
 * 
 * Mark: 2/5
 * -0.5 Mark: Comment block not update for assignment 3
 * -1.5 Marks: Indentation issues
 * -1 Mark: Missing if statements for adding playerOneMenus and playerTwoMenus
 *
 */

public class CreatureWorld extends World
{
    private String playerOneCreature;
    private String playerTwoCreature;
    private boolean playerOneTurn;
    private String playerOneName;
    private String playerTwoName;
    private Menu oneFightMenu;
    private Menu oneSwitchMenu;
    private Menu twoFightMenu;
    private Menu twoSwitchMenu;
    private boolean start;
    private boolean playerOneMenusAdded;
    private boolean playerTwoMenusAdded;
    private Creature[] playerOneCreatures;
    private Creature[] playerTwoCreatures;
    /**
     * Default constructor for objects of class MyWorld.
     * 
     * @param There are no parameters
     * @return an object of class MyWorld
     */
    public CreatureWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(400, 400, 1); 
        playerOneCreatures = new Creature[] { new Charmander(this), new Golem(this), new Ivysaur(this)};
        playerTwoCreatures = new Creature[] { new Pikachu(this), new Lapras(this), new Pidgeot(this)};

        start = true;
        playerOneCreature = "Charmander";
        playerTwoCreature = "Pikachu";
        prepareCreatures();
        Greenfoot.start();
    }

    /**
     * prepareCreature get the image of the creature
     * 
     * @param There Are no parameters 
     * @return nothing is returned
     */
    private void prepareCreatures()
    {
        for( int i = 0; i <playerOneCreatures.length; i++)
        {
            if(i == 0)
            {
                addObject(playerOneCreatures[i], playerOneCreatures[i].getImage().getWidth()/2, getHeight() - playerOneCreatures[i].getImage().getHeight()/2);
            } 
            else
            { 
                playerOneCreatures[i].getImage().setTransparency(0);

                addObject( playerOneCreatures[i], 0, getHeight() - playerOneCreatures[i].getImage().getHeight()/2);
            }
        }
        for( int j = 0; j <playerTwoCreatures.length; j++)
        {
            if(j == 0)
            {
                addObject(playerTwoCreatures[j], getWidth() - playerTwoCreatures[j].getImage().getWidth()/2, playerTwoCreatures[j].getImage().getHeight()/2);
            } 
            else
            { 
                playerTwoCreatures[j].getImage().setTransparency(0);

                addObject( playerTwoCreatures[j], getWidth(), playerTwoCreatures[j].getImage().getHeight()/2);
            }
        }
    }

    /**
     * Creature getPlayerOne is the that gets currentplayerone
     *
     * @param there are no parameters
     * @return nothing is being returned
     */
    public Creature getPlayerOne()
    {
        Creature currentPlayerOne;
        if( playerOneCreature.equalsIgnoreCase("Charmander") )
        {   
            currentPlayerOne = playerOneCreatures[0];
        }
        else if(playerOneCreature.equalsIgnoreCase("Golem") )
        {
            currentPlayerOne = playerOneCreatures[1];
        }
        else
        {
            currentPlayerOne = playerOneCreatures[2];
        }
        return currentPlayerOne;
    }

     /**
     * Creature getPlayerTwo is the that gets currentplayertwo
     *
     * @param there are no parameters
     * @return nothing is being returned
     */
    public Creature getPlayerTwo()
    {
        Creature currentPlayerTwo;
        if( playerTwoCreature.equalsIgnoreCase("Pikachu") )
        {   
            currentPlayerTwo = playerTwoCreatures[0];
        }
        else if(playerTwoCreature.equalsIgnoreCase("Lapras") )
        {
            currentPlayerTwo = playerTwoCreatures[1];
        }
        else
        {
            currentPlayerTwo = playerTwoCreatures[2];
        }
        return currentPlayerTwo;
    }

    public void changePlayerOne(String creature)
    {
        playerOneCreature = creature;
        removeObject(oneFightMenu);
        removeObject(oneSwitchMenu);
        playerOneMenusAdded = false;
    }

    public void changePlayerTwo(String creature)
    {
        playerTwoCreature = creature;
        removeObject(twoFightMenu);
        removeObject(twoSwitchMenu);
        playerTwoMenusAdded = false;
    }

     /**
     * getNewoneCreature is the code that get a new playerTwocreature
     *
     * @param The params are Int index
     * @return playeroneCreatures are being returned
     */
    public Creature getNewOneCreature(int index)
    {
        return playerOneCreatures[index];
    }

     /**
     * getNewTwoCreature is the code that get a new playerTwocreature
     *
     * @param The params are Int index
     * @return playerTwoCreatures are being returned
     */
    public Creature getNewTwoCreature(int index)
    {   
        return playerTwoCreatures[index];
    }

    /**
    * isPlayerOneTurn is when the code tells the computer it is player one turn
    * 
    * @param there is parameters
    * @return playerOneturn is being returned
    */
    public boolean isPlayerOneTurn()
    {
        //Indentation issues
        return playerOneTurn; 
    }
    
    /**
     *  seturnTurnNumber is the code that 
     *  
     *  @param There are no parameters
     *  @return nothing is return
     */
    public void setTurnNumber(boolean turn)
    {
        playerOneTurn = turn;
    }

    /**
     * act will complete actions that the CreatureWorld object should
     * accomplish while the scenario is running
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    public void act()
    {
        List allObjects = getObjects(null);
        boolean playerOneLose = true;
        boolean playerTwoLose = true;
        if( start == true )
        {
            playerOneName = JOptionPane.showInputDialog(" Player One, please enter your name:", null);          
            playerTwoName = JOptionPane.showInputDialog(" Player Two, please enter your name:", null);           
            start = false;
            playerOneTurn = true;
        }
        else if(playerOneTurn == true )
        {
            showText(playerOneName + "it's your Turn", getWidth() / 2, getHeight() / 2 );
            showText( "" , getWidth() /2, getHeight()/2 + 26);
        }
        else
        {
            showText(playerTwoName + "it's your Turn" , getWidth() / 2, getHeight() / 2);
            showText( "" , getWidth() /2, getHeight()/2 + 26);
        }

        //You should have two if statements here for adding playerOneMenus and playerTwoMenus
        if(playerOneMenusAdded == false)
        {
            if(playerOneCreature.equalsIgnoreCase("Charmander") )
            {
                oneFightMenu = new  Menu( " Fight ", " Scratch \n Flamethrower ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new FightCommands() );
                oneSwitchMenu = new Menu( " Switch ", " Golem \n Ivysaur ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new SwitchCommands() );
            }
            else if(playerOneCreature.equalsIgnoreCase("Golem") )
            {
                oneFightMenu = new  Menu( " Fight ", " Tackle \n Earthquake ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new FightCommands() );
                oneSwitchMenu = new Menu( " Switch ", " Charmander \n Ivysaur ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new SwitchCommands() );
            }
            else
            {
                oneFightMenu = new  Menu( " Fight ", " Tackle \n Razor Leaf ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new FightCommands() );
                oneSwitchMenu = new Menu( " Switch ", " Charmander \n Golem ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new SwitchCommands() );
            }
            
            addObject( oneFightMenu, 177, getHeight() - 100);
            addObject( oneSwitchMenu, 241, getHeight() - 100);
            playerOneMenusAdded = true ;
        }

        if(playerTwoMenusAdded == false )
        {
            if(playerTwoCreature.equalsIgnoreCase("Pikachu") )
            {
                twoFightMenu = new  Menu( " Fight ", " Tackle \n Thunderbolt ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new FightCommands() );
                twoSwitchMenu = new Menu( " Switch ", " Lapras \n Pidgeot ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new SwitchCommands() );
            }
            else if(playerTwoCreature.equalsIgnoreCase("Lapras") )
            {
                twoFightMenu = new  Menu( " Fight ", " Tackle \n Hydro Pump ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new FightCommands() );
                twoSwitchMenu = new Menu( " Switch ", " Pikachu \n Pidgeot ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new SwitchCommands() );
            }
            else
            {
                twoFightMenu = new  Menu( " Fight ", " Tackle \n Wing Attack ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new FightCommands() );
                twoSwitchMenu = new Menu( " Switch ", " Pikachu \n Lapras ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new SwitchCommands() );
            }
            
            addObject(twoFightMenu, 135, 75);
            addObject(twoSwitchMenu, 199, 75);
            playerTwoMenusAdded = true;

        }

        for( int i = 0; playerOneLose == true && i < playerOneCreatures.length; i++ )
        {   
            if(playerOneCreatures[i].getHealthBar().getCurrent()>0)
            {
                playerOneLose = false;
            }
        }

        for( int i = 0; playerTwoLose == true && i < playerTwoCreatures.length; i++ )
        {   
            if(playerTwoCreatures[i].getHealthBar().getCurrent()>0)
            {
                playerTwoLose = false;
            }
        }

        if(playerOneLose == true)
        {
            removeObjects(allObjects);
            showText( " Player Two Wins! " , getWidth() / 2, getHeight() / 2);
            showText( "" , getWidth() /2, getHeight()/2 + 26);
            Greenfoot.stop();
        }

        if(playerTwoLose == true )
        {
            removeObjects(allObjects);
            showText( " Player One Wins! " , getWidth() / 2, getHeight() / 2);
            showText( "" , getWidth() /2, getHeight()/2 + 26);
            Greenfoot.stop();
        }
    }
}
