import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EventBus {
    private final Map<Class<? extends SimulationEvent>, List<SimulationEventListener>> listenersMap = new HashMap<>();

    // Register a listener for a specific event type
    public <T extends SimulationEvent> void register(Class<T> eventType, SimulationEventListener listener) {
        listenersMap.computeIfAbsent(eventType, k -> new ArrayList<>()).add(listener);
    }

    // Publish an event to all listeners of its type
    public void publish(SimulationEvent event) {
        Class<? extends SimulationEvent> eventType = event.getClass();
        List<SimulationEventListener> listeners = listenersMap.getOrDefault(eventType, new ArrayList<>());

        for (SimulationEventListener listener : listeners) {
            listener.handleEvent(event);
        }
    }
}