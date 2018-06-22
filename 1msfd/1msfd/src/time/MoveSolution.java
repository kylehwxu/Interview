package time;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MoveSolution {
    private static class TimeSpeed {
        double time;
        double speed;
        public TimeSpeed (double t, double s) {
            this.time = t;
            this.speed = s;
        }
    }
    private static class DistanceSpeed {
        double distance;
        double speed;
        public DistanceSpeed (double d, double s) {
            this.distance = d;
            this.speed = s;
        }
    }
    public static double move(double v0, List<TimeSpeed> tv, List<DistanceSpeed> dv, Double time) {
        if ((tv == null && dv == null) || (tv.size() == 0 && dv.size() == 0)) {
            return v0;
        }
        Collections.sort(tv, new Comparator<TimeSpeed>() {
            @Override
            public int compare(TimeSpeed o1, TimeSpeed o2) {
                return (int)(o1.time - o2.time);
            }});
        Collections.sort(dv, new Comparator<DistanceSpeed>() {
            @Override
            public int compare(DistanceSpeed o1, DistanceSpeed o2) {
                return (int) (o1.distance - o2.distance);
            }});
        double t = 0.0;
        double dis = 0.0;
        double cur = v0;
        double next = v0;
        int index1 = 0, index2 = 0;
        while (t < time && (index1 < tv.size() || index2 < dv.size())) {
            if (index2 < dv.size()) {
//                double tmpV = next;
                cur = next;
                double tmp = t + (dv.get(index2).distance - dis) / cur;
                //System.out.println("dis: " + dis + "tmp: " + tmp + "cur: " + cur);
                if ((index1 < tv.size() && tmp < tv.get(index1).time) || index1 >= tv.size()) {
                    next = dv.get(index2).speed;
                    dis = dv.get(index2).distance;
                    index2++;
                    t = tmp;
                    //System.out.println("case1: " +t);
                } else {
                    next = tv.get(index1).speed;
                    dis += cur * (tv.get(index1).time - t);
                    //System.out.println("case2: " + t + "next" + next + " " +(tv.get(index1).time - t));
                    t = tv.get(index1).time;            
                    index1++;
                }
            } else {
                next = tv.get(index1).speed;
                dis += cur * (tv.get(index1).time - t);
                t = tv.get(index1).time;
                //dis += next * t;
                //System.out.println("case3: " + t);
                index1++;
            }
        }
        return time >= t ? next : cur;
    }
    public static void main(String[] args) {
        MoveSolution ms = new MoveSolution();
        TimeSpeed ts1 = new TimeSpeed(5,3);
        TimeSpeed ts2 = new TimeSpeed(2,4);
        List<TimeSpeed> ts = new ArrayList<>();
        ts.add(ts1);
        ts.add(ts2);
        DistanceSpeed ds1 = new DistanceSpeed(1,3);
        DistanceSpeed ds2 = new DistanceSpeed(19,1);
        List<DistanceSpeed> ds = new ArrayList<>();
        ds.add(ds1);
        ds.add(ds2);
        System.out.println(move(1.0, ts, ds, 1.0));
    }
}
