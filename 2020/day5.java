import java.util.*;

public class day5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int columns = 8, row = 0, col = 0, seat = 0, max = 0, min = Integer.MAX_VALUE;
        String s = " ";
        List<Integer> list = new ArrayList<Integer>();
        while (scan.hasNext()) {
            s = scan.next();
            row = binarySearch(s.substring(0, 7), 0, 127, 'F');
            col = binarySearch(s.substring(7, s.length()), 0, 7, 'L');
            seat = row * columns + col;
            list.add(seat);
            max = Math.max(max, seat);
            min = Math.min(seat, min);
        }
        System.out.println(max); // maxSeat
        System.out.println(min); // minSeat
        int mySeat = 0;
        for (int l : list) {
            if (l != max && l != min) {
                if (!list.contains(l - 1)) {
                    System.out.println("Seat#:" + l);
                    System.out.println(l - 1);
                }
                if (!list.contains(l + 1)) {
                    System.out.println("Seat#:" + l);
                    System.out.println(l + 1);
                }
            }
        }

        scan.close();

    }

    public static int binarySearch(String s, int low, int high, char ch) {
        int mid = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            mid = (high - low) / 2;
            if (c == ch) {
                high -= mid + 1;
            } else {
                low += mid + 1;
            }
        }
        return low;
    }

    public static void part1() {

    }

    public static void part2() {

    }
}