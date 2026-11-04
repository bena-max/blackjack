import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;
import java.util.Scanner;


public class Blackjack 
{
    public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);

    String again = "yes";

    int chips = 100;
    int bet = 0;

    
    

    while(again.equals("yes"))
    {
        

        System.out.println("player has " + chips + " chips");
    Deck deck = new Deck();

    System.out.println("how much do you want to bet out of your balance?");
        bet = Integer.parseInt(input.nextLine());
    while(bet>chips || bet <= 0)
    {
        System.out.println("invalid bet try again");
        bet = Integer.parseInt(input.nextLine());
    }

    


    Hand player = new Hand();
    Hand dealer = new Hand();

    dealer.addCard(deck.dealCard());

    player.addCard(deck.dealCard());

    dealer.addCard(deck.dealCard());

    player.addCard(deck.dealCard());

    System.out.println("dealer card is:");
    dealer.Hands.get(0).printcard();


    System.out.println("Your cards are:");
   for (int i = 0; i < player.Hands.size(); i ++)
   {
    player.Hands.get(i).printcard();
   }
   System.out.println("Score: " + player.getScore());
   System.out.println("Hit or stand?");
   String choice = input.nextLine();
   System.out.println("You chose: " + choice);
   while (choice.equals("hit") && player.getScore() <= 21)
   {
    player.addCard(deck.dealCard());
    System.out.println("Score: " + player.getScore());
    choice = input.nextLine();
    System.out.println("Hit or stand?");

   }

   
   if(player.getScore() <= 21 )
   {
   while(dealer.getScore()<17)
   {
     dealer.addCard(deck.dealCard());

   }
    

   System.out.println("New dealer Score is : " + dealer.getScore());
   }

   if(player.getScore() > 21){
    System.out.println("Bust!! You lose");
    chips -= bet;
    }
else if(dealer.getScore() > 21){
    System.out.println("Dealer Busted!!. You win!!");
    chips+=bet;
}

else if(player.getScore() > dealer.getScore()){
    System.out.println("You win!!");
    chips += bet;
}

else if(dealer.getScore() > player.getScore()){
    System.out.println("You lose!!");
    chips -= bet;
}

else
    System.out.println("Tieee!!");


if(chips == 0)
{
    System.out.println("Broke boy get out of my game or give me more of your money");
    again = "no";
}

else{



System.out.println("do you want to play again? yes or no");

        

        again = input.nextLine();
        if(again.equals("no"))
            System.out.println("Thank you for playing have a great day");

}
            
}

        
}   

}

class cards
{
    private int value;
    private String suit;
    

    public cards(int value, String suit)
    {
        this.value = value;
        this.suit = suit;

    }

     public int getValue() {
        return value;
    }

    public String getSuit() {
        return suit;
    }

    public void printcard()
    {
        String name = "";
        if(this.value == 1)
        {
             name = "Ace";
        }
        else if(this.value == 11)
        {
             name = "Lilo/Messi";
        }
        else if(this.value == 12)
        {
             name = "Neta";
        }
        else if (this.value == 13)
        {
             name = "Ben";
        }
        else
            name = "" + value;
        System.out.println(name + " of " + this.suit);
    }
}


class Deck
{
    Random random = new Random();
    
    ArrayList <cards> deck = new ArrayList<cards>();
    
    public Deck()
    {
    
        String[] suits = {"Diamonds", "Hearts", "Clubs", "Spades"};

        for (int i = 0; i<suits.length;i++)
        {
            for(int j = 1; j <= 13; j++)
            {
                deck.add(new cards(j, suits[i]));
                
            }

        }
            Collections.shuffle(deck);


        
    }
    public int getCardAmount()
            {
                return deck.size();
            }


            public cards dealCard()
            {
                return deck.remove(0);
            }
}


class Hand
{
    ArrayList<cards> Hands = new ArrayList<cards>();

    public void addCard(cards c)
    {
        Hands.add(c);
    }

    public int getScore()
    {
        int aces = 0;
        int value = 0;
        int score = 0;
        for (int i = 0; i < Hands.size(); i ++)
        {
            
            value = Hands.get(i).getValue();
            if(value>10)
            {
                score+= 10;
            }


            else if(value == 1)
            {
                score+=11;
                aces ++;
            }
            else
                score+=value;
        }

        while (score>21 && aces>0)
        {
            score -= 10;
            aces--;
        }

        return score;
        
   
    }
}