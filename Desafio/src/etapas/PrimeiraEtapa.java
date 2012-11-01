package etapas;

import java.security.NoSuchAlgorithmException;

import criptografia.simetrica.algoritmos.Aes;
import criptografia.simetrica.algoritmos.TripleDes;

/**
 * primeira etapa- gerador de chaves simétricas
 * 
 * @author Jhonata da Rocha
 * 
 * Esta primeira etapa é capaz de:
 * 
 * - Gerar uma chave simetrica usando o algoritmo <i>Advanced Encryption Standard</i> (AES); <br>
 * - Gerar uma chave simetrica usando o algoritmo <i>Triple Data Encryption Standard</i> (Triple-DES); <br>
 * - Salvar em disco as chaves geradas. <p>
 *
 */


public class PrimeiraEtapa {

	private final static String caminhoChaveTripleDes = "artefatos/chaves/chaveTripleDes";
	
	private final static String caminhoChaveAes = "artefatos/chaves/chaveAes";
	
	public static void main(String[] args) throws NoSuchAlgorithmException {
	    
		Aes aes = new Aes();
		aes.escreverChave(aes.gerarChave(128), caminhoChaveAes);
		
		TripleDes tdes = new TripleDes();
		tdes.escreverChave(tdes.gerarChave(), caminhoChaveTripleDes);
		
	}
}
