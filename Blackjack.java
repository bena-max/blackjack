import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;


public class Blackjack 
{
    public static void main(String[] args)
{
    Deck deck = new Deck();

    //for (int i = 0; i < deck.getCardAmount(); i++)
    //{
      //  deck.deck.get(i).printcard();
        //System.out.println();
    //}

    Hand player = new Hand();

    player.addCard(deck.dealCard());
    player.addCard(deck.dealCard());

   for (int i = 0; i < player.Hands.size(); i ++)
   {
    player.Hands.get(i).printcard();
   }

   System.out.println("Score: " + player.getScore());
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