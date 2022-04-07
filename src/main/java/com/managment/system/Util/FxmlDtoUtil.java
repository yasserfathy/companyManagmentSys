/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.managment.system.Util;

import com.managment.system.dto.FxmlDto;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

/**
 *
 * @author OS
 */
public class FxmlDtoUtil {

    public static Parent loadFxml(FxmlDto fxmlDto) throws IOException {
        String fxml = fxmlDto.getFxml();
        Object owner = fxmlDto.getOwner();
        FXMLLoader loader = new FXMLLoader(owner.getClass().getResource(fxml));
        Parent pane = loader.load();
        fxmlDto.setLoader(loader);
        return pane;
    }

    public static FxmlDto getFxmlDto(String fileName, Class clazz) throws IOException {
        FxmlDto mainFxmlDto = new FxmlDto();
        mainFxmlDto.setFxml(fileName);
        mainFxmlDto.setOwner(clazz);
        return mainFxmlDto;
    }

}
