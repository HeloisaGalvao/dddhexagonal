package br.gov.pe.sefaz.sfi.trb.gpf.service.rules;

import br.gov.pe.sefaz.sfi.trb.gpf.dpo.interfaces.IDPOParcelamento;

public class RNEmitirParcelas {

    private static RNEmitirParcelas instancia;
    
    private RNEmitirParcelas(){}
    
    //Inicializa��o por bloco est�tico
    static{
        try{
            instancia = new RNEmitirParcelas();
        }catch(Exception e){
            throw new RuntimeException("Exception occured in creating singleton instance");
        }
    }
    
    public static RNEmitirParcelas getInstance(){
        return instancia;
    }
    
    public void executar(IDPOParcelamento payload){
    	
    }
}
