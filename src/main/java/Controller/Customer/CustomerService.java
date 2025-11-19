package Controller.Customer;

import javafx.collections.ObservableList;
import model.dto.CustomerDTO;

public interface CustomerService {
    void addCustomerDetails(String id, String title, String name, String dob, double salary, String address, String city, String province, String postcode);

    void updateCustomerDetails(String id, String title, String name, String dob, double salary, String address, String city, String province, String postcode);

    void deleteCustomerDetails(String id);

    ObservableList<CustomerDTO> getAllCustomerDetails();
}
