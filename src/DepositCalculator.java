import java.util.Scanner;

public class DepositCalculator {
    public static void main(String[] args) {
        new DepositCalculator().processMenu();
    }

    double calculateComplexPercent(double amount, int depositPeriod) {
        double pay = amount * Math.pow(1.005, 12.0 * depositPeriod);
        return calculateAmount(pay);
    }

    double calculateSimplePercent(double amount, int depositPeriod) {
        double pay = amount * (1 + 0.06 * depositPeriod);
        return calculateAmount(pay);
    }

    double calculateAmount(double multiplier) {
        double level = Math.pow(10, 2);
        return Math.round(multiplier * level) / level;
    }

    void processMenu() {
        int period;
        int action;
        int amount;
        double outAmount;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        amount = scanner.nextInt();

        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();

        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();

        outAmount = 0;
        if (action == 1) outAmount = calculateSimplePercent(amount, period);
        else if (action == 2) outAmount = calculateComplexPercent(amount, period);

        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + outAmount);
    }

}
