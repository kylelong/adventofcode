import java.util.*;

public class day13 {

    public static void main(String[] args) {
        part1();
        part2();
    }

    public static void part1() {
        int start = 1002461, time = 1002461;
        int[] id = { 29, 41, 521, 23, 13, 17, 601, 37, 19 };
        boolean departed = false;
        int earliest = Integer.MAX_VALUE;
        int bus_taken = 0;
        while (departed == false) {
            for (int bus : id) {
                if (time % bus == 0) {
                    earliest = Math.min(earliest, time);
                    departed = true;
                    bus_taken = bus;
                    break;
                }
            }
            time++;
        }
        System.out.println((earliest - start) * bus_taken);
    }

    public static void part2() {
        String str = "29,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,41,x,x,x,x,x,x,x,x,x,521,x,x,x,x,x,x,x,23,x,x,x,x,13,x,x,x,17,x,x,x,x,x,x,x,x,x,x,x,x,x,601,x,x,x,x,x,37,x,x,x,x,x,x,x,x,x,x,x,x,19";
        str = "7,13,x,x,59,x,31,19";
        String[] ids = str.split(",");
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Long> times = new HashMap<>(); // <bus, latest depart time>
        boolean found = false;
        for (int i = 0; i < ids.length; i++) {
            if (!ids[i].equals("x")) {
                map.put(Integer.parseInt(ids[i]), i);
            }
        }
        long time = 1068773;
        int[] buses = { 7, 13, 59, 31, 19 };
        // 29, 41, 521, 23, 13, 17, 601, 37, 19
        for (int bus : buses) {
            if (time % bus == 0) {
                times.put(bus, time);
            }
        }
        while (found == false) {
            System.out.println(time);
            for (int bus : buses) {
                if (time % bus == 0) {
                    times.put(bus, time);
                }
            }
            long start = times.get(buses[0]);
            boolean correct = true;
            for (int i = 1; i < buses.length; i++) {
                if (times.get(buses[i]) - start != map.get(buses[i])) {
                    correct = false;
                    break;
                }
            }
            if (correct) {
                found = true;
                break;
            }

            time++;
        }
        System.out.println(time);

    }
}