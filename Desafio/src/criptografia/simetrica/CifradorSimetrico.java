package criptografia.simetrica;

/**
 * Classe responsavel por executar a cifragem e decifragem.
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

import criptografia.simetrica.algoritmos.Aes;


public abstract class CifradorSimetrico {

	
    
	protected Cipher cifrador;
	
    /**
     * Transforma o objeto {@link SecretKey} em bytes.
     * 
     * @param chave - {@link SecretKey}
     * 
     * @return byte[]
     */
    protected abstract byte[] transformaChaveEmBytes(SecretKey chave); // Esse metodo sera implementado nas classes dos algoritmos.

    /**
     * Transforma os bytes de uma chave no objeto {@link SecretKey}.
     * 
     * @param chaveBytes - chave em bytes
     * 
     * @return {@link SecretKey}
     */
    protected abstract SecretKey transformaByteEmChave(byte[] chaveBytes); // Esse metodo sera implementado nas classes dos algoritmos.

	
    
    /**
     * Escreve a chave em disco.
     * 
     * @param chave - {@link SecretKey}
     * @param caminhoChave - caminho que sera escrito a chave
     */
	public void escreverChave(SecretKey chave, String caminhoChave) {
		
		File outFile = new File(caminhoChave + "/chave.txt");
		byte[] chaveEmBytes = transformaChaveEmBytes(chave);
		
		try {
			OutputStream out = new FileOutputStream(outFile);
			out.write(chaveEmBytes);
			out.close();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
			
	
	
	}

	/**
     * Cifra um determinado arquivo.
     * 
     * @param chave - chave que sera usada para cifrar
     * @param arquivoEntrada - arquivo contendo o texto plano
     * @param arquivoSaida - arquivo que sera escrito o resultado da cifragem
     */
	public void cifrar(SecretKey chave, FileInputStream arquivoEntrada,FileOutputStream arquivoSaida) {
		

	}

	/**
     * Decifra um determinado arquivo.
     * 
     * @param chave - chave que sera usada para decifrar
     * @param arquivoEntrada - arquivo contendo o texto cifrado
     * @param arquivoSaida - arquivo que sera escrito o resultado da decifragem
     */
	public void decifrar(SecretKey chave, FileInputStream arquivoEntrada, FileOutputStream arquivoSaida) {
	    
	    // TODO: Implementar.
	}

	/**
     * Le a chave do arquivo.
     * 
     * @param arquivo
     * 
     * @return {@link SecretKey}
     */
	public SecretKey lerChave(File arquivo) {
	    
		
	    return null;
	}
}
