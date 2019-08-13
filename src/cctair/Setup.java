package cctair;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author Pedro, Rafa e Kate
 */
public class Setup
{

    private ArrayList<Pilot> pilots = new ArrayList<>();
    private ArrayList<AirPlane> fleet = new ArrayList<>();
    private ArrayList<Flight> flights = new ArrayList<>();
    private String names[] =
    {
        "Alice", "Barbara", "Carmen", "Diana", "Esthell",
        "Francine", "Grace", "Hannah", "Isadora", "Janet"
    };

    private String[][] models =
    {
        {
            "Boeing", "747", "366"
        },
        {
            "Boeing", "737", "300"
        },
        {
            "Airbus", "A220", "240"
        },
        {
            "Airbus", "A350", "400"
        }
    };

    private String cities[] =
    {
        "Dublin", "Paris", "Frankfurt", "Amsterdan", "London",
        "Praga", "Lisbon", "Barcelona", "Ibisa", "Split"
    };

    /**
     * Creates the fleet of airplanes
     */
    private void createFleet()
    {
        fleet = new ArrayList<>();
        Random rnd = new Random();
        if (pilots.size() != 10) // check if we already have the pilots and if not create then
        {
            createPilots();
        }

        AirPlane plane;
        Boolean pilot_skill;
        Pilot pilot = null;
        for (int i = 0; i < 20; i++) // create 20 airplanes
        {
            pilot_skill = false;
            String randModel[] = models[rnd.nextInt(models.length)];
            String make = randModel[0];
            String model = randModel[1];
            while(!pilot_skill){ // checks if the chosen pilot has the right skill
                pilot = pilots.get(rnd.nextInt(pilots.size()));
                for(String spec: pilot.getSpeciality())
                {
                    if(spec.equals(make)){
                        pilot_skill = true;
                    }
                }
            }
            int capacity = Integer.parseInt(randModel[2]);
            plane = new AirPlane(make, model, capacity, pilot);
            fleet.add(plane);
        }
    }

    /**
     * Creates the pilots
     */
    private void createPilots()
    {
        pilots = new ArrayList<>();
        Pilot pilot;
        int num_spec;
        Random rnd = new Random();
        String specs[];
        for (int i = 0; i < 10; i++)
        {
            num_spec = rnd.nextInt(3);
            switch (num_spec)
            {
                case 0:
                    specs = new String[]
                    {
                        "Airbus"
                    };
                    break;
                case 1:
                    specs = new String[]
                    {
                        "Boeing"
                    };
                    break;
                default:
                    specs = new String[]
                    {
                        "Airbus", "Boeing"
                    };

            }
            pilot = new Pilot(names[i], specs);
            pilots.add(pilot);
        }
        Boolean boeing = false;
        Boolean airbus = false;
        for (Pilot pil : pilots)
        {
            specs = pil.getSpeciality();
            for (String spec : specs)
            {
                if (spec.equals("Boeing"))
                {
                    boeing = true;
                } else if (spec.equals("Airbus"))
                {
                    airbus = true;
                }
            }
        }
        if (!boeing && !airbus) // check if there's at least one pilot capable of piloting each model of airplane
        {
            createPilots();
        }
    }

    /**
     * Creates the flights
     */
    private void createFlights()
    {
        if (fleet.size() != 20) // checks if we have the fleet ready and if not create it
        {
            createFleet();
        }
        flights = new ArrayList<>();
        Random rnd = new Random();

        Flight flight;
        String departure;
        String arrival;
        String date;
        AirPlane plane;
        for (int i = 0; i < 30; i++)
        {
            departure = Integer.toString(rnd.nextInt(24) + 1) + ":"
                    + Integer.toString(rnd.nextInt(6) * 10);
            arrival = Integer.toString(rnd.nextInt(24) + 1) + ":"
                    + Integer.toString(rnd.nextInt(6) * 10);
            date = Integer.toString(rnd.nextInt(28) + 1) + "/"
                    + Integer.toString(rnd.nextInt(12) + 1);
            plane = this.fleet.get(rnd.nextInt(fleet.size()));
            flight = new Flight(arrival, departure, date, plane);
            flight.schedule(departure, arrival);
            flights.add(flight);
        }
    }

    public ArrayList<Pilot> getPilots()
    {
        if (this.pilots.size() != 10)
        {
            createPilots();
        }
        return this.pilots;
    }

    public ArrayList<AirPlane> getFleet()
    {
        if (this.fleet.size() != 20)
        {
            createFleet();
        }
        return this.fleet;
    }

    public ArrayList<Flight> getFlights()
    {
        if (this.flights.size() != 30)
        {
            createFlights();
        }
        return this.flights;
    }
}
