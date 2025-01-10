public class RadarScanEvent implements SimulationEvent {
  private final String radarData;

  public RadarScanEvent(String radarData) {
    this.radarData = radarData;
  }

  public String getRadarData() {
    return radarData;
  }

  @Override
  public String getName() {
    return "RadarScanEvent";
  }

  @Override
  public String getEventDetails() {
    return radarData;
  }
}
