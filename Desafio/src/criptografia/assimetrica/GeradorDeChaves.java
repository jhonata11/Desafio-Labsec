package criptografia.assimetrica;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
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
		this.algoritmo = algoritmo;

	}
	
	public KeyPair gerarParDeChaves(int tamanhoDaChave) {
	     try {
	 		KeyPairGenerator generator = KeyPairGenerator.getInstance(algoritmo);
			generator.initialize(tamanhoDaChave);
			return generator.generateKeyPair();
		
	     } catch (NoSuchAlgorithmException e) {

	    	 System.out.println("houve um problema na geração do par de chaves");
	    	 
	    	 e.printStackTrace();
			return null;
		}
		
	}

	/**
	 * Pega a chave publica do par de chaves.
	 * 
	 * @param parDeChaves - {@link KeyPair}
	 * 
	 * @return {@link PublicKey} - chave publica do par de chaves
	 */
	public PublicKey pegarChavePublica(KeyPair parDeChaves) 	{
	 
		
        return parDeChaves.getPublic();
	}

	/**
	 * Pega a chave privada do par de chaves.
	 * 
	 * @param parDeChaves - {@link KeyPair}
	 * 
	 * @return {@link PrivateKey} - chave privada do par de chaves
	 */
	public PrivateKey pegarChavePrivada(KeyPair parDeChaves) {
	    
        return parDeChaves.getPrivate();
	}
}
