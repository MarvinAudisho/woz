package newmain;

public enum CommandWord

{
    // A value for each command word along with its
    // corresponding user interface string.
    GO("go"),OCEANS("oceans"), QUIT("quit"), HELP("help"), MARK("mark"), BACK("back"),INVENTORY("inventory"),GET("get"), UNKNOWN("?"),OCEAN("ocean"), TIME("time");

    // The command string.
    private String commandString;
    
    /**
     * Initialise with the corresponding command string.
     * @param commandString The command string.
     */
    CommandWord(String commandString)
    {
        this.commandString = commandString;
    }
    
    /**
     * @return The command word as a string.
     */
    public String toString()
    {
        return commandString;
    }
}