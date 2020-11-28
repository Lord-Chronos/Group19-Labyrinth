package constants;

/**
 * Enum defining all the error messages and headers that will be displayed through GUI
 *
 * @author Joseph Omar
 * @version 1.0
 */
public enum ErrorMsg {
    PROFILE_FILE_NOT_FOUND("The profiles save file <profiles.txt> could not be found.\nPlease verify that the file is in the saves folder.\n", "Profiles Not Found"),
    PROFILE_READ_ERROR("The profiles save file <profiles.txt> could not be read.\nPlease verify all game files.\n", "Profiles Read Error"),
    PROFILE_WRITE_ERROR("The profiles save file <profiles.txt> could not be written.\nPlease verify all game files and directories.\n", "Profiles Write Error"),
    PROFILE_LOAD_ERROR("The profiles save file <profiles.txt> could not be parsed\n", "Profile Parse Error"),
    PROFILE_ADD_ERROR("That nickname is already taken, please choose a new one\n", "Cannot Create Profile"),
    FXML_NOT_FOUND("The FXML file for this window cannot be found.\nPlease verify game files and directories.\n", "FXML Not Found"),
    SAVE_WRITE_ERROR("The game could not be written to a file\n", "Savegame Write Error"),
    SAVE_READ_ERROR("The savegame selected could not be parsed\n", "Savegame Parse Error"),
    SAVE_LOAD_ERROR("The savegame selected could not be loaded\n", "Savegame Load Error"),
    SAVE_FILE_NOT_FOUND("The savegame selected could not be found\n", "Savegame File Path Error"),
    SAVE_NOT_SELECTED("You have not selected a save file to load\n", "No Savegame Selected");

    private final String MESSAGE;
    private final String HEADER;

    /**
     * Errormsg Constructor
     *
     * @param message Message to be displayed
     * @param header  Header to be displayed
     */
    ErrorMsg(String message, String header) {
        this.MESSAGE = message;
        this.HEADER = header;
    }

    /**
     * Gets message
     *
     * @return message
     */
    public String getMessage() {
        return this.MESSAGE;
    }

    /**
     * Gets Header Text
     *
     * @return header
     */
    public String getHeader() {
        return this.HEADER;
    }
}