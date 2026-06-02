package algorithm;

import models.*;
import java.util.*;

public class Dijkstra {

    private Map<Location, Double> distances; // This will calculate distance for examples lahore 101 ->
    private Map<Location, Location> parents;
    private Set<Location> visited;
    private PriorityQueue<Location> pq;

    public List<Location> findShortestPath(Graph graph, Location start, Location end) {

        // 1. Initialize structures
        distances = new HashMap<>();
        parents = new HashMap<>();
        visited = new HashSet<>();

        // 2. Set all distances to infinity
        for (Location loc : graph.getLocations()) {
            distances.put(loc, Double.MAX_VALUE);
        }

        // 3. Start node distance = 0
        distances.put(start, 0.0);

        // 4. Priority Queue (min distance first)
        pq = new PriorityQueue<>(Comparator.comparingDouble(distances::get));
        pq.add(start);

        // 5. Dijkstra main loop
        while (!pq.isEmpty()) {

            Location current = pq.poll();

            if (visited.contains(current))
                continue;

            visited.add(current);

            // If reached destination, stop early
            if (current.equals(end))
                break;

            // Check neighbors
            for (Road road : graph.getNeighbors(current)) {

                Location neighbor = road.getDestinationCity();

                double newDist = distances.get(current) + road.getDistance();

                if (newDist < distances.get(neighbor)) {

                    distances.put(neighbor, newDist);
                    parents.put(neighbor, current);

                    pq.add(neighbor);
                }
            }
        }

        // 6. Reconstruct path
        return reconstructPath(start, end);
    }

    // -----------------------------
    // PATH RECONSTRUCTION
    // -----------------------------
    private List<Location> reconstructPath(Location start,
                                           Location end) {

        List<Location> path = new ArrayList<>();

        Location current = end;

        // If no path exists
        if (!parents.containsKey(end) && !start.equals(end)) {
            return path; // empty
        }

        // Go backwards from end → start
        while (current != null) {
            path.add(current);
            current = parents.get(current);
        }

        // Reverse path to make it start → end
        Collections.reverse(path);

        return path;
    }

    // Optional: get distance
    public double getDistance(Location end) {
        return distances.getOrDefault(end, Double.MAX_VALUE);
    }
}