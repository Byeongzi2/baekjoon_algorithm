class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[] {0, 0};
        int forth = 0;
        int sum = 0;
        int len = 1_000_000;
        
        for (int back = 0; back < sequence.length; back++) {
            sum += sequence[back];
            
            if (sum == k) {
                if (len > back - forth) {
                    answer[0] = forth;
                    answer[1] = back;
                    len = back - forth;
                }
                sum -= sequence[forth];
                forth++;
                continue;
            }
            
            if (sum > k) {
                sum -= sequence[forth];
                forth++;
                sum -= sequence[back];
                back--;
            }
        }
        
        return answer;
    }
}