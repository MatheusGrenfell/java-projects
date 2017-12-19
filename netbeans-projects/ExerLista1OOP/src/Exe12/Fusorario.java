package Exe12;

public class Fusorario {

    public String getPaises() {
        return "Pa�ses:\nBrasil\nInglaterra\nAlemanha";
    }

    public String getFusorario(String paisOrigem, String paisDestino, int hora) {
        if (hora < 0 || hora > 23) {
            return "Hor�rio inv�lido";
        }
        if (paisOrigem.equalsIgnoreCase("Brasil") && paisDestino.equalsIgnoreCase("Inglaterra")) {
            return getBrasilInglaterra(hora);
        }
        if (paisOrigem.equalsIgnoreCase("Brasil") && paisDestino.equalsIgnoreCase("Alemanha")) {
            return getBrasilAlemanha(hora);
        }
        if (paisOrigem.equalsIgnoreCase("Inglaterra") && paisDestino.equalsIgnoreCase("Brasil")) {
            return getInglaterraBrasil(hora);
        }
        if (paisOrigem.equalsIgnoreCase("Inglaterra") && paisDestino.equalsIgnoreCase("Alemanha")) {
            return getInglaterraAlemanha(hora);
        }
        if (paisOrigem.equalsIgnoreCase("Alemanha") && paisDestino.equalsIgnoreCase("Brasil")) {
            return getAlemanhaBrasil(hora);
        }
        if (paisOrigem.equalsIgnoreCase("Alemanha") && paisDestino.equalsIgnoreCase("Inglaterra")) {
            return getAlemanhaInglaterra(hora);
        }
        return "Pa�s de origem ou destino inv�lido";
    }

    private String getBrasilInglaterra(int hora) {
        hora += 3;
        if (hora > 23) {
            return "Hor�rio na Inglaterra: " + (hora - 24) + " Horas";
        } else {
            return "Hor�rio na Inglaterra: " + hora + " Horas";
        }
    }

    private String getBrasilAlemanha(int hora) {
        hora += 4;
        if (hora > 23) {
            return "Hor�rio na Alemanha: " + (hora - 24) + " Horas";
        } else {
            return "Hor�rio na Alemanha: " + hora + " Horas";
        }
    }

    private String getInglaterraBrasil(int hora) {
        hora -= 3;
        if (hora < 0) {
            return "Hor�rio no Brasil: " + (hora + 24) + " Horas";
        } else {
            return "Hor�rio no Brasil: " + hora + " Horas";
        }
    }

    private String getInglaterraAlemanha(int hora) {
        hora += 1;
        if (hora > 23) {
            return "Hor�rio na Alemanha: " + (hora - 24) + " Horas";
        } else {
            return "Hor�rio na Alemanha: " + hora + " Horas";
        }
    }

    private String getAlemanhaBrasil(int hora) {
        hora -= 4;
        if (hora < 0) {
            return "Hor�rio no Brasil: " + (hora + 24) + " Horas";
        } else {
            return "Hor�rio no Brasil: " + hora + " Horas";
        }
    }

    private String getAlemanhaInglaterra(int hora) {
        hora -= 1;
        if (hora < 0) {
            return "Hor�rio na Inlaterra: " + (hora + 24) + " Horas";
        } else {
            return "Hor�rio na Inglaterra: " + hora + " Horas";
        }
    }
}
