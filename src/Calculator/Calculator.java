package Calculator;

import java.util.Locale;
import java.util.Scanner;

/**Метод умеет выполнять операции сложения, вычитания, умножения и деления с двумя числами: a + b, a - b, a * b, a / b. Данные передаются в одну строку (смотрите пример)! Решения, в которых каждое число и арифмитеческая операция передаются с новой строки считаются неверными.
 Метод умеет работать как с арабскими (1,2,3,4,5…), так и с римскими (I,II,III,IV,V…) числами.
 Метод должен принимать на вход числа от 1 до 10 включительно, не более. На выходе числа не ограничиваются по величине и могут быть любыми.
 Метод умеет работать только с целыми числами.
 Метод умеет работать только с арабскими или римскими цифрами одновременно, при вводе пользователем строки вроде 3 + II метод должен выбросить исключение и прекратить свою работу.
 При вводе римских чисел, ответ должен быть выведен римскими цифрами, соответственно, при вводе арабских - ответ ожидается арабскими.
 При вводе пользователем неподходящих чисел метдод выбрасывает исключение и завершает свою работу.
 При вводе пользователем строки, не соответствующей одной из вышеописанных арифметических операций, метод выбрасывает исключение и завершает свою работу
 Результатом операции деления является целое число, остаток отбрасывается.
 Результатом работы метода с арабскими числами могут быть отрицательные числа и ноль. Результатом работы метода с римскими числами могут быть только положительные числа, если результат работы меньше единицы, выбрасывается исключение

 */
/*
* @author Va4
*/

public class Calculator {
    public static void main(String[] args) throws Exception {
        CalculatorHelper calculatorHelper = new CalculatorHelper();
        System.out.println("Введите выражение:");
        Scanner myObj = new Scanner(System.in);  // Создаем обьект Scanner
        String input = myObj.nextLine();  // Считываем ввод пользователя
        System.out.println(calculatorHelper.calc(input));
    }
}

class CalculatorHelper {
    public String calc(String input) throws Exception {
        String[] splitText = input.split(" ");
        boolean rome = false;
        int letter1, letter2;

        int countLetters = 0;

        for (int i = 0; i < 3; i+=2) {
            try {
                Integer.parseInt(splitText[i]);
            } catch (NumberFormatException e) {
                rome = true;
                countLetters++;
            }
        }
        if (countLetters == 1) {
            throw new Exception("letter format do not consist");
        }

        letter1 = getLetter(splitText[0]);
        if (letter1 <= 0 || letter1 > 10){
            throw new Exception("Arab/Rome letter should be > 0 or < then 10");
        }
        letter2 = getLetter(splitText[2]);
        if (letter2 <= 0 || letter2 > 10){
            throw new Exception("Arab/Rome letter should be > 0 or < then 10");
        }
        int result = getResult(letter1, letter2, splitText[1]);
        String output;

        if (rome) {
            if ( result < 0 ) {
                throw new Exception("Rome letter result should be > 0");
            } else output = getRomeNumber(result);
        } else output = String.valueOf(result);{

             /*if ( result > 10 ) {
                throw new Exception("Arab letter should be > 0");*/


        }
        return output;
    }

    public Integer getLetter(String letter) throws Exception {
        int integer = 0;

        try {
            integer = Integer.parseInt(letter);
        } catch (Exception e) {
            integer = switch (letter.toLowerCase(Locale.ROOT)) {
                case "i" -> 1;
                case "ii" -> 2;
                case "iii" -> 3;
                case "iv" -> 4;
                case "v" -> 5;
                case "vi" -> 6;
                case "vii" -> 7;
                case "viii" -> 8;
                case "ix" -> 9;
                case "x" -> 10;
                case "xi" -> 11;
                case "xii" -> 12;
                case "xiii" -> 13;
                case "xiv" -> 14;
                case "xv" -> 15;
                case "xvi" -> 16;
                case "xvii" -> 17;
                case "xviii" -> 18;
                case "xviv" -> 19;
                case "xx" -> 20;
                default -> throw new Exception("Arab letter > 10");
            };
        }
        return integer;
    }

    public String getRomeNumber(int num) throws Exception {
        String romeNum = switch (num) {
            case 1 -> "I";
            case 2 -> "II";
            case 3 -> "III";
            case 4 -> "IV";
            case 5 -> "V";
            case 6 -> "VI";
            case 7 -> "VII";
            case 8 -> "VIII";
            case 9 -> "IX";
            case 10 -> "X";
            case 11 -> "XI";
            case 12 -> "XII";
            case 13 -> "XIII";
            case 14 -> "XIV";
            case 15 -> "XV";
            case 16 -> "XVI";
            case 17 -> "XVII";
            case 18 -> "XVIII";
            case 19 -> "XVIV";
            case 20 -> "XX";
            default -> throw new Exception("The result > 10");
        };
        return romeNum;
    }

    public Integer getResult(int letter1, int letter2, String s) throws Exception { 
        int result = switch (s) {
            case "/" -> letter1 / letter2;
            case "+" -> letter1 + letter2;
            case "-" -> letter1 - letter2;
            case "*" -> letter1 * letter2;
            default -> throw new Exception("Wrong operation format");
        };

        return result;
    }
}