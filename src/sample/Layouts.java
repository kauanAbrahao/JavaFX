package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Layouts extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Button btnSalvar = new Button("Salvar");
        TextField textField = new TextField();
        textField.setPrefSize(250, 40);
        btnSalvar.setPrefSize(150, 20);


        //FLOWPANE
//        FlowPane pane = new FlowPane();
//        pane.setHgap(20.0); //espaço entre os componentes no flowpane (eixo x)
//        pane.setVgap(100.0); // eixo y

//        //BORDERPANE
//        BorderPane borderPane = new BorderPane();
//        Scene scene =  new Scene(borderPane, 500, 500);
//        borderPane.setTop();  Define em que local o componente vai ficar. Pode até mesmo ser outro pane.
//        borderPane.setRight();

        //TILEPANE
//        TilePane tilePane = new TilePane();
//        tilePane.setPrefColumns(0); //numero de colunas
//        tilePane.getChildren().addAll(btnSalvar, textField);



        //GRIDPANE
        //similar ao Tilepane, mas nós definimos onde o componente vai ficar
        GridPane gridPane = new GridPane();
        gridPane.add(btnSalvar, 0, 1);
        gridPane.add(textField, 0, 2);
        gridPane.setVgap(20);

        Scene scene = new Scene(gridPane, 500,500);
        stage.setScene(scene);
        stage.setTitle("Testes de Layout");
        stage.show();

        //Há ainda VBOX, ARCHORPANE e HBOX
        

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
