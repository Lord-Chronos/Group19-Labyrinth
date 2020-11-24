package holdables;

public class DoubleMovement extends PlayerEffect {

    protected DoubleMovement(boolean doubleMovement) {
        super(doubleMovement);
    }
    public void setDoubleMovement(boolean doubleMovement) {
        this.doubleMovement = doubleMovement;
        System.out.println("Double movement is in effect");
    }

    public boolean DoubleMovement() {
        return this.doubleMovement;
    }

}
