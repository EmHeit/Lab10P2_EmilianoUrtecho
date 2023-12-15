package lab8p2_mejorado;

public class SuperBuild extends MejorasVisuales {
    
    private double precioBase = 25000;
    private static String pais;
    
    public SuperBuild(String marca, String calificacion, double precio) {
        super(marca, calificacion, precio);
    }
    
    private static double PrecioBuilds(String marca){
        return 0;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
    
    
    
    private static double PrecioMarca(String marca){
        if (marca.equalsIgnoreCase("Advance") || marca.equalsIgnoreCase("RocketBunny")) {
            if (pais.equalsIgnoreCase("Estados Unidos")) {
                return 1.05;
            }else if(pais.equalsIgnoreCase("Japan")){
                return 1.0;
            }else if(pais.equalsIgnoreCase("Italia") || pais.equalsIgnoreCase("Alemania")
                    || pais.equalsIgnoreCase("Francia") || pais.equalsIgnoreCase("UK")
                    || pais.equalsIgnoreCase("Sweden")){
                return 1.05;
            }
        }else if (marca.equalsIgnoreCase("DTM Fiberwerkz")) {
            if (pais.equalsIgnoreCase("Alemania")) {
                return 1.10;
            }else if(pais.equalsIgnoreCase("Italia")|| pais.equalsIgnoreCase("Francia")
                    || pais.equalsIgnoreCase("UK")
                    || pais.equalsIgnoreCase("Sweden")){
                return 1.05;    
            }else{
                return 1.0;
            }
        }else if (marca.equalsIgnoreCase("Origin Lab") || marca.equalsIgnoreCase("Urban Outlaw")) {
            if (pais.equalsIgnoreCase("Estados Unidos")) {
                return 1.05;
            }else if(pais.equalsIgnoreCase("Japan")){
                return 1.15;
            }else{
                return 1.0;
            }            
        }else if(marca.equalsIgnoreCase("Fifteen 52")){
            return 1.08;
        }
        return 1.0;
    }
}
