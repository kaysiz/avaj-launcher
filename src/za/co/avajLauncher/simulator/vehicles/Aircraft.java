package za.co.avajLauncher.simulator.vehicles;

public class Aircraft {

    protected long        id;
    protected String      name;
    protected Coordinates coords;
    private static long   idCounter;

    protected Aircraft(String _name, Coordinates _coords){
        this.coords     = _coords;
        this.name       = _name;
        this.id         = nextId();
    }

    private long nextId() {

        return (idCounter++);
    }
}
