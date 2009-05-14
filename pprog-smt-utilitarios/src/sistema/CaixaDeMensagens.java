package sistema;

import java.util.Vector;

public class CaixaDeMensagens {

    Vector<Mensagem> mensagens;

    public CaixaDeMensagens() {
        mensagens = new Vector<Mensagem>();
    }

    public void adicionarMensagem(int de, String assunto, String corpo) {
        mensagens.add(new Mensagem(de, assunto, corpo));
    }

    public void removerMensagem(int i) {
        mensagens.remove(i);
    }

    @Override
    public String toString() {
        String mensagensAcumuladas = "";

        for (Mensagem mensagem : mensagens)
            mensagensAcumuladas.concat(mensagem.getSubject() + "\n");

        return mensagensAcumuladas;
    }

    public String verMensagem(int i) {
        return mensagens.get(i).toString();
    }
    
}
