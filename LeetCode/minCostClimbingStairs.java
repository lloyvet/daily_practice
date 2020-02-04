public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length+1];
        if(cost.length==2){
            return Math.min(cost[0],cost[1]);
        }
        dp[0] = cost[0];
        dp[1] = cost[1];
        for(int i = 2; i <= cost.length; i++){
            dp[i] = Math.min(dp[i-1],dp[i-2]) + (i==cost.length ? 0 : cost[i]);
        }
        return dp[cost.length];
    }