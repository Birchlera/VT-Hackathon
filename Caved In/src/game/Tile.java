package game;

public abstract class Tile
{
    private boolean walkable;
    private String type;
    
    protected Tile(boolean walk, String typ)
    {
        walkable = walk;
        type = typ;
    }
    public boolean isWalkable()
    {
        return walkable;
    }
    public String type()
    {
        return type;
    }
    protected abstract void onStep();
    protected abstract void onInteract();
    public String getType()
    {
        return type;
    }
}
