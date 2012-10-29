package criptografia.resumo;

import java.io.File;
import java.security.MessageDigest;

/**
 * Classe responsavel por executar a funcao de resumo criptografico.
 * 
 * @see MessageDigest
 */
public class Sha1 {
	
	private final String algoritmo = "sha-1";
	
	public Sha1() {}
	
	/**
     * Executa o resumo criptografico do arquivo indicado.
     * 
     * @param arquivoDeEntrada - arquivo a ser "resumido"
     * 
     * @return byte[]

     */
	public byte[] resumir(File arquivoDeEntrada) {
		
	    // TODO: Implementar.
	    return null;
	}
	
    /**
     * Escreve o resumo criptografico no local indicado
     * 
     * @param resumo - resumo criptografico em bytes
     * @param caminhoArquivo - caminho do arquivo
     */
	public void escreveResumoEmDisco(byte[] resumo, String caminhoArquivo) {
	 
	    // TODO: Implementar.
	}
}
