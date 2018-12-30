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
import java.io.*;
import java.util.*;
public class Maze1 
{
    int G[][] = new int[100][100] ;
    int solution[][] = new int[100][100] ;
    int rows , columns ;
    
    
    public void getmaze() throws FileNotFoundException
    {
        File file = new File("C:\\Users\\Nandan\\Documents\\NetBeansProjects\\DS\\maze1.txt");
        Scanner in = new Scanner(file);
        int i =0;
        while(in.hasNextLine())
        {
            String s = in.nextLine();
            for(int j = 0 ; j < s.length() ; j++)
            {
                if(s.charAt(j)=='S')
                {
                    G[i][j] = 1 ;
                    System.out.print(" ");
                }
                else if(s.charAt(j)=='%')
                {
                    G[i][j] = 0 ;
                    System.out.print("|");
                }
                else if(s.charAt(j)==' ')
                {
                    G[i][j] = 1 ;
                    System.out.print(" ");
                }
                else if(s.charAt(j)=='E')
                {
                    G[i][j] = 1 ;
                    System.out.print(" ");
                } 
            }
            System.out.println();
            columns = s.length()-1;
            i++;
        }
        
        rows = i ;
        System.out.println("\n\n\n\n\n");
        print(G); 
        System.out.println("\n\n\n\n\n");
        findthepath(G,0,0,"down");
               
    }
    
    public void print(int G[][])
    {
        for(int i=0 ; i< rows ; i++)
        {
            for(int j=0 ; j < columns ; j++)
            {
                System.out.print(G[i][j]);
            }
            System.out.println();
        }
    }

    public boolean findthepath(int G[][] , int x , int y , String direction)
    {
        if(x==rows-1 && y== columns-1)
        {
            solution[x][y] = 1 ;
            print(solution);
            return true;
        }
        
        if(x >= 0 && y >= 0 && x < rows && y < columns && G[x][y] != 0)
        {
            solution[x][y] = 1 ;
            if(!direction.equals("up") && findthepath(G , x+1 , y ,"down" ))
            {
                return true ;             
            }
            if(!direction.equals("right") && findthepath(G , x , y-1 ,"left" ))
            {
                return true ;             
            }
            if(!direction.equals("left") && findthepath(G , x , y+1,"right" ))
            {
                return true ;             
            }
            if(!direction.equals("down") && findthepath(G , x-1 , y ,"up" ))
            {
                return true ;             
            }

                
        
        
        
            solution[x][y] = 0 ;
            return false ;
        }
    
        return false ;
        
    }
    
    
   
    
  
    
    
    
    public static void main(String... args) throws Exception
    {
        Maze1 ob = new Maze1();
        ob.getmaze();
    }
}
