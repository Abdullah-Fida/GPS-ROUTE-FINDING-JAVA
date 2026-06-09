package algorithm;

import models.Location;
import java.util.*;

public class PathReconstructor {

    public List<Location> buildPath(
            Map<Location, Location> parents,
            Location start,
            Location end) {

        List<Location> path = new ArrayList<>();

        Location current = end;

        // No path exists
        if (!parents.containsKey(end) && !start.equals(end)) {
            return path;
        }

        while (current != null) {

            path.add(current);

            current = parents.get(current);
        }

        Collections.reverse(path);

        return path;
    }
}