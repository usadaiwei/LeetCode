package Examples.Algorithms.Bloomberg;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
An underground railway system is keeping track of customer travel times between different stations. They are using this data to calculate the average time it takes to travel from one station to another.

Implement the UndergroundSystem class:

void checkIn(int id, string stationName, int t)
A customer with a card ID equal to id, checks in at the station stationName at time t.
A customer can only be checked into one place at a time.
void checkOut(int id, string stationName, int t)
A customer with a card ID equal to id, checks out from the station stationName at time t.
double getAverageTime(string startStation, string endStation)
Returns the average time it takes to travel from startStation to endStation.
The average time is computed from all the previous traveling times from startStation to endStation that happened directly, meaning a check in at startStation followed by a check out from endStation.
The time it takes to travel from startStation to endStation may be different from the time it takes to travel from endStation to startStation.
There will be at least one customer that has traveled from startStation to endStation before getAverageTime is called.
You may assume all calls to the checkIn and checkOut methods are consistent. If a customer checks in at time t1 then checks out at time t2, then t1 < t2. All events happen in chronological order.
 */
public class DesignUndergroundSystem {
    HashMap<Integer, Pair<String, Integer>> map; // Store id, and a pair of start station name with startTime
    HashMap<String, List<Integer>> data; // Store route name, and a list of time record

    public DesignUndergroundSystem() {
        map = new HashMap<>();
        data = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        map.put(id, new Pair<String, Integer>(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        String startStationName = map.get(id).getKey();
        int startTime = map.get(id).getValue();
        int totalTime = t - startTime;
        String routeName = route(startStationName, stationName);
        List<Integer> list = data.getOrDefault(routeName, new ArrayList<>());
        list.add(totalTime);
        data.put(routeName, list);
    }

    public double getAverageTime(String startStation, String endStation) {
        int time = 0;
        double count = 0;
        List<Integer> list = data.get(route(startStation, endStation));
        for (int i = 0; i < list.size(); i++){
            time += list.get(i);
            count++;
        }
        return time/count;
    }

    public String route(String start, String destination){
        return start + "-" + destination;
    }
}
