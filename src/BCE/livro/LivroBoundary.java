package BCE.livro;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafx.util.converter.DateStringConverter;
import javafx.util.converter.LongStringConverter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LivroBoundary extends Application {

    private TextField txtId = new TextField();
    private TextField txtISBN = new TextField();
    private TextField txtTitulo = new TextField();
    private TextField txtEdicao = new TextField();
    private TextField txtLancamento = new TextField();
    private TextField txtAutor = new TextField();
    private TextField txtEditora = new TextField();

    private Button btnAdicionar = new Button();
    private Button btnPesquisar = new Button();

    private LivroControl livroControl = new LivroControl();

    @Override
    public void start(Stage stage) throws Exception {
        GridPane gridPane = new GridPane();
        Scene scene = new Scene(gridPane, 500, 500);

        //Criando as labels

        gridPane.add(new Label("Id"), 0 ,0);
        gridPane.add(new Label("ISBN"), 0 ,1);
        gridPane.add(new Label("Titulo"), 0 ,2);
        gridPane.add(new Label("Edicao"), 0 ,3);
        gridPane.add(new Label("Lançamento"), 0 ,4);
        gridPane.add(new Label("Autor"), 0 ,5);
        gridPane.add(new Label("Editora"), 0 ,6);

        gridPane.add(txtId, 0, 0);
        gridPane.add(txtISBN, 0, 1);
        gridPane.add(txtTitulo, 0, 2);
        gridPane.add(txtEdicao, 0, 3);
        gridPane.add(txtLancamento, 0, 4);
        gridPane.add(txtAutor, 0, 5);
        gridPane.add(txtEditora, 0, 6);

        gridPane.add(btnAdicionar, 0 ,7);
        gridPane.add(btnPesquisar, 1, 7);

        btnAdicionar.setOnAction((e)->livroControl.adicionarLivro());
        btnPesquisar.setOnAction((e) -> entityToBoundary(livroControl.pesquisarLivroPorTitulo())
        );

        //Criando um vinculo com as propriedades da Control
        StringConverter longToStringConverter = new LongStringConverter();
        StringConverter dateToStringConverter = new DateStringConverter();

        Bindings.bindBidirectional(txtId.textProperty(), livroControl.idProperty(), longToStringConverter);
        Bindings.bindBidirectional(txtTitulo.textProperty(), livroControl.tituloProperty());
        Bindings.bindBidirectional(txtLancamento.textProperty(), livroControl.lancamentoProperty(), dateToStringConverter);
        //todos os atributos...

        stage.setScene(scene);
        stage.setTitle("Gestão de Livros");
        stage.show();
    }

    public Livro boundaryToEntity(){
        Livro livro = new Livro();
        try{
            livro.setId(Long.parseLong(txtId.getText()));
            DateTimeFormatter dt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            livro.setLancamento(LocalDate.parse(txtLancamento.getText(), dt));
            livro.setAutor(txtAutor.getText());
            livro.setTitulo(txtTitulo.getText());
            return livro;
            //colocar os outros sets
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

    public void entityToBoundary(Livro livro){
        if(livro!= null) {
            txtId.setText(String.valueOf(livro.getId()));
            txtAutor.setText(livro.getAutor());
            //colocar outros sets
        } else{
            txtId.setText("Livro não encontrado");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
