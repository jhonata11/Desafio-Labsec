package criptografia.simetrica;

/**
 * Classe responsavel por executar a cifragem e decifragem.
 */

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;


import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.SecretKey;

public abstract class CifradorSimetrico {

	protected Cipher cifrador;
	protected String algoritmo;



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

		try {
			OutputStream arquivoChave = new FileOutputStream(caminhoChave);
			arquivoChave.write(transformaChaveEmBytes(chave));
			arquivoChave.close();

		} catch (FileNotFoundException e) {
			System.out.println("O arquivo passado não foi encontrado");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("houve um erro ao escrever a chave do arquivo");
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
	public void cifrar(SecretKey chave, File arquivoEntrada,FileOutputStream arquivoSaida) {
		try {
			//inicializa o cifrador
			cifrador = Cipher.getInstance(algoritmo);
			cifrador.init(Cipher.ENCRYPT_MODE, chave);

			OutputStream output = arquivoSaida;	
			output = new CipherOutputStream(arquivoSaida, cifrador);
			
			//escreve o texto cifrado
			output.write(lerArquivo(arquivoEntrada));
			output.close();

		} catch (Exception e) {

			System.out.println("Houve um problema, e não foi possível cifrar o texto");
			e.printStackTrace();
		}

	}

	/**
	 * Decifra um determinado arquivo.
	 * 
	 * @param chave - chave que sera usada para decifrar
	 * @param arquivoEntrada - arquivo contendo o texto cifrado
	 * @param arquivoSaida - arquivo que sera escrito o resultado da decifragem
	 */
	public void decifrar(SecretKey chave, File arquivoEntrada, FileOutputStream arquivoSaida) {
		try {

			//inicializa o cifrador
			cifrador = Cipher.getInstance(algoritmo);
			cifrador.init(Cipher.DECRYPT_MODE, chave);

			OutputStream output = arquivoSaida;
			output = new CipherOutputStream(arquivoSaida, cifrador);

			//escreve o texto decifrado 
			output.write(lerArquivo(arquivoEntrada));
			output.close();

		} catch (Exception e) {
			System.out.println("houve um problema, e não foi possível decifrar o texto");
			e.printStackTrace();
		}

	}



	/**
	 * Le a chave do arquivo.
	 * 
	 * @param arquivo
	 * 
	 * @return {@link SecretKey}
	 */
	public SecretKey lerChave(File arquivo) {



		FileInputStream leitor;
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();

		byte[] data = new byte[16384];

		try {
			leitor = new FileInputStream(arquivo);

			int nRead = 0;

			//leitor.read() retorna -1 quando os dados do arquivo chega ao final
			while ((nRead = leitor.read(data, 0, data.length)) != -1) {
				buffer.write(data, 0, nRead);
			}

			leitor.close();
			buffer.flush();

		} catch (FileNotFoundException e) {
			System.out.println("a chave passada não pode ser encontrada");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("houve um erro ao ler a chave");

			e.printStackTrace();
		}


		return transformaByteEmChave(buffer.toByteArray());




	}


	/**
	 * Lê um arquivo e retorna seu conteúdo em byte[]
	 * 
	 * @param arquivo - arquivo a ser lido 
	 * @return byte[] - conteúdo do arquivo passado por parâmetro
	 * 
	 **/

	public byte[] lerArquivo(File arquivo) {

		FileInputStream leitor;
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();

		byte[] data = new byte[16384];

		try {
			leitor = new FileInputStream(arquivo);

			int nRead = 0;

			//leitor.read() retorna -1 quando os dados do arquivo chega ao final
			while ((nRead = leitor.read(data, 0, data.length)) != -1) {
				buffer.write(data, 0, nRead);
			}

			leitor.close();
			buffer.flush();

		} catch (FileNotFoundException e) {
			System.out.println("O arquivo passado não foi encontrado");

			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("houve um erro ao ler o arquivo");

			e.printStackTrace();
		}


		return buffer.toByteArray();




	}
}
