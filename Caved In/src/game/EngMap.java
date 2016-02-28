package game;

public class EngMap
{
    private Tile[][] layout;
    
    
    public EngMap(int mapID, int dir)
    {
        layout = new Tile[19][15];
        for(int i = 0; i < layout.length; i++)
        {
            for(int j = 0; j < layout[i].length; j++)
            {
                if(((i == 0 || i == layout.length - 1)&& j != 7) ||
                        ((j == 0 || j == layout[i].length - 1)&& i != 9))
                {
                    layout[i][j] = new Wall();
                }
                else if(i == 9 && j == 0)
                {
                    layout[i][j] = new TeleTile(0);
                }
                else if(i == 9 && j == 14)
                {
                    layout[i][j] = new TeleTile(1);
                }
                else if(i == 0 && j == 7)
                {
                    layout[i][j] = new TeleTile(2);
                }
                else if(i == 18 && j == 7)
                {
                    layout[i][j] = new TeleTile(3);
                }
                else 
                {
                    layout[i][j] = new Floor();
                }
            }
        }
        if(mapID != 0)
        {
            layout[3][3] = new Wall();
        }
        if (dir == 0)
        {
            EngMain.chara.setloc(9, 13);
        }
        else if (dir == 1)
        {
            EngMain.chara.setloc(9, 1);
        }
        else if (dir == 2)
        {
            EngMain.chara.setloc(1, 7);
        }
        else if (dir == 3)
        {
            EngMain.chara.setloc(17, 7);
        }
        else{
            EngMain.chara.setloc(9, 7);
        }
    }
    public void move(int dir)
    {
        if (dir == 0 && layout[EngMain.chara.getx()][EngMain.chara.gety()+1].isWalkable())
        {
            EngMain.chara.move(dir);
            layout[EngMain.chara.getx()][EngMain.chara.gety()].onStep();
        }
        else if (dir == 1 && layout[EngMain.chara.getx()][EngMain.chara.gety()-1].isWalkable())
        {
            EngMain.chara.move(dir);
            layout[EngMain.chara.getx()][EngMain.chara.gety()].onStep();
        }
        else if (dir == 2 && layout[EngMain.chara.getx()-1][EngMain.chara.gety()].isWalkable())
        {
            EngMain.chara.move(dir);
            layout[EngMain.chara.getx()][EngMain.chara.gety()].onStep();
        }
        else if (dir == 3 && layout[EngMain.chara.getx()+1][EngMain.chara.gety()].isWalkable())
        {
            EngMain.chara.move(dir);
            layout[EngMain.chara.getx()][EngMain.chara.gety()].onStep();
        }
        else
        {
            return;
        }

    }
    public void enter(int loc)
    {
        
    }
    public String[][] getLayout()
    {
        String[][]ret = new String[19][15];
        for(int i = 0; i < layout.length; i++)
        {
            for(int j = 0; j < layout[i].length; j++)
            {
            ret[i][j] = layout[i][j].getType();
            }
        }
        return ret;
    }
    public void interact(int x, int y)
    {
        layout[x][y].onInteract();
    }
}
