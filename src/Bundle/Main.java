package Bundle;

public class Main 
{
    
    /** 
     * grid=187, 173, 160
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
    
    public static void main(String[] args) throws InterruptedException 
    {
        Thread.sleep(2500);
        Grid grid=new Grid(getScreenResolution());
    }
    
    static java.awt.Dimension getScreenResolution()
    {
        return new java.awt.Dimension(java.awt.Toolkit.getDefaultToolkit().getScreenSize());
    }
    
    
}