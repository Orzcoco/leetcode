package com.lp;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
    	
    	if(board==null) return false;
    	int rowlength = board.length;
    	int collength = board[0].length;
    	int[][] visited=new int[rowlength][collength];
    	for(int i=0;i<rowlength;i++){
    		for(int j=0;j<collength;j++){
    			visited[i][j]=0;
    		}
    	}
    	char[] wordarr = word.toCharArray();
    	for(int i=0;i<rowlength;i++){
    		for(int j=0;j<collength;j++){
    			if(wordarr[0]==board[i][j]){
    				visited[i][j]=1;
    				boolean a = find(board, visited, i-1, j, wordarr, 1);
    				boolean b = find(board, visited, i+1, j, wordarr, 1);
    				boolean c = find(board, visited, i, j-1, wordarr, 1);
    				boolean d = find(board, visited, i, j+1, wordarr, 1);
    				if(a||b||c||d) return true;
    				else visited[i][j]=0;
    			}
    		}
    	}
    	
		return false;
        
    }
    
    private boolean find(char[][] board,int[][] visited,int row,int col,char[] wordarr,int pos){
    	if(row>=board.length||row<0||col>=board[0].length||col<0) return false;
    	if(pos>=wordarr.length) return true;
    	
    	if(visited[row][col]==0&&wordarr[pos]==board[row][col]){
    		visited[row][col]=1;
    		boolean a= find(board, visited, row-1, col, wordarr, pos+1);
    		boolean b= find(board, visited, row+1, col, wordarr, pos+1);
    		boolean c= find(board, visited, row, col-1, wordarr, pos+1);
    		boolean d= find(board, visited, row, col+1, wordarr, pos+1);
    		if(a||b||c||d) return true;
    		else visited[row][col]=0;
    		
    	}
		return false;
    	
    }
    
    public static void main(String[] args) {
		WordSearch solution = new WordSearch();
		char[][] aa={{'a','b','c','e'},{'s','f','c','s'},{'a','d','e','e'}};
		String a = "abcced";
		String b = "see";
		String c = "abcb";
		System.out.println(solution.exist(aa, a));
		System.out.println(solution.exist(aa, b));
		System.out.println(solution.exist(aa, c));
	}
}