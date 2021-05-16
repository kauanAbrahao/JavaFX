package BCE.livro;

import java.util.ArrayList;
import java.util.List;

public class LivroControl {

    private List<Livro> livros = new ArrayList<>();


    public void adicionarLivro(Livro livro){
        livros.add(livro);
    }

    public Livro pesquisarLivroPorTitulo(String titulo){
        for(Livro l: livros){
            if(l.getTitulo().contains(titulo)){
                return l;
            }
        }
        return null;
    }
}
