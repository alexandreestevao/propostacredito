package br.com.calcard.persistence.service;

import br.com.calcard.persistence.model.PropostaDeCredito;
import br.com.calcard.persistence.repository.PropostaDeCreditoRepository;
import br.com.calcard.persistence.service.exceptions.UnicidadeCpfException;
import br.com.calcard.persistence.service.interfaces.PropostaDeCreditoInterface;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class PropostaDeCreditoTest {

    private static final String NOME = "Isadora Pereira";
    private static final String CPF = "96464763334";
    private static final int IDADE = 6;
    private static final int SEXO = 2;
    private static final int ESTADO_CIVIL = 1;
    private static final int ESTADO = 21;
    private static final int DEPENDENTES = 0;
    private static final int VAL = 350;

    @MockBean
    private PropostaDeCreditoRepository propostaDeCreditoRepository;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private PropostaDeCreditoInterface pci;

    private PropostaDeCredito propostaDeCredito;

    @Before
    public void setUp() throws Exception {
        pci = new PropostaDeCreditoService(propostaDeCreditoRepository);

        propostaDeCredito = new PropostaDeCredito();
        propostaDeCredito.setNome(NOME);
        propostaDeCredito.setCpf(CPF);
        propostaDeCredito.setIdade(IDADE);
        propostaDeCredito.setSexo(SEXO);
        propostaDeCredito.setEstadoCivil(ESTADO_CIVIL);
        propostaDeCredito.setEstado(ESTADO);
        propostaDeCredito.setDependentes(DEPENDENTES);
        propostaDeCredito.setRenda(BigDecimal.valueOf(VAL));

        when(propostaDeCreditoRepository.findByCpf(CPF)).thenReturn(Optional.empty());
    }

    @Test
    public void deve_salvar_proposta_no_repositorio() throws Exception {
        pci.salvar(propostaDeCredito);

        verify(propostaDeCreditoRepository).save(propostaDeCredito);
    }

    @Test
    public void nao_deve_salvar_duas_pessoas_com_o_mesmo_cpf() throws Exception {
        when(propostaDeCreditoRepository.findByCpf(CPF)).thenReturn(Optional.of(propostaDeCredito));

        expectedException.expect(UnicidadeCpfException.class);
        expectedException.expectMessage("Já existe proposta cadastrada com o CPF '"+ CPF +"'");

        pci.salvar(propostaDeCredito);
    }

}
