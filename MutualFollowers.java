import java.util.*;

class Solution {
    public int[] solve(int[][] relations) {

        HashMap<Integer, Set<Integer>> hm=new HashMap<>();
        for(int [] r: relations){
            hm.putIfAbsent(r[0], new HashSet());
            hm.get(r[0]).add(r[1]);
        }
        Set<Integer> set=new HashSet<>();
        for(int i:hm.keySet()){
            for(int neighbours: hm.get(i)){
                boolean following=hm.containsKey(neighbours);
                boolean follow_back=hm.containsKey(neighbours) && 
                hm.get(neighbours).contains(i);
                if(following && follow_back)
                set.add(i);
            }
        }

        int [] res=new int[set.size()];
        int j=0;
        for(int a: set){
            res[j]=a;
            j++;
        }
        Arrays.sort(res);
        return res;
    }
}