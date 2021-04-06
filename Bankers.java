/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankers;

/**
 *
 * @author hp
 */import java.util.Scanner;
public class Bankers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner in= new Scanner(System.in);
        int[][] allocation=new int[5][3];
        int[][] available= new int[1][3];
        int[][] max=new int[5][3];
        int[][] need= new int[5][3];
        int[] process= new int[5];
        int[] wait= new int[5];
        int a=0,flag=1,k=1,b=0,c=0,temp2=1;
        try{
        System.out.println("Enter available instances");
        
            for(int j=0;j<3;j++)
            {
                available[0][j]=in.nextInt();
            }
        
        System.out.println("Enter allocation matrix");
        for(int i=0;i<5;i++)
        {
            for(int j=0;j<3;j++)
            {
                allocation[i][j]=in.nextInt();
            }
        }
        System.out.println("Enter maximum matrix");
        for(int i=0;i<5;i++)
        {
            for(int j=0;j<3;j++)
            {
                max[i][j]=in.nextInt();
            }
        }
        
        for(int i=0;i<5;i++)
        {
            for(int j=0;j<3;j++)
            {
                need[i][j]=max[i][j]-allocation[i][j];
            }
        }
        }
        catch(Exception e)
        {
            System.out.println("bye");
        }
        
        for(int i=0;i<5;i++)
        {
            flag=1;
            for(int j=0;j<3;j++)
            {
                if(available[0][j]<need[i][j])
                    flag=0;
            }
            if(flag==0)
            {
                wait[a]=k;
                a++;
                k++;
            }
            else 
            {
                for(int j=0;j<3;j++)
                    available[0][j]=available[0][j]+allocation[i][j];
                process[b]=k;
                b++;
                k++;
            }
        }
        
        System.out.println("Allocation matrix\n");
        for(int i=0;i<5;i++)
        {
            for(int j=0;j<3;j++)
            {
                System.out.print(allocation[i][j]+" ");
            }
            System.out.print("\n");
        }
        System.out.println("Max matrix\n");
        for(int i=0;i<5;i++)
        {
            for(int j=0;j<3;j++)
            {
                System.out.print(max[i][j]+" ");
            }
            System.out.print("\n");
        }
        System.out.println("need matrix\n");
        for(int i=0;i<5;i++)
        {
            for(int j=0;j<3;j++)
            {
                System.out.print(need[i][j]+" ");
            }
            System.out.print("\n");
        }
        
        for(int i=0;i<5;i++)
        {
            int temp=1;
            if(wait[i]!=0)
            {
                for(int x=wait[i];x<wait[i]+1;x++)
                {
                    for(int j=0;j<3;j++)
                    {
                        if(available[0][j]<need[x][j])
                           temp=0;
                    }
                
                
            
            if(temp==1)
            {
                for(int j=0;j<3;j++)
                    available[0][j]=available[0][j]+allocation[x][j];
                process[b]=wait[i];
                b++;
                
            }
        }
    }
  }
        for(int i=0;i<5;i++)
        {
            if(process[i]==0)
                temp2=0;
        }
        if(temp2==0)
            System.out.println("Not a safe sequence");
        else
        {    System.out.println("Safe sequence: ");
            for(int i=0;i<5;i++)
            {
                System.out.print("process:"+process[i]+" ");
                
        }
        }
    }
    

}