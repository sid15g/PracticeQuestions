package code.general;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Minimum Number of Platforms Required for a Railway/Bus Station
 * <p>
 * Given the arrival and departure times of all trains that reach a railway station,
 * the task is to find the minimum number of platforms required for the railway station so that no train waits.
 * We are given two arrays that represent the arrival and departure times of trains that stop.
 * <p>
 * Examples:-
 * <p>
 * Input: arr[] = {900, 940, 950, 1100, 1500, 1800}
 * dep[] = {910, 1200, 1120, 1130, 1900, 2000}
 * Output: 3
 * Explanation: There are at-most three trains at a time (time between 9:40 to 12:00)
 * <p>
 * Input: arr[] = {900, 940}
 * dep[] = {910, 1200}
 * Output: 1
 * Explanation: Only one platform is needed.
 */
public class MinimumPlatform {

    /**
     * Find minimum Platform required
     *
     * @param arrivals   arrival time array
     * @param departures departure time array
     * @param n          total time
     * @return minimum platforms required (integer)
     */
    public int findMinimumPlatformsRequired(final int[] arrivals, final int[] departures, final int n) {

        if (arrivals == null || departures == null || arrivals.length == 0 || departures.length == 0 || n == 0) {
            return 0;
        }

        final Map<Integer, List<TimeSlot>> scheduleMap = new HashMap<>(n);
        final List<TimeSlot> allSlots = new LinkedList<>();
        int platformNumber = 0;

        for (int i = 0; i < n; i++) {
            final TimeSlot timeSlot = new TimeSlot(arrivals[i], departures[i]);
            allSlots.add(timeSlot);
        }

        final List<TimeSlot> sortedSlots = allSlots.stream().sorted().collect(Collectors.toList());
        //printTimeSlots(sortedSlots, -1);

        for (int i = 0; i < n; i++) {

            final TimeSlot timeSlot = sortedSlots.get(i);
            System.out.printf("Using timeslot [%d, %d]\n", timeSlot.getStart(), timeSlot.getEnd());

            final int index = scheduleMap.entrySet().stream()
                    .filter(entry -> !entry.getValue().stream().anyMatch(ts -> ts.intersect(timeSlot)))
                    .map(Map.Entry::getKey)
                    .findFirst()
                    .orElse(++platformNumber);

            final List<TimeSlot> timeSlots = scheduleMap.getOrDefault(index, new LinkedList<>());
            System.out.printf("Found slots at index (%d) and length (%d) \n", index, timeSlots.size());
            insertIntoListOfTimeSlot(timeSlots, timeSlot);
            printTimeSlots(timeSlots, index);
            scheduleMap.put(index, timeSlots);
        }

        return scheduleMap.size();
    }

    /**
     * Inserts the new time slot into the given list
     *
     * @param timeSlots   existing list
     * @param newTimeSlot new time slot
     */
    private void insertIntoListOfTimeSlot(final List<TimeSlot> timeSlots, final TimeSlot newTimeSlot) {

        if (timeSlots.size() == 0) {
            timeSlots.add(newTimeSlot);
            return;
        }

        int index = 0;
        int res = timeSlots.get(0).compareTo(newTimeSlot);

        while (res < 0 && index + 1 < timeSlots.size()) {
            final TimeSlot current = timeSlots.get(++index);
            res = current.compareTo(newTimeSlot);
        }

        if (res < 0) {
            timeSlots.add(index + 1, newTimeSlot);
        } else {
            timeSlots.add(index, newTimeSlot);
        }
    }

    /**
     * Print the list of time slot, for a given platform
     *
     * @param timeSlots      time slot list
     * @param platformNumber platform number
     */
    private void printTimeSlots(final List<TimeSlot> timeSlots, final int platformNumber) {
        System.out.printf("TS%d:", platformNumber);
        timeSlots.forEach(slot -> {
            System.out.printf(" -> [%d,%d]", slot.getStart(), slot.getEnd());
        });
        System.out.println();
    }

}
