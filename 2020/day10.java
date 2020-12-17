import java.util.*;

public class day10 {
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextInt()) {
            int num = scan.nextInt();
            list.add(num);
        }
        part1();
    }

    public static void part1() {
        Queue<Integer> q = new LinkedList<>();
        int adapter = 0;
        q.add(0);
        int ones = 0, threes = 0;
        while (!q.isEmpty()) {
            adapter = q.poll();
            if (list.contains(adapter + 1)) {
                q.add(adapter + 1);
                ones++;
            } else if (list.contains(adapter + 2)) {
                q.add(adapter + 2);
            } else if (list.contains(adapter + 3)) {
                q.add(adapter + 3);
                threes++;
            }

        }
        threes++;
        System.out.printf("#1 jolt differences: %d\n#3 jolt differences: %d\nProduct : %d\n", ones, threes,
                ones * threes);
    }

    public static void part2() {

    }

}