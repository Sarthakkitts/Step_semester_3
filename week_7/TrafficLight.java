public class TrafficLight {
    private static final String[] COLORS = {"RED", "GREEN", "YELLOW"};
    private final String id;
    private int currentColorIndex; // 0=RED, 1=GREEN, 2=YELLOW

    public TrafficLight(String id) {
        this.id = id;
        this.currentColorIndex = 0; // Start at RED
    }

    public void next() {
        currentColorIndex = (currentColorIndex + 1) % COLORS.length;
    }

    public String getColor() {
        return COLORS[currentColorIndex];
    }

    public String getId() {
        return id;
    }

    // No setter for color - it can only be changed via next() method
}
