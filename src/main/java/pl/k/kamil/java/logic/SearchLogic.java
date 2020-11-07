package pl.k.kamil.java.logic;

import pl.k.kamil.java.dao.CarDao;
import pl.k.kamil.java.dao.CustomerDao;
import pl.k.kamil.java.dao.RentDao;
import pl.k.kamil.java.model.*;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.util.ArrayList;
import java.util.List;

public class SearchLogic {


    public TableModel allCustomerTable(){

        List<String[]> values = new ArrayList<String[]>();
        List<Customer> customers = new CustomerDao().findAll();
        for (Customer e : customers) {
            values.add(new String[]{String.valueOf(e.getId()),e.getFirstName(), e.getLastName(), e.getStreet(), e.getHouseNumber(), e.getPostalCode(), e.getCity()});
        }
        String[] column = {"ID","Imię", "Nazwisko", "Ulica", "Numer domu", "Kod pocztowy", "Miasto"};

        return new DefaultTableModel(values.toArray(new Object[][]{}), column);
    }

    public TableModel allCarTable(){

        List<String[]> values = new ArrayList<String[]>();
        List<Car> cars = new CarDao().findAll();
        for (Car e : cars) {
            values.add(new String[]{e.getRegNumber(), e.getMark(), e.getModel(), e.getColor(), String.valueOf(e.getPrice()), String.valueOf(e.getCarStatus())});
        }
        String[] column = {"Numer rejestracyjny", "Marka", "Model", "Kolor", "Cena-dzień","Status"};

        return new DefaultTableModel(values.toArray(new Object[][]{}), column);
    }

    public TableModel allCarTableByStatus(CarStatus carStatus){

        List<String[]> values = new ArrayList<String[]>();
        List<Car> cars = new CarDao().findAllCarByStatus(carStatus);
        for (Car e : cars) {
            values.add(new String[]{e.getRegNumber(), e.getMark(), e.getModel(), e.getColor(), String.valueOf(e.getPrice()), String.valueOf(e.getCarStatus())});
        }
        String[] column = {"Numer rejestracyjny", "Marka", "Model", "Kolor", "Cena-dzień","Status"};

        return new DefaultTableModel(values.toArray(new Object[][]{}), column);
    }

    public TableModel allRentTableByStatus(RentStatus rentStatus){

        List<String[]> values = new ArrayList<String[]>();
        List<Rent> rents = new RentDao().findAllRentByStatus(rentStatus);
        for (Rent e : rents) {
            values.add(new String[]{String.valueOf(e.getRentId()),e.getCar().getRegNumber(),e.getCar().getMark(), String.valueOf(e.getCustomer().getId()),e.getCustomer().getFirstName(),e.getCustomer().getLastName(), String.valueOf(e.getRentDate())});
        }
        String[] column = {"ID","Numer rejestracyjny","Marka","ID Klienta","Imię","Nazwisko","Data wypożyczenia"};

        return new DefaultTableModel(values.toArray(new Object[][]{}), column);
    }

}
