/*
    Tato aplikace převede aktuální čas na binární formát a vypíše ho do konzole. 
    Budeme používat bitové operace pro konverzi decimálních čísel na binární a pro výpis.

    Hlavní Body:
        While Loop: Sleduje čas a každou sekundu aktualizuje výstup.
        Bitový Posun: 1 << i umožňuje přesunout bit na pozici i.
        Bitový AND: (decimal & (1 << i)) ověří, zda je bit na pozici i nastaven.
        Ternární Operátor: ... ? "1" : "0" poskytuje kompaktní syntaxi pro podmíněný výraz.
        Analýza Kódu:
        getBinaryTime: Vrací aktuální čas v binárním formátu.
        decimalToBinary: Převádí decimální číslo na binární řetězec s daným počtem bitů.
 */
public class BinaryClock {
    public static void main(String[] args) {
        while (true) {
            String binaryTime = getBinaryTime();
            System.out.println(binaryTime);
            try {
                Thread.sleep(1000);  // Pause for one second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static String getBinaryTime() {
        // Getting the current time
        int hours = java.time.LocalTime.now().getHour();
        int minutes = java.time.LocalTime.now().getMinute();
        int seconds = java.time.LocalTime.now().getSecond();

        // Converting decimal to binary string
        String binaryHours = decimalToBinary(hours, 5);   // 24-hour format has max 24 = 11000 in binary (5 digits)
        String binaryMinutes = decimalToBinary(minutes, 6); // 60 minutes has max 111100 in binary (6 digits)
        String binarySeconds = decimalToBinary(seconds, 6); // 60 seconds has max 111100 in binary (6 digits)

        return binaryHours + " : " + binaryMinutes + " : " + binarySeconds;
    }

    private static String decimalToBinary(int decimal, int bits) {
        StringBuilder binary = new StringBuilder();


        /*
            Smyčka prochází všechny bity od nejvyššího bitu (bits - 1) k nejnižšímu bitu (0). 
            Například pokud chceme 8-bitovou reprezentaci, smyčka začne od indexu 7 a pokračuje směrem dolů k indexu 0.

            (1 << i) posune bit 1 doleva o i pozic. To vytvoří číslo s jedničkou pouze na pozici i a zbytkem nul.
            Použití logické operace AND (&) mezi decimal a (1 << i) vrátí hodnotu větší než 0, pokud je bit na pozici i v decimal nastaven na 1. Pokud je bit 0, vrátí 0.
            Ternární operátor ? : pak vrací "1" nebo "0" podle výsledku operace AND.

            Ukázka:
            Mějme číslo decimal = 5 a chceme jeho 8-bitovou reprezentaci.

            iterace (i=7): (5 & (1 << 7)) = 0 => Přidá "0"
            iterace (i=6): (5 & (1 << 6)) = 0 => Přidá "0"
            iterace (i=5): (5 & (1 << 5)) = 0 => Přidá "0"
            iterace (i=4): (5 & (1 << 4)) = 0 => Přidá "0"
            iterace (i=3): (5 & (1 << 3)) = 0 => Přidá "0"
            iterace (i=2): (5 & (1 << 2)) = 4 => Přidá "1"
            iterace (i=1): (5 & (1 << 1)) = 0 => Přidá "0"
            iterace (i=0): (5 & (1 << 0)) = 1 => Přidá "1"
            Výsledek: "00000101", což je 8-bitová reprezentace čísla 5.
         */
        for (int i = bits - 1; i >= 0; i--) {
            binary.append((decimal & (1 << i)) > 0 ? "1" : "0");
        }


        return binary.toString();
    }
}
