package criptografia.simetrica.comparador;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ComparadorDeTextos {

	public ComparadorDeTextos (){
		
	}
	
		public String lerArquivo(File arquivo) {

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


			return buffer.toString();
		}
	
	
	public void comparaArquivos (String caminhoArquivoA, String caminhoArquivoB){

		File arquivoA = new File(caminhoArquivoA);
		File arquivoB = new File(caminhoArquivoB);
		
	
		if ( lerArquivo(arquivoA).equals(lerArquivo(arquivoB)) == true){
			System.out.println("Os arquivos são iguais");
		}
		else{
			System.out.println("Os arquivos são diferentes");
		}
		
			
				



	}

}
