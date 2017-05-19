package com.sourceit.lesson4.visitors;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

public class MaxVisitorInOffice {
    public static void main(String[] args) {
        Visitor[] visitors = Visitor.createVisitors();
        Arrays.sort(visitors, new Comparator<Visitor>() {
            @Override
            public int compare(Visitor o1, Visitor o2) {
                return o1.getComeTime() > o2.getComeTime() ? 1 : -1;
            }
        });
        for (Visitor visitor : visitors) {
            System.out.println("Come " + new Date(visitor.getComeTime()));
            System.out.println("Leave " + new Date(visitor.getLeaveTime()));
        }
        int maxVisitorAtOnce = 0;

        int length = visitors.length;
        int[][] meetingMatrix = new int[length][length]; //Just to see who was with whome
        for (int i = 0; i < length; i++) {
            Visitor currentVisitor = visitors[i];
            long comeTime = currentVisitor.getComeTime();
            long leaveTime = currentVisitor.getLeaveTime();
            meetingMatrix[i][i] = 1;
            int countTogether = 1;
            for (int j = 0; j < length; j++) {
                if (j != i) {
                    Visitor otherVisitor = visitors[j];
                    long otherComeTime = otherVisitor.getComeTime();
                    long otherLeaveTime = otherVisitor.getLeaveTime();
                    if ((otherComeTime <= comeTime && otherLeaveTime > comeTime) ||
                            (otherComeTime > comeTime && otherComeTime < leaveTime)) {
                        meetingMatrix[i][j] = 1;
                        meetingMatrix[j][i] = 1;
                        countTogether++;
                    }
                }
            }
            if (countTogether > maxVisitorAtOnce) {
                maxVisitorAtOnce = countTogether;
            }
        }

        //Display meeting matrix to check
        System.out.println("Meeting matrix: ");
        for (int i = 0; i < length; i++) {
            System.out.println(Arrays.toString(meetingMatrix[i]));
        }
        System.out.println("Max visitors was " + maxVisitorAtOnce);
    }
}
