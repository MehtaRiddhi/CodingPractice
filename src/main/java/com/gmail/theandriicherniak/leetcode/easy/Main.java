package com.gmail.theandriicherniak.leetcode.easy;

/**
 * Created by andriicherniak on 11/23/15.
 */
public class Main {
    public static void main(java.lang.String [] args){
        System.out.println("running");
        E252_MeetingRooms rooms = new E252_MeetingRooms();
        E252_MeetingRooms.Interval[] it = new E252_MeetingRooms.Interval[3];
        it[0]=rooms.new Interval(1,2);
        it[1]=rooms.new Interval(3,4);
        it[2]=rooms.new Interval(5,6);


        System.out.print(rooms.canAttendMeetings(it));
    }
}
