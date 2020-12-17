import java.util.*;

public class day7 {
    static List<String> list = new ArrayList<String>();
    static HashMap<String, List<String>> colors = new HashMap<>(); // bag relationships
    static HashMap<String, Integer> counts = new HashMap<>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextLine()) {
            list.add(scan.nextLine());
        }

        // Maps color -> List of bags
        int numBags = 0;
        for (String s : list) {
            if (!s.contains("contain no other bags")) {
                String[] data = s.split("contain");
                String parent = data[0].substring(0, data[0].length() - 1);
                List<String> content = new ArrayList<>();
                String items = data[1].substring(0, data[1].length() - 1);
                String[] bags = items.split(",");

                for (String b : bags) {
                    b = b.substring(1, b.length());
                    content.add(b);
                    numBags += Integer.valueOf(String.valueOf(b.charAt(0)));
                }
                colors.put(parent, content); // ex: light red bags -> [1 bright white bag, 2 muted yellow bags]
                /*
                 * stores bag -> how many bags it contains vibrant plum bags -> 11 (vibrant plum
                 * bags contain 5 faded blue bags, 6 dotted black bags.)
                 */
                counts.put(parent, numBags);

                numBags = 0;
            }

        }
        part1(); // 4
        part2(); // 32
    }

    public static void part1() {

        HashSet<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        int bags = 0;
        for (String color : colors.keySet()) {
            if (!visited.contains(color)) {
                q.add(color);
                while (!q.isEmpty()) {
                    String currColor = q.poll();
                    for (String subBag : colors.get(currColor)) {
                        subBag = subBag.substring(2, subBag.length());
                        if (subBag.contains("shiny gold bag") && !visited.contains(color)) {
                            visited.add(color);
                            bags++;
                        }
                        if (!subBag.endsWith("s")) {
                            subBag += "s";
                        }
                        if (colors.containsKey(subBag)) {
                            q.add(subBag);
                        }
                    }

                }
            }
        }
        System.out.println(bags);

    }

    public static void part2() {
        HashSet<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        int bags = 0;
        q.add("shiny gold bags");
        while (!q.isEmpty()) {
            String currBag = q.poll();
            for (String b : colors.get(currBag)) {
                int amount = Integer.valueOf(b.substring(0, b.length() - (b.length() - 1))); // amount of bag b

                b = b.substring(2, b.length());
                if (!b.endsWith("s")) {
                    b += "s";
                }

                if (colors.containsKey(b)) {
                    bags += amount + (amount * counts.get(b));
                    q.add(b);
                }
            }
        }
        System.out.println(bags);

    }
}