package etapas;


/**
 * <b>Quarta Etapa - Gerar par de chaves assimetricas</b> <p>
 * 
 * A tarefa aqui e parecida com a Primeira Etapa, pois refere-se apenas a criar e 
 * armazenar chaves, mas nesse caso sera usado apenas um algoritmo de criptografia assimetrica, o RSA. <p>
 * 
 * Os pontos a serem verificados para essa etapa ser considerada conclui­da, sao os seguintes: <p>
 * 
 * - Gerar um par de chaves usando o algoritmo RSA com o tamanho de <b>1024</b> bits; <br>
 * - Gerar outro par de chaves, mas com o tamanho de <b>2048</b> bits. <br>
 * - Armazenar em disco os pares de chaves. <p>
 * 
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *<br>
 * Todas as variaveis globais definidas nessa classe devem 				    <br>
 * ser usadas. Elas definem os locais para escrever os 						<br>
 * resultados obtidos. 														<br>
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *<br>
 */
public class QuartaEtapa {
	private static final String caminhoChavePublicaUsuario = "artefatos/chaves/chavePublica1024";
	private static final String caminhoChavePrivadaUsuario = "artefatos/chaves/chavePrivada1024";
	
	private static final String caminhoChavePublicaAc = "artefatos/chaves/chavePublica2048";
	private static final String caminhoChavePrivadaAc = "artefatos/chaves/chavePrivada2048";
	
	public static void main(String[] args) {
	    
		/**
		 * PAR DE CHAVES DE 1024.
		 */
		
	    // TODO: implementar a quarta etapa.
		
		/**
		 * PAR DE CHAVES DE 2048.
		 */
	    
	    // TODO: implementar a quarta etapa.
	}
}
