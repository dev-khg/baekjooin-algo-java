class Solution {
    static int dfs(boolean[] visited, int[][] board, int node) {
        int result = 1;
        visited[node]  = true;
        for(int i = 1; i < board.length; i++) {
            if(board[node][i] == 1 && !visited[i]) {
                result += dfs(visited, board, i);
            }
        }
        
        return result;
    }
    
    public int solution(int n, int[][] wires) {
        int answer = 100000;
        int[][] board = new int[n + 1][n + 1];
        
        for(int i = 0; i < wires.length; i++) {
            int[] pick = wires[i];
            board[pick[0]][pick[1]] = 1;
            board[pick[1]][pick[0]] = 1;
        }
        
        for(int i = 0; i < wires.length; i++) {
            int[] pick = wires[i];
            board[pick[0]][pick[1]] = 0;
            board[pick[1]][pick[0]] = 0;
            
            boolean[] visited = new boolean[n + 1];
            
            int count1 = dfs(visited, board, pick[0]);
            int count2 = dfs(visited, board, pick[1]);
            
            answer = Math.min(answer, Math.abs(count1 - count2));            
            
            board[pick[0]][pick[1]] = 1;
            board[pick[1]][pick[0]] = 1;
        }
        
        return answer;
    }
}