package br.gov.pe.sefaz.sfi.trb.gpf.service.business;

import br.gov.pe.sefaz.sfi.trb.gpf.domain.interfaces.IDPOParcelamento;

public class RNEsgotarParcelamento {

    private static RNEsgotarParcelamento instancia;
    
    private RNEsgotarParcelamento(){}

    //Inicializa��o do tipo LAZY (pregui�osa)
    public static RNEsgotarParcelamento getInstance(){
        if(instancia == null){
            instancia = new RNEsgotarParcelamento();
        }
        return instancia;
    }
    
    public void executar(IDPOParcelamento payload){
    	
    }
}
