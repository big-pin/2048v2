package Bundle;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main 
{
    public static void main(String[] args)
    {
        Process process = null;
        String arch= System.getProperty("os.arch");
        String progPath= System.getenv("ProgramFiles");
        String chromePath="Google\\Chrome\\Application\\chrome.exe";
        String path=progPath+"\\"+chromePath;
        String res=getScreenResolution(true);
        if(arch.equals("amd64"))
        {
            path=progPath+" (x86)\\"+chromePath;
        }
        try {
            process = new ProcessBuilder(path,"--window-size="+res,"--new-window","--window-position=0,0","http://gabrielecirulli.github.io/2048/").start();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Grid grid=new Grid(getScreenResolution());
        log("Created grid.");
        grid.showGrid();
        grid.makeMove();
        grid.sortTiles();
        try {
            Runtime.getRuntime().exec("taskkill /im chrome.exe");
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    static Dimension getScreenResolution()
    {
        return new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
    }
    
    static String getScreenResolution(boolean str)
    {
        return getScreenResolution().width+","+getScreenResolution().height;
    }
    static void log(String msg)
    {
        System.out.println("LOG: "+msg);
    }
    
}