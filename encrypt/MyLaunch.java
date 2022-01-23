package encrypt;


import encrypt.enum_.SecurityAction;
import encrypt.threads.SecurityThread;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.TextArea;

import javafx.stage.Stage;

import java.io.IOException;

import static encrypt.datastorage.GuiConstants.FILE_ENCRYPT_GUI_FXML;
import static encrypt.datastorage.GuiConstants.STAGE_TITLE;

public class MyLaunch extends Application {

    @FXML
    Button btnEncrypt;
    @FXML
    Button btnDecrypt;
    @FXML
    Button btnNewKeyPair;
    @FXML
    Button btnSetKeyPaths;
    @FXML
    TextArea taData;
    @FXML
    ButtonBar region;
    private Stage myStage;


    @Override
    public void start(Stage stage) throws IOException {


        Parent root = FXMLLoader.load(getClass().getResource(FILE_ENCRYPT_GUI_FXML));
        btnEncrypt = new Button();
        btnDecrypt = new Button();
        btnNewKeyPair = new Button();
        taData = new TextArea();
        region = new ButtonBar();


        stage.setTitle(STAGE_TITLE);

        Scene scene = new Scene(root);


        stage.setScene(scene);


        myStage = stage;
        stage.show();


    }


    /**
     * Encrypts a file chosen by the end-user
     *
     * @param ae
     */
    @FXML
    public void Encrypt(ActionEvent ae) {


        Platform.runLater(new SecurityThread(SecurityAction.ENCRYPT, taData, myStage));


    }


    /**
     * Decrypts a file chosen by the end-user
     *
     * @param ae
     */
    @FXML
    public void Decrypt(ActionEvent ae) {


        Platform.runLater(new SecurityThread(SecurityAction.DECRYPT, taData, myStage));

    }

    /**
     * Generates a new Keypair
     *
     * @param ae
     */

    @FXML
    public void GenerateNewKeyPair(ActionEvent ae) {

        Platform.runLater(new SecurityThread(SecurityAction.GENERATE_NEW_KEY_PAIR, taData, myStage));

    }

    @FXML
    public void SetKeyPaths(ActionEvent ae){

        Platform.runLater(new SecurityThread(SecurityAction.SET_KEY_PATHS,taData,myStage));
    }


}