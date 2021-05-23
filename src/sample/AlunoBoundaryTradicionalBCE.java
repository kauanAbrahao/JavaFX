package sample;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafx.util.converter.DateStringConverter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class AlunoBoundaryTradicionalBCE extends  Application {
    private AlunoControlTradicionalBCE alunoControl = new AlunoControlTradicionalBCE();

    //Campos para adicionar aluno
    private Label lblAdd = new Label("Adicionando Alunos");
    private TextField txtRa = new TextField("digite o RA");
    private TextField txtNome = new TextField("digite o nome");
    private TextField txtNascimento = new TextField("digite data de nasc");
    private Button btnAdd = new Button("Adicionar");

    //Campos para Pesquisar
    private Label lblBuscar = new Label("Buscar Alunos");
    private TextField txtBuscaPorNome = new TextField("Digite o nome");
    private TextField listAlunos = new TextField();
    private Label lblResultado = new Label("Resultado: ");
    private Button btnBuscar = new Button("Buscar");

    @Override
    public void start(Stage stage) throws Exception {
        GridPane gridPane = new GridPane();

        Scene scene = new Scene(gridPane, 400, 400);

        gridPane.add(lblAdd, 0, 0);
        gridPane.add(txtRa, 0, 1);
        gridPane.add(txtNome, 0, 2 );
        gridPane.add(txtNascimento, 0, 3 );
        gridPane.add(btnAdd, 0, 4);

        gridPane.add(lblBuscar, 3, 0);
        gridPane.add(txtBuscaPorNome, 3, 1);
        gridPane.add(btnBuscar, 3, 2);
        gridPane.add(lblResultado, 3, 4);

        listAlunos.setPrefSize(200, 200);
        gridPane.add(listAlunos, 3, 5);

        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(5, 5, 5,5));
        gridPane.setPrefSize(10, 10);

        btnAdd.setOnAction((e) -> alunoControl.adicionarAluno());
        btnBuscar.setOnAction((e)-> alunoControl.pesquisarAlunoPorNome());

        //Criando os Bindings para enviar à controller
        StringConverter dataToStringConverter = new DateStringConverter();

        Bindings.bindBidirectional(txtNome.textProperty(), alunoControl.nomeProperty());
        Bindings.bindBidirectional(txtRa.textProperty(), alunoControl.raProperty());
        Bindings.bindBidirectional(txtNascimento.textProperty(), alunoControl.nascimentoProperty(), dataToStringConverter);
        Bindings.bindBidirectional(txtBuscaPorNome.textProperty(), alunoControl.respostaProperty());
        Bindings.bindBidirectional(listAlunos.textProperty(), alunoControl.listviewProperty());

        stage.setScene(scene);
        stage.setTitle("Cadastro e Busca de Alunos");
        stage.show();

    }



    public static void main(String[] args) {
        Application.launch(args);
    }
}

