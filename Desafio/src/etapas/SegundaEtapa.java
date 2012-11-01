package etapas;

import java.io.File;
import java.io.FileOutputStream;

import criptografia.simetrica.algoritmos.Aes;
import criptografia.simetrica.algoritmos.TripleDes;


/**
 * <B>Segunda Etapa - Cifrar/Decifrar um texto.</B> <p>
 * 
 * Nessa etapa deve-se usar as chaves previamente geradas e armazenadas para cifrar um documento. 
 * Note que o documento deve ser o arquivo <b>textoPlano.txt</b>, que esta na pasta <b>artefatos/textos</b>. 
 * Para verificar se o processo esta correto, entao, deve-se decifrar o texto resultante, e assim, comparar com o texto inicial. <p>
 * 
 * Os pontos a serem verificados para essa etapa ser considerada concluida, sao os seguintes: <p>
 * 
 * - Cifrar um texto usando AES e decifra-lo para comparar os resultados. Essa comparacao de textos devera ser feita no codigo; <br>
 * - Cifrar o mesmo texto usado no item anterior, mas usando o Triple-DES, e decifra-lo para comparar os resultados. Essa comparacao de textos devera ser feita no codigo; <br>
 * - Salvar em disco os textos cifrados e decifrados resultantes de cada algoritmo. <p>
 * 
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *<br>
 * Todas as variaveis globais definidas nessa classe devem 				    <br>
 * ser usadas. Elas definem os locais para escrever os 						<br>
 * resultados obtidos. 														<br>
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *<br>
 */
public class SegundaEtapa {

	//	TODO: IMPORTANTE -- esse arquivo deve conter seu nome e sua matricula
	private static final String caminhoTextoPlano = "artefatos/textos/textoPlano.txt";

	private final static String caminhoChaveTripleDes = "artefatos/chaves/chaveTripleDes";
	private final static String caminhoTextoCifradoTripleDes = "artefatos/textosCifrados/textoCifradoTripleDes";
	private final static String caminhoTextoDecifradoTripleDes = "artefatos/textosDecifrados/textoDecifradoTripleDes";

	private final static String caminhoChaveAes = "artefatos/chaves/chaveAes";
	private final static String caminhoTextoCifradoAes = "artefatos/textosCifrados/textoCifradoAes";
	private final static String caminhoTextoDecifradoAes = "artefatos/textosDecifrados/textoDecifradoAes";

	public static void main(String[] args) {
		segundaEtapaAes();
		segundaEtapaTripleDes();
	}

	private static void segundaEtapaAes()	{
		// TODO: implementar a segunda etapa - parte do AES.

		Aes aes = new Aes();
		try {
			aes.cifrar(aes.lerChave(new File(caminhoChaveAes)), new File(caminhoTextoPlano),
					new FileOutputStream(caminhoTextoCifradoAes + ".txt"));
			
			aes.decifrar(aes.lerChave(new File(caminhoChaveAes)), new File(caminhoTextoCifradoAes + ".txt"), 
					new FileOutputStream(caminhoTextoDecifradoAes + ".txt"));


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	private static void segundaEtapaTripleDes() {
		// TODO: implementar a segunda etapa - parte do Triple-DES.
		
		TripleDes tripledes = new TripleDes();
		
		try {
			tripledes.cifrar(tripledes.lerChave(new File(caminhoChaveTripleDes)), new File(caminhoTextoPlano),
					new FileOutputStream(caminhoTextoCifradoTripleDes + ".txt"));
			
			tripledes.decifrar(tripledes.lerChave(new File(caminhoChaveTripleDes)), new File(caminhoTextoCifradoTripleDes + ".txt"), 
					new FileOutputStream(caminhoTextoDecifradoTripleDes + ".txt"));


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
