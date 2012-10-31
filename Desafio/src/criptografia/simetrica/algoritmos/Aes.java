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
public class Aes extends CifradorSimetrico{

	private final String algoritmo = "AES";
	SecretKey chave;

	/**
	 * Construtor.
	 */
	public Aes() {
		
		//define o algoritmo que vai ser usado no cifrador da super classe, e ao gerar uma chave
		super.algoritmo = this.algoritmo;
		

	}

	/**
	 * Gera uma chave secreta com o tamanho indicado.
	 * 
	 * @param tamanhoChave - tamanho da chave em bits
	 * 
	 * @return {@link SecretKey}
	 */
	public SecretKey gerarChave(int tamanhoChave) {

		try {
			KeyGenerator keygen = KeyGenerator.getInstance(algoritmo);
			keygen.init(tamanhoChave);	
			return keygen.generateKey();

		} catch (NoSuchAlgorithmException e) {

			e.printStackTrace();
			return null;
		}

	}

	@Override
	protected byte[] transformaChaveEmBytes(SecretKey chave) {

		return chave.getEncoded();
	}

	@Override
	protected SecretKey transformaByteEmChave(byte[] chaveBytes) {

		return new SecretKeySpec(chaveBytes, algoritmo);
	}

}
