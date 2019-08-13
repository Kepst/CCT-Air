package cctair;

/**
 * Creation of the class pilot
 * @author Pedro, Rafa e Kate
 */
public class Pilot
{
    private String name;
    private String specialty[];

    /**
     * Creation of the method pilot with it's parameters
     * @param name
     * @param specialty 
     */
    Pilot(String name, String specialty[])
    {
        this.name = name;
        this.specialty = specialty;
    }
    
/**
 * Creation of the getters and setters
 * @return 
 */
    public String getName()
    {
        return name;
    }

    public String[] getSpeciality()
    {
        return specialty;
    }

    public void setSpecialty(String specialty[])
    {
        this.specialty = specialty;
    }

    /**
     * @param specialty String of the new specialty
     * 
     * Creates a new array that is one size bigger than the one we already had
     * This is done to store the new specialty.
     */
    public void addSpeciality(String specialty)
    {
        String new_specialty[] = new String[this.specialty.length + 1];
        for (int i = 0; i < this.specialty.length; i++)
        {
            new_specialty[i] = this.specialty[i];
        }
        new_specialty[new_specialty.length] = specialty;
    }

/**
 * Overwriting super class by daughter class
 * @return the parameters
 */
    @Override
    public String toString()
    {
        return this.name;
    }

}
