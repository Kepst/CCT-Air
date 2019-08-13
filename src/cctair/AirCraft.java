package cctair;

/**
 * Creation of the class AirCraft
 * @author Pedro, Rafa e Kate
 */

public class AirCraft
{

    protected String make;
    protected final String model;
    protected final int capacity;
/**
 * Creation of the object AirCraft and it's related parameters
 */
    public AirCraft(String make, String model, int capacity)
    {
        this.make = make;
        this.model = model;
        this.capacity = capacity;
    }
    
    public String getMake()
    {
        return this.make;
    }

    public String getModel()
    {
        return this.model;
    }

    public int getCapacity()
    {
        return this.capacity;
    }
}
