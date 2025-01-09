public class Simulation {

  private Scanner scanner;
  private Identifier identifier;
  private Firer firer;

  public Simulation(Scanner scanner, Identifier identifier, Firer firer) {
    this.scanner = scanner;
    this.identifier = identifier;
    this.firer = firer;
  }

  public void run()
  {
    for (int i = 0; i < 20; i++)
    {
      System.out.println("Timestep " + i);
      String threat = scanner.scan();
      if (identifier.identify(threat))
      {
        firer.fire();
      }
      System.out.println("----------------");
    }
  }
}