class Solution {
    public int numIslands(char[][] grid) {
        if(grid.length==0) return 0;
        
        int row = grid.length;
        int col = grid[0].length;
        int grid_count = 0;
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                if(grid[i][j]=='1')
                {
                    grid_count+=1;
                    dfs(grid,i,j,row,col);
                }
            }
        }
        return grid_count;

    }

    public void dfs(char[][]grid, int i, int j,int row,int col)
    {
        if(grid[i][j]=='0') return;
        grid[i][j]='0';
        if(j+1<=col-1 && grid[i][j+1]=='1') dfs(grid,i,j+1,row,col);
        if(j-1>=0 && grid[i][j-1]=='1') dfs(grid,i,j-1,row,col);
        if(i+1<=row-1 && grid[i+1][j]=='1') dfs(grid,i+1,j,row,col);
        if(i-1>=0 && grid[i-1][j]=='1') dfs(grid,i-1,j,row,col);
    }
}