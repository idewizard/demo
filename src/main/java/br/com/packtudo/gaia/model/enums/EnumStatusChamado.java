package br.com.packtudo.gaia.model.enums;

import br.com.packtudo.gaia.model.entity.StatusChamado;

public enum EnumStatusChamado {

    NOVO(1, "Novo"),
    PENDENTE(2, "Pendente"),
    SOLUCIONADO(3, "Solucionado");

    private final short codStatusChamado;
    private final String descStatusChamado;

    EnumStatusChamado(int codStatusChamado, String descStatusChamado) {
        this.codStatusChamado = (short) codStatusChamado;
        this.descStatusChamado = descStatusChamado;
    }

    public StatusChamado getEntidade() {
        return StatusChamado.of(getCodigoStatus(), getDescStatusChamado());
    }

    private String getDescStatusChamado() {
        return this.descStatusChamado;
    }

    private short getCodigoStatus() {
        return this.codStatusChamado;
    }
}
