package utils;

import java.io.File;

public class TesteCrypto {
	public static void main(String[] args) throws Exception {
		String sMsgClara = "123456";
		String sMsgCifrada = null;
		String sMsgDecifrada = null;
		byte[] bMsgClara = null;
		byte[] bMsgCifrada = null;
		byte[] bMsgDecifrada = null;
		// Instancia objeto da classe Impressora
		Impressora prn = new Impressora();
		// Imprime marcador de bloco
		System.out
				.println("-------------------------------------------------------------- -");
		// Imprime Texto
		System.out.println(">>> Imprimindo mensagem original...");
		System.out.println("");
		// Converte o texto String dado no equivalente byte[]
		bMsgClara = sMsgClara.getBytes("ISO-8859-1"); // Imprime cabecalho da mensagem
		System.out.println("Mensagem Clara (Hexadecimal):");
		// Imprime o texto original em Hexadecimal
		System.out.print(prn.hexBytesToString(bMsgClara));
		System.out.println("");
		// Imprime o cabecalho da mensagem
		System.out.println("Mensagem Clara (String):");
		// Imprime o texto original em String
		System.out.println(sMsgClara);
		System.out.println("");
		
		///////////////////////////////////////////////////////////////////////////////
		// Imprime Texto
				System.out.println(">>> Cifrando com o algoritmo AES...");
				System.out.println("");
				// Instancia um objeto da classe CryptoAES
				CryptoAES caes = new CryptoAES();
				// Gera a Chave criptografica AES simetrica e o nome do arquivo onde
				// seraÌ� armazenada
				caes.geraChave(new File("chave.simetrica"));
				// Gera a cifra AES da mensagem dada, com a chave simetrica dada
				caes.geraCifra(bMsgClara, new File("chave.simetrica")); // Recebe o
																		// texto cifrado
				bMsgCifrada = caes.getTextoCifrado();
				// Converte o texto byte[] no equivalente String
				sMsgCifrada = (new String(bMsgCifrada, "ISO-8859-1")); // Imprime
																		// cabecalho da
																		// mensagem
				System.out.println("Mensagem Cifrada (Hexadecimal):");
				// Imprime o texto cifrado em Hexadecimal
				System.out.print(prn.hexBytesToString(bMsgCifrada));
				System.out.println("");
				// Imprime cabecalho da mensagem
				System.out.println("Mensagem Cifrada (String):");
				// Imprime o texto cifrado em String
				System.out.println(sMsgCifrada);
				System.out.println("");
				// Imprime texto
				System.out.println(">>> Decifrando com o algoritmo AES...");
				System.out.println("");
				// Gera a decifra AES da mensagem dada, segundo a chave simetrica gerada
				caes.geraDecifra(bMsgCifrada, new File("chave.simetrica")); // recebe o
																			// texto
																			// decifrado
				bMsgDecifrada = caes.getTextoDecifrado();
				// Converte o texto byte[] no equivalente String
				sMsgDecifrada = (new String(bMsgDecifrada, "ISO-8859-1")); // Imprime
																			// cabecalho
																			// da
																			// mensagem
				System.out.println("Mensagem Decifrada (Hexadecimal):");
				// Imprime o texto decifrado em Hexadecimal
				System.out.print(prn.hexBytesToString(bMsgDecifrada));
				System.out.println();
				// Imprime cabecalho da mensagem
				System.out.println("Mensagem Decifrada (String):");
				// Imprime o texto decifrado em String
				System.out.println(sMsgDecifrada);
				System.out.println("");
		
	}

}
