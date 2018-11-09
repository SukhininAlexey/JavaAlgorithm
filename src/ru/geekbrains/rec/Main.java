package ru.geekbrains.rec;

public class Main {

    // Считает любые целые положительные и отрицательные степени в пределах ёмкости double первого аргумента.
    // Так же работает степень 0, то есть выводит 1. Не считает только дробные степени. Но это уже задача нахождения корня.
    private static double powSlow(double x, int y){
        if(y > 0){
            return x* powSlow(x, y - 1);
        } else if(y < 0) {
            return 1/x* powSlow(x, y + 1);
        } else {
            return 1;
        }
    }

    private static double powQuick(double x, int y){
        if(y % 2 != 0){ // Шаг 1: Забирает все нечетные случаи. Остаются четные и нулевые.
            if(y > 0){
                return x * powQuick(x, y - 1); // Задаёт первый множитель для положительной степени.
            }
            else if(y < 0) {
                return 1 / x * powQuick(x, y + 1); // Задает первый множитель для отрицательной степени.
            }
            return 1;
        } else if(y != 0) { // Шаг 2: Забирает оставшиеся четные случаи, но не берет нулевые. Остаются нулевые.
            double tmp = powQuick(x, y / 2);
            return tmp * tmp;
        }
        return 1; // Шаг 3: Общий случай: обрабатывает оставшийся нулевой случай.
    }

    public static void main(String[] args) {
        double arg = 2;
        int pow = -1000;

        double slowResult, quickResult;
        long slowTime, quickTime;

        slowTime = System.nanoTime();
        slowResult = powSlow(arg, pow);
        slowTime = System.nanoTime() - slowTime;

        quickTime = System.nanoTime();
        quickResult = powQuick(arg, pow);
        quickTime = System.nanoTime() - quickTime;

        System.out.println("Результат  powSlow: " + arg + " ^ " + pow + " = " + slowResult + "; за " + slowTime + " нс.");
        System.out.println("Результат powQuick: " + arg + " ^ " + pow + " = " + quickResult + "; за " + quickTime + " нс.");
    }
}
