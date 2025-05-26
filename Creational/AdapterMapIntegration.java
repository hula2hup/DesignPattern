interface MapService {
    void displayMap(String location);
}

class OldMapAPI {
    public void renderOldMap(String coords) { System.out.println("Rendering old map for: " + coords); }
}

class MapAdapter implements MapService {
    private OldMapAPI oldApi = new OldMapAPI();
    public void displayMap(String location) {
        String coords = convertToCoords(location);
        oldApi.renderOldMap(coords);
    }
    private String convertToCoords(String location) {
        // Simulasi konversi sederhana
        return location.replace(" ", ",").toLowerCase();
    }
}

public class AdapterMapIntegration {
    public static void main(String[] args) {
        MapService modernMap = new MapAdapter();
        modernMap.displayMap("Jakarta Indonesia");
    }
}