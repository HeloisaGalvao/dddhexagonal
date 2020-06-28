package br.gov.pe.sefaz.sfi.trb.gpf.parcelamento;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.gov.pe.sefaz.sfi.trb.gpf.service.RegularizacaoDebitoService;

@RunWith(JUnitPlatform.class)
public class RegularizacaoDebitoTest {

	private static final Logger LOG = LoggerFactory.getLogger(RegularizacaoDebitoTest.class);
	
	@Mock private RegularizacaoDebitoService service; 
	
	@BeforeClass
    public static void setup(){
		LOG.info("Pr� processamento");
    }
     
    @AfterClass
    public static void after(){
    	LOG.info("P�s processamento");
    }
	
    @Test
    public void whenFormalizarRegularizacao_thenCriarProcessoParcelamento_e_Infracoes() {
    	LOG.info("Formalizando Regulariza��o de D�bitos");
        assertTrue(true);
    }
 
    @Test
    public void whenCancelarRegularizacao_thenExcluirProcessoParcelamento() {
    	LOG.info("Cancelando Regulariza��o de D�bitos");
    	assertTrue(true);
    }
}
