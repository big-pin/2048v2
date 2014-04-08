package Bundle;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Grid 
{
    private final Dimension resolution;
    private final int screenX;
    private final int screenY;
    private Robot r;
    private Rectangle area;
    private final Tile[][] tiles;
    private final int left=KeyEvent.VK_LEFT;
    private final int right=KeyEvent.VK_RIGHT;
    private final int up=KeyEvent.VK_UP;
    private final int down=KeyEvent.VK_DOWN;
    private ArrayList<Tile> listTiles;
    
    public Grid(Dimension resolution)
    {
        this.resolution=resolution;
        screenX=resolution.width;
        screenY=resolution.height;
        tiles=new Tile[4][4];
        listTiles=new ArrayList();
        init();
    }
    
    private void init()
    {
        area = null;
        int width=(int) ((int)screenX/2.78); //estimate on where to start search for color based on ratio of space between grid and border of chrome window
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
    
    public void readGrid()
    {
        int xval=(int) (area.getX()+30);
        int yval=(int) (area.getY()+40);
        for(int x=0;x<4;x++)
        {
            for(int y=0;y<4;y++)
            {
                //log(r.getPixelColor(xval,yval).toString());
                tiles[x][y]=new Tile(r.getPixelColor(xval,yval),x,y);
                //log("Added tile: "+tiles[x][y].toString()+" >"+xval+","+yval);
                yval+=120; //tile height move row
            }
            yval=(int) (area.getY()+30);
            xval+=120; //move column
        }
    }
    
    public void showGrid()
    {
        readGrid();
        for(int y=0;y<4;y++)
        {
            for(int x=0;x<4;x++)
            {
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
    
    public void sortTiles()
    {
        Tile t;
        int valueTile;
        int valueLastTile=tiles[0][0].getTileValue();
        int indexLastTile;
        int indexLastTileValue;
        boolean firstTile=false;
        for(int x=0;x<3;x++)
        {
            for(int y=0;y<3;y++)
            {
                t=tiles[x][y];
                valueTile=t.getTileValue();
                if(valueTile!=0)
                {
                    listTiles.add(t);
                    firstTile=true;
                }
                if(!firstTile)
                {
                    
                }
            }
        }
        log(listTiles.size());
        for(Tile tile : listTiles)
        {
            log(tile.tileValue);
        }
    }
    
    public void makeMove()
    {
        
    }
    
    public void log(Object msg)
    {
        System.out.println("LOG: "+msg);
    }
}
