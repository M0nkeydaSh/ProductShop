import java.util.Scanner;
import java.util.TreeMap;

public class InternetShop {
    public static void main(String[] args) {
        userdata();
        System.out.println("Каталог:");
        TreeMap<Integer, Catalog> catalog = new TreeMap();
        catalog.put( 1, new Catalog("Хлеб") );
        catalog.put( 2, new Catalog("Мясо"));
        catalog.put( 3, new Catalog("Молоко"));
        catalog.put( 4, new Catalog("Сыр"));
        catalog.put( 5, new Catalog("Мармелад"));
        catalog.put( 6, new Catalog("Масло") );
        catalog.put( 7, new Catalog("Сахар") );
        catalog.put( 8, new Catalog("Соевый_соус"));
        catalog.put( 9, new Catalog("Чай"));
        catalog.put( 10, new Catalog("Кофе"));

        for (int i = 1; i <= catalog.size(); i++) {
            System.out.println(i + ". " + catalog.get(i));
        }

        Scanner sc = new Scanner(System.in);
        TreeMap<Integer, Catalog> basket = new TreeMap();
        System.out.print("Напишите 'начать' , что бы начать делать покупки: ");
        String buy = sc.next();
        int id = 0;
        while (!buy.equals("нет")){
            System.out.println("Напишите номер товара из каталога, чтобы добавить его в корзину: ");
            id = sc.nextInt();
            basket.put(id, catalog.get(id));
            System.out.println("Вы добавили " +  catalog.get(id) + " в вашу корзину! Продолжить?");
            buy = sc.next();
        }

        System.out.println("В вашей корзине сейчас лежит: ");
        System.out.println(basket);
        System.out.println("Вас устраивает покупка?");
        String answer = sc.next();
        if (answer.equals("да")) {
            System.out.println("Спасибо за покупку!");
            basket.clear();
            System.out.println(basket);
        } else{
            System.out.println("Вы хотите добавить товар или убрать?");
            answer = sc.next();
            if (answer.equals("добавить")){
                while (!answer.equals("нет")) {
                    System.out.println("Напишите номер товара из каталога, чтобы добавить его в корзину: ");
                    id = sc.nextInt();
                    basket.put(id, catalog.get(id));
                    System.out.println("Вы добавили " + catalog.get(id) + " в вашу корзину! Продолжить?");
                    answer = sc.next();
                }
            } else if(answer.equals("убрать")){
                while (!answer.equals("нет")) {
                    System.out.println("Напишите номер товара из каталога , чтобы убрать его из карзины: ");
                    id = sc.nextInt();
                    basket.remove(id);
                    System.out.println("Вы убрали " + catalog.get(id) + " из вашей корзины! Продолжить?");
                    answer = sc.next();
                }
            }
            System.out.println("Спасибо за покупку!");
            basket.clear();
            System.out.println(basket);
        }







    }

    static void userdata() {
        Scanner sc = new Scanner(System.in);

        TreeMap<String, Integer> user = new TreeMap<>();
        user.put("Vadim", 1234);
        user.put("Maxim", 4567);
        user.put("Ramina", 7890);
        System.out.println(user);

        System.out.print("Введите имя пользователя: ");
        String login = sc.next();

        while (!user.containsKey(login)) {
            System.out.println("Здравствуйте новый пользователь!!! Мы зарегестрировали ваш логин!!!");
            System.out.println("Теперь введите пароль состоящий из 4 цифр: ");
            int password = sc.nextInt();
            user.put(login, password);
            System.out.print("Введите логин еще раз: ");
            login = sc.next();
        }
        System.out.print("Введите пароль: ");
        int password = sc.nextInt();

        while (!user.containsValue(password)) {
            System.out.println("Неверный пароль!!! Ппробуйте еще раз: ");
             password = sc.nextInt();
        }

        System.out.println("Добро пожаловать " + login);
    }
}

class Catalog implements Comparable <Catalog>{
public Catalog (String name) {
        this.name = name;
        }

        String name;

@Override
public String toString() {
        return name;
        }

@Override
public int compareTo(Catalog catalog) {
        return name.compareTo(catalog.name);
        }

        }

