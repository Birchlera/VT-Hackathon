
public class CharWalker
{
    private int x;
    private int y;
    private int lastx;
    private int lasty;
    private char facing;
    private boolean sex;
    
    public CharWalker(int xset, int yset)
    {
        x = xset;
        y = yset;
        lasty = y;
        lastx = x;
        facing = 's';
        sex = true;
    }
    public void move(int dir)
    {
        lasty = y;
        lastx = x;
        if(dir == 0)
        {
            y++;
            facing = 's';
        }
        if(dir == 1)
        {
            y--;
            facing = 'n';
        }
        if(dir == 2)
        {
            x--;
            facing = 'w';
        }
        if(dir == 3)
        {
            x++;
            facing = 'e';
        }
        ((MapScreen)EngMain.panels.Map()).update();
    }
    public int getx()
    {
        return x;
    }
    public int gety()
    {
        return y;
    }
    public void setx(int xnew)
    {
        lastx = x;
        x = xnew;
    }
    public void sety(int ynew)
    {
        lasty = y;
        y = ynew;
    }
    public char facing()
    {
        return facing;
    }
    public int getlasty()
    {
        return lasty;
    }
    public int getlastx()
    {
        return lastx;
    }
    public boolean getSex()
    {
        return sex;
    }
    public void setloc(int i, int j)
    {
        lastx = x;
        lasty = y;
        x = i;
        y = j;
        
    }
}
