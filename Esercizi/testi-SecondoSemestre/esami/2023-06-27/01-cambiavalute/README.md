Cambiavalute

fix importo


# Valuta (enum)
- nome not null
- simbolo carattere
(solo queste 
Dollaro ($)
Euro (€)
Franco (₣)
Lira (₺)
Rupia (₹)
Sterlina (£)
Yen (¥)
)
*l'ordine è importante!!!*
# Importo
- valore (unità e centesimi) BigDecimalNumber
- valuta
## Metodi 
- somma
- sottrai 
- confronta
- creaImporto nullo (costruttore)

# Cassa Multi valuta
contenitore di importi
## Metodi
- versamento (qualunque valuta) importo
- prelevale (qualunque valuta) importo
- iteratore su importi diverso da zero nell'ordine definito sopra
- rappresentazione della cassa testuale:
Cassa:
$55.30
€87.79
₣89.50
₹11000.00
£200.00
¥24.95

# Tasso di Cambio  classe concreta (?) non sono sicuro :(
-due importi con valute divese da intendersi equivalenti nel senso che è possibile convertire qualunque multiplo del primo importo nello stesso multiplo del secondo.

$2 = €2.40



# CambiaValute
- cassa
- lista tassi di cambio


può cambiare a richiesta un importo (in una data valuta) in una valuta differente.
*Ciclo di vita:*
1.  il cambiavalute riceve una serie di importi (di varie valute) che deposita in cassa; successivamente la cassa non può essere più modificata direttamente (ma solo tramite le operazioni di cambio);
2. quando sta operando può:
    - ricevere degli aggiornamenti sui tassi di cambio che memorizza; se riceve un tasso di cambio tra due valute di cui ne era già memorizzato uno, il nuovo tasso rimpiazza il precedente;
    - cambio valuta:
    se ha memorizzato il tasso di cambio relativo e ha in cassa l'equivalente dell'importo nella nuova valuta procede a: 
    1. versare in cassa l'importo nella valuta originaria 
    2. prelevare l'importo equivalente nella nuova valuta; viceversa segnala opportunamente gli errori relativi alla mancanza di conoscenza del tasso, o di disponibilità dei fondi.


In aggiunta, un cambiavalute deve consentire di iterare sui propri tassi di cambio nell'ordine in cui sono stati aggiornati (ossia inseriti e, nel caso, successivamente modificati); tale capacità è particolarmente utile nel fornire una rappresentazione testuale di un cambiavalute.

