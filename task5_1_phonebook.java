import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
// Добавить функции 1) Добавление номера
// 2) Вывод всего
// Пример:
// Я ввожу: 1
// К: Введите фамилию
// Я: Иванов
// К: Введите номер
// Я: 1242353
// К: Введите 1) Добавление номера
// 2) Вывод всего
// Я ввожу: 1
// К: Введите фамилию
// Я: Иванов
// К: Введите номер
// Я: 547568
// К: Введите 1) Добавление номера
// 2) Вывод всего
// Я: 2
// Иванов: 1242353, 547568

public class task5_1_phonebook {
    public static void main(String[] args) {
        Map<String, String> phoneBook = new HashMap<>();
        phoneBook.put("Васильев", "321456");
        phoneBook.put("Петрова", "234561");
        Scanner inPut = new Scanner(System.in);
        Scanner name = new Scanner(System.in);
        Scanner phone = new Scanner(System.in);
        Character choice = 0;
        System.out.println("Меню программы:\n1) Добавление контакта\n2) Вывод списка контактов\n3) Выход\n");
        
        while (choice != 3) {
            System.out.print("Для добавления контакта введите '1',\nДля выхода из программы введите '3',\nДля вывода всех контактов введите '2' или любой другой символ: ");
            choice = inPut.next().charAt(0);
            System.out.println();
            if (choice == '1') {
                System.out.println("Добавляем контакт");
                System.out.println("Введите фамилию: ");
                String lastName = name.nextLine();
                System.out.println("Введите номер: ");
                String phoneNumber = phone.nextLine();
                createContact(phoneBook, lastName, phoneNumber);
            }
            else if (choice == '3') break;
            else printPhoneBook(phoneBook);  
        }
        inPut.close();
        name.close();
        phone.close();
    }
        
    public static void printPhoneBook(Map<String, String> phoneBook) {
        System.out.println("Список контактов:");
        for (Map.Entry<String, String> item : phoneBook.entrySet()) {
            System.out.printf("%s: %s\n", item.getKey(), item.getValue());
        }
        System.out.println();
    }

   
    public static Map<String, String> createContact(Map<String, String> phoneBook, String lastName, String phoneNumber) {
        if (phoneBook.containsKey(lastName)) {
            String savePhoneNumber = phoneBook.get(lastName) + ", " + phoneNumber;
            phoneBook.put(lastName, savePhoneNumber);
        }
        else phoneBook.putIfAbsent(lastName, phoneNumber);
        return phoneBook;
    }
}
        