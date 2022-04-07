package com.managment.system.controller;

import com.managment.system.SBBST.SelfBalancingBinarySearchTree;
import com.managment.system.Util.FxmlDtoUtil;
import com.managment.system.Util.UiPathUtil;
import com.managment.system.dto.FxmlDto;
import com.managment.system.model.Employees;
import com.managment.system.model.Employer;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import static jdk.nashorn.internal.runtime.Debug.id;

public class LoginController implements Initializable {

    @FXML
    private BorderPane mainPane;

    @FXML
    private VBox center;

    @FXML
    private TextField userNameField;

    @FXML
    private TextField passwordField;

    @FXML
    private Button asEmployee;

    @FXML
    private Button asEmployer;

    @FXML
    private Button createAccount;

    @FXML
    private HBox top;

    @FXML
    private HBox bottom;

    @FXML
    private VBox left;
    private List<Employees> employees;
    private List<Employer> employers;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        asEmployee.setOnAction(event -> {
            try {
                FxmlDto fxmlDto = FxmlDtoUtil.getFxmlDto(UiPathUtil.EMPLOYEE_LEFT_PAGE, EmployeeLeftMenuController.class);
                VBox vBox = (VBox) FxmlDtoUtil.loadFxml(fxmlDto);
                mainPane.setLeft(vBox);
                FxmlDto fxmlDto1 = FxmlDtoUtil.getFxmlDto(UiPathUtil.EMPLOYEE_PAGE, EmployeePageController.class);
                VBox vBox1 = (VBox) FxmlDtoUtil.loadFxml(fxmlDto1);
                mainPane.setCenter(vBox1);
//                List<Employees> employeesList = new ArrayList<>();
//                int uniqueID = UUID.randomUUID().clockSequence();
//                Employer ibm = new Employer(uniqueID, uniqueID, null, uniqueID, null, null, uniqueID, uniqueID, uniqueID, null)
//                employeesList.add(new Employees(uniqueID, "Amr", "Amr@gmail.com", "Development", 1, 6, "California", null, null, null, null))
                SelfBalancingBinarySearchTree sbbst = new SelfBalancingBinarySearchTree();
//                sbbst.insert(data);
            } catch (IOException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    public BorderPane getMainPane() {
        return mainPane;
    }

    public void setMainPane(BorderPane mainPane) {
        this.mainPane = mainPane;
    }

    public VBox getCenter() {
        return center;
    }

    public void setCenter(VBox center) {
        this.center = center;
    }

    public Button getAsEmployee() {
        return asEmployee;
    }

    public void setAsEmployee(Button asEmployee) {
        this.asEmployee = asEmployee;
    }

    public Button getAsEmployer() {
        return asEmployer;
    }

    public void setAsEmployer(Button asEmployer) {
        this.asEmployer = asEmployer;
    }

    public Button getCreateAccount() {
        return createAccount;
    }

    public void setCreateAccount(Button createAccount) {
        this.createAccount = createAccount;
    }

    public HBox getTop() {
        return top;
    }

    public void setTop(HBox top) {
        this.top = top;
    }

    public HBox getBottom() {
        return bottom;
    }

    public void setBottom(HBox bottom) {
        this.bottom = bottom;
    }

    public VBox getLeft() {
        return left;
    }

    public void setLeft(VBox left) {
        this.left = left;
    }

    public int getId() {
        return  UUID.randomUUID().clockSequence();
    }

    public List<Employees> getEmployees() {
        employees.add(new Employees(getId(), "Samer", null, null, null, 1, 15, null, null, null, null));
        employees.add(new Employees(getId(), "Aicha", null, null, null, 2, 12, null, null, null, null));
        employees.add(new Employees(getId(), "Maryam", null, null, null, 2, 12, null, null, null, null));
        employees.add(new Employees(getId(), "Marie", null, null, null, 3, 9, null, null, null, null));
        employees.add(new Employees(getId(), null, null, null, null, 3, 9, null, null, null, null));
        employees.add(new Employees(getId(), null, null, null, null, 4, 5, null, null, null, null));
        employees.add(new Employees(getId(), null, null, null, null, 4, 4, null, null, null, null));
        employees.add(new Employees(getId(), null, null, null, null, 4, 6, null, null, null, null));
        employees.add(new Employees(getId(), null, null, null, null, 4, 3, null, null, null, null));
        return employees;
        
        
        
    }

    public void setEmployees(List<Employees> employees) {
        this.employees = employees;
    }

    public List<Employer> getEmployers() {
        employers.add(new Employer(getId(), 3, "john", 43, "john@gmail.com", "Development", 1, 15000, 15, "Paris"));
        employers.add(new Employer(getId(), 2, "jack", 45, "jack@gmail.com", "Development", 2, 12000, 13, "California"));
        employers.add(new Employer(getId(), 3, "mark", 35, "mark@gmail.com", "Development", 2, 12000, 11, "London"));
        employers.add(new Employer(getId(), 4, "julie", 37, "julie@gmail.com", "Development", 3, 9000, 9, "Perlin"));
        employers.add(new Employer(getId(), 3, "caroline", 28, "caroline@gmail.com", "Development", 3, 9000, 7, "Milan"));
        employers.add(new Employer(getId(), 4, "nadia", 47, "nadia@gmail.com", "Development", 4, 7000, 3, "Cairo"));
        employers.add(new Employer(getId(), 5, "sarah", 33, "sarah@gmail.com", "Development", 4, 7000, 3, "Morroco"));
        return employers;
    }

    public void setEmployers(List<Employer> employers) {
        this.employers = employers;
    }
}
