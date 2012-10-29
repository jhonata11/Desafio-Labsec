	package criptografia.simetrica;

	import java.io.InputStream;
	import java.io.OutputStream;
	import java.io.FileInputStream;
	import java.io.FileOutputStream;
	import javax.crypto.Cipher;
	import javax.crypto.SecretKey;
	import javax.crypto.spec.IvParameterSpec;
	import javax.crypto.CipherInputStream;
	import javax.crypto.CipherOutputStream;
	import javax.crypto.KeyGenerator;

	import java.security.spec.AlgorithmParameterSpec;

	public class Aes
	{
		Cipher cifrador;
		Cipher decifrador;
		
		// buffer usado para transportar os bytes nas streams
		byte[] buffer = new byte[1024];

		public Aes(SecretKey key)
		{
			// cria um vetor inicial, exigido pelo cifrador
			byte[] vetorInicial = new byte[]
					{
					0x00, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08, 0x09,0x0a, 0x0b, 0x0c, 0x0d, 0x0e, 0x0f
					};

			AlgorithmParameterSpec paramSpec = new IvParameterSpec(vetorInicial);
			try
			{
				cifrador = Cipher.getInstance("AES/CBC/PKCS5Padding");
				decifrador = Cipher.getInstance("AES/CBC/PKCS5Padding");

				
				cifrador.init(Cipher.ENCRYPT_MODE, key, paramSpec);
				decifrador.init(Cipher.DECRYPT_MODE, key, paramSpec);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}

	


		public void cifrar(InputStream arquivoEntrada, OutputStream arquivoSaida)
		{
			try
			{
				//  cifra os bytes do arquidoEntrada em arquivoSaida 
				arquivoSaida = new CipherOutputStream(arquivoSaida, cifrador);

				// lê o texto do arquivoEntrada, e escreve cifrado no arquivoSaida
				int numRead = 0;
				while ((numRead = arquivoEntrada.read(buffer)) >= 0)
				{
					arquivoSaida.write(buffer, 0, numRead);
				}
				arquivoSaida.close();
			}
			catch (java.io.IOException e)
			{
			}
		}

		public void decifrar(InputStream arquivoEntrada, OutputStream arquivoSaida)
		{
			try
			{
				// decifra os bytes lidos no arquivoEntrada
				arquivoEntrada = new CipherInputStream(arquivoEntrada, decifrador);

				// lê os bytes já decifrados dearquivoEntradaRead, e escreve no arquivoSaida
				int numRead = 0;
				while ((numRead = arquivoEntrada.read(buffer)) >= 0)
				{
					arquivoSaida.write(buffer, 0, numRead);
				}
				arquivoSaida.close();
			}
			catch (java.io.IOException e)
			{
			}
		}
		
		public void escreveTexto(){
			
		}
	}