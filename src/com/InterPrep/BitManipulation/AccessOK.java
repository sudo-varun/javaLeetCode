package com.InterPrep.BitManipulation;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class AccessOK {
    static final List<String[]> rules = new ArrayList<>(Arrays.asList(
            new String[]{"ALLOW", "192.168.100.0/24"},
            new String[]{"DENY", "192.168.0.5/30"},
            new String[]{"ALLOW", "192.168.1.1/22"},
            new String[]{"ALLOW", "1.0.0.0/8"},
            new String[]{"ALLOW", "2.3.4.9"},
            new String[]{"DENY", "8.8.8.8/1"},
            new String[]{"ALLOW", "5.6.7.8"}
    ));

    static long parseIp(String ip) {
        long result = 0;
        for(String oct: ip.split("\\.")) {
            result = (result << 8) | Integer.parseInt(oct);
        }
        return result;
    }
    public long[] parseRule(String cidr) {
        int slashPos = cidr.indexOf("/");
        if(slashPos == -1) {
            return new long[]{parseIp(cidr), mask(32)};
        }
        String ip = cidr.substring(0, slashPos);
        int prefix = Integer.parseInt(cidr.substring(slashPos + 1));
        return new long[]{parseIp(ip), mask(prefix)};
    }
    static long mask(int prefix) {
        return 0xFFFFFFFFL << (32 - prefix);
    }
    public boolean accessOk(List<String[]> rules, String ip) {
        long targetIp = parseIp(ip);
        for(String[] rule: rules) {
            String action = rule[0];
            long[] parsed = parseRule(rule[1]);
            long ruleIp = parsed[0];
            long mask = parsed[1];
            if((targetIp & mask) == (ruleIp & mask)) {
                return action.equals("ALLOW");
            }
        }
        return false;
    }
}
