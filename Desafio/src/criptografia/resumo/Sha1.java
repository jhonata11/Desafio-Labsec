package criptografia.resumo;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;

/**
 * Classe responsavel por executar a funcao de resumo criptografico.
 * 
 * @see MessageDigest
 */
public class Sha1 {

	String textoPlano;
	private final String algoritmo = "sha-1";

	public Sha1() {}

	
	
	/**
	 * Executa o resumo criptografico do arquivo indicado.
	 *
	 * @param arquivoDeEntrada - arquivo a ser "resumido"
	 *
	 * @return byte[]

	 */
	public byte[] resumir(String caminhoTextoPlano) {

		try {
			MessageDigest md = MessageDigest.getInstance(algoritmo);
			md.update(lerArquivo(caminhoTextoPlano));
			return md.digest();

		} catch (Exception e) {
			
			System.out.println("O programa não pôde retornar o resumo");
			return null;
		}

	}



	/**
	 * Escreve o resumo criptografico no local indicado
	 *
	 * @param resumo - resumo criptografico em bytes
	 * @param caminhoArquivo - caminho do arquivo
	 */
	public void escreveResumoEmDisco(byte[] resumo, String caminhoArquivo) {
		FileOutputStream streamdeSaida;
		try {
			streamdeSaida = new FileOutputStream(caminhoArquivo + ".txt");
			
			//escreve em disco os bytes gerados em resumo()
			streamdeSaida.write(resumo);
			
			streamdeSaida.close();
		} catch (IOException e) {

			e.printStackTrace();
		}




	}

	
	/**
	 * Lê um arquivo e retorna seu conteúdo em byte[]
	 * 
	 * @param caminhoTextoPlano- caminho do arquivo a ser lido
	 * @return byte[] - conteúdo do arquivo passado por parâmetro
	 * @throws IOException
	 */
	
	public byte[] lerArquivo(String caminhoTextoPlano) {

		FileInputStream leitor;
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();

		byte[] data = new byte[16384];

		try {
			leitor = new FileInputStream(new File(caminhoTextoPlano));

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
			e.printStackTrace();
		}


		return buffer.toByteArray();
	}
}