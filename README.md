# Compilatore Ac-Dc UPO

Questo progetto consiste nella realizzazione di un compilatore completo per un linguaggio didattico denominato **Ac-Dc**, progettato per tradurre il codice sorgente in istruzioni eseguibili per il calcolatore a stack `dc` (Desk Calculator). Il sistema è sviluppato in Java 21 e segue le fasi classiche del processo di compilazione: analisi lessicale, sintattica, semantica e generazione del codice.

---

## 🚀 Funzionalità e Architettura

L'architettura del compilatore è modulare e suddivisa nelle seguenti fasi principali:

### 1. Analisi Lessicale (Scanner)
L'analizzatore lessicale (`Scanner`) legge il file sorgente carattere per carattere e produce un flusso di `Token`.
* **Token gestiti**: Include parole chiave (`int`, `float`, `print`), identificatori (ID), costanti numeriche e operatori.
* **Gestione Errori**: Rileva e segnala errori come caratteri illegali, numeri con zeri iniziali non permessi o formati a virgola mobile errati.
* **Whitespace**: Gestisce correttamente spazi, tabulazioni e interruzioni di riga per il conteggio delle righe di codice.

### 2. Analisi Sintattica (Parser)
Il `Parser` implementa un analizzatore a discesa ricorsiva che valida la sequenza di token rispetto alla grammatica del linguaggio.
* **AST**: Genera un albero sintattico astratto (Abstract Syntax Tree) che rappresenta la struttura gerarchica del programma.
* **Grammatica**: Supporta dichiarazioni di variabili, assegnamenti (semplici e composti come `+=`, `-=`, `*=`, `/=`) e chiamate di stampa.

### 3. Analisi Semantica (Type Checker)
Utilizzando il pattern **Visitor**, il `TypeCheckingVisitor` attraversa l'AST per verificare la correttezza del programma.
* **Symbol Table**: Gestisce le dichiarazioni delle variabili e ne memorizza gli attributi, prevenendo doppie dichiarazioni o l'uso di variabili mai definite.
* **Controllo dei Tipi**: Verifica la compatibilità tra i tipi nelle operazioni e negli assegnamenti, gestendo correttamente la promozione automatica da `int` a `float`.

### 4. Generazione del Codice (Code Generator)
Il `CodeGeneratorVisitor` traduce i nodi dell'AST validati in codice post-fisso per lo stack di `dc`.
* **Gestione Registri**: Assegna dinamicamente le variabili ai registri disponibili di `dc` (dalla 'a' alla 'z').
* **Codice Prodotto**: Genera istruzioni come `sa` (store), `la` (load), `p` (print) e gli operatori aritmetici necessari.

---

## 📁 Organizzazione delle Cartelle

Il progetto è strutturato in modo da separare chiaramente le componenti logiche e i test:

```bash
Compilatore-Ac-Dc-UPO/
├── src/                        # Codice sorgente Java
│   ├── ast/                    # Definizione dei nodi dell'AST (es. NodeId, NodeAssign, NodeBinOp)
│   ├── parser/                 # Analizzatore sintattico e definizioni di eccezioni sintattiche
│   ├── scanner/                # Analizzatore lessicale e definizioni di eccezioni lessicali
│   ├── symbolTable/            # Gestione della Tabella dei Simboli e relativi attributi
│   ├── token/                  # Classi per la rappresentazione dei Token e tipi di Token
│   ├── visitor/                # Logica di attraversamento dell'AST (Visitor Pattern)
│   │   ├── type/               # Descrittori dei tipi (IntType, FloatType, ErrorType, OkType)
│   │   └── codegen/            # Gestione dei registri per la generazione del codice
│   └── test/                   # Classi di test JUnit per ogni modulo
│       └── data/               # File .txt utilizzati come casi di test (corretti ed errati)
