package game;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Listener implements KeyListener
{
    //private EngMain eng;
    private EngMap map;
    private boolean held = false;

    public Listener(EngMap argMap)
    {
        map = argMap;
    }

    @Override
    public void keyPressed(KeyEvent arg0)
    {
        
        int code = arg0.getKeyCode();
        if(code == KeyEvent.VK_W)
        {
            map.move(1);
        }
        else if(code == KeyEvent.VK_S)
        {
            map.move(0);
        }
        else if(code == KeyEvent.VK_A)
        {
            map.move(2);
        }
        else if(code == KeyEvent.VK_D)
        {
            map.move(3);
        }
        if(held){
            return;
        }
        else if(code == KeyEvent.VK_ENTER)
        {
            int x, y;
            x = EngMain.chara.getx();
            y = EngMain.chara.gety();
            if(EngMain.chara.facing()=='n')
                y--;
            if(EngMain.chara.facing()=='s')
                y++;
            if(EngMain.chara.facing()=='e')
                x++;
            if(EngMain.chara.facing()=='w')
                x--;
            ((MapScreen)EngMain.panels.Map()).interact(x, y);
            held = true;
        }
        else if(code == KeyEvent.VK_ESCAPE)
        {
            held = true;
        }

    }

    @Override
    public void keyReleased(KeyEvent arg0)
    {
        held = false;

    }

    @Override
    public void keyTyped(KeyEvent arg0)
    {
        

    }

}
