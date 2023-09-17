package geek_java_oop_lesson5.presenters;

import java.util.Date;

// Интерфейс ViewObserver, представляющий наблюдателя для представления (View) в архитектуре MVP
public interface ViewObserver {
    // Метод, вызываемый при бронировании стола
    void onReservationTable(Date orderDate, int tableNo, String name);
}
