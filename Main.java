import java.io.FileNotFoundException;

public class Main {

  public static void main(String[] args) {
    try {
      // Event bus and simulation
      EventBus eventBus = new EventBus();
      Simulation simulation = new Simulation(eventBus);
      
      // Simulation components
      Radar radar = new Radar("radar_data.csv", eventBus);
      FriendFoeIdentifier identifier = new FriendFoeIdentifier(eventBus);
      MissileLauncher firer = new MissileLauncher(0.8, eventBus);
      
      // Utility components
      Sleeper sleeper = new Sleeper();
      Logger logger = new Logger();
      
      // Add logger to all events, add logging before other listeners to see the order of events
      eventBus.register(MissileLaunchEvent.class, logger);
      eventBus.register(IdentificationEvent.class, logger);
      eventBus.register(RadarScanEvent.class, logger);
      eventBus.register(SimulationTickEvent.class, logger);
    
      eventBus.register(SimulationTickEvent.class, radar);
      eventBus.register(RadarScanEvent.class, identifier);
      eventBus.register(IdentificationEvent.class, firer);
      
      // Register a 1 second sleeper for every tick event for real-time simulation
      eventBus.register(SimulationTickEvent.class, sleeper);
      
      simulation.run();

    } catch (FileNotFoundException e) {
      System.out.println("File not found");
    }
  }
}