package model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class Funcionario {

    private String nome;
    private LocalDate dataAdmissao;
    private BigDecimal salario;


    public void reajustarSalario(BigDecimal percentual) {
        BigDecimal aumento = calcularValorDoAumento(percentual);
        this.salario = this.salario.add(aumento).setScale(2, RoundingMode.HALF_UP);
    }// arredondamento do aumento de salario do funcionario

    private BigDecimal calcularValorDoAumento(BigDecimal percentual) {
        return salario.multiply(percentual);
    }
  //calculando o valor do aumento multiplicando o salario pelo percentual
}









