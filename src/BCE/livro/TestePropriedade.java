package BCE.livro;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class TestePropriedade {

    public static void main(String[] args) {
        StringProperty titulo = new SimpleStringProperty("titulo1");

//        titulo.addListener(new ChangeListener<String>() {
//            @Override
//            public void changed(ObservableValue<? extends String> observableValue, String oldValue,
//                                String newValue) {
//
//                System.out.println("O titulo foi mudado de " + oldValue + " para " + newValue);
//            }
//        });

//        Tudo o que está comentado acima pode ser resumido hein:
        titulo.addListener((observable, oldValue, newValue) ->{ System.out.println("O titulo foi mudado de " + oldValue + " para " + newValue);
        });

        titulo.set("titulo2");

        titulo.set("titulo3");
    }
}
