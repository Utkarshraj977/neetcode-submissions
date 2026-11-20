/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals.size() == 0)
            return 0;
        Collections.sort(intervals, (a, b) -> { return a.start - b.start; });
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        pq.add(intervals.get(0).end);
        int room = 1;
        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i).start < pq.peek()) {
                room++;
                pq.add(intervals.get(i).end);
            }else{
                pq.remove();
                pq.add(intervals.get(i).end);
            }
        }
        return room;
    }
}
