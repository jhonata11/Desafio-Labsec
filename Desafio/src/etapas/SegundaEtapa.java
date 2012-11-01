package etapas;

import java.io.File;
import java.io.FileOutputStream;

import criptografia.simetrica.algoritmos.Aes;
import criptografia.simetrica.algoritmos.TripleDes;

/**
 * segunda etapa - encriptação de um texto
 * 
 * @author Jhonata da Rocha
 * 
 * Esta segunda etapa é capaz de
 *  
 * - Cifrar um texto usando AES e decifra-lo para comparar os resultados. 
 * - Cifrar o mesmo texto usado no item anterior, mas usando o Triple-DES, e decifra-lo para comparar os resultados. 
 * - Salvar em disco os textos cifrados e decifrados resultantes de cada algoritmo. <p>
 *
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
