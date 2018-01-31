package model.entidades;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "tamanho")
public class Tamanho implements Serializable {

    // C�digo
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "cd_tamanho", nullable = false, columnDefinition = "number(10)")
    private int cdTamanho;
    // Descri��o
    @Column(name = "ds_tamanho", nullable = false, columnDefinition = "varchar2(50)")
    private String dsTamanho;
    // Descri��o
    @Column(name = "tm_ativo", nullable = false, columnDefinition = "number(10)")
    private int tmAtivo;

    public String getDsTamanho() {
        return dsTamanho;
    }

    public void setDsTamanho(String dsTamanho) {
        this.dsTamanho = dsTamanho;
    }

    public int getTmAtivo() {
        return tmAtivo;
    }

    public void setTmAtivo(int tmAtivo) {
        this.tmAtivo = tmAtivo;
    }

    public int getCdTamanho() {
        return cdTamanho;
    }

    public void setCdTamanho(int cdTamanho) {
        this.cdTamanho = cdTamanho;
    }
}
