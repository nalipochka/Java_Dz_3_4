package org.example;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class Money {
    private int dollars;
    private int cents;

    public Money(int dollars, int cents) {
        this.dollars = dollars;
        this.cents = cents;
    }

    public int getDollars() {
        return dollars;
    }

    public int getCents() {
        return cents;
    }

    public void display() {
        System.out.println("Сума: " + dollars + "." + cents);
    }
}

class Product {
    private String name;
    private Money price;

    public Product(String name, Money price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Money getPrice() {
        return price;
    }

    public void reducePrice(Money amount) {
        int newDollars = price.getDollars() - amount.getDollars();
        int newCents = price.getCents() - amount.getCents();

        if (newCents < 0) {
            newDollars -= 1;
            newCents += 100;
        }

        if (newDollars < 0) {
            System.out.println("Помилка: Ціна не може бути менше нуля.");
        } else {
            price = new Money(newDollars, newCents);
            System.out.println("Ціна товару " + name + " зменшилася на " + amount.getDollars() + "." + amount.getCents());
        }
    }

    public void display() {
        System.out.println("Назва товару: " + name);
        System.out.print("Ціна товару: ");
        price.display();
    }
}

class Device {
    private String name;
    private String characteristics;
    private String sound;

    public Device(String name, String characteristics, String sound) {
        this.name = name;
        this.characteristics = characteristics;
        this.sound = sound;
    }

    public void Sound() {
        System.out.println("Звук пристрою: "+ sound);
    }

    public void Show() {
        System.out.println("Назва пристрою: " + name);
    }

    public void Desc() {
        System.out.println("Опис пристрою: " + characteristics);
    }
}

class Kettle extends Device {
    public Kettle(String name, String characteristics, String sound) {
        super(name, characteristics, sound);
    }
}

class Microwave extends Device {
    public Microwave(String name, String characteristics, String sound) {
        super(name, characteristics, sound);
    }
}

class Car extends Device {
    public Car(String name, String characteristics, String sound) {
        super(name, characteristics, sound);
    }
}

class Steamship extends Device {
    public Steamship(String name, String characteristics, String sound) {
        super(name, characteristics, sound);
    }
}

interface IMath {
    int Max();
    int Min();
    float Avg();
}

class Array1 implements IMath {
    private int[] elements;

    public Array1(int[] elements) {
        this.elements = elements;
    }

    @Override
    public int Max() {
        int max = elements[0];
        for (int i = 1; i < elements.length; i++) {
            if (elements[i] > max) {
                max = elements[i];
            }
        }
        return max;
    }

    @Override
    public int Min() {
        int min = elements[0];
        for (int i = 1; i < elements.length; i++) {
            if (elements[i] < min) {
                min = elements[i];
            }
        }
        return min;
    }

    @Override
    public float Avg() {
        int sum = 0;
        for (int element : elements) {
            sum += element;
        }
        return (float) sum / elements.length;
    }
}

class Array<T extends Comparable<T>> {
    private T[] elements;
    private int size;

    public Array(int capacity) {
        elements = (T[]) new Comparable[capacity];
        size = 0;
    }

