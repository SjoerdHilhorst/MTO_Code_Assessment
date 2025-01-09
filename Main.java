import java.io.FileNotFoundException;

public class Main {

  public static void main(String[] args) {

    /**
     * Every simulation component is an interface. This allows for easy
     * replacement of components. For example, if we wanted to change the
     * firer to a different type of missile launcher, we could simply create a new
     * launcher class that implements the Firer interface and pass it to the
     * Simulation constructor.
     */
    try {
      Scanner scanner = new Radar("radar_data.csv");
      Identifier identifier = new FriendFoeIdentifier();
      Firer firer = new MissileLauncher(0.8);

      Simulation simulation = new Simulation(scanner, identifier, firer);
      simulation.run();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }
}