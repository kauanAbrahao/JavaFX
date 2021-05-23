package sample;

import javafx.beans.property.*;
import javafx.scene.control.Alert;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AlunoControlTradicionalBCE {

    private List<Aluno> alunos = new ArrayList<>();

    public String getRa() {
        return ra.get();
    }

    public StringProperty raProperty() {
        return ra;
    }

    public String getNome() {
        return nome.get();
    }

    public StringProperty nomeProperty() {
        return nome;
    }

    public StringProperty listviewProperty() {
        return listView;
    }

    public LocalDate getNascimento() {
        return nascimento.get();
    }

    public String getResposta(){ return resposta.get();}

    public StringProperty respostaProperty (){
        return resposta;
    }

    public ObjectProperty<LocalDate> nascimentoProperty() {
        return nascimento;
    }

    private StringProperty ra = new SimpleStringProperty("digite ra");
    private StringProperty nome = new SimpleStringProperty("digita nome");
    private ObjectProperty<LocalDate> nascimento = new SimpleObjectProperty<>();
    private StringProperty resposta = new SimpleStringProperty("busca");
    private StringProperty listView = new SimpleStringProperty();


    public void setAluno(Aluno aluno){
        if (aluno!=null){
            ra.set(aluno.getRa());
            nome.set(aluno.getNome());
            nascimento.set(aluno.getNascimento());
        }
    }

    public Aluno getAluno(){
        Aluno aluno = new Aluno();
        aluno.setRa(ra.get());
        aluno.setNome(nome.get());
        aluno.setNascimento(nascimento.get());
        return aluno;
    }

    public void adicionarAluno() {
        Aluno aluno = this.getAluno();
        alunos.add(aluno);
            ra.set("");
            nome.set("");
            nascimento.set(null);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Aluno adicionado com sucesso!");
            alert.show();

    }

    public void pesquisarAlunoPorNome() {
        StringBuffer stringBuffer = new StringBuffer();
        for (Aluno aluno : alunos) {
            if (aluno.getNome().contains(resposta.get())) {
                stringBuffer.append(aluno.getNome() + ", " + aluno.getRa() + "\n");
            }
        }
        listView.set(stringBuffer.toString());
    }
}