import model.Funcionario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.BonusService;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class BonusServiceTest {

    private BonusService service;

    @BeforeEach
    public void inicializa() {
        this.service = new BonusService();
    }

    private Funcionario criarFuncionario(BigDecimal salario) {
        return new Funcionario("Rodrigo", LocalDate.now(), salario);
    }

    @Test 
    void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto() {
        try {
            service.calcularBonus(criarFuncionario(new BigDecimal("25000")));
            fail("nao deu exception");
        } catch (IllegalArgumentException e) {
            assertEquals("Funcionario com salario maior do que R$1000 nao pode receber bonus!", e.getMessage());
        }

    }

    @Test
    void bonusDeveriaSer10PorCentoDoSalario() {
        BigDecimal bonus = service.calcularBonus(criarFuncionario(new BigDecimal("2500")));

        assertEquals(new BigDecimal("250.00"), bonus);
    }

    @Test
    void bonusDeveriaSerDezPorCentoParaSalarioDeExatamente10000() {
        BigDecimal bonus = service.calcularBonus(criarFuncionario(new BigDecimal("10000")));

        assertEquals(new BigDecimal("1000.00"), bonus);
    }


}

