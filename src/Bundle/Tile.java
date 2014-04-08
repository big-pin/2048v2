package Bundle;

import java.awt.Color;
import java.util.ArrayList;

public class Tile implements Comparable<Tile>
{
    private static ArrayList<Color> tileColors;
    Color color;
    int tileValue;
    int x;
    int y;
    int index;
    public Tile(Color c, int x, int y)
    {
        color=c;
        this.x=x;
        this.y=y;
        initTileColors();
        calcTileValue();
    }
    private void calcTileValue()
    {
        index=tileColors.indexOf(color);
        if(index==0)
        {
            tileValue=0;
        }
        else
        {
            tileValue=(int) Math.pow(2, index);
        }
    }
    /** 
     * grid border=187, 173, 160
     * blank tile= 204,192,179
        2 tile= 238,228,218
        4 tile= 237,224,200
        8 tile= 242,177,121]
        16 tile= 245,149,99
        32 tile= 246,124,95
        64 tile= 246,94,59
        128 tile= 237,207,114
        256 tile= 237,204,97
        512 tile= 237,200,80
    **/
    private static void initTileColors()
    {  
        tileColors=new ArrayList();
        tileColors.add(new Color(204,192,179));
        tileColors.add(new Color(238,228,218));
        tileColors.add(new Color(237,224,200));
        tileColors.add(new Color(242,177,121));
        tileColors.add(new Color(245,149,99));
        tileColors.add(new Color(246,124,95));
        tileColors.add(new Color(246,94,59));
        tileColors.add(new Color(237,207,114));
        tileColors.add(new Color(237,204,97));
        tileColors.add(new Color(237,200,80));
    }
    public Color getColor()
    {
        return color;
    }
    public int getTileValue()
    {
        return tileValue;
    }
    public int getX()
    {
        return x;
    }
    public int getY()
    {
        return y;
    }
    public int getIndex()
    {
        return index;
    }
    @Override
    public String toString()
    {
        return getTileValue()+" tile @ "+ getX()+","+getY()+" index:"+getIndex();
    }
    private static void log(String msg)
    {
        System.out.println("LOG: "+msg);
    }

    @Override
    public int compareTo(Tile t) 
    {
        if(getTileValue()>t.getTileValue())
        {
            return 1;
        }
        else if(getTileValue()==t.getTileValue())
        {
            return 0;
        }
        else
        {
            return -1;
        }
    }
    
}
