package Bundle;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Grid 
{
    private final Dimension resolution;
    private final int screenX;
    private final int screenY;
    private Robot r;
    private Rectangle area;
    
    public Grid(Dimension resolution)
    {
        this.resolution=resolution;
        screenX=resolution.width;
        screenY=resolution.height;
        init();
    }
    
    private void init()
    {
        area = null;
        int width=(int) ((int)screenX/2.78); //estimate on where to start search for color
        System.out.println(width);
        try {
            r=new Robot();
        } catch (AWTException ex) {
            Logger.getLogger(Grid.class.getName()).log(Level.SEVERE, null, ex);
        }
        xiteration:
        for(int x=width;x<screenX;x++)
        {
            yiteration:
            for(int y=300;y<320;y++)
            {
                System.out.println(x+" "+y);
                if(r.getPixelColor(x, y).equals(new Color(187, 173, 160)))
                {
                    System.out.println("done");
                    area=new Rectangle(x,y,500,500);
                    break xiteration;
                }
            }
        }
    }
    
    public void update()
    {
        
    }
    
    
}
