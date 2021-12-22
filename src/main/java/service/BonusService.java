package service;

import model.Funcionario;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BonusService {

    public BigDecimal calcularBonus(Funcionario funcionario) {
        BigDecimal valor = funcionario.getSalario().multiply(new BigDecimal("0.1"));

        if (valor.compareTo(new BigDecimal("1000")) > 0) {
            throw new IllegalArgumentException("Funcionario com salario maior do que R$1000 nao pode receber bonus!");
        } // lança exceção de funcionario com saldo muito grande não recebe bonus

        return valor.setScale(2, RoundingMode.HALF_UP);
    } // setando 2 numeros a direita do ponto decimal
}
