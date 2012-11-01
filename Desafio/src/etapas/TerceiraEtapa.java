package etapas;

import criptografia.resumo.Sha1;

/**
 * terceira etapa - resumo criptográfico
 * 
 * @author Jhonata da Rocha
 * 
 * Esta terceira etapa é capaz de:
 *
 * 	- Gerar um resumo criptográfico do texto plano encontrado em <artefatos/textos/textoPlano.txt>
 * 	- Anexar este resumo à pasta destinada <artefatos/resumos/resumoTextoPlano>
 *
 *  
 *
 */


public class TerceiraEtapa {

	private static final String caminhoTextoPlano = "artefatos/textos/textoPlano.txt";
	private static final String caminhoResumoCriptografico = "artefatos/resumos/resumoTextoPlano";

	public static void main(String[] args) {


		Sha1 sha1= new Sha1();
		try {

			sha1.escreveResumoEmDisco(sha1.resumir(caminhoTextoPlano), caminhoResumoCriptografico);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
