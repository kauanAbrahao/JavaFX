package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class AlunoBoundary extends Application {

    private AlunoControl alunoControl = new AlunoControl();

    //Campos para adicionar aluno
    private Label lblAdd = new Label("Adicionando Alunos");
    private TextField txtRa = new TextField("digite o RA");
    private TextField txtNome = new TextField("digite o nome");
    private TextField txtNascimento = new TextField("digite data de nasc");
    private Button btnAdd = new Button("Adicionar");

    //Campos para Pesquisar
    private Label lblBuscar = new Label("Buscar Alunos");
    private TextField txtBuscaPorNome = new TextField("Digite o nome");
    private ListView listAlunos = new ListView();
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

        btnAdd.setOnAction((e) -> alunoControl.adicionarAluno(boundaryToEntity()));
        btnBuscar.setOnAction((e)-> entityToBoundary(alunoControl.pesquisarAlunoPorNome(txtBuscaPorNome.getText())));

        stage.setScene(scene);
        stage.setTitle("Cadastro e Busca de Alunos");
        stage.show();

    }

    private void entityToBoundary(List<Aluno> listaAlunos) {
        if(!listaAlunos.isEmpty()){
            ObservableList<String> itens = FXCollections.observableArrayList();
            for (Aluno aluno : listaAlunos){
                itens.add(aluno.getNome() + ", RA:" + aluno.getRa().toString() + " - Datanasc:" + aluno.getNascimento().toString());
            }
            listAlunos.setItems(itens);
        } else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Nenhum aluno encontrado!");
            alert.show();
        }
    }

    private Aluno boundaryToEntity() {
            Aluno aluno = new Aluno();
            try{
                aluno.setRa(txtRa.getText());
                aluno.setNome(txtNome.getText());
                DateTimeFormatter dt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                aluno.setNascimento(LocalDate.parse(txtNascimento.getText(), dt));
                limpaCampos();
                return aluno;
            } catch (Exception e){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Campo vazio ou preenchimento equivocado");
                alert.show();
                return null;
            }
    }

    private void limpaCampos() {
        txtRa.setText("digite o RA");
        txtNome.setText("digite o nome");
        txtNascimento.setText("digite a data de nascimento");
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Aluno adicionado com sucesso!");
        alert.show();
    }

    public static void main(String[] args) {
         Application.launch(args);
    }
}
