package e.harrison.dogtrain;

public class DogTrick {
    private String trickname;
    private int tracker;
    public DogTrick(String trickname){
        this.trickname = trickname;
        this.tracker = 0;
    }

    public int getTracker() {
        return tracker;
    }

    public void setTracker(int tracker) {
        this.tracker = tracker;
    }

    public String getTrickname() {
        return trickname;
    }

}
