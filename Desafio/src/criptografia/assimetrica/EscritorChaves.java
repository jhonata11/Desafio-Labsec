package criptografia.assimetrica;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.Key;

/**
 * Essa classe e responsavel por escrever uma chave assimetrica no disco. Note que a chave pode ser tanto uma chave publica quanto uma chave privada.
 * 
 * @see Key
 */
public class EscritorChaves {

    /**
     * Escreve uma chave no local indicado.
     * 
     * @param chave - chave assimetrica a ser escrita em disco
     * @param nomeDoArquivo - nome do local onde sera escrita a chave.
     */
	public static void escreveChaveEmDisco(Key chave, String nomeDoArquivo) {
		try {
			OutputStream arquivoChave = new FileOutputStream(nomeDoArquivo);
			arquivoChave.write(chave.getEncoded());
			arquivoChave.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
}
