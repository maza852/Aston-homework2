import java.util.Arrays;
import java.util.List;

public class PuttingIntoPractice {

    public static void main(String... args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        // 1 пункт задания
        Tasks.showTransactionsForYear(transactions, 2011);
        // 2 пункт задания
        Tasks.showCitiesOfTraders(transactions);
        // 3 пункт задания
        Tasks.showTradersFrom(transactions, "Cambridge");
        // 4 пункт задания
        Tasks.showAllTraders(transactions);
        // 5 пункт задания
        Tasks.checkTraderFrom(transactions, "Milan");
        // 6 пункт задания
        Tasks.showAllTransactionsByCity(transactions,"Cambridge");
        // 7 пункт задания
        Tasks.showMaxTransaction(transactions);
        // 8 пункт задания
        Tasks.showMinTransaction(transactions);
    }
}