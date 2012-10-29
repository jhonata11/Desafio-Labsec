package criptografia.simetrica.algoritmos;

import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import criptografia.simetrica.CifradorSimetrico;

/**
 * Essa classe e responsavel pela geracao de chaves usando o algoritmo AES.
 * 
 * @see Cipher
 */
public class Aes extends CifradorSimetrico
{
	
	private final String algoritmo = "AES";
	public SecretKey key;
	public byte[] chaveEmByte;
	
	/**
     * Construtor.
     */
	
	
	
	public Aes() {

	}
	
	
	/**
     * Gera uma chave secreta com o tamanho indicado.
     * 
     * @param tamanhoChave - tamanho da chave em bits
     * 
     * @return {@link SecretKey}
     */
	public SecretKey gerarChave(int tamanhoChave) {
	    SecretKey chave = null;
		
	    try {
			KeyGenerator keygen = KeyGenerator.getInstance(algoritmo);
			keygen.init(tamanhoChave);
			chave = keygen.generateKey();
			key = chave;

			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	
		return key;
	}

	
	protected byte[] transformaChaveEmBytes(SecretKey chave) {
		byte[] chaveEmBytes = chave.getEncoded();
		this.chaveEmByte = chaveEmBytes;
		return chaveEmBytes;
		
	}
	
	
	protected SecretKey transformaByteEmChave(byte[] chaveBytes) {
		SecretKey chave = new SecretKeySpec(chaveBytes, algoritmo);
		return chave;
		
	}
	



	public void interaja() {
		//classe criada para testar o progresso
		
		gerarChave(128);
		transformaChaveEmBytes(key);
		
		for (int i = 0; i < chaveEmByte.length; i++	){
			System.out.print(chaveEmByte[i]);
		}
		escreverChave(key, "artefatos/chaves/chaveAes");
		
	}
	
	
}
