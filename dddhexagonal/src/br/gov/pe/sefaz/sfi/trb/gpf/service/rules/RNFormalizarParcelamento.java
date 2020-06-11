package br.gov.pe.sefaz.sfi.trb.gpf.service.rules;

import br.gov.pe.sefaz.sfi.trb.gpf.dpo.interfaces.IDPOParcelamento;

public class RNFormalizarParcelamento {

private static RNFormalizarParcelamento instancia;
    
    private RNFormalizarParcelamento(){}

    //Inicializa��o do tipo LAZY (pregui�osa)
    public static RNFormalizarParcelamento getInstance(){
        if(instancia == null){
            instancia = new RNFormalizarParcelamento();
        }
        return instancia;
    }
    
    public void executar(IDPOParcelamento payload){
    	
    }
}
