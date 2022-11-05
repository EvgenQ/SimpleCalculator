import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите арифметическую операцию в одну строку без пробелов.");
        String input = scan.nextLine().toUpperCase();
        System.out.println(calc(input));
    }

    public static String calc(String input)
    {
        if(input.contains("+"))
        {
            String[] numbers = input.split("\\+");
            if (numbers.length < 2)
            {
                throw new IllegalArgumentException("Нет второго операнда.");
            }
            if (numbers.length > 2)
            {
                throw new IllegalArgumentException("Операнда больше чем 2.");
            }
            int sum = 0;
            for (String number: numbers)
            {
                if(isNumber(number))
                {
                    if (Integer.parseInt(number) > 10)
                    {
                        return "Одно из чисел больше 10 повторите попытку.";
                    }
                    sum += Integer.parseInt(number);
                }
                else
                {
                    return "Ошибка при вводе строка содержит недопустимые символы или пробелы -> " + input;
                }
            }
            return "Ответ = " + sum;
        }

        if(input.contains("-"))
        {
            String[] numbers = input.split("-");
            int sum = 0;
            for (String number: numbers)
            {
                if(isNumber(number))
                {
                    if (Integer.parseInt(number) > 10)
                    {
                        return "Одно из чисел больше 10 повторите попытку.";
                    }
                    sum -= Integer.parseInt(number);
                }
                else
                {
                    return "Ошибка при вводе строка содержит недопустимые символы или пробелы -> " + input;
                }
            }
            return "Ответ = " + sum;
        }

        if(input.contains("/"))
        {
            String[] numbers = input.split("/");
            int sum = 0;
            for (String number: numbers)
            {
                if(isNumber(number))
                {
                    if (Integer.parseInt(number) > 10)
                    {
                        return "Одно из чисел больше 10 повторите попытку.";
                    }
                    if(Integer.parseInt(number) == 0)
                    {
                        throw new ArithmeticException("На ноль делить нельзя.");
                    }
                }
                else
                {
                    return "Ошибка при вводе строка содержит недопустимые символы или пробелы -> " + input;
                }
            }
            sum = Integer.parseInt(numbers[0]) / Integer.parseInt(numbers[1]);
            return "Ответ = " + sum;
        }

        if(input.contains("*"))
        {
            String[] numbers = input.split("\\*");
            int sum = 0;
            for (String number: numbers)
            {
                if(isNumber(number))
                {
                    if (Integer.parseInt(number) > 10)
                    {
                        return "Одно из чисел больше 10 повторите попытку.";
                    }
                }
                else
                {
                    return "Ошибка при вводе строка содержит недопустимые символы или пробелы -> " + input;
                }
            }
            sum = Integer.parseInt(numbers[0]) * Integer.parseInt(numbers[1]);
            return "Ответ = " + sum;
        }
        return "Решение";
    }

    private static boolean isNumber(String number)
    {
        try
        {
            Integer.parseInt(number);
            return true;
        }
        catch (NumberFormatException ex)
        {
            return false;
        }
    }
    private static boolean romanNumber(String[] numbers)
    {
        for (int i = 0; i < numbers.length; i++)
        {

        }
        return true;
    }
}