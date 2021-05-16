package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class FormularioComLayout extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FlowPane pane = new FlowPane();
        pane.setVgap(5);
        pane.setHgap(15);
        pane.setPadding(new Insets(10));

        //id ---------------------------
        Label labelId = new Label("ID");
        TextField textFieldId = new TextField();
        textFieldId.setPrefSize(400, 20);
        labelId.setPrefSize(50, 50);

        //nome ----------------------------
        Label labelNome = new Label("Nome");
        TextField textFieldName = new TextField();
        textFieldName.setPrefSize(400, 20);
        labelNome.setPrefSize(50,50);

        //telefone --------------------------
        Label labelTel = new Label("Telefone");
        TextField textFieldTel = new TextField();
        textFieldTel.setPrefSize(400, 20);
        labelTel.setPrefSize(50, 50);


        Button btnSalvar = new Button("Salvar");
        Button btnPesquisar = new Button("Pesquisar");
        btnSalvar.setPrefWidth(70);
        btnPesquisar.setPrefWidth(70);


        pane.getChildren().addAll(labelId, textFieldId, labelNome, textFieldName,
                labelTel, textFieldTel, btnSalvar, btnPesquisar);

        Scene scene = new Scene(pane,500, 250);
        stage.setTitle("Formulário com Layout");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
