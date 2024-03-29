package constants;

/**
 * Enum defining all the error messages and headers that will be displayed through GUI
 *
 * @author Joseph Omar
 * @version 1.9
 */
@SuppressWarnings("unused")
public enum ErrorMessage {
    FXML_NOT_FOUND(
            "The FXML file for this window cannot be found.\nPlease verify " +
                    "game files and directories.\n",
            "FXML Not Found"),
    MESSAGE_FAIL("The Message of the Day could not be fetched",
            "Message of the Day Error"),
    PROFILE_ADD_ERROR(
            "That nickname is already taken, please choose a new one\n",
            "Cannot Create Profile"),
    PROFILE_LOAD_ERROR(
            "The profiles save file <profiles.ser> could not be parsed\n",
            "Profile Parse Error"),
    PROFILE_NOT_VALID("You must select a profile",
            "Selected Profile Not Valid"),
    PROFILE_READ_ERROR(
            "The profiles save file <profiles.ser> could not be read.\nPlease" +
                    " verify all game files.\n",
            "Profiles Read Error"),
    PROFILE_WRITE_ERROR(
            "The profiles save file <profiles.ser> could not be written" +
                    ".\nPlease verify all game files " +
                    "and directories.\n", "Profiles Write Error"),
    SAVE_FILE_NOT_FOUND("The saved game selected could not be found\n",
            "Saved game File Path Error"),
    SAVE_LOAD_ERROR("The saved game selected could not be loaded\n",
            "Saved Game Load Error"),
    SAVE_NOT_SELECTED("You have not selected a save file to load\n",
            "No Saved Game Selected"),
    SAVE_READ_ERROR("The saved game selected could not be parsed\n",
            "Saved Game Parse Error"),
    SAVE_WRITE_ERROR("The game could not be written to a file\n",
            "Saved Game Write Error"),
    STYLE_NOT_VALID("The selected Style is unavailable", "Style Unavailable"),
    LEVEL_READ_ERROR(
            "The level could not be read.\nPlease verify files or use a " +
                    "different level file.",
            "Level Read Error"),
    BOARD_CREATE_ERROR(
            "The Gameboard could not be created\nPlease try using a different" +
                    " level",
            "Gameboard Creation Error"),
    LEVEL_FILE_ERROR(
            "There are no Level Files to use\nPlease verify game files",
            "No Levels to Use"),
    BOARD_REFRESH_ERROR(
            "The Gameboard could not be refreshed\nRedirecting to game setup " +
                    "menu",
            "Gameboard Refresh Error");

    private final String MESSAGE;
    private final String HEADER;

    /**
     * ErrorMsg Constructor
     *
     * @param message Message to be displayed
     * @param header  Header to be displayed
     */
    ErrorMessage(String message, String header) {
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
