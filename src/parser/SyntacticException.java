package parser;

import token.TokenType;

@SuppressWarnings("serial")
public class SyntacticException extends Exception {

	public SyntacticException(int riga, String atteso, TokenType ottenuto) {
		super("Errore sintattico a riga " + riga + ": atteso " + atteso + ", ma è " + ottenuto);
	}

	public SyntacticException(String msg) {
		super(msg);
	}

}