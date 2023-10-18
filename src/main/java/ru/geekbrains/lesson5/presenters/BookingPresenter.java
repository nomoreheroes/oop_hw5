package ru.geekbrains.lesson5.presenters;

import ru.geekbrains.lesson5.models.Table;
import ru.geekbrains.lesson5.models.TableModel;
import ru.geekbrains.lesson5.views.BookingView;

import java.util.Collection;
import java.util.Date;

public class BookingPresenter implements ViewObserver {

    private Model model;
    private View view;

    public BookingPresenter(Model model, View view) {
        this.model = model;
        this.view = view;
        view.setObserver(this);
    }

    /**
     * Получение списка всех столиков
     */
    private Collection<Table> loadTables(){
        return model.loadTables();
    }

    /**
     * Отобразить список столиков
     */
    public void updateUIShowTables(){
        view.showTables(loadTables());
    }

    /**
     * Отобразить результат бронирования на представлении
     * @param reservationId результат бронирования
     */
    private void updateUIShowReservationResult(int reservationId){
        view.showReservationTableResult(reservationId);
    }

    private void updateUIShowDeleteReservationResult(int tableNo){
        view.showDeleteReservationTableResult(tableNo);
    }

    /**
     * Произошло событие, пользователь нажал на кнопку резерва столика
     * @param orderDate дата резерва
     * @param tableNo номер столика
     * @param name имя клиента
     */
    @Override
    public void onReservationTable(Date orderDate, int tableNo, String name) {
        try {
            int reservationNo = model.reservationTable(orderDate, tableNo, name);
            updateUIShowReservationResult(reservationNo);
        }
        catch (RuntimeException e){
            updateUIShowReservationResult(-1);
        }
    }

    @Override
    public void onDeleteReservationTable(int oldReservation)
    {
        try {
            int oldTableNo = model.deleteReservationTable(oldReservation);
            updateUIShowDeleteReservationResult(oldTableNo);
        }
        catch (RuntimeException e){
            updateUIShowDeleteReservationResult(-1);
        }       
    }

    @Override
    public void onChangeReservationTable(int oldReservation, Date orderDate, int tableNo, String name)
    {
        try {
            int newReservation = model.changeReservationTable(oldReservation, orderDate, tableNo,name);
            updateUIShowChangeReservationResult(newReservation);
        }
        catch (RuntimeException e){
            updateUIShowChangeReservationResult(-1);
        }       
    }

    private void updateUIShowChangeReservationResult(int newReservation) {
        view.showChangeReservationTableResult(newReservation);
    }    
}
