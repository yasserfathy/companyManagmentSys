/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.managment.system.Util;

import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;

/**
 *
 * @author OS
 */
public class DialogUtil {

    public static void showInfoDialog(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(message);
        alert.showAndWait();
        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.getStylesheets().add(StylePathUtil.MAIN_STYLE);
        dialogPane.getStyleClass().add("myDialog");
    }

    public static void showErrorDialog(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(message);
        alert.showAndWait();
        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.getStylesheets().add(StylePathUtil.MAIN_STYLE);
        dialogPane.getStyleClass().add("myDialog");
    }

//    public static void showConfirmDialog(String message, StackPane stackPane) {
//        JFXDialogLayout dialogLayout = new JFXDialogLayout();
//        dialogLayout.setHeading(new Label("Confirmation Dialog"));
//        HBox hBox = new HBox();
//        hBox.setSpacing(30);
//        Button confirm = new Button("Confirm");
//        Button cancle = new Button("Cancle");
//        hBox.getChildren().add(confirm);
//        hBox.getChildren().add(cancle);
//        dialogLayout.setBody(hBox);
//        JFXDialog confirmdDialog = new JFXDialog(stackPane, dialogLayout, JFXDialog.DialogTransition.BOTTOM);
//        confirmdDialog.show();
//    }
    public static int showConfirmationDialog(String title, String message) {
        int count = 0;
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setContentText(message);
        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.getStylesheets().add(StylePathUtil.MAIN_STYLE);
        dialogPane.getStyleClass().add("myDialog");
        Optional<ButtonType> result = alert.showAndWait();

        if ((result.isPresent()) && (result.get() == ButtonType.OK)) {
            count = 1;
        }
        return count;
    }
}
