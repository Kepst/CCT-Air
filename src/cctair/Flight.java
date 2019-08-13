package cctair;

/**
 * @author Pedro, Rafa e Kate
 */

public class Flight
{

    private String origin;
    private String destination;
    private String departureTime;
    private String arrivalTime;
    private String dateOfFlight;
    private AirPlane aircraftAssigned;
/**
 * Creation of a new object Flight and association with it's parameters
 * @param origin
 * @param destination
 * @param dateOfFlight
 * @param aircraftAssigned 
 */
    public Flight(String origin, String destination, String dateOfFlight, AirPlane aircraftAssigned)
    {
        this.origin = origin;
        this.destination = destination;
        this.dateOfFlight = dateOfFlight;
        this.aircraftAssigned = aircraftAssigned;
    }
/**
 * Creation of getters for the parameters of the Object Flight
 */
    public String getOrigin()
    {
        return origin;
    }

    public String getDestination()
    {
        return destination;
    }

    public String getDepartureTime()
    {
        return departureTime;
    }

    public String getArrivalTime()
    {
        return arrivalTime;
    }

    public String getDateOfFlight()
    {
        return dateOfFlight;
    }

    public AirPlane getAircraftAssigned()
    {
        return aircraftAssigned;
    }
/**
 * Overwriting super class by daughter class
 * @return the parameters of the object Flight
 */
    @Override
    public String toString()
    {
        return "Flight Information:\nDate: " + dateOfFlight + "\nFrom: "
                + origin + "\nTo: " + destination + "\nDeparture Time: "
                + departureTime + "\nArrival Time: " + arrivalTime + "\n" + aircraftAssigned;
    }
/**
 * Creation of the schedule for flights
 * @param arrivalTime
 * @param departureTime 
 */
    void schedule(String arrivalTime)
    {
        if (validTime(arrivalTime))
        {
            this.arrivalTime = arrivalTime;
        }
    }

    void schedule(String arrivalTime, String departureTime)
    {
        if (validTime(arrivalTime) && validTime(departureTime))
        {
            this.arrivalTime = arrivalTime;
            this.departureTime = departureTime;
        }
    }
/**
 * Definition of the time format
 * @param time
 * @return 
 */
    boolean validTime(String time)
    {
        if (time.length() != 5)
        {
            return false;
        }
        else return time.matches("([01][\\d]|(2[0-3])):[0-5][\\d]");
    }
}