/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds;

/**
 *
 * @author Nandan
 */
import java.util.* ;
import java.io.*;
import java.util.concurrent.TimeUnit ;
public class DS 
{

    static int G[][] = new int[100][100] ;
    static int rows , columns  ;
    static int sr  , sc , er , ec ;
    public static void main(String[] args) throws Exception 
    {
        File file = new File("C:\\Users\\Nandan\\Documents\\NetBeansProjects\\DS\\maze1.txt");
    Scanner in = new Scanner(file);
    
    int n=0 , i =0;
    while (in.hasNextLine())
    {
    
        String s = in.nextLine();
        n = s.length();
        for(int j = 0 ; j < s.length() ; j++)
        {
            if(s.charAt(j)=='%')
            {
                System.out.print("|");
                G[i][j] = 0 ;
            }
            else if(s.charAt(j)=='S')
            {
                System.out.print("S");
                G[i][j] = 1 ;
                sr = i ;
                sc = j ;
            }
                else if(s.charAt(j)=='E')
                {
                    System.out.print("E");
                G[i][j] = 1 ;
                er = i ;
                        ec = j;
                }
            else
                {
                System.out.print(" ");
                G[i][j] = 1 ;
            }
        }
        i++;
        System.out.println();
    }
    rows = i ;
    columns = n ;
    //while(true){
    for(int k=0; k <rows ; k++)
    {
        for(int j=0 ; j < columns ; j++)
        {
            /*if(k==1 && j==1)
                System.out.print("P");
else */     if(k== sr && j==sc)
                System.out.print("S ");
else if(k==er && j==ec)
                System.out.print("E ");
            else
            System.out.print(G[k][j]+" ");
        }
        System.out.println();
    }
   // 
    System.out.println(sr+" "+sc+" \n"+er+" "+ec);
    //System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    //TimeUnit.SECONDS.sleep(2); 
    solution = new int[rows][columns];
    for (int l = 0; l < rows; l++) {
	for (int j = 0; j < columns; j++) {
	solution[l][j] = 0;
   
    
    //DFS(G,3);
    }
    
    
	 

	//initialize the solution matrix in constructor.
	
		
			}
    
    new DS().solveMaze(G, rows , columns);
		}
	
public static int[][] solution;
	public void solveMaze(int[][] maze, int row , int col) {
		if (findPath(maze, 0, 0, row,col, "down")) {
			print(solution, row,col);
		}else{
			System.out.println("NO PATH FOUND");
		}
		
	}

	public boolean findPath(int[][] maze, int x, int y, int row,int col, String direction) {
		// check if maze[x][y] is feasible to move
		if(x==row-1 && y==col-1){//we have reached
			solution[x][y] = 1;
                       //print(solution,row,col);
			return true;
		}
		if (isSafeToGo(maze, x, y,row,col)) {
			// move to maze[x][y]
			solution[x][y] = 1;			
			// now rat has four options, either go right OR go down or left or go up
                        

                        if(direction!="up" && findPath(maze, x+1, y, row,col, "down")){ //go down
				return true;
			}

                       	if(direction!="right" &&  findPath(maze, x, y-1, row,col, "left")){ //go left
				return true;
			}
                        
                        if(direction!="left" && findPath(maze, x, y+1,row,col,"right")){ //go right
				return true;
			}
                        if(direction!="down" && findPath(maze, x-1, y, row,col, "up")){ //go up
				return true;
			}
                        

			
			




			//if none of the options work out BACKTRACK undo the move
			solution[x][y] = 0;
			return false;
		}
		return false;
	}

	// this function will check if mouse can move to this cell
	public boolean isSafeToGo(int[][] maze, int x, int y, int row, int col) {
		// check if x and y are in limits and cell is not blocked
		if (x >=0 && y >= 0 && x < row  && y < col && maze[x][y] != 0) {
			return true;
		}
		return false;
	}
	public void print(int [][] solution, int row,int col){
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print(" " + solution[i][j]);
			}
			System.out.println();
		}
	}
    
    
    }
    
    
    
    
    
    
    
    

