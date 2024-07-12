package com.exemplo.model.enumeration;

public enum Prioridade {
    MUITO_ALTA("Muito Alta"),
    ALTA("Alta"),
    BAIXA("Baixa"),
    MUITO_BAIXA("Muito Baixa");

    private final String descricao;

    Prioridade(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
