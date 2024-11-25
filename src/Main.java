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

Структура программы:

Для чтения файла input.txt используется метод readFile .
Программа вызывает три метода для обработки строки, каждый из которых соответствует одному из заданий:
Для записи результатов работы программы в файл output.txt используется метод writeFile
                     Методы программы
1. readFile - читает файл построчно и объединяет строки в одну.
2. Delete_Symbols-использует регулярное выражение \\(.*?\\), которое находит и удаляет содержимое скобок.
3. Delete_Numbers-использует регулярное выражение (\\d{2})(\\d+),
которое сохраняет только первые две цифры в каждой группе и удаляет остальные.
4. Delete_Zero - использует регулярное выражение \\b0+(\\d), чтобы найти и удалить нули, предшествующие цифрам.
5. writeFile - метод используется для записи результатов работы программы в файл output.txt
6. Для удобства я вывожу содержимое "input.txt"  и "output.txt" на экран.
*/

public class Main {

    public static void main(String[] args) {
        String input = readFile("input.txt");
        StringBuilder string = new StringBuilder();

        string.append(Delete_Symbols(input)).append("\n");
        string.append(Delete_Numbers(input)).append("\n");
        string.append(Delete_Zero(input)).append("\n");

        writeFile("output.txt", string.toString());

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

    // Метод 1: Исключение символов внутри круглых скобок
    private static String Delete_Symbols(String input) {
        return input.replaceAll("\\(.*?\\)", "");
    }

    // Метод 2: Удаление лишних цифр в группах
    private static String Delete_Numbers(String input) {
        return input.replaceAll("(\\d{2})(\\d+)", "$1");
    }

    // Метод 3: Удаление незначащих нулей
    private static String Delete_Zero(String input) {
        return input.replaceAll("\\b0+(\\d)", "$1");
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