package cctair;

public class AirPlane extends AirCraft
{

    private Pilot pilot;
    
   /**
    * This method is using the constructors from it's parent
    */
    public AirPlane(String make, String model, int capacity)
    {
        super(make, model, capacity);
    }
   /**
    * This method is including one more parameter (pilot)
    */
    public AirPlane(String make, String model, int capacity, Pilot pilot)
    {
        super(make, model, capacity);
        this.pilot = pilot;
    }
    
    public Pilot getPilot()
    {
        return pilot;
    }
/**
 * Creation of the object assignPilot
 * @param pilot 
 */
    public void assignPilot(Pilot pilot)
    {
        this.pilot = pilot;
    }
/**
 * Overwriting super class by daughter class
 * @return the parameters
 */
    @Override
    public String toString()
    {
        return "Aircraft: " + make +" "+ model + ", Capacity:" + capacity
                + " seats, Pilot:" + pilot;
    }

}
