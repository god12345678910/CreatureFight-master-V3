import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class TextBox here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TextBox extends Actor
{
    private GreenfootImage img;
    private boolean border = false;
    private String text;
    private int fontSize;
    private Color foreground;
    private Color background;
    
    public TextBox( String message, int fs, boolean hasborder, Color fg, Color bg )
    {
        fontSize = fs;
        border = hasborder;
        foreground = fg;
        background = bg;
        text = message;
        
        img = new GreenfootImage( message, fontSize, foreground, background );
        
        display();
    }
   
    /**
     * display. it displays the the Color
     * 
     * @param there are no parameters
     * @return there is nothing returned
     */
    private void display()
    {   
        if( border == true )
        {
            img.setColor( Color.BLACK );
            img.drawRect( 0, 0, img.getWidth() - 1, img.getHeight() - 1 );
          
        }
        
        setImage( img );
    }
    /**
     * getText diplays text in the world
     * 
     * @param there are no parameters
     * @return it returns the text.
     */
    public String getText()
    {
        return text;
    }
    
    /**
     * setText it prepare the text, fontSize, foreground, background
     * 
     * @param is a string message
     * @return there is nothing returned
     */
    public void setText( String message )
    {
        text = message;
        img = new GreenfootImage( text, fontSize, foreground, background );
        display();
    }
    
    /**
     * Act - do whatever the TextBox wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
