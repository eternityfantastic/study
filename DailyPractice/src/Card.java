import java.beans.PersistenceDelegate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class Card {
    private String suit;    //花色
    private String num;     //点数

    public Card(String suit, String num) {
        this.suit = suit;
        this.num = num;
    }

    @Override
    public String toString() {
        return "Card{" + "suit='" + suit + '\'' + ", num='" + num + '\'' + '}';
    }
}

class PlayCard {
    public ArrayList<Card> makeCard() {

        final String[] suit = {"♥", "♠", "♦", "♣"};
        final String[] num = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

        ArrayList<Card> cards = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                cards.add(new Card(suit[i], num[j]));
            }
        }
        return cards;
    }

    private void swap(ArrayList<Card> cards, int i, int j) {
        Card temp = cards.get(i);
        cards.set(i, cards.get(j));
        cards.set(j, temp);

    }

    public void washCard(ArrayList<Card> cards) {
        Random random = new Random();
        for (int i = cards.size() - 1; i > 0; i--) {
            swap(cards, i, random.nextInt(i));
        }
    }
    ArrayList<ArrayList<Card>> personCard = new ArrayList<>();

    {
        personCard.add(new ArrayList<>());
        personCard.add(new ArrayList<>());
        personCard.add(new ArrayList<>());
    }

    public void playGame(ArrayList<Card> cards,Collection<ArrayList<Card>> personCard) {
         for (int i = 0; i < 3; i++) {
            //三个人
            for (int j = 0; j < 3; j++) {
                ((ArrayList<ArrayList<Card>>) personCard).get(j).add(i, cards.remove(0));
            }
        }
    }

}

class CardTest {
    public static void main(String[] args) {
        PlayCard p = new PlayCard();
        ArrayList<Card> cards = p.makeCard();
        System.out.println(cards);
        p.washCard(cards);
        System.out.println(cards);
        p.playGame(cards,p.personCard);
        System.out.println(p.personCard.get(0));
        System.out.println(p.personCard.get(1));
        System.out.println(p.personCard.get(2));
    }
}
