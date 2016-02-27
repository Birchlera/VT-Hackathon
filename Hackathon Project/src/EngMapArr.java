
public class EngMapArr
{
    private EngMap[][] maps;
    private int x, y;
    private int[] count;

    public EngMap getCurrent()
    {
        return maps[x][y];
    }

    public EngMap getHome()
    {
        return maps[12][12];
    }

    public EngMapArr()
    {
        maps = new EngMap[25][25];
        maps[12][12] = new EngMap(0, -1);
        count = new int[50];
        for (int i = 0; i < count.length; i++)
        {
            count[i] = 0;
        }
        count[0] = 1;
    }

    public void go(char c)
    {
        if (c == 'n')
        {
            EngMain.chara.sety(1);
            y--;
            if (y < 0)
            {
                y = 24;
            }
        } else if (c == 's')
        {
            EngMain.chara.sety(13);
            y++;
            if (y > 24)
            {
                y = 0;
            }
        } else if (c == 'e')
        {
            EngMain.chara.setx(1);
            x++;
            if (x > 24)
            {
                x = 0;
            }
        } else if (c == 'w')
        {
            EngMain.chara.setx(17);
            x--;
            if (x < 0)
            {
                x = 24;
            }
        }
        if (maps[x][y] == null && c != '*')
        {
            maps[x][y] = generateMap(c);
        }
        else if (maps[x][y] == null && c == '*')
        {
            maps[x][y] = generateMap(c);
            return;
        }
        ((MapScreen)(EngMain.panels.Map())).go(maps[x][y]);
    }

    private EngMap generateMap(char c)
    {
        int id = 0;
        boolean bool = true;
        while (bool)
        {
            id = (int) (49 * Math.random());
            bool = false;
            if (id < 10 && count[id] > 0)
            {
                bool = false;
            }
        }
        int dir = -1;
        if(c == 'n')
        {
            dir = 0;
        }
        else if(c == 's')
        {
            dir = 1;
        }
        else if(c == 'e')
        {
            dir = 2;
        }
        else if(c == 'w')
        {
            dir = 3;
        }
        else if(c == '*')
        {
            id = 0;
        }
        EngMap map = new EngMap(id, dir);
        count[id]++;
        return map;
    }
}
