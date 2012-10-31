package criptografia.simetrica.algoritmos;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import criptografia.simetrica.CifradorSimetrico;

/**
 * Essa classe e responsavel pela geracao de chaves usando o algoritmo Triple-DES.
 * 
 * @see Cipher
 */
public class TripleDes extends CifradorSimetrico {

	private final String algoritmo = "DESede"; //algoritmo Triple-DES
	SecretKey chave;

	/**
	 * Construtor.
	 */
	public TripleDes() 	{
	
		//define o algoritmo que vai ser usado no cifrador da super classe, e ao gerar uma chave
		super.algoritmo = this.algoritmo;

	}

	/**
	 * Gera uma chave Triple-DES para cifrar e decifrar.
	 * 
	 * @return {@link SecretKey}
	 */
	public SecretKey gerarChave() {

		try {
			KeyGenerator keygen = KeyGenerator.getInstance(algoritmo);
			keygen.init(112); //tamanho da chave gerada em bits
			return keygen.generateKey();

		} catch (Exception e) {
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
