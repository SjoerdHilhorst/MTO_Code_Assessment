public class SimulationTickEvent implements SimulationEvent {
  @Override
  public String getName() {
    return "SimulationTickEvent";
  }  

  @Override
  public String getEventDetails() {
    return "Tick";
  }
}
