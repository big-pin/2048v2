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
    private Tile[][] tiles;
    public Grid(Dimension resolution)
    {
        this.resolution=resolution;
        screenX=resolution.width;
        screenY=resolution.height;
        tiles=new Tile[4][4];
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
                //System.out.println(x+" "+y);
                if(r.getPixelColor(x, y).equals(new Color(187, 173, 160)))
                {
                    log("Found game grid.");
                    area=new Rectangle(700,310,505,500);
                    break xiteration;
                }
            }
        }
    }
    
    public void update()
    {
        int xval=(int) (area.getX()+30);
        int yval=(int) (area.getY()+40);
        for(int x=0;x<4;x++)
        {
            for(int y=0;y<4;y++)
            {
                log(r.getPixelColor(xval,yval).toString());
                tiles[x][y]=new Tile(r.getPixelColor(xval,yval),x,y);
                log("Added tile: "+tiles[x][y].toString()+" >"+xval+","+yval);
                yval+=120; //tile height move row
            }
            yval=(int) (area.getY()+30);
            xval+=120; //move column
        }
    }
    
    public void showGrid()
    {
        update();
        for(int y=0;y<4;y++)
        {
            for(int x=0;x<4;x++)
            {
                //System.out.println(tiles[x][y].toString());
                
                if(x==3)
                {
                    System.out.println("["+tiles[x][y].getTileValue()+"]");
                }
                else
                {
                    System.out.print("["+tiles[x][y].getTileValue()+"]");
                }
            }
        }
    }
    
    public void log(String msg)
    {
        System.out.println("LOG: "+msg);
    }
}
