package arrays.backtracking;

public class AllPath {
    public static void main(String[] args) {
        boolean[][] maze= {
            {true,true,true},
            {true,true,true},
            {true,true,true}
        };

        int[][] path = new int[maze.length][maze[0].length];

        allPathPrint("",maze,0,0,path,1);
    }

    private static void allPathPrint(String p, boolean[][] maze, int r, int c, int[][] path, int step) {


        if(r==maze.length-1 && c == maze[0].length-1){
            path[r][c]=step;  // last step is also a step
            for (int i = 0; i < path.length; i++) {
                for(int j=0; j<path[0].length;j++){
                    System.out.print(path[i][j]+ " ");
                }
                System.out.println();
            }
            System.out.println(p);
            System.out.println();
            return;
        }

        if(!maze[r][c]){ // already explored, otherwise it will be infinite loop.
            return;
        }

        // I am considering this block in my path
        maze[r][c] =false;
        path[r][c]=step;

        if(r<maze.length-1){
            allPathPrint(p+'D', maze, r+1, c, path, step+1);
        }

        if(c<maze[0].length-1){
            allPathPrint(p+'R', maze, r, c+1, path, step+1);
        }

        if(r>0){
            allPathPrint(p+'U', maze, r-1, c, path, step+1);
        }

        if(c>0){
            allPathPrint(p+'L', maze, r, c-1, path, step+1);
        }


        // end of the function call, so need to remove the changes made.
        maze[r][c]=true;
        path[r][c]=0; // backtrack , make the block as 0


    }

}
