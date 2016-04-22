package com.gmail.theandriicherniak.leetcode.medium;

/**
 * Created by andriicherniak on 11/23/15.
 */
public class Main {
    public static void main(java.lang.String[] args) {
        System.out.println("running medium ");

        M253_MeetingRoomsII rooms = new M253_MeetingRoomsII();
        M253_MeetingRoomsII.Interval [] ii = new M253_MeetingRoomsII.Interval[]{
                rooms.new Interval(0,30),
                rooms.new Interval(5,10),
                rooms.new Interval(15,20)
        };

        System.out.println(rooms.minMeetingRooms(ii));




    }
}