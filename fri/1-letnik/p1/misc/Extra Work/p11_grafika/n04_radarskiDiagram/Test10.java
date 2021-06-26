// _NE_ODSTRANI_

import java.awt.*;

public class Test10 {

    public static void main(String[] args) {
        RadarskiDiagram diagram = new RadarskiDiagram(new double[]{0.01, 0.89, 0.01, 0.04, 0.45, 0.57, 0.25, 0.73, 0.18, 0.55, 0.67, 0.29, 0.85, 0.47, 0.84, 0.41, 0.73, 0.03, 0.90, 0.80});
        diagram.sproziRisanje(new String[]{"rezultat10.png", "600x900"});
    }
}
