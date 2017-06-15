package com.sourceit.lesson9.callcentre;


import com.sourceit.lesson9.callcentre.impl.Call;
import com.sourceit.lesson9.callcentre.impl.CallCentre;
import com.sourceit.lesson9.callcentre.impl.CallsDto;

import java.util.*;

public class CallCentreAll {
    private static final int TOTAL_CALLS = 10;
    private static final String OPERATOR = "Operator";

    public static void main(String[] args) {
        List<Call> calls = new LinkedList<>();

        for (int i = 0; i < TOTAL_CALLS; i++) {
            calls.add(CallCentre.produceCall());
        }

        System.out.println(Arrays.toString(calls.toArray()));

        Comparator comparator = getComparator();
        Map<String, Integer> callDurations  = new TreeMap<>(comparator);
        Map<String, Integer> callQuantities = new TreeMap<>(comparator);
        for (Call call : calls) {
            String operatorName = call.getOperator();
            if (callDurations.get(operatorName) != null) {
                callDurations.put(operatorName, callDurations.get(operatorName) + call.getDuration());
                callQuantities.put(operatorName, callQuantities.get(operatorName) + 1);
            } else {
                callDurations.put(operatorName, call.getDuration());
                callQuantities.put(operatorName, 1);
            }
        }

        List<CallsDto> data = new ArrayList<>(callDurations.size());
        for (String operator : callDurations.keySet()) {
            data.add(new CallsDto(operator, callDurations.get(operator), callQuantities.get(operator)));
        }
        System.out.println(data);
    }

    private static Comparator getComparator()
    {
        return new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String o1Number = o1.substring(OPERATOR.length());
                int o1IntNumber = Integer.parseInt(o1Number) - 1;
                String o2Number = o2.substring(OPERATOR.length());
                int o2IntNumber = Integer.parseInt(o2Number) - 1;
                return o1IntNumber - o2IntNumber;
            }
        };
    }
}
