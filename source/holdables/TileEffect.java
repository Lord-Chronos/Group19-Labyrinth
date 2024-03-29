package holdables;

/**
 * Defines the types of {@link Effect} that can be applied to a {@link Tile}. These are also {@link
 * Holdable}, like {@link Tile} and {@link PlayerEffect}
 *
 * @author Joseph Omar
 * @version 3.2
 */
@SuppressWarnings("unused")
public enum TileEffect implements Holdable, Effect {
    FIRE(3, 2),
    ICE(3, 1),
    NONE(1, 0);
    private final int RANGE;
    private final int TURNS_ACTIVE;

    /**
     * Constructs the effect and its details
     *
     * @param range       Range of the Effect
     * @param turnsActive How long it is active
     */
    TileEffect(int range, int turnsActive) {
        this.RANGE = range;
        this.TURNS_ACTIVE = turnsActive;
    }

    /**
     * Gets the range of the effect
     *
     * @return Range
     */
    public int getRange() {
        return RANGE;
    }

    /**
     * Gets the Number of turns the effect will be active
     *
     * @return Number of turns
     */
    public int getTurnsActive() {
        return TURNS_ACTIVE;
    }

    @Override
    public String toString() {
        switch (this) {
            case FIRE:
                return "Ignite";
            case ICE:
                return "Freeze";
            case NONE:
                return "No Effect";
            default:
                return "Not a Tile Effect";
        }
    }
}