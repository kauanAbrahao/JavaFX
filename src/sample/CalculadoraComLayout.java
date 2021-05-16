package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class CalculadoraComLayout extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        FlowPane pane = new FlowPane();
        pane.setVgap(10);
        pane.setHgap(15);
        pane.setPadding(new Insets(10));

        //CE ---------------------
        TextField textFieldCE = new TextField("0");
        Button buttonCE = new Button("CE");
        buttonCE.setPrefSize(50, 30);
        pane.getChildren().addAll(textFieldCE, buttonCE);

        //Fileira 1 ---------------------------
        botoesFileira(1, 4, "+", pane);

        //Fileira 2 ---------------------------
        botoesFileira(4, 7, "-", pane);

        //Fileira 3 ---------------------------
        botoesFileira(7, 10, "*", pane);

        //Fileira 4 ---------------------------
        Button button1 = new Button(",");
        Button button2 = new Button("0");
        Button button3 = new Button("=");
        Button button4 = new Button("/");

        button1.setPrefSize(40, 30);
        button2.setPrefSize(40, 30);
        button3.setPrefSize(40, 30);
        button4.setPrefSize(40, 30);
        pane.getChildren().addAll(button1, button2, button3, button4);

        Scene scene = new Scene(pane,240,210);
        stage.setTitle("Calculadora");
        stage.setScene(scene);
        stage.show();
    }

    private void botoesFileira(int a, int b, String btn, FlowPane pane) {
        for (int i = a; i<=b; i++){
            Button button;
            if(i == b){
                button = new Button(btn);

            } else {
                button = new Button(String.valueOf(i));

            }
            button.setPrefSize(40, 30);;
            pane.getChildren().add(button);
        }
    }
}
