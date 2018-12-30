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
public class DS2
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
    for(int k=0; k <30; k++)
    {
        for(int j=0 ; j < 30 ; j++)
        {
            /*if(k==1 && j==1)
                System.out.print("P");
else */     if(k== sr && j==sc)
                System.out.print("S, ");
else if(k==er && j==ec)
                System.out.print("E, ");
            else
            System.out.print(G[k][j]+", ");
        }
        System.out.println();
    }
   // 
    System.out.println(sr+" "+sc+" \n"+er+" "+ec);
    //System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    //TimeUnit.SECONDS.sleep(2); 
    DFS();
    }
    
    
    public static void DFS()
    {
        Stack<String> stack = new Stack<String>();
        Stack<String> visited = new Stack<String>();
        stack.push(0+" "+0);
        visited.push(0+" "+0);
        
        //while(!stack.contains(9+" "+21))       {
            String s[] = stack.peek().split(" ");
            int row , col ;
            row = Integer.parseInt(s[0]);
            col  = Integer.parseInt(s[1]);
            System.out.println(row+" "+col);
            
             //left
            if(col-1>0)
            {
                if(G[row][col-1] != 0 && !stack.contains(row+" "+(col-1)))
                    stack.push(row+" "+(col-1));                
            }
            
            

            
            //down 
            if(row+1 < rows)
            {
                  if(G[row+1][col] != 0 && !stack.contains((row+1)+" "+(col)))
                    stack.push((row+1)+" "+(col));              
            }
            
                        //right
            if(col+1 < columns )
            {
                if(G[row][col+1] != 0 && !stack.contains(row+" "+(col+1)))
                    stack.push(row+" "+(col+1));
                
                                        
            }

            //up
            if(row-1 > 0)
            {
                    if(G[row-1][col] != 0 && !stack.contains((row-1)+" "+(col)))
                    stack.push((row-1)+" "+(col));                 
            }
            
         //  if(row>0 && row < rows && col > 0 && col < columns && )
                
          
               
       // }
        
        for(String s1 : stack)
            System.out.println(s1);
        
    }
}
