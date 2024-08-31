import java.util.List;
import java.util.stream.Collectors;

/**
 * Утилитный класс в котором каждый метод решает одну задачу
 * из списка задач на выполнение (в файле task.txt)
 * все методы статичные
 */

public class Tasks {
    private Tasks() {
    }

    public static void showTransactionsForYear(List<Transaction> transactions, Integer year) {
        List<Transaction> transactionForYear = transactions.stream()
                .filter(obj -> obj.getYear() == year)
                .sorted((t1, t2) -> t1.getYear() - t2.getYear())
                .collect(Collectors.toList());

        System.out.printf("\nТранзакции за %d год в порядке возрастания:\n", year);
        transactionForYear.forEach(System.out::println);
    }

    public static void showCitiesOfTraders(List<Transaction> transactions) {
        List<String> cities = transactions.stream()
                .map(obj -> obj.getTrader())
                .map(obj -> obj.getCity())
                .distinct()
                .collect(Collectors.toList());

        System.out.println("\nГорода в которых проживают трейдеры (без повторов):");
        cities.forEach(System.out::println);
    }

    public static void showTradersFrom(List<Transaction> transactions, String city) {
        List<String> names = transactions.stream()
                .map(obj -> obj.getTrader())
                .distinct()
                .filter(trader -> trader.getCity().equals(city))
                .map(obj -> obj.getName())
                .sorted((s1, s2) -> s1.compareTo(s2))
                .collect(Collectors.toList());

        System.out.printf("\nИмена трейдеров из %s:\n", city);
        names.forEach(System.out::println);
    }

    public static void showAllTraders(List<Transaction> transactions) {
        String tradersName = transactions.stream()
                .map(obj -> obj.getTrader().getName())
                .distinct()
                .sorted((s1, s2) -> s1.compareTo(s2))
                .collect(Collectors.joining(" "));

        System.out.println("\nИмена всех трейдеров в алфавитном порядке:\n" + tradersName);
    }

    public static void checkTraderFrom(List<Transaction> transactions, String city) {
        boolean isFromCity = transactions.stream()
                .map(obj -> obj.getTrader())
                .anyMatch(trader -> trader.getCity().equals(city));

        if (isFromCity)
            System.out.printf("\nТрейдер из города %s найден в списке транзакций.\n", city);
        else
            System.out.printf("\nТрейдер из города %s не найден в списке транзакций.\n", city);
    }

    public static void showAllTransactionsByCity(List<Transaction> transactions, String city) {
        List<Integer> values = transactions.stream()
                .filter(obj -> obj.getTrader().getCity().equals(city))
                .map(obj -> obj.getValue())
                .collect(Collectors.toList());

        System.out.printf("\nСуммы транзакций всех трейдеров из города %s\n", city);
        values.forEach(System.out::println);
    }

    public static void showMaxTransaction(List<Transaction> transactions) {
        int max = transactions.stream()
                .map(obj -> obj.getValue())
                .max((v1, v2) -> v1.compareTo(v2))
                .get();

        System.out.printf("\nМаксимальная сумма транзакции = %d\n", max);
    }

    public static void showMinTransaction(List<Transaction> transactions) {
        int min = transactions.stream()
                .map(obj -> obj.getValue())
                .min((v1, v2) -> v1.compareTo(v2))
                .get();

        System.out.printf("\nМинимальная сумма транзакции = %d\n", min);
    }
}
