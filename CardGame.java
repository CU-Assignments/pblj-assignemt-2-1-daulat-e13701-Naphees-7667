import java.util.*;

class Card {
    String symbol;
    int number;

    public Card(String symbol, int number) {
        this.symbol = symbol;
        this.number = number;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getNumber() {
        return number;
    }
}

public class CardGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<Card>> cardMap = new TreeMap<>();

        System.out.println("Enter Number of Cards: ");
        int n = scanner.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println("Enter card " + i + ":");
            String symbol = scanner.next();
            int number = scanner.nextInt();

            cardMap.putIfAbsent(symbol, new ArrayList<>());
            cardMap.get(symbol).add(new Card(symbol, number));
        }

        // Print distinct symbols in alphabetical order
        System.out.println("Distinct Symbols are: ");
        for (String key : cardMap.keySet()) {
            System.out.print(key + " ");
        }
        System.out.println();

        // Print card details for each symbol
        for (String symbol : cardMap.keySet()) {
            List<Card> cards = cardMap.get(symbol);
            System.out.println("Cards in " + symbol + " Symbol");
            int sum = 0;
            for (Card card : cards) {
                System.out.println(card.getSymbol() + " " + card.getNumber());
                sum += card.getNumber();
            }
            System.out.println("Number of cards: " + cards.size());
            System.out.println("Sum of Numbers: " + sum);
        }

        scanner.close();
    }
}
