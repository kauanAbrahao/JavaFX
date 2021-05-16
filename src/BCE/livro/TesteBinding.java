package BCE.livro;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class TesteBinding extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane borderPane = new BorderPane();
        Scene scene = new Scene(borderPane, 400, 400);

        TextField txtField = new TextField();

        txtField.textProperty().addListener( (obs, antigo, novo) -> {
            System.out.println("Alterado de " + antigo + " para " + novo);
        });
        borderPane.setTop(txtField);

        TextField textField1 = new TextField();
        TextField textField2 = new TextField();
        TextField textField3 = new TextField();
        TextField textField4 = new TextField();

    // VAMOS FAZER O BINDING!!!!!!!
        Bindings.bindBidirectional(textField1.textProperty(), textField2.textProperty());
        textField4.textProperty().bind(textField3.textProperty());

        stage.setScene(scene);
        stage.setTitle("Binding");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
