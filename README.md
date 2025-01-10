# Radar Simulation

This project simulates a radar system that scans for targets, identifies them as friend or foe, and fires missiles at foes.
The simulations uses a publish subscribe design pattern for loose coupling between components.

1. **Event Bus**: Components can register to listen for specific events and publish events to the event bus.

2. **Simulation Setup**: In Main.java an `EventBus` is created. The simulation components (`Radar`, `FriendFoeIdentifier`, `MissileLauncher`, and `Logger`) are also created and registered with the event bus to listen for specific events.

3. **Simulation Loop**: The `Simulation` class runs for  20 iterations. In each iteration, it publishes a `SimulationTickEvent` to the event bus. The `Radar` component listens for this event and performs a radar scan, publishing a `RadarScanEvent` with the scan data.  When a `RadarScanEvent` is published, the `FriendFoeIdentifier` component is notified and identifies the target as friend or foe, publishing an `IdentificationEvent` notifying if it is a friend of foe. The `MissileLauncher` component listens for this event and fires a missile with a certain probability if it is a friend.

4. **Logging**: The `Logger` component listens for all events and logs them.

### Compilation

1. Compile and run the Java files using the following commands:

```sh
$ javac *.java
$ java Main
```
