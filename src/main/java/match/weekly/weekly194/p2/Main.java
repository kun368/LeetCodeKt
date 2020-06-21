package match.weekly.weekly194.p2;


import utils.java.DebugUtils;

import java.util.*;

class Solution {
    public String[] getFolderNames(String[] names) {
        String[] ret = new String[names.length];
        Set<String> set = new HashSet<>();
        Map<String, Integer> findSkip = new HashMap<>();
        for (int i = 0; i < names.length; ++i) {
            final String name = names[i];
            if (!set.contains(name)) {
                ret[i] = name;
                set.add(name);
                continue;
            }
            for (int j = findSkip.getOrDefault(name, 1); ; ++j) {
                String cur = name + "(" + j + ")";
                if (!set.contains(cur)) {
                    ret[i] = cur;
                    set.add(cur);
                    findSkip.put(name, j);
                    break;
                }
            }
        }
        return ret;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().getFolderNames(
                DebugUtils.parseStrArr1("[\"pes\",\"fifa\",\"gta\",\"pes(2019)\"]"))));
        System.out.println(Arrays.toString(new Solution().getFolderNames(
                DebugUtils.parseStrArr1("[\"gta\",\"gta(1)\",\"gta\",\"avalon\"]"))));
        System.out.println(Arrays.toString(new Solution().getFolderNames(
                DebugUtils.parseStrArr1("[\"onepiece\",\"onepiece(1)\",\"onepiece(2)\",\"onepiece(3)\",\"onepiece\"]"))));
        System.out.println(Arrays.toString(new Solution().getFolderNames(
                DebugUtils.parseStrArr1("[\"wano\",\"wano\",\"wano\",\"wano\"]"))));
        System.out.println(Arrays.toString(new Solution().getFolderNames(
                DebugUtils.parseStrArr1("[\"kaido\",\"kaido(1)\",\"kaido\",\"kaido(1)\"]"))));

    }
}
