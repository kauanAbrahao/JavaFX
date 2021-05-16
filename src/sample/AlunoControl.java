package sample;

import java.util.ArrayList;
import java.util.List;

public class AlunoControl {


    private List<Aluno> alunos = new ArrayList<>();

    public void adicionarAluno(Aluno aluno){
        if (aluno != null) {
            alunos.add(aluno);
        }
    }

    public List<Aluno> pesquisarAlunoPorNome(String nome){
        List<Aluno> alunosRetorno = new ArrayList<>();
        for (Aluno aluno : alunos){
            if(aluno.getNome().contains(nome)){
                alunosRetorno.add(aluno);
            }
        }
        return alunosRetorno;
    }


}
