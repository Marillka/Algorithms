package lesson5_Рекурсия.HomeWork;

public class ExponentiationWithRecursion {

    public static void main(String[] args) {
        System.out.println(exponentiation(14,4));
    }

    public static double exponentiation(double number, double degree) {
        // Если нулевая степень
        if (degree == 0) {
            return 1;
        }
        // Если степень равна 1
        if (degree == 1) {
            return number;
        }
        degree--;
        return number * exponentiation(number, degree);
    }
}
