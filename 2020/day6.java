import java.util.*;

//https://adventofcode.com/2020/day/6
public class day6 {
    static List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextLine()) {
            list.add(scan.nextLine());
        }
        part1();
        part2();
    }

    public static void part1() {
        int ans = 0;
        Set<Character> set = new HashSet<>();
        for (String s : list) {
            if (s.isEmpty()) {
                ans += set.size();
                set = new HashSet<>();
            }
            for (char c : s.toCharArray()) {
                set.add(c);
            }
        }
        System.out.println(ans + set.size());
    }

    public static void part2() {
        int ans = 0;
        Set<Character> set = new HashSet<>();
        boolean start = true;
        for (String s : list) {
            if (start) {
                start = false;
                for (char c : s.toCharArray()) {
                    set.add(c);
                }
            }
            if (s.isEmpty()) {
                ans += set.size();
                set = new HashSet<>();
                start = true;
            }

            Iterator itr = set.iterator();
            while (itr.hasNext()) {
                char c = (char) itr.next();
                if (!s.contains(String.valueOf(c))) {
                    itr.remove();
                }
            }

        }
        System.out.println(ans + set.size());
    }
}