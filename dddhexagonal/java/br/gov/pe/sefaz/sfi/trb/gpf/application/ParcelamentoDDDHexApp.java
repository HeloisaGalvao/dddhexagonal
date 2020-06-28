package br.gov.pe.sefaz.sfi.trb.gpf.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.gov.pe.sefaz.sfi.trb.gpf.domain.DPOParcelamentoFactory;
import br.gov.pe.sefaz.sfi.trb.gpf.domain.categories.EnumTipoParcelamento;
import br.gov.pe.sefaz.sfi.trb.gpf.domain.interfaces.IDPOParcelamento;
import br.gov.pe.sefaz.sfi.trb.gpf.domain.transfer.OTDDebitosFiscais;
import br.gov.pe.sefaz.sfi.trb.gpf.infrastructure.model.VOProcesso;
import br.gov.pe.sefaz.sfi.trb.gpf.infrastructure.model.VOProcesso.DataCiencia;
import br.gov.pe.sefaz.sfi.trb.gpf.infrastructure.model.VOProcesso.NumeroDocumento;
import br.gov.pe.sefaz.sfi.trb.gpf.infrastructure.model.VOProcesso.Protocolo;
import br.gov.pe.sefaz.sfi.trb.gpf.infrastructure.model.VOProcessoParcelamento;
import br.gov.pe.sefaz.sfi.trb.gpf.infrastructure.model.VOProcessoParcelamento.ParcelasConcedidas;
import br.gov.pe.sefaz.sfi.trb.gpf.infrastructure.model.VOProcessoParcelamento.ParcelasSolicitadas;
import br.gov.pe.sefaz.sfi.trb.gpf.pagamento.PagamentosTest;
import br.gov.pe.sefaz.sfi.trb.gpf.service.ParcelamentoService;
import br.gov.pe.sefaz.sfi.trb.gpf.service.error.ExcecaoAtributoNulo;
import br.gov.pe.sefaz.sfi.trb.gpf.service.impl.ParcelamentoServiceImpl;

public class ParcelamentoDDDHexApp {
	
	private static final Logger LOG = LoggerFactory.getLogger(PagamentosTest.class);
	private static ParcelamentoService service = new ParcelamentoServiceImpl();

	public static void main(String[] args) {
		
		OTDDebitosFiscais debito = new OTDDebitosFiscais();
		
		try {
			//Teste de formaliza��o de parcelamento normal
			VOProcesso processo = new VOProcesso(new Protocolo("202000000000018"), 
					new DataCiencia(new SimpleDateFormat("yyyy-MM-dd").parse("2020-06-01")), 
					new NumeroDocumento( "00000191"));
			debito.getDadosProcesso().setProcesso(processo);
			
			VOProcessoParcelamento processoParcelamento = new VOProcessoParcelamento(new Protocolo("202000000000018"), 
					new Protocolo("202000000000019"), 
					new ParcelasConcedidas(10), 
					new ParcelasSolicitadas(10));
			debito.getDadosParcelamento().setParcelamento(processoParcelamento);
			
			IDPOParcelamento payloadNormal = DPOParcelamentoFactory.criar(EnumTipoParcelamento.NORMAL, debito);

			service.formalizarParcelamento(payloadNormal);
			
			//Teste de formaliza��o de parcelamento especial
			debito = new OTDDebitosFiscais();			
			
			IDPOParcelamento payloadEspecial = DPOParcelamentoFactory.criar(EnumTipoParcelamento.ESPECIAL, debito);
			
			service.formalizarParcelamento(payloadEspecial);
			
			//Teste de formaliza��o de de regularizacao de debitos
			debito = new OTDDebitosFiscais();
			
			IDPOParcelamento payloadRD = DPOParcelamentoFactory.criar(EnumTipoParcelamento.REGULARIZACAO_DEBITOS, debito);
			
			service.formalizarRegularizacaoDebitos(payloadRD);
		} catch (ExcecaoAtributoNulo | ParseException e) {
			LOG.info(e.getMessage());
		}
	}
}