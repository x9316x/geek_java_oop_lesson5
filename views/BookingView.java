package geek_java_oop_lesson5.views;

// Импорт зависимостей
import geek_java_oop_lesson5.models.Table;
import geek_java_oop_lesson5.presenters.View;
import geek_java_oop_lesson5.presenters.ViewObserver;

import java.util.Collection;
import java.util.Date;

// Класс BookingView реализует интерфейс View
public class BookingView implements View {

    // Объявление переменной для наблюдателя
    private ViewObserver observer;

    // Метод для отображения таблиц
    public void showTables(Collection<Table> tables){
        for (Table table: tables) {
            System.out.println(table);
        }
    }

    // Метод для установки наблюдателя
    @Override
    public void setObserver(ViewObserver observer) {
        this.observer = observer;
    }

    // Метод для отображения результата бронирования столика
    @Override
    public void printReservationTableResult(int reservationNo) {
        if (reservationNo > 0)
            System.out.printf("Столик успешно забронирован. Номер вашей брони: #%d\n", reservationNo);
        else
            System.out.println("Не удалось забронировать столик. Попробуйте выполнить операцию позже.");
    }

    // Метод для бронирования стола
    public void reservationTable(Date orderDate, int tableNo, String name){
        observer.onReservationTable(orderDate, tableNo, name);
    }

    /**
     * Действие клиента (пользователь нажал на кнопку отмены бронирования)
     * @param oldReservation идентификатор бронирования (старый)
     * @param reservationDate дата бронирования
     * @param tableNo номер столика
     * @param name Имя
     */
    public void changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name){
        //TODO: Реализовать самостоятельно в рамках домашней работы
    }
}
