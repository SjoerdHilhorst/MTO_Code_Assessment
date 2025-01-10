public class Simulation {

  private EventBus eventBus;

  public Simulation(EventBus eventBus) {
    this.eventBus = eventBus;
  }

  public void run()
  {
    for (int i = 0; i < 20; i++)
    {
      eventBus.publish(new SimulationTickEvent());
      System.out.println("--------------------");
    }
  }
}