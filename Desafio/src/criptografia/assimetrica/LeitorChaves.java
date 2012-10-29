package criptografia.assimetrica;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.KeySpec;

/**
 * Classe responsavel por ler uma chave assimetrica do disco.
 * 
 * @see KeyFactory
 * @see KeySpec
 *
 */
public class LeitorChaves {

    /**
     * Le a chave privada do local indicado.
     * 
     * @param caminhoChave - local do arquivo da chave privada
     * @param algoritmo - algoritmo de criptografia assimetrica que a chave foi gerada
     * 
     * @return {@link PrivateKey} - chave privada
     */
	public static PrivateKey lerChavePrivadaDoDisco(String caminhoChave, String algoritmo) {
		
	    // TODO: Implementar.
	    return null;
	}

	/**
     * Le a chave publica do local indicado.
     * 
     * @param caminhoChave - local do arquivo da chave publica
     * @param algoritmo - algoritmo de criptografia assimetrica que a chave foi gerada
     * 
     * @return {@link PublicKey}
     */
	public static PublicKey lerChavePublicaDoDisco(String caminhoChave, String algoritmo) 	{

	    // TODO: Implementar.
        return null;
	}
}
