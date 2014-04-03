package Bundle;

import java.awt.Color;
import java.util.ArrayList;

public class Tile
{
    private ArrayList<Color> tileColors;
    Color color;
    int tileValue;
    int x;
    int y;
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
        int index=tileColors.indexOf(color);
        if(index==0)
        {
            tileValue=0;
        }
        else
        {
            tileValue=2^index;
        }
    }
    private void initTileColors()
    {
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
}
