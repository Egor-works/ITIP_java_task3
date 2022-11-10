import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("№1 -> " + solutions(1, 0, -1));
        System.out.println("№2 -> " + findZip("all zip files are zipped"));
        System.out.println("№3 -> " + checkPerfect(6));
        System.out.println("№4 -> " + flipEndChars("Cat, dog, and mouse."));
        System.out.println("№5 -> " + isValidHexCode("#CD5C5C"));
        System.out.println("№6 -> " + same(new Integer[]{1, 3, 4, 4, 4}, new Integer[]{2, 5, 7}));
        System.out.println("№7 -> " + isKaprekar(3));
        System.out.println("№8 -> " + longestZero("01100001011000"));
        System.out.println("№9 -> " + nextPrime(12));
        System.out.println("№10 -> " + rightTriangle(3, 4, 5));
    }

    /** Функция, возвращающая число корней квадратного уравнения **/
    public static byte solutions(int a, int b, int c) {
        double D = Math.pow(b, 2) - (4*a*c);
        if (D > 0) return 2;
        else if (D == 0) return 1;
        else return 0;
    }

    /** Функция, возвращающая позицию второго вхождения "zip" в строку, или, -1 если оно не происходит по крайней мере дважды **/
    public static int findZip(String string) {
        return string.replaceFirst("zip", "***").indexOf("zip");
    }

    /** Функция, проверяющая является ли число совершенным **/
    public static boolean checkPerfect(int decimal) {
        int sum = 0;
        for (int i = 1; i < decimal; i++) {
            if (decimal % i == 0) sum += i;
        }
        return sum == decimal;
    }

    /** Функция, принимающая строку и возвращающая новую строку с
     заменой ее первого и последнего символов **/
    public static String flipEndChars(String string) {
        char [] chars = string.toCharArray();
        if (string.length() < 2 ) return "\"Incompatible.\"";
        else if (chars[0] == chars[string.length() - 1]) return "\"Two's a pair.\"";
        char temp = chars[0];
        chars[0] = chars[string.length() - 1];
        chars[string.length() - 1] = temp;
        return "\"" + new String(chars) + "\"";
    }

    /** Функция, проверяющая является ли строка допустимым шестнадцатеричным кодом **/
    public static boolean isValidHexCode(String string) {
        String HEX = "#0123456789abcdefABCDEF";
        for (char c : string.toCharArray()) {
            if (!HEX.contains(c + "")) return false;
        }
        return string.startsWith("#") && string.length() == 7;
    }

    /** Функция, определяющая содержат ли два массива равное количество уникальных значений **/
    public static boolean same(Integer[] firstArray, Integer[] secondArray) {
        Set<Integer> arr1 = new HashSet<>(Arrays.asList(firstArray));
        Set<Integer> arr2 = new HashSet<>(Arrays.asList(secondArray));
        return arr2.size() == arr1.size();
    }

    /** Функция, определяющая является ли число - числом Капрекара**/
    public static boolean isKaprekar(Integer decimal) {
        if (decimal*decimal < 10) return decimal*decimal == decimal;
        return Integer.parseInt((decimal*decimal + "").substring(0, (decimal*decimal + "").length()/2)) +
                Integer.parseInt((decimal*decimal + "").substring((decimal*decimal + "").length()/2)) == decimal;
    }

    /** Функция, возвращающая самую длинную последовательность подряд идущих нулей в двоичной строке **/
    public static String longestZero(String string) {
        String maxLength = "";
        for (String str : string.split("1")) {
            if (str.length() > maxLength.length()) maxLength = str;
        }
        return "\"" + maxLength + "\"";
    }

    /** Функция, возвращающая следующее простое число или введёное, если оно простое **/
    public static int nextPrime(int integer) {
        for (int i = 2; i < Math.sqrt(integer) + 1; i++) {
            if (integer % i == 0) return nextPrime(integer + 1);
        }
        return integer;
    }

    /** Функция, проверяющая являются ли введённые числа рёбрами прямоугольного треугольника **/
    public static boolean rightTriangle(int x, int y, int z) {
        int[] triangle = Arrays.stream(new int[]{x, y, z}).sorted().toArray();
        return Math.pow(triangle [2], 2) == Math.pow(triangle [0], 2) + Math.pow(triangle [1], 2);
    }
}