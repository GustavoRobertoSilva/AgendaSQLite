package br.edu.ifsp.agendasqlite.model;

import java.io.Serializable;
import java.util.Objects;

public class Contato implements Serializable {

    private int id;
    private String nome;
    private String dataNascimento;
    private String fone;
    private String foneContato;
    private String email;
    private int favorito = 0;

    public Contato() {
    }

    public Contato(int id) {
        this.id = id;
    }

    public Contato(String nome, String fone, String email, int favorito, String foneContato, String dataNascimento) {
        this.nome = nome;
        this.fone = fone;
        this.dataNascimento = dataNascimento;
        this.foneContato = foneContato;
        this.email = email;
        this.favorito = favorito;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getFavorito() {
        return favorito;
    }

    public void setFavorito(int favorito) {
        this.favorito = favorito;
    }

    public String getFoneContato() {
        return foneContato;
    }

    public void setFoneContato(String foneContato) {
        this.foneContato = foneContato;
    }

    public String getDataNascimento() {return dataNascimento;}

    public void setDataNascimento(String dataNascimento) {this.dataNascimento = dataNascimento;}

//    @Override
//    public int hashCode() {
//        return Objects.hash(getId(), getNome(), getDataNascimento(), getFone(), getFoneContato(), getEmail(), getFavorito());
//    }

    public boolean equals(Object obj) {
        Contato c2 = (Contato) obj;
        if (this.id == c2.getId())
            return true;
        else
            return false;
    }


    @Override
    public String toString() {
        return "Contato{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", dataNascimento='" + dataNascimento + '\'' +
                ", fone='" + fone + '\'' +
                ", foneContato='" + foneContato + '\'' +
                ", email='" + email + '\'' +
                ", favorito=" + favorito +
                '}';
    }
}
