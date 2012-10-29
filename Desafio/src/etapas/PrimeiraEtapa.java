package etapas;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.NoSuchAlgorithmException;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import criptografia.simetrica.Aes;



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
		
		try
		{
			// Generate a temporary key. In practice, you would save this key.

			KeyGenerator kgen = KeyGenerator.getInstance("AES");
			kgen.init(128);
			SecretKey key = kgen.generateKey();

			// Create encrypter/decrypter class
			
			Aes encrypter = new Aes(key); 

			// Encrypt
			encrypter.encrypt(new FileInputStream("artefatos/textos/textoPlano.txt"),new FileOutputStream("artefatos/textosCifrados/textoCifrado.txt"));
			// Decrypt
			encrypter.decrypt(new FileInputStream("artefatos/textosCifrados/textoCifrado.txt"),new FileOutputStream("artefatos/textosDecifrados/textoDecifrado.txt"));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	    

	}
}
