package lk.Demo.src.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import lk.Demo.src.bo.BOFactory;
import lk.Demo.src.bo.custom.CustomerBO;
import lk.Demo.src.dto.CustomerDTO;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerController implements Initializable {
    public JFXTextField txtName;
    public JFXTextField txtContact;
    public JFXTextField txtEmail;

    public JFXButton btnSave;
    public JFXButton btnupdate;
    public JFXButton btndelete;
    public JFXTextField txtID;
    public JFXTextField txtSearch;
    public JFXButton btnSearch;
    public TableView tableSearch;
    public TableColumn columID;
    public TableColumn columName;
    public TableColumn columContact;
    public TableColumn columEmail;
    public TableColumn columAddress;
    public JFXTextField txtAddress;
    CustomerBO bo = BOFactory.getInstance().getBO(BOFactory.BOType.CUSTOMER);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        columID.setCellValueFactory(new PropertyValueFactory<>("id"));
        columName.setCellValueFactory(new PropertyValueFactory<>("name"));
        columContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
        columEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        columAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        loadAllCustomer();
    }

    public void onActionSave(ActionEvent actionEvent) {
        String id = txtID.getText();
        String name = txtName.getText();
        String contact = txtContact.getText();
        String email = txtEmail.getText();
        String address = txtAddress.getText();

        CustomerDTO customerDTO = new CustomerDTO(id, name, contact, email, address);

        boolean add = false;
        try {
            add = bo.addCustomer(customerDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (add) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Customer save");
            alert.setHeaderText(null);
            alert.setContentText("Customer added successfully!");
            alert.showAndWait();
            clear();
            loadAllCustomer();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Customer save");
            alert.setHeaderText(null);
            alert.setContentText("Oops, something went wrong!");
            alert.showAndWait();
        }
    }

    private void clear() {
        txtID.clear();
        txtName.clear();
        txtContact.clear();
        txtEmail.clear();
        txtAddress.clear();
    }

    public void onactionUpdate(ActionEvent actionEvent) {
        String id = txtID.getText();
        String name = txtName.getText();
        String contact = txtContact.getText();
        String email = txtEmail.getText();
        String address = txtAddress.getText();

        CustomerDTO customerDTO = new CustomerDTO(id, name, contact, email, address);

        boolean add = false;
        try {
            add = bo.updateCustomer(customerDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (add) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Customer Update");
            alert.setHeaderText(null);
            alert.setContentText("Customer Updated successfully!");
            alert.showAndWait();
            clear();
            loadAllCustomer();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Customer save");
            alert.setHeaderText(null);
            alert.setContentText("Oops, something went wrong!");
            alert.showAndWait();
        }
    }

    public void onactionDelete(ActionEvent actionEvent) {
        try {
            String customerID = txtID.getText();
            boolean b = bo.deleteCustomer(customerID);
            if (b) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Customer delete");
                alert.setHeaderText(null);
                alert.setContentText("Customer deleted successfully!");
                alert.showAndWait();
                clear();
                loadAllCustomer();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Customer save");
                alert.setHeaderText(null);
                alert.setContentText("Oops, something went wrong!");
                alert.showAndWait();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onActionSearch(ActionEvent actionEvent) {
        try {
            String userId = txtSearch.getText();
            CustomerDTO customerDTO = bo.searchCustomer(userId);
            txtID.setText(customerDTO.getId());
            txtName.setText(customerDTO.getName());
            txtContact.setText(customerDTO.getContact());
            txtEmail.setText(customerDTO.getEmail());
            txtAddress.setText(customerDTO.getAddress());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onTableclick(MouseEvent mouseEvent) {
        CustomerDTO selectedItem = (CustomerDTO) tableSearch.getSelectionModel().getSelectedItem();
        txtID.setText(selectedItem.getId());
        txtName.setText(selectedItem.getName());
        txtContact.setText(selectedItem.getContact());
        txtEmail.setText(selectedItem.getEmail());
        txtAddress.setText(selectedItem.getAddress());
    }

    private void loadAllCustomer() {
        try {
            ArrayList<CustomerDTO> allCustomer = bo.getAllCustomer();
            tableSearch.setItems(FXCollections.observableArrayList(allCustomer));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean checkRegEx(String pattern, String text) {
        Pattern compile = Pattern.compile(pattern);
        Matcher matcher = compile.matcher(text);
        return matcher.matches();
    }

    public void txtNameOnKeyReleassed(KeyEvent keyEvent) {
        String name = txtName.getText();
        if (checkRegEx("^[A-z]{1,}$", name)){
            txtName.setFocusColor(Paint.valueOf("BLUE"));
            txtName.setUnFocusColor(Paint.valueOf("BLUE"));
        }else{
            txtName.setFocusColor(Paint.valueOf("RED"));
            txtName.setUnFocusColor(Paint.valueOf("RED"));
        }
    }

    public void IdOnKeyReleseased(KeyEvent keyEvent) {
        String id = txtID.getText();
        if (checkRegEx("^[a-zA-Z0-9_-]+$", id)){
            txtID.setFocusColor(Paint.valueOf("BLUE"));
            txtID.setUnFocusColor(Paint.valueOf("BLUE"));
        }else{
            txtID.setFocusColor(Paint.valueOf("RED"));
            txtID.setUnFocusColor(Paint.valueOf("RED"));
        }
    }

    public void contactOnKeyReleased(KeyEvent keyEvent) {
        String contact = txtContact.getText();
        if (checkRegEx("^+[0-9]{6,14}$", contact)){
            txtContact.setFocusColor(Paint.valueOf("BLUE"));
            txtContact.setUnFocusColor(Paint.valueOf("BLUE"));
        }else{
            txtContact.setFocusColor(Paint.valueOf("RED"));
            txtContact.setUnFocusColor(Paint.valueOf("RED"));
        }
    }

    public void emailOnKeyRelesed(KeyEvent keyEvent) {
        String email = txtEmail.getText();
        if (checkRegEx("^[A-Za-z0-9+_.-]+@(.+)$", email)){
            txtEmail.setFocusColor(Paint.valueOf("BLUE"));
            txtEmail.setUnFocusColor(Paint.valueOf("BLUE"));
        }else{
            txtEmail.setFocusColor(Paint.valueOf("RED"));
            txtEmail.setUnFocusColor(Paint.valueOf("RED"));
        }
    }

    public void addressOnKeyRelesed(KeyEvent keyEvent) {

        String address = txtAddress.getText();
        if (checkRegEx("^[#.0-9a-zA-Z\\s,-]+$", address)){
            txtAddress.setFocusColor(Paint.valueOf("BLUE"));
            txtAddress.setUnFocusColor(Paint.valueOf("BLUE"));
        }else{
            txtAddress.setFocusColor(Paint.valueOf("RED"));
            txtAddress.setUnFocusColor(Paint.valueOf("RED"));
        }
    }

    public void searchOnKeyRelesed(KeyEvent keyEvent) {
        String search = txtSearch.getText();
        if (checkRegEx("^[a-zA-Z0-9]+$", search)){
            txtSearch.setFocusColor(Paint.valueOf("BLUE"));
            txtSearch.setUnFocusColor(Paint.valueOf("BLUE"));
        }else{
            txtSearch.setFocusColor(Paint.valueOf("RED"));
            txtSearch.setUnFocusColor(Paint.valueOf("RED"));
        }
    }
}
