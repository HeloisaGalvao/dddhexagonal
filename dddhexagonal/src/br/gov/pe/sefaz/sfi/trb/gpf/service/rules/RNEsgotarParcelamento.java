package br.gov.pe.sefaz.sfi.trb.gpf.service.rules;

import br.gov.pe.sefaz.sfi.trb.gpf.dpo.interfaces.IDPOParcelamento;

public class RNEsgotarParcelamento {

    private static RNEsgotarParcelamento instancia;
    
    private RNEsgotarParcelamento(){}

    //Inicialização do tipo LAZY (preguiçosa)
    public static RNEsgotarParcelamento getInstance(){
        if(instancia == null){
            instancia = new RNEsgotarParcelamento();
        }
        return instancia;
    }
    
    public void executar(IDPOParcelamento payload){
    	
    }
}
