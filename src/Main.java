//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.io.*;
import java.util.regex.*;


/*Лабораторная работа 43*. Регулярные выражения
Задание:
Для выполнения использовать регулярные выражения.
Каждое задание реализовать в отдельном методе.

Строку получать из текстового файла input.txt.
Результат работы методов записывать в выходной текстовый файл output.txt.

1. Из заданной строки исключить символы, расположенные внутри круглых скобок.
 Сами скобки тоже должны быть исключены.
2. Из заданной строки удалить из каждой группы идущих подряд цифр, в которой более двух цифр, все цифры, начиная с третьей.
3. Из заданной строки удалить из каждой группы идущих подряд цифр все незначащие нули.


Новое Задание:
Для выполнения используйте регулярные выражения. Каждое задание должно быть реализовано в отдельном методе.

Входные данные:
Строка получается из текстового файла input.txt.

Выходные данные:
Результаты работы методов записываются в выходной текстовый файл output.txt.

Задачи:
Удаление символов внутри круглых скобок:
Из заданной строки исключите все символы, расположенные внутри круглых скобок ( и ), включая сами скобки. Например, строка Привет (мир) должна преобразоваться в Привет .
Сокращение последовательностей цифр:
Из заданной строки удалите из каждой группы идущих подряд цифр, в которой более двух цифр, все цифры, начиная с третьей. Например, строка 123456 должна преобразоваться в 124.
Удаление незначащих нулей:
Из заданной строки удалите из каждой группы идущих подряд цифр все незначащие нули. Например, строка 00123 04500 0009 должна преобразоваться в 123 450 9.
*/

public class Main {
public class Main {
    public static void main(String[] args) {
        String input = readFile("input.txt");
        StringBuilder result = new StringBuilder();

        // Выполнение всех заданий
        result.append(removeSymbolsInBrackets(input)).append("\n");
        result.append(removeExcessDigits(input)).append("\n");
        result.append(removeLeadingZeros(input)).append("\n");

        // Запись результата в выходной файл
        writeFile("output.txt", result.toString());

        // Вывод содержимого входного и выходного файлов
        System.out.println("Содержимое input.txt:");
        System.out.println(input);
        System.out.println("\nСодержимое output.txt:");
        String output = readFile("output.txt");
        System.out.println(output);
    }

    // Метод для чтения файла
    private static String readFile(String filePath) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString().trim(); // Удаляем последний перевод строки
    }

    // 1. Исключение символов внутри круглых скобок
    private static String removeSymbolsInBrackets(String input) {
        return input.replaceAll("\\(.*?\\)", ""); // Удаляем текст в круглых скобках, включая сами скобки
    }

    // 2. Удаление лишних цифр в группах
    private static String removeExcessDigits(String input) {
        return input.replaceAll("(\\d{2})(\\d+)", "$1"); // Сохраняем только первые две цифры в группе
    }

    // 3. Удаление незначащих нулей
    private static String removeLeadingZeros(String input) {
        return input.replaceAll("\\b0+(\\d)", "$1"); // Заменяем нули, перед которыми следует цифра
    }

    // Метод для записи в файл
    private static void writeFile(String filePath, String content) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            bw.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
