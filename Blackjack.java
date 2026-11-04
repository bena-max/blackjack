import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;
import java.util.Scanner;


public class Blackjack 
{
    public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    Deck deck = new Deck();

    //for (int i = 0; i < deck.getCardAmount(); i++)
    //{
      //  deck.deck.get(i).printcard();
        //System.out.println();
    //}

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

   if(player.getScore() > 21)
    System.out.println("Bust!! You lose");

else if(dealer.getScore() > 21)
    System.out.println("Dealer Busted!!. You win!!");

else if(player.getScore() > dealer.getScore())
    System.out.println("You win!!");

else if(dealer.getScore() > player.getScore())
    System.out.println("You lose!!");

else
    System.out.println("Tieee!!");
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
        System.out.println("your cards value is: " + this.value + " and your card suit is: " + this.suit);
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