package geek_java_oop_lesson5;

// Импорт зависимостей
import geek_java_oop_lesson5.models.TableModel;
import geek_java_oop_lesson5.presenters.BookingPresenter;
import geek_java_oop_lesson5.views.BookingView;

import java.util.Date;

public class Program {

    /**
     * TODO: ДОМАШНЯЯ РАБОТА
     * Метод changeReservationTable должен ЗАРАБОТАТЬ!
     *
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        // Создание объектов модели, представления и презентера
        TableModel model = new TableModel();
        BookingView view = new BookingView();
        BookingPresenter bookingPresenter = new BookingPresenter(model, view);

        // Обновление UI с данными о таблицах
        bookingPresenter.updateTablesUI();

        // Бронирование стола
        view.reservationTable(new Date(), 3, "Станислав");

        // Изменение бронирования стола (метод еще не реализован)
        view.changeReservationTable(101, new Date(), 1, "Станислав");
    }
}
