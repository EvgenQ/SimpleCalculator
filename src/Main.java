import java.util.HashMap;
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
        int sum = 0;
        int a,b;
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

            if(arabNumber(numbers[0]) && arabNumber(numbers[1]))
            {
                for (String number: numbers)
                {
                    if (Integer.parseInt(number) > 10)
                    {
                        throw new IllegalArgumentException("Одно из чисел больше 10 повторите попытку.");
                    }
                    sum += Integer.parseInt(number);
                }
            }
            else if (romanNumber(numbers[0]) && romanNumber(numbers[1]))
            {
                a = covertToArabianNumber(numbers[0]);
                b = covertToArabianNumber(numbers[1]);
                if(a > 10 || b > 10)
                {
                    throw new IllegalArgumentException("Одно из чисел больше 10 повторите попытку.");
                }
                sum = a+b;
                String roman = convertToRomanNumber(sum);
                return "Ответ: " + input + " = " + roman;
            }
            else
            {
                throw new IllegalArgumentException("Ошибка при вводе строка содержит недопустимые символы или пробелы ->" + input);
            }

            return "Ответ: " + input + " = " + sum;
        }

        if(input.contains("-"))
        {
            String[] numbers = input.split("-");
            if (numbers.length < 2)
            {
                throw new IllegalArgumentException("Нет второго операнда.");
            }
            if (numbers.length > 2)
            {
                throw new IllegalArgumentException("Операнда больше чем 2.");
            }

            if(arabNumber(numbers[0]) && arabNumber(numbers[1]))
            {
                for (String number: numbers)
                {
                    if (Integer.parseInt(number) > 10)
                    {
                        throw new IllegalArgumentException("Одно из чисел больше 10 повторите попытку.");
                    }
                    sum -= Integer.parseInt(number);
                }
            }
            else if (romanNumber(numbers[0]) && romanNumber(numbers[1]))
            {
                a = covertToArabianNumber(numbers[0]);
                b = covertToArabianNumber(numbers[1]);
                if(a > 10 || b > 10)
                {
                    throw new IllegalArgumentException("Одно из чисел больше 10 повторите попытку.");
                }
                sum = a-b;
                if(sum < 1)
                {
                    throw new IllegalArgumentException("Римские числа не содержат число меньше одного Ваш ответ = " + sum);
                }
                String roman = convertToRomanNumber(sum);
                return "Ответ: " + input + " = " + roman;
            }
            else
            {
                throw new IllegalArgumentException("Ошибка при вводе строка содержит недопустимые символы или пробелы ->" + input);
            }

            return "Ответ: " + input + " = " + sum;

        }

        if(input.contains("/"))
        {
            String[] numbers = input.split("/");
            if (numbers.length < 2)
            {
                throw new IllegalArgumentException("Нет второго операнда.");
            }
            if (numbers.length > 2)
            {
                throw new IllegalArgumentException("Операнда больше чем 2.");
            }

            if(arabNumber(numbers[0]) && arabNumber(numbers[1]))
            {
                for (String number: numbers)
                {
                    if (Integer.parseInt(number) > 10)
                    {
                        throw new IllegalArgumentException("Одно из чисел больше 10 повторите попытку.");
                    }
                    if (Integer.parseInt(number) == 0)
                    {
                        throw new ArithmeticException("На ноль делить нельзя.");
                    }
                    sum /= Integer.parseInt(number);
                }
            }
            else if (romanNumber(numbers[0]) && romanNumber(numbers[1]))
            {
                a = covertToArabianNumber(numbers[0]);
                b = covertToArabianNumber(numbers[1]);
                if(a > 10 || b > 10)
                {
                    throw new IllegalArgumentException("Одно из чисел больше 10 повторите попытку.");
                }
                sum = a/b;
                String roman = convertToRomanNumber(sum);
                return "Ответ: " + input + " = " + roman;
            }
            else
            {
                throw new IllegalArgumentException("Ошибка при вводе строка содержит недопустимые символы или пробелы ->" + input);
            }

            return "Ответ: " + input + " = " + sum;
        }

        if(input.contains("*"))
        {
            String[] numbers = input.split("\\*");
            if (numbers.length < 2)
            {
                throw new IllegalArgumentException("Нет второго операнда.");
            }
            if (numbers.length > 2)
            {
                throw new IllegalArgumentException("Операнда больше чем 2.");
            }

            if(arabNumber(numbers[0]) && arabNumber(numbers[1]))
            {
                for (String number: numbers)
                {
                    if (Integer.parseInt(number) > 10)
                    {
                        throw new IllegalArgumentException("Одно из чисел больше 10 повторите попытку.");
                    }
                    sum *= Integer.parseInt(number);
                }
            }
            else if (romanNumber(numbers[0]) && romanNumber(numbers[1]))
            {
                a = covertToArabianNumber(numbers[0]);
                b = covertToArabianNumber(numbers[1]);
                if(a > 10 || b > 10)
                {
                    throw new IllegalArgumentException("Одно из чисел больше 10 повторите попытку.");
                }
                sum = a*b;
                String roman = convertToRomanNumber(sum);
                return "Ответ: " + input + " = " + roman;
            }
            else
            {
                throw new IllegalArgumentException("Ошибка при вводе строка содержит недопустимые символы или пробелы ->" + input);
            }

            return "Ответ: " + input + " = " + sum;
        }
        return "Решение";
    }

    private static String convertToRomanNumber(int sum)
    {
        String newSum = String.valueOf(sum);
        Map<Integer,String> arabian = new HashMap<>();
        arabian.put(1,"I");
        arabian.put(2,"II");
        arabian.put(3,"III");
        arabian.put(4,"IV");
        arabian.put(5,"V");
        arabian.put(6,"VI");
        arabian.put(7,"VII");
        arabian.put(8,"VIII");
        arabian.put(9,"IX");
        arabian.put(10,"X");
        arabian.put(20,"XX");
        arabian.put(30,"XXX");
        arabian.put(40,"XL");
        arabian.put(50,"L");
        arabian.put(60,"LX");
        arabian.put(70,"LXX");
        arabian.put(80,"LXXX");
        arabian.put(90,"XC");
        arabian.put(100,"C");

        String num = "";
        String num2 = "";
        int discharge = newSum.length();
        for (int i = 0; i < newSum.length(); i++)
        {
            num += newSum.charAt(i);
            if(Integer.parseInt(num) == 0)
            {
                discharge--;
                //break;
            }
            else if(discharge == 3)
            {
                int a = Integer.parseInt(num) * 100;
                num2 = arabian.get(a);
                discharge--;
            }
            else if(discharge == 2)
            {
                int a = Integer.parseInt(num) * 10;
                num2 += arabian.get(a);
                discharge--;
            }
            else if(discharge == 1)
            {
                int a = Integer.parseInt(num);
                num2 += arabian.get(a);
                discharge--;
            }
            num = "";
        }

        return num2;
    }

    private static int covertToArabianNumber(String romanNumber)
    {
        int arabianNumber;
        Map<String,Integer> roman = new HashMap<>();
        roman.put("I",1);
        roman.put("II",2);
        roman.put("III",3);
        roman.put("IV",4);
        roman.put("V",5);
        roman.put("VI",6);
        roman.put("VII",7);
        roman.put("VIII",8);
        roman.put("IX",9);
        roman.put("X",10);

        arabianNumber = roman.get(romanNumber);

        return  arabianNumber;
    }

    private static boolean arabNumber(String number)
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
    private static boolean romanNumber(String number)
    {
        String[] roman = new String[]
                {
                        "I",
                        "II",
                        "III",
                        "IV",
                        "V",
                        "VI",
                        "VII",
                        "VIII",
                        "IX",
                        "X"
                };
        for (String romanNumber: roman)
        {
            if (number.equals(romanNumber))
            {
                return true;
            }
        }
        return false;
    }
}