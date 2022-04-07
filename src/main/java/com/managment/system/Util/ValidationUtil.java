/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.managment.system.Util;

import com.jfoenix.controls.JFXTextField;
import javafx.scene.control.TextField;

/**
 *
 * @author OS
 */
public class ValidationUtil {

    public static boolean isEmpty(JFXTextField... textFields) {
        for (JFXTextField textField : textFields) {
            if (textField.getText().isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public static boolean isEmpty(TextField... textFields) {
        for (TextField textField : textFields) {
            if (textField.getText().isEmpty()) {
                return true;
            }
        }
        return false;
    }
}
