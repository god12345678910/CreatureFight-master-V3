import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.JOptionPane;
/**
 * Write a description of class MyWorld here.
 * CS20S
 * Dalu Onwuekwe 
 *OCT.2.17  */
public class Lapras extends Creature
{
    public Lapras( World w)
    {
        super(900, false , "water");
        getImage(). scale (150,100);
        w.addObject( getHealthBar(),143, 31);
        getHealthBar().getImage().setTransparency(0);
    }

    /**
     * Act - do whatever the Pikachu wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        CreatureWorld playerWorld = (CreatureWorld)getWorld();
        if ( getHealthBar().getCurrent() <= 0)
        {
            getWorld().showText("Lapras has fainted…", getWorld().getWidth()/2, getWorld().getHeight()/2+26);
            Greenfoot.delay(30);

            if(playerWorld.getNewTwoCreature(1).getHealthBar().getCurrent() > 0)
            {
                switchCreature(0);
                playerWorld.setTurnNumber(false);
                getWorld().showText("",getWorld().getWidth()/2,getWorld().getHeight()/2 + 26);
                getWorld().removeObject(this);
            }
            else if((playerWorld.getNewTwoCreature(2).getHealthBar().getCurrent() > 0))
            {
                switchCreature(1);
                playerWorld.setTurnNumber(false);
                getWorld().showText("",getWorld().getWidth()/2,getWorld().getHeight()/2 + 26);
                getWorld().removeObject(this);
            }
        }
    }

     /**
     * void attack is when the creature attacks. 
     * 
     * @param is a int idx
     * @return there is nothing to return
     */
    public void attack(int idx)
    {
        //Indentation issues
        CreatureWorld world=(CreatureWorld)getWorld();
        Creature enemy = world.getPlayerOne();
        String enemyType =enemy.getType();
        attackAnimation();
        if( idx == 0)
        {
            //Indentation issues
            enemy.getHealthBar().add(-30);
            //Indentation issues
        }
        else
        {
            if(enemyType.equalsIgnoreCase("Fire"))
            {
                enemy.getHealthBar().add(-100* 2);
                getWorld().showText("it super effective",getWorld().getWidth()/2,getWorld().getHeight()/2 +26);
                Greenfoot.delay(30);
            }
            else if(enemyType.equalsIgnoreCase("Rock"))
            {
                enemy.getHealthBar().add(-100*2);
                getWorld().showText("it's super effective",getWorld().getWidth()/2,getWorld().getHeight()/2 +26);
                Greenfoot.delay(30);
            }
            else if(enemyType.equalsIgnoreCase("Grass"))
            {
                enemy.getHealthBar().add(-100/2);
                getWorld().showText("it's not very effective",getWorld().getWidth()/2,getWorld().getHeight()/2 +26);
                Greenfoot.delay(30);
            }
            
            else
            {
                enemy.getHealthBar().add(-100);
            }
        }
        world.setTurnNumber(true);
    }
    
     /**
     * attackAnimation is the animation in an attack.
     * 
     * @param there are no param
     * @return there is nothing to return
     */
    private void attackAnimation()
    {
        int originalX = getX();
        int originalY = getY();
        for(int i = 0; i < 15; i++)
        {
            setLocation(getX() - 1, getY() + 2 );
            Greenfoot.delay(1);
        }
        setLocation(originalX,originalY);
    }

     /**
     * switchCreature switch the creatures
     * 
     * @param is int idx
     * @return there is nothing to return
     */
    public void switchCreature(int idx)
    {
        Creature switchCreature;
        CreatureWorld world=(CreatureWorld)getWorld();
        if( idx == 0)
        {
            switchCreature = world.getNewTwoCreature(0);
        }
        else
        {
            switchCreature = world.getNewTwoCreature(2);
        }

        if(switchCreature.getHealthBar().getCurrent() <= 0)
        {   
            JOptionPane.showMessageDialog( null, "This creature has fainted! Please select a different creature." );
        }
        else
        {
            while(getX()< getWorld().getWidth() - 1)
            {
                setLocation(getX() + 5, getY());
                Greenfoot.delay(2);
            }
            getImage().setTransparency(0);
            getHealthBar().getImage().setTransparency(0);
            
            if( idx == 0)
            {
                world.changePlayerTwo("Pikachu");
            }
            else
            {
                world.changePlayerTwo("Pidgeot");
            }
            
            switchCreature.switchedIn();
            world.setTurnNumber(true);
        }
    }

    
    /** 
     * switched whice of the creatures is switched in
     * 
     * @param there are no parameters
     * @return there is nothing to return
     */
    public void switchedIn()
    {
        getImage().setTransparency(255);
        getHealthBar().getImage().setTransparency(255);
        while( getX() > 325)
        {
            setLocation( getX() - 5,getY() );
            Greenfoot.delay(2);
        }
    }
}