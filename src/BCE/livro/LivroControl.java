package BCE.livro;

import javafx.beans.property.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LivroControl {

    private List<Livro> livros = new ArrayList<>();

    //MUDANÇAS! Vamos usar JavaFXProperties

    private LongProperty id = new SimpleLongProperty(0);


    private StringProperty titulo = new SimpleStringProperty("");
    private ObjectProperty<LocalDate> lancamento = new SimpleObjectProperty<>(LocalDate.now());
    private IntegerProperty edicao = new SimpleIntegerProperty(1);
    //outros atributos...

    public void setEntity(Livro livro){
        if (livro!=null){
            id.set(livro.getId());
            titulo.set(livro.getTitulo());
            lancamento.set(livro.getLancamento());
            //etc e tal


        }
    }

    public Livro getEntity(){
        Livro livro = new Livro();
        livro.setId(id.get());
        livro.setTitulo(titulo.get());
        // etc e tal
        return livro;
    }


    public void adicionarLivro(){
        Livro livro = this.getEntity();
        livros.add(livro);

    }

    public Livro pesquisarLivroPorTitulo(){
        for(Livro l: livros){
            if(l.getTitulo().contains(titulo.get())){
                this.setEntity(l);
            }
        }
        return null;
    }

    public long getId() {
        return id.get();
    }

    public LongProperty idProperty() {
        return id;
    }

    public String getTitulo() {
        return titulo.get();
    }

    public StringProperty tituloProperty() {
        return titulo;
    }

    public LocalDate getLancamento() {
        return lancamento.get();
    }

    public ObjectProperty<LocalDate> lancamentoProperty() {
        return lancamento;
    }

    public int getEdicao() {
        return edicao.get();
    }

    public IntegerProperty edicaoProperty() {
        return edicao;
    }
}
