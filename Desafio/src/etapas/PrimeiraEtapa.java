package etapas;

import java.security.NoSuchAlgorithmException;

import javax.crypto.SecretKey;

import criptografia.simetrica.CifradorSimetrico;
import criptografia.simetrica.algoritmos.Aes;



/**
 * <B>Primeira Etapa - Gerar chaves simetricas.</B> <p>
 * 
 * Essa etapa consiste em usar algum algoritmo simetrico para gerar chaves e armazena-las em disco. <p>
 * 
 * Os pontos a serem verificados para essa etapa ser considerada concluida, sao os seguintes: <p>
 * 
 * - Gerar uma chave simetrica usando o algoritmo <i>Advanced Encryption Standard</i> (AES); <br>
 * - Gerar uma chave simetrica usando o algoritmo <i>Triple Data Encryption Standard</i> (Triple-DES); <br>
 * - Salvar em disco as chaves geradas. <p>
 * 
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *<br>
 * Todas as variaveis globais definidas nessa classe devem 					<br>
 * ser usadas. Elas definem os locais para escrever os 						<br>
 * resultados obtidos. 														<br>
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *<br>
 */
public class PrimeiraEtapa {

	
	private final static String caminhoChaveTripleDes = "artefatos/chaves/chaveTripleDes";
	
	private final static String caminhoChaveAes = "artefatos/chaves/chaveAes";
	
	public static void main(String[] args) throws NoSuchAlgorithmException {
		
		Aes aes = new Aes();
		aes.interaja();
		
	    

	}
}
