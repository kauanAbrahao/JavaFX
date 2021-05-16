package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class HelloWorldButton extends Application {
    Label label = new Label("Oi!");

    class Clique implements EventHandler<MouseEvent>{

        @Override
        public void handle(MouseEvent mouseEvent) {
            label.setText("Hello world!");
        }
    }

    @Override
    public void start(Stage stage) throws Exception {
        Button btnHW = new Button("Clique em mim!");
        Clique clique = new Clique();
        btnHW.addEventFilter(MouseEvent.MOUSE_CLICKED, clique);

        Pane pane = new Pane();
        pane.getChildren().add(btnHW);
        pane.getChildren().get(0).setLayoutX(50);
        pane.getChildren().get(0).setLayoutY(80);

        pane.getChildren().add(label);
        pane.getChildren().get(1).setLayoutX(90);


        Scene scene = new Scene(pane,200, 200);
        stage.setTitle("Um botão simpático");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String []args){
        Application.launch(args);
    }
}
