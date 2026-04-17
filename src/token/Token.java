package token;

public class Token {

	// riga di codice in cui si trova il token
	private int riga;
	// tipo di token
	private TokenType tipo;
	// per id e numeri contiene la stringa matchata
	private String val;
	
	// Costruttore Token con solamente riga e tipo
	public Token(int riga, TokenType tipo) {
		
		this.riga = riga;
		this.tipo = tipo;
	}
	
	// Costruttore Token con riga, tipo e valore
	public Token(int riga, TokenType tipo, String val) {
		
		this.riga = riga; 
		this.tipo = tipo; 
		this.val = val;
	}
	
	// Getter e Setter
	public int getRiga() {
		
		return riga;
	}
	
	public TokenType getTipo() {
		
		return tipo;
	}
	
	public String getVal() {
		
		return val;
	}
	
	@Override
	public String toString() {
		
		if (getTipo() == TokenType.INT || getTipo() == TokenType.FLOAT || getTipo() == TokenType.ID
				|| getTipo() == TokenType.OP_ASSIGN) {
			return "<" + getTipo().toString() + ", r:" + getRiga() + ", val:" + getVal() + ">";
		}

		return "<" + getTipo().toString() + ", r:" + getRiga() + ">";
	}
}
