import java.io.PrintStream;
import java.util.Scanner;

public class Main {
    static PrintStream out = new PrintStream(System.out);
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        Dictionary dictionary_1 = new Dictionary();
        Dictionary dictionary_2 = new Dictionary();

        dictionary_1.addLetter("FirstWord");
        dictionary_1.addLetter("SecondWord");
        dictionary_1.addLetter("ThirdWord");

        out.println("Первый словарь содержит следующие буквы: " + dictionary_1);

        dictionary_2.addLetter("ПервоеСлово");
        dictionary_2.addLetter("ВтороеСлово");
        dictionary_2.addLetter("ТретьеСлово");
        dictionary_2.setFlag(false);

        out.println("Второй словарь содержит следующие буквы: " + dictionary_2);
        out.println();

        out.println("Количество букв w в первом словаре: " + dictionary_1.countOfLetter('w'));
        out.println("Количество букв о в втором словаре: " + dictionary_2.countOfLetter('о'));
        out.println();

        out.println("Количество букв в первом словаре: " + dictionary_1.totalAmount());
        out.println("Количество букв в втором словаре: " + dictionary_2.totalAmount());
        out.println();

        out.println("Сборка слова swagger из букв первого словаря: " + dictionary_1.negativePossibleWord("swagger"));
        dictionary_1.setFlag(false);
        out.println("Словарь после сборки слова: " + dictionary_1);
        out.println();

        out.print("Введите слова которое хотите составить из букв второго словаря: ");
        String word = in.nextLine();

        if (dictionary_2.isWordPossible(word)) {
            out.println("Такое слово можно составить");
        }

        else {
            out.println("Такое слово нельзя составить");
        }

        out.println();

        out.println("Сборка слова " + word + " из букв второго словаря: " + dictionary_2.positivePossibleWord(word));
        out.println("При этом словарь не изменился: " + dictionary_2);
        out.println();

        out.print("Введите слово, которое хотите составить из букв первого словаря: ");
        String newWord = in.nextLine();
        String result = dictionary_1.fullWord(newWord);

        if (result.isEmpty()) {
            out.println("Слово нельзя составить");
        }

        else {
            out.println("Слово можно составить: " + result);
            out.println("Словарь после сборки: " + dictionary_1);
        }
        out.println();

        out.println("Слово рост из букв второго словаря можно составить " + dictionary_2.numberPossibleWords("рост") + " раза");
    }
}
