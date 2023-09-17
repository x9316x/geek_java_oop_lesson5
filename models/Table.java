package geek_java_oop_lesson5.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;

// Класс для представления стола
public class Table {

    // Статическая переменная для автоматической генерации номера стола
    private static int counter;
    private final int no;  // Номер стола
    private final Collection<Reservation> reservations = new ArrayList<>();  // Коллекция бронирований для стола

    // Геттеры для полей класса
    public Collection<Reservation> getReservations() {
        return reservations;
    }

    public int getNo() {
        return no;
    }

    // Инициализация блока для автоматической генерации номера стола
    {
        no = ++counter;
    }

    // Метод для представления объекта в виде строки
    @Override
    public String toString() {
        return String.format(Locale.getDefault(), "Столик #%d", no);
    }
}
