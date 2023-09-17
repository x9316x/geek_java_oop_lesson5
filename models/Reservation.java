package geek_java_oop_lesson5.models;

import java.util.Date;

// Класс для представления бронирования
public class Reservation {

    // Статическая переменная для автоматической генерации ID бронирования
    private static int counter = 100;
    private final int id;

    private Date date;     // Дата бронирования
    private String name;   // Имя клиента

    // Инициализация блока для автоматической генерации ID
    {
        id = ++counter;
    }

    // Конструктор класса Reservation
    public Reservation(Date date, String name) {
        this.date = date;
        this.name = name;
    }

    // Геттеры для полей класса
    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public String getName() {
        return name;
    }
}
