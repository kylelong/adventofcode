import java.util.*;

public class day7 {
    static List<String> list = new ArrayList<String>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextLine()) {
            list.add(scan.nextLine());
        }
        part1();
    }

    public static void part1() {
        HashMap<String, List<String>> parents = new HashMap<>(); // holds shiny bags
        int count = 0;
        // Maps parent (contains a shiny bag) -> List of bags
        for (String s : list) {
            String[] data = s.split("contain");
            String parent = data[0].substring(0, data[0].length() - 1);
            List<String> content = new ArrayList<>();
            if (data[1].contains("shiny gold bag")) { // contains a shiny gold bad
                String items = data[1].substring(0, data[1].length() - 1);
                String[] bags = items.split(",");
                for (String b : bags) {
                    content.add(b.substring(3, b.length()));
                }
                parents.put(parent, content);
                System.out.println(parent + " " + parents.get(parent));
            }

        }
        Set<String> set = new HashSet<>();
        System.out.println("-----");
        // loop over non parent bags (bags that do not inherently contain shingy gold
        // ones)
        for (String s : list) {
            String[] data = s.split("contain");
            String parent = data[0].substring(0, data[0].length() - 1); // minus space
            if (!parents.containsKey(parent)) {
                String[] bags = data[1].substring(0, data[1].length() - 1).split(","); // minus period
                // System.out.println(parent + " " + Arrays.deepToString(bags));

                for (String b : bags) {
                    b = b.trim();
                    b = b.substring(2, b.length()); // plural if it contains s
                    String singular = b.substring(0, b.length() - 1); // singular form
                    // Bag contains a bag that has a shiny gold one
                    if ((!set.contains(parent) && !set.contains(parent.substring(0, parent.length() - 1)))
                            && (parents.containsKey(b) || parents.containsKey(singular)
                                    || parents.containsKey(b + "s"))) { // data[0]
                        set.add(parent);
                        set.add(parent.substring(0, parent.length() - 1));
                        System.out.println(parent + ": " + b + " " + singular);
                        count++;
                        break;
                    }
                }
            }
        }

        System.out.println(parents.keySet().size() + count);
    }

    public static void part2() {

    }
}