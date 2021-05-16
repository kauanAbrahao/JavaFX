package sample;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        /*Parent root = FXMLLoader.load(getClass().getResource("aluno.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();*/
        stage.setTitle("Formulário");
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.TOP_CENTER);

        gridPane.setPadding(new Insets(20, 20, 20, 20));
        gridPane.setHgap(20);
        gridPane.setVgap(30);

        // columnOneConstraints will be applied to all the nodes placed in column one.
        ColumnConstraints columnOneConstraints = new ColumnConstraints(100, 100, Double.MAX_VALUE);
        columnOneConstraints.setHalignment(HPos.LEFT);

        // columnTwoConstraints will be applied to all the nodes placed in column two.
        ColumnConstraints columnTwoConstrains = new ColumnConstraints(200,200, Double.MAX_VALUE);
        columnTwoConstrains.setHgrow(Priority.ALWAYS);

        gridPane.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);

        Scene scene = new Scene(gridPane, 700, 300);
        addUI(gridPane);

        stage.setScene(scene);
        stage.show();

    }

    private void addUI(GridPane gridPane) {
        Label id = new Label("ID");
        id.setFont(Font.font("Arial", FontWeight.NORMAL, 22));
        gridPane.add(id, 0,1);

        TextField txtField = new TextField();
        txtField.setPrefHeight(40);
        gridPane.add(txtField, 1, 1);

        Label nome = new Label("Nome");
        nome.setFont(Font.font("Arial", FontWeight.NORMAL, 22));
        gridPane.add(nome, 0, 2);

        TextField txtField2 = new TextField();
        txtField2.setPrefHeight(40);
        gridPane.add(txtField2, 1, 2);

        Label telefone = new Label("Telefone");
        telefone.setFont(Font.font("Arial", FontWeight.NORMAL, 22));
        gridPane.add(telefone, 0, 3);

        TextField txtField3 = new TextField();
        txtField3.setPrefHeight(40);
        gridPane.add(txtField3, 1, 3);

        Button button = new Button("Salvar");
        Button button1 = new Button("Pesquisar");
        button.setPrefHeight(40);
        button1.setPrefHeight(40);
        button.setDefaultButton(true);
        button1.setDefaultButton(true);
        button.setPrefWidth(100);
        button1.setPrefWidth(100);
        gridPane.add(button, 0, 4);
        gridPane.add(button1, 1, 4);

    }


    public static void main(String[] args) {
        Application.launch(args);
    }
}
