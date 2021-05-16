package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

public class Calculadora extends Application {


    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Calculadora");
        Pane pane = new Pane();
        Scene scene = new Scene(pane, 220, 240);
        stage.setScene(scene);
        addUI(pane);
        stage.show();

    }

    private void addUI(Pane pane) {
//        Linha 1 --------------
        TextField textField = new TextField("0");
        textField.relocate(10, 30);
        pane.getChildren().add(textField);

        Button buttonCE = new Button("CE");
        addStyle(buttonCE);
        buttonCE.relocate(170, 30);
        pane.getChildren().add(buttonCE);

//        Linha 2 ----------------

        Button button1 = new Button("1");
        addStyle(button1);
        button1.relocate(10, 70);
        pane.getChildren().add(button1);


        Button button2 = new Button("2");
        addStyle(button2);
        button2.relocate(60, 70);
        pane.getChildren().add(button2);

        Button button3 = new Button("3");
        addStyle(button3);
        button3.relocate(110, 70);
        pane.getChildren().add(button3);

        Button buttonSum = new Button("+");
        addStyle(buttonSum);
        buttonSum.relocate(160, 70);
        pane.getChildren().add(buttonSum);

//        Linha 3 --------------------

        Button button4 = new Button("4");
        addStyle(button4);
        button4.relocate(10, 110);
        pane.getChildren().add(button4);

        Button button5 = new Button("5");
        addStyle(button5);
        button5.relocate(60, 110);
        pane.getChildren().add(button5);

        Button button6 = new Button("6");
        addStyle(button6);
        button6.relocate(110, 110);
        pane.getChildren().add(button6);

        Button buttonMinus = new Button("-");
        addStyle(buttonMinus);
        buttonMinus.relocate(160, 110);
        pane.getChildren().add(buttonMinus);

//        Linha 4 ----------------------------

        Button button7 = new Button("7");
        addStyle(button7);
        button7.relocate(10, 150);
        pane.getChildren().add(button7);

        Button button8 = new Button("8");
        addStyle(button8);
        button8.relocate(60, 150);
        pane.getChildren().add(button8);

        Button button9 = new Button("9");
        addStyle(button9);
        button9.relocate(110, 150);
        pane.getChildren().add(button9);

        Button buttonMult = new Button("*");
        addStyle(buttonMult);
        buttonMult.relocate(160, 150);
        pane.getChildren().add(buttonMult);

//        Linha 5 ----------------------------
        Button buttonVir = new Button(",");
        addStyle(buttonVir);
        buttonVir.relocate(10, 190);
        pane.getChildren().add(buttonVir);

        Button button0 = new Button("0");
        addStyle(button0);
        button0.relocate(60, 190);
        pane.getChildren().add(button0);

        Button buttonEq = new Button("=");
        addStyle(buttonEq);
        buttonEq.relocate(110, 190);
        pane.getChildren().add(buttonEq);

        Button buttonBar = new Button("/");
        addStyle(buttonBar);
        buttonBar.relocate(160, 190);
        pane.getChildren().add(buttonBar);


    }

    private void addStyle(Button button) {
        button.setDefaultButton(true);
        button.setPrefWidth(40);
        button.setStyle("-fx-background-radius: 0.5em;" +
                "-fx-border-radius: 0.5em");
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
