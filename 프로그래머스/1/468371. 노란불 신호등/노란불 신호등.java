class Solution {
    public int solution(int[][] signals) {
        int limit = 1;
        int n = signals.length;
        int[] periods = new int[n];
        
        for (int i = 0; i < n; ++i) {
            int g = signals[i][0];
            int y = signals[i][1];
            int r = signals[i][2];
            periods[i] = g + y + r;
            limit = getLcm(limit, periods[i]);
        }
        
        for (int t = 1; t <= limit; ++t) {
            int count = 0;
            
            for (int i = 0; i < n; ++i) {
                int remainder = t % periods[i];
                int g = signals[i][0];
                int y = signals[i][1];
                
                if (g < remainder && remainder <= g + y) {
                    count++;
                }
            }
            
            if (count == n) {
                return t;
            }
        }
        
        return -1;
    }
    
    private int getLcm(int a, int b) {
        return (a * b) / getGcd(a, b);
    }
    
    private int getGcd(int a, int b) {
        int r = -1;
        
        while (r != 0) {
            r = a % b;
            a = b;
            b = r;
        }
        
        return a;
    }
}