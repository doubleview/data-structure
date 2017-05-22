package leetcode_algorithm;

/**

There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

        You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

        Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

        Note:
        The solution is guaranteed to be unique.

        Subscribe to see which companies asked this question.

*/

public class q134_GasStation {


    /**
     * ½â·¨1
     *
     * 1 If car starts at A and can not reach B. Any station between A and B
        can not reach B.(B is the first station that A can not reach.)
        2 If the total number of gas is bigger than the total number of cost. There must be a solution.

     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0 , total = 0 , tank = 0;
        for(int i = 0;i<gas.length;i++) {
            if ((tank = tank + gas[i] - cost[i]) < 0) {
                start=i+1;
                total+=tank;
                tank=0;
            }
        }
        return (total+tank<0)?-1 : start;
    }
}
