package criptografia.simetrica.algoritmos;

import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;

import criptografia.simetrica.CifradorSimetrico;

/**
 * Essa classe e responsavel pela geracao de chaves usando o algoritmo Triple-DES.
 * 
 * @see Cipher
 */
public class TripleDes extends CifradorSimetrico {
	
	private final String algoritmo = "DESede";
	
	/**
     * Construtor.
     */
	public TripleDes() 	{
	    
	    // TODO: Implementar.
	}

	/**
     * Gera uma chave Triple-DES para cifrar e decifrar.
     * 
     * @return {@link SecretKey}
     */
	public SecretKey gerarChave() throws NoSuchAlgorithmException {
	 
	    // TODO: Implementar.
        return null;
	}

	@Override
	protected byte[] transformaChaveEmBytes(SecretKey chave) {
	 
	    // TODO: Implementar.
        return null;
	}

	@Override
	protected SecretKey transformaByteEmChave(byte[] chaveBytes) {
	 
	    // TODO: Implementar.
        return null;
	}
}
