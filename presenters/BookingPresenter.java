package geek_java_oop_lesson5.presenters;

// Импорт зависимостей
import geek_java_oop_lesson5.models.Table;
import geek_java_oop_lesson5.models.TableModel;
import geek_java_oop_lesson5.views.BookingView;

import java.util.Collection;
import java.util.Date;

// Класс BookingPresenter реализует интерфейс ViewObserver
public class BookingPresenter implements ViewObserver {

    // Объявление переменных для модели и представления
    private final Model tableModel;
    private final View bookingView;

    // Конструктор класса BookingPresenter
    public BookingPresenter(Model tableModel, View bookingView) {
        this.tableModel = tableModel;
        this.bookingView = bookingView;
        bookingView.setObserver(this);
    }

    // Метод для загрузки таблиц
    public Collection<Table> loadTables(){
        return tableModel.loadTables();
    }

    // Метод для обновления UI с таблицами
    public void updateTablesUI(){
        bookingView.showTables(loadTables());
    }

    // Метод для обновления UI с результатом бронирования
    public void updateReservationResultUI(int reservationId){
        bookingView.printReservationTableResult(reservationId);
    }

    // Метод, вызывающийся при бронировании стола
    @Override
    public void onReservationTable(Date orderDate, int tableNo, String name) {
        int reservationNo = tableModel.reservationTable(orderDate, tableNo, name);
        updateReservationResultUI(reservationNo);
    }

    @Override
    // Метод для обработки изменения бронирования столика
    public int onChangeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name) {
        int newReservationNo = tableModel.changeReservationTable(oldReservation, reservationDate, tableNo, name);
        bookingView.printReservationTableResult(newReservationNo);
        return newReservationNo;
    }
}
