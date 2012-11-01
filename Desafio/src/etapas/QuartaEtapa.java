package etapas;

import criptografia.assimetrica.EscritorChaves;
import criptografia.assimetrica.GeradorDeChaves;


/**
 * quarta etapa - gerador de chaves assimétricas
 * 
 * @author Jhonata da Rocha
 * 
 * Esta etapa é capaz de:
 * 
 * - Gerar um par de chaves usando o algoritmo RSA com o tamanho de <b>1024</b> bits; <br>
 * - Gerar outro par de chaves, mas com o tamanho de <b>2048</b> bits. <br>
 * - Armazenar em disco os pares de chaves. <p>
 *
 */
public class QuartaEtapa {
	private static final String caminhoChavePublicaUsuario = "artefatos/chaves/chavePublica1024";
	private static final String caminhoChavePrivadaUsuario = "artefatos/chaves/chavePrivada1024";
	
	private static final String caminhoChavePublicaAc = "artefatos/chaves/chavePublica2048";
	private static final String caminhoChavePrivadaAc = "artefatos/chaves/chavePrivada2048";
	
	public static void main(String[] args) {

		GeradorDeChaves gerador = new GeradorDeChaves("RSA");
		
		/**
		 * PAR DE CHAVES DE 1024.
		 */

		EscritorChaves.escreveChaveEmDisco(gerador.pegarChavePublica(gerador.gerarParDeChaves(1024)), caminhoChavePublicaUsuario);
		EscritorChaves.escreveChaveEmDisco(gerador.pegarChavePrivada(gerador.gerarParDeChaves(1024)), caminhoChavePrivadaUsuario);
		
		
		/**
		 * PAR DE CHAVES DE 2048.
		 */
	    
		EscritorChaves.escreveChaveEmDisco(gerador.pegarChavePublica(gerador.gerarParDeChaves(1024)), caminhoChavePublicaAc);
		EscritorChaves.escreveChaveEmDisco(gerador.pegarChavePrivada(gerador.gerarParDeChaves(1024)), caminhoChavePrivadaAc);
	}
}
