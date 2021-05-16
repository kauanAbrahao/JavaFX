package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class BotoesComFuncionalidade extends Application {


    class AssinanteMouse implements EventHandler<MouseEvent>{
        @Override
        public void handle(MouseEvent mouseEvent) {
            System.out.println("Botao apertado");
        }
    }


    @Override
    public void start(Stage stage) throws Exception {
        BorderPane borderPane = new BorderPane();
        Scene scene = new Scene(borderPane, 600, 600);

        Button btn = new Button("Me aperte");
        Label lbl = new Label();

        AssinanteMouse assinanteMouse = new AssinanteMouse();
        btn.addEventFilter(MouseEvent.MOUSE_PRESSED, assinanteMouse);

        borderPane.setTop(btn);

        borderPane.getChildren().add(btn);

        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}
