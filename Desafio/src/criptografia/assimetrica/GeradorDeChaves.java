package criptografia.assimetrica;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * Classe responsavel por gerar pares de chaves assimetricas.
 * 
 * @see KeyPair
 * @see PublicKey
 * @see PrivateKey
 * 
 */
public class GeradorDeChaves {
	private String algoritmo;

	/**
     * Construtor
     * 
     * @param algoritmo - algoritmo de criptografia assimetrica a ser usado
     */
	public GeradorDeChaves(String algoritmo) {
	    
		// TODO: Implementar.
	}
	
	public KeyPair gerarParDeChaves(int tamanhoDaChave) {
	 
	    // TODO: Implementar.
	    return null;
	}

	/**
	 * Pega a chave publica do par de chaves.
	 * 
	 * @param parDeChaves - {@link KeyPair}
	 * 
	 * @return {@link PublicKey} - chave publica do par de chaves
	 */
	public PublicKey pegarChavePublica(KeyPair parDeChaves) 	{
	 
	    // TODO: Implementar.
        return null;
	}

	/**
	 * Pega a chave privada do par de chaves.
	 * 
	 * @param parDeChaves - {@link KeyPair}
	 * 
	 * @return {@link PrivateKey} - chave privada do par de chaves
	 */
	public PrivateKey pegarChavePrivada(KeyPair parDeChaves) {
	    
	    // TODO: Implementar.
        return null;
	}
}
