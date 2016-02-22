package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 11/23/15.
 */
public class Main {
    public static void main(java.lang.String [] args){
        System.out.println("running");
        M332_ReconstructItinerary it = new M332_ReconstructItinerary();
        String input = "[\"AXA\",\"EZE\"],[\"EZE\",\"AUA\"],[\"ADL\",\"JFK\"],[\"ADL\",\"TIA\"]," +
                "[\"AUA\",\"AXA\"],[\"EZE\",\"TIA\"],[\"EZE\",\"TIA\"],[\"AXA\",\"EZE\"]," +
                "[\"EZE\",\"ADL\"],[\"ANU\",\"EZE\"],[\"TIA\",\"EZE\"],[\"JFK\",\"ADL\"]," +
                "[\"AUA\",\"JFK\"],[\"JFK\",\"EZE\"],[\"EZE\",\"ANU\"],[\"ADL\",\"AUA\"]," +
                "[\"ANU\",\"AXA\"],[\"AXA\",\"ADL\"],[\"AUA\",\"JFK\"],[\"EZE\",\"ADL\"]," +
                "[\"ANU\",\"TIA\"],[\"AUA\",\"JFK\"],[\"TIA\",\"JFK\"],[\"EZE\",\"AUA\"]," +
                "[\"AXA\",\"EZE\"],[\"AUA\",\"ANU\"],[\"ADL\",\"AXA\"],[\"EZE\",\"ADL\"]," +
                "[\"AUA\",\"ANU\"],[\"AXA\",\"EZE\"],[\"TIA\",\"AUA\"],[\"AXA\",\"EZE\"]," +
                "[\"AUA\",\"SYD\"],[\"ADL\",\"JFK\"],[\"EZE\",\"AUA\"],[\"ADL\",\"ANU\"]," +
                "[\"AUA\",\"TIA\"],[\"ADL\",\"EZE\"],[\"TIA\",\"JFK\"],[\"AXA\",\"ANU\"]," +
                "[\"JFK\",\"AXA\"],[\"JFK\",\"ADL\"],[\"ADL\",\"EZE\"],[\"AXA\",\"TIA\"]," +
                "[\"JFK\",\"AUA\"],[\"ADL\",\"EZE\"],[\"JFK\",\"ADL\"],[\"ADL\",\"AXA\"]," +
                "[\"TIA\",\"AUA\"],[\"AXA\",\"JFK\"],[\"ADL\",\"AUA\"],[\"TIA\",\"JFK\"]," +
                "[\"JFK\",\"ADL\"],[\"JFK\",\"ADL\"],[\"ANU\",\"AXA\"],[\"TIA\",\"AXA\"]," +
                "[\"EZE\",\"JFK\"],[\"EZE\",\"AXA\"],[\"ADL\",\"TIA\"],[\"JFK\",\"AUA\"]," +
                "[\"TIA\",\"EZE\"],[\"EZE\",\"ADL\"],[\"JFK\",\"ANU\"],[\"TIA\",\"AUA\"]," +
                "[\"EZE\",\"ADL\"],[\"ADL\",\"JFK\"],[\"ANU\",\"AXA\"],[\"AUA\",\"AXA\"]," +
                "[\"ANU\",\"EZE\"],[\"ADL\",\"AXA\"],[\"ANU\",\"AXA\"],[\"TIA\",\"ADL\"]," +
                "[\"JFK\",\"ADL\"],[\"JFK\",\"TIA\"],[\"AUA\",\"ADL\"],[\"AUA\",\"TIA\"]," +
                "[\"TIA\",\"JFK\"],[\"EZE\",\"JFK\"],[\"AUA\",\"ADL\"],[\"ADL\",\"AUA\"]," +
                "[\"EZE\",\"ANU\"],[\"ADL\",\"ANU\"],[\"AUA\",\"AXA\"],[\"AXA\",\"TIA\"]," +
                "[\"AXA\",\"TIA\"],[\"ADL\",\"AXA\"],[\"EZE\",\"AXA\"],[\"AXA\",\"JFK\"]," +
                "[\"JFK\",\"AUA\"],[\"ANU\",\"ADL\"],[\"AXA\",\"TIA\"],[\"ANU\",\"AUA\"]," +
                "[\"JFK\",\"EZE\"],[\"AXA\",\"ADL\"],[\"TIA\",\"EZE\"],[\"JFK\",\"AXA\"]," +
                "[\"AXA\",\"ADL\"],[\"EZE\",\"AUA\"],[\"AXA\",\"ANU\"],[\"ADL\",\"EZE\"]," +
                "[\"AUA\",\"EZE\"]]";

        String[] data = input.split("\\]\\,\\[");
        String[][] tickets = new String[data.length][2];

        for (int i = 0; i < data.length; i++){
            String [] tt = data[i].replace("[", "").replace("]", "").replace("\"", "").split(",");
            tickets[i] = tt;
        }

        it.findItinerary(tickets);
    }
}
