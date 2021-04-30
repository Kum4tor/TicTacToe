import java.util.Scanner;
public class Tictactoe 
{
    
    String tic[]=new String[9];
    void getNumber()
    {
        int position;
        String valPosition="";
        String player="x",check=null;
        fillTheTable();
        System.out.println("TIC-TAC-TOE");
        display();
        Scanner sc=new Scanner(System.in);
        System.out.println("Player X can start the game");
        while(check==null)
        {
        System.out.println("Player " + player + " it's your turn to play");
        position=sc.nextInt();
        valPosition=String.valueOf(position);
        if(valPosition.equals(tic[position-1]))
        {
            tic[position-1]=player;
            display();
            if(player.equals("x"))
                player="o";
            else
                player="x";
            check=isWinner();
        }
        else
            System.out.println("This place is already occupied");
        }
        if(check.equalsIgnoreCase("draw"))
            System.out.println("This game has ended up in a tie");
        else
        {
            if(player.equals("x"))
                player="o";
            else
                player="x";
            System.out.println("Player "+ player + " has won the game");
        }
           
        
    }
    void fillTheTable()
    {
        int i;
        for(i=0;i<9;i++)
        {
            String j=String.valueOf(i+1);
            tic[i]=j;
        }
    }
    String isWinner()
    {
        String condition=null;
        int flag=0;
        for(int i=1;i<=8;i++)
        {
            condition=null;
            switch(i)
            {
                case 1:
                    condition=tic[0]+tic[1]+tic[2];
                    break;
                case 2:
                    condition=tic[3]+tic[4]+tic[5];
                    break;
                case 3:
                    condition=tic[6]+tic[7]+tic[8];
                    break;
                case 4:
                    condition=tic[0]+tic[3]+tic[6];
                    break;
                case 5:
                    condition=tic[1]+tic[4]+tic[7];
                    break;
                case 6:
                    condition=tic[2]+tic[5]+tic[8];
                    break;
                case 7:
                    condition=tic[0]+tic[4]+tic[8];
                    break;
                case 8:
                    condition=tic[2]+tic[4]+tic[6];
                    break;
            
                    
            }
            if(condition.equalsIgnoreCase("xxx"))
                return "x";
            else if(condition.equalsIgnoreCase("ooo"))
                return "o";
        }
            for(int j=0;j<=8;j++)
            {
                if(String.valueOf(j+1).equalsIgnoreCase(tic[j]))
                    flag++;
            }
            if(flag==0)
                return "Draw";
            return null;
    }
    void display()
    {
        System.out.println(tic[0]+" | "+tic[1]+" | "+tic[2]);
        System.out.println(tic[3]+" | "+tic[4]+" | "+tic[5]);
        System.out.println(tic[6]+" | "+tic[7]+" | "+tic[8]);
    }
    public static void main(String args[])
    {
        Tictactoe ob=new Tictactoe();
        ob.getNumber();
    }
}