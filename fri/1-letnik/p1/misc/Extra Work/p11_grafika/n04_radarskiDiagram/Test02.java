// _NE_ODSTRANI_

import java.awt.*;

public class Test02 {

    public static void main(String[] args) {
        RadarskiDiagram diagram = new RadarskiDiagram(new double[]{0.60, 0.30, 0.80, 0.50, 0.90});
        diagram.sproziRisanje(new String[]{"rezultat02.png", "900x600"});
    }
}
