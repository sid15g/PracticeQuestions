package code.general;

import java.util.Objects;

/**
 * Time slot for problem {@link code.general.MinimumPlatform}
 */
public class TimeSlot implements Comparable<TimeSlot> {

    private final int start;
    private final int end;

    public TimeSlot(final int start, final int end) {
        this.start = start;
        this.end = end;
    }

    public int getEnd() {
        return end;
    }

    public int getStart() {
        return start;
    }

    public boolean intersect(final TimeSlot timeSlot) {
        if (this.start == timeSlot.start || this.end == timeSlot.end) {
            return true;
        }
        if (timeSlot.start > this.start && timeSlot.start < this.end) {
            return true;
        }
        if (timeSlot.end > this.start && timeSlot.end < this.end) {
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimeSlot timeSlot = (TimeSlot) o;
        return start == timeSlot.start &&
                end == timeSlot.end;
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end);
    }

    @Override
    public int compareTo(TimeSlot ts) {
        if (this.start == ts.start) {
            return this.end > ts.end ? 1 : -1;
        } else if (this.end == ts.end) {
            return this.start > ts.start ? 1 : -1;
        } else if (this.start >= ts.end) {
            return 1;
        } else if (this.end <= ts.start) {
            return -1;
        } else {
            return 0;
        }
    }
}
