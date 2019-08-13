package cctair;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Creation of the class CCTAir
 *
 * @author Pedro, Rafa e Kate
 */
public class CCTAir
{

    public static void main(String[] args)
    {

        ArrayList<AirPlane> fleet;
        ArrayList<Flight> schedule;
        ArrayList<Pilot> pilots;

        Setup setup = new Setup();

        pilots = setup.getPilots();
        fleet = setup.getFleet();
        schedule = setup.getFlights();

        System.out.println("How many flights do you want to add? (max 5)\n"
                + "PS: Any number bigger than 5 will be considered as 5");
        int amount = getInt();
        amount = (amount < 5) ? amount : 5;

        for (int i = 0; i < amount; i++)
        {
            Flight flight = createFlight(fleet);
            schedule.add(flight);
        }

        runMenu(schedule);
    }

    /**
     * Creation of the Flights asking the quantity of flights, date and time,
     * arrival and departure and checking if it's values matches with the
     * correct format set
     *
     * @param fleet
     * @return
     */
    static Flight createFlight(ArrayList<AirPlane> fleet)
    {

        for (int j = 0; j < fleet.size(); j++)
        {
            System.out.println(j + ": " + fleet.get(j));
        }
        System.out.println("Type the number of your AirPlane choice");
        int plane;
        while (true)
        {
            plane = getInt();
            if (plane > 0 && plane < fleet.size())
            {
                break;
            }
            System.out.println("Invalid choice, try again");
        }

        String origin = "";
        String destination = "";
        String departure;
        String arrival;
        int month = 0;
        int day = 0;
        int year;
        Flight flight;

        while (origin.equals(destination))
        {
            System.out.println("Origin and destination cannot be the same place");
            System.out.println("Choose an origin");
            origin = getInput(); // User chooses the origin.
            System.out.println("Choose destination");
            destination = getInput(); // User chooses the destination.
        }

        System.out.println("Choose a date");
        System.out.println("Choose a month for the flight");
        while (true)
        {
            month = getInt();

            if (month >= 1 && month <= 12)
            {
                break;
            }
            System.out.println("Invalid month, try again");
        }

        System.out.println("Choose a day for the flight");
        while (true)
        {
            day = getInt();
            if (day >= 1 && day <= 28)
            {
                break;
            } else if ((month == 4 || month == 6 || month == 9 || month == 11)
                    && day >= 1 && day <= 30)
            {
                break;
            } else if (day >= 1 && day <= 31)
            {
                break;
            }
            System.out.println("Invalid day, try again");
        }

        System.out.println("Choose the year of the flight");
        year = getInt();
        String date = day + "/" + month + "/" + year;

        while (true)
        {
            System.out.println("Write the time of the flight departure in 24h format");
            departure = getInput();
            if (departure.matches("([01][\\d]|(2[0-3])):[0-5][\\d]"))
            {
                break;
            }
            System.out.println("Invalid time, try again");
        }

        while (true)
        {
            System.out.println("Write the time of the flight arrival in 24h format");
            arrival = getInput();
            if (arrival.matches("([01][\\d]|(2[0-3])):[0-5][\\d]"))
            {
                break;
            }
            System.out.println("Invalid time, try again");
        }
        flight = new Flight(origin, destination, date, fleet.get(plane));
        flight.schedule(departure, arrival);
        return flight;
    }

    /**
     * Creation of a method to get the number from the user and verify if it's a
     * real number.
     *
     * @return
     */
    static int getInt()
    {
        int result;
        Scanner kb = new Scanner(System.in);
        while (true)
        {
            if (kb.hasNextInt())
            {
                result = kb.nextInt();
                kb.nextLine();
                return result;
            } else
            {
                kb.next();
                System.out.println("Input is not a number, try again");
            }
        }
    }

    /**
     * Creation of a input method that get strings from the user.
     *
     * @return
     */
    static String getInput()
    {
        String result;
        Scanner kb = new Scanner(System.in);
        result = kb.nextLine();
        return result;
    }

    /**
     * Creation of a menu that gives options to modify characteristics of the
     * flights already created if needed.
     *
     * @param schedule
     */
    private static void runMenu(ArrayList<Flight> schedule)
    {

        int choice;
        String departure;
        String arrival;
        Boolean running = true;
        while (running)
        {
            System.out.println("Menu");
            System.out.println("1: List all flghts");
            System.out.println("2: Change the arrival time for one flight");
            System.out.println("3: Change the departure and arrival time for one flight");
            System.out.println("4: Exit");
            choice = getInt();
            switch (choice)
            {
                case 1:
                {
                    for (int i = 0; i < schedule.size(); i++)
                    {
                        System.out.println(i + ": ");
                        System.out.println(schedule.get(i));
                        System.out.println("");
                    }
                    break;
                }
                case 2:
                {
                    System.out.println("What's the flight number?");
                    while (true)
                    {
                        choice = getInt();
                        if (choice > 0 && choice < schedule.size())
                        {
                            break;
                        }
                    }
                    while (true)
                    {
                        System.out.println("Write the time of the flight arrival in 24h format");
                        arrival = getInput();
                        if (arrival.matches("([01][\\d]|(2[0-3])):[0-5][\\d]"))
                        {
                            break;
                        }
                        System.out.println("Invalid time, try again");
                    }
                    schedule.get(choice).schedule(arrival);
                    break;
                }
                case 3:
                {
                    System.out.println("What's the flight number?");
                    while (true)
                    {
                        choice = getInt();
                        if (choice > 0 && choice < schedule.size())
                        {
                            break;
                        }
                    }
                    while (true)
                    {
                        System.out.println("Write the time of the flight departure in 24h format");
                        departure = getInput();
                        if (departure.matches("([01][\\d]|(2[0-3])):[0-5][\\d]"))
                        {
                            break;
                        }
                        System.out.println("Invalid time, try again");
                    }
                    while (true)
                    {
                        System.out.println("Write the time of the flight departure in 24h format");
                        arrival = getInput();
                        if (arrival.matches("([01][\\d]|(2[0-3])):[0-5][\\d]"))
                        {
                            break;
                        }
                        System.out.println("Invalid time, try again");
                    }
                    schedule.get(choice).schedule(arrival, departure);
                    break;
                }
                case 4:
                {
                    running = false;
                }

            }
            System.out.println("");
        }
    }
}
