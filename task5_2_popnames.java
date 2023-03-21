import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

// Пусть дан список сотрудников:
// Иван Иванов
// Светлана Петрова
// Кристина Белова
// Анна Мусина
// Анна Крутова
// Иван Юрин
// Петр Лыков
// Павел Чернов
// Петр Чернышов
// Мария Федорова
// Марина Светлова
// Мария Савина
// Мария Рыкова
// Марина Лугова
// Анна Владимирова
// Иван Мечников
// Петр Петин
// Иван Ежов

// Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
// Отсортировать по убыванию популярности Имени.

public class task5_2_popnames {
    public static void main(String[] args) {
        Map<String, String> people = new HashMap<>();
        people.put("Иванов", "Иван");
        people.put("Петрова", "Светлана");
        people.put("Белова", "Кристина");
        people.put("Мусина", "Анна");
        people.put("Крутова", "Анна");
        people.put("Юрин", "Иван");
        people.put("Лыков", "Петр");
        people.put("Чернов", "Павел");
        people.put("Чернышов", "Петр");
        people.put("Федорова", "Мария");
        people.put("Светлова", "Марина");
        people.put("Савина", "Мария");
        people.put("Рыкова", "Мария");
        people.put("Лугова", "Марина");
        people.put("Владимирова", "Анна");
        people.put("Мечников", "Иван");
        people.put("Петин", "Петр");
        people.put("Ежов", "Иван");

        LinkedList<String> names = new LinkedList<>();
        names = getArray(people); // Linkedlist


        Map<String, Integer> popNames = new HashMap<>();
        popNames = popularityValue(names); // hashmap
         

        System.out.println("\nСписок имен, встречающихся более одного раза:");
        for (HashMap.Entry<String, Integer> entry : popNames.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + " - " + entry.getValue());
            }
        }


        LinkedList<String> sortedNames = new LinkedList<>();
        sortedNames = sortedList(popNames);

             
        System.out.println("\nСписок имен, отсортированный по популярности:");
        for (String item : sortedNames) {
            System.out.println(item);
        }

    }

    public static LinkedList<String> getArray(Map<String, String> col) {
        LinkedList<String> names = new LinkedList<>();
        for (Map.Entry<String, String> item : col.entrySet()) {
            names.add(0, item.getValue());
        }
        return names;
    }


    public static HashMap<String, Integer> popularityValue(LinkedList<String> listValues) {
        HashMap<String, Integer> popValue = new HashMap<>();
        for (String name : listValues) {
            if (!popValue.containsKey(name)) {
                popValue.put(name, 1);
            } else popValue.put(name, popValue.get(name) + 1);
        }
        return popValue;
    }


    public static LinkedList<String> sortedList(Map<String, Integer> popNames) {
        LinkedList<String> sorted = new LinkedList<>();
        for (Map.Entry<String, Integer> item : popNames.entrySet()) {
            sorted.add(item.getValue() + " - " + item.getKey());
        }
        Collections.sort(sorted, Collections.reverseOrder());
        return sorted;
    }
    
}
