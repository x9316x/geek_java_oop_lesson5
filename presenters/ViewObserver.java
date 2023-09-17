package geek_java_oop_lesson5.presenters;

import java.util.Date;

// Интерфейс ViewObserver, представляющий наблюдателя для представления (View) в архитектуре MVP
public interface ViewObserver {
    // Метод, вызываемый при бронировании стола
    void onReservationTable(Date orderDate, int tableNo, String name);
    /**
     * Оповещение о попытке изменения бронирования столика.
     * @param oldReservation старый номер резервирования
     * @param reservationDate дата резервирования
     * @param tableNo номер столика
     * @param name имя клиента
     */
    int onChangeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name);
}


