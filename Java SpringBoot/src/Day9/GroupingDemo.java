package Day9;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class GroupingDemo {

    static void add(Map<String, List<String>> groups, String category, String item) {
        if (!groups.containsKey(category)) {
            groups.put(category, new ArrayList<>());
        }
        groups.get(category).add(item);
    }

    public static void main(String[] args) {
        Map<String, List<String>> groups = new LinkedHashMap<>();
        add(groups, "TODO", "Design API");
        add(groups, "IN_PROGRESS", "Fix bug");
        add(groups, "TODO", "Write docs");
        add(groups, "DONE", "Setup repo");

        for (Map.Entry<String, List<String>> entry : groups.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}