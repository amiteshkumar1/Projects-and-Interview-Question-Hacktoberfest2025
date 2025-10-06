class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int h1=heights.length;
        int h2=heights[0].length;
        boolean[][] pacific= new boolean[h1][h2];
        boolean[][] atlantic= new boolean[h1][h2];
        for(int i=0;i<h1;i++){
            mark(i,0,pacific,-1,-1,heights);
            mark(i,h2-1,atlantic,-1,-1,heights);
        }
        for(int i=0;i<h2;i++){
            mark(0,i,pacific,-1,-1,heights);
            mark(h1-1,i,atlantic,-1,-1,heights);
        }
        List<List<Integer>> arr=new ArrayList<>();
        for(int i=0;i<h1;i++){
            for(int j=0;j<h2;j++){
                if(pacific[i][j]&& atlantic[i][j]){
                List<Integer> temp=new ArrayList<>();
                temp.add(i);
                temp.add(j);
                arr.add(temp);
                }
                
            }
        }
        return arr;
    }
    private void mark(int i,int j,boolean[][] temp,int oi,int oj,int[][] heights){
        if(i<0 || j<0 || i>=temp.length || j>=temp[0].length || temp[i][j] ||      (oi>=0 && oj>=0 && heights[oi][oj]>heights[i][j])) return;
        temp[i][j]=true;
        mark(i+1,j,temp,i,j,heights);
        mark(i,j+1,temp,i,j,heights);
        mark(i-1,j,temp,i,j,heights);
        mark(i,j-1,temp,i,j,heights);
    }
}
