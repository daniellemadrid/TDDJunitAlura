package service;

import model.Desempenho;
import model.Funcionario;

import java.math.BigDecimal;

public class ReajusteService {
    public void concederReajuste(Funcionario funcionario, Desempenho desempenho) {
        BigDecimal reajuste = desempenho.percentualReajuste();
        funcionario.reajustarSalario(reajuste);
    } // reajusta o salario do funcionario pelo seu desempenho
}