    // Заповнення масиву з клавіатури
    public void inputFromKeyboard() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < elements.length; i++) {
            System.out.print("Введіть елемент #" + (i + 1) + ": ");
            elements[i] = (T) scanner.next();
        }
        size = elements.length;
    }

    // Заповнення масиву випадковими числами
    public void fillRandomly(int min, int max) {
        Random random = new Random();
        for (int i = 0; i < elements.length; i++) {
            elements[i] = (T) (Integer.valueOf(random.nextInt(max - min + 1) + min));
        }
        size = elements.length;
    }

    // Виведення масиву
    public void display() {
        System.out.println(Arrays.toString(elements));
    }

    // Пошук максимального значення
    public T findMax() {
        T max = elements[0];
        for (int i = 1; i < size; i++) {
            if (elements[i].compareTo(max) > 0) {
                max = elements[i];
            }
        }
        return max;
    }

    // Пошук мінімального значення
    public T findMin() {
        T min = elements[0];
        for (int i = 1; i < size; i++) {
            if (elements[i].compareTo(min) < 0) {
                min = elements[i];
            }
        }
        return min;
    }

    // Підрахунок середньо арифметичного значення
    public double calculateAvg() {
        double sum = 0;
        for (int i = 0; i < size; i++) {
            sum += Double.parseDouble(elements[i].toString());
        }
        return sum / size;
    }

    // Сортування масиву по зростанню
    public void sortAscending() {
        Arrays.sort(elements);
    }

    // Сортування масиву по спаданню
    public void sortDescending() {
        Arrays.sort(elements, (a, b) -> b.compareTo(a));
    }

    // Пошук значення в масиві, використовуючи бінарний пошук
    public int binarySearch(T value) {
        Arrays.sort(elements);
        int low = 0;
        int high = size - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cmp = elements[mid].compareTo(value);
            if (cmp == 0) {
                return mid; // Знайдено
            } else if (cmp < 0) {
                low = mid + 1; // Шукати праворуч
            } else {
                high = mid - 1; // Шукати ліворуч
            }
        }
        return -1; // Не знайдено
    }

    // Заміна значення в масиві на нове значення
    public void replaceValue(int index, T newValue) {
        if (index >= 0 && index < size) {
            elements[index] = newValue;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите задание: ");
        int task = scanner.nextInt();
        switch (task){
            case 1:{
                Money price1 = new Money(10, 50);
                Money discount = new Money(2, 25);

                Product product1 = new Product("Продукт 1", price1);

                product1.display();
                product1.reducePrice(discount);
                product1.display();
            }
            break;
            case 2:{
                Kettle kettle = new Kettle("Чайник", "Об'єм: 1 літр, потужність: 1500 Вт", "*cвист*");
                Microwave microwave = new Microwave("Мікрохвильовка", "Об'єм: 20 літрів, потужність: 800 Вт", "*пик*");
                Car car = new Car("Автомобіль", "Швидкість: 150 км/год, об'єм двигуна: 2.0 л", "*звук мотора*");
                Steamship steamship = new Steamship("Пароплав", "Швидкість: 25 вузлів, потужність: 5000 кВт", "*гудок*");

                kettle.Sound();
                kettle.Show();
                kettle.Desc();

                microwave.Sound();
                microwave.Show();
                microwave.Desc();

                car.Sound();
                car.Show();
                car.Desc();

                steamship.Sound();
                steamship.Show();
                steamship.Desc();
            }
            break;
            case 3:{
                int[] numbers = {10, 5, 8, 20, 3};

                Array1 array = new Array1(numbers);

                System.out.println("Максимум: " + array.Max());
                System.out.println("Мінімум: " + array.Min());
                System.out.println("Середнє арифметичне: " + array.Avg());
            }
            break;
            case 4:{
                int capacity = 5;
                Array<Integer> intArray = new Array<>(capacity);

                // Заповнення масиву випадковими числами
                intArray.fillRandomly(1, 100);

                // Виведення масиву
                System.out.println("Масив:");
                intArray.display();

                // Пошук максимального і мінімального значень
                System.out.println("Максимальне значення: " + intArray.findMax());
                System.out.println("Мінімальне значення: " + intArray.findMin());

                // Підрахунок середньо арифметичного значення
                System.out.println("Середнє арифметичне: " + intArray.calculateAvg());

                // Сортування масиву
                intArray.sortAscending();
                System.out.println("Сортування по зростанню:");
                intArray.display();

                intArray.sortDescending();
                System.out.println("Сортування по спаданню:");
                intArray.display();

                // Пошук значення в масиві, використовуючи бінарний пошук
                int searchValue = 42;
                int searchResult = intArray.binarySearch(searchValue);
                if (searchResult != -1) {
                    System.out.println("Знайдено значення " + searchValue + " на позиції " + searchResult);
                } else {
                    System.out.println("Значення " + searchValue + " не знайдено в масиві.");
                }

                // Заміна значення в масиві
                int replaceIndex = 2;
                int newValue = 99;
                intArray.replaceValue(replaceIndex, newValue);
                System.out.println("Після заміни:");
                intArray.display();
            }
            break;
            default:
                System.out.println("Error!");
        }
    }
}