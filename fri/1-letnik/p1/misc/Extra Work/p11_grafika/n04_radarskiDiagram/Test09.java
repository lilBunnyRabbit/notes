// _NE_ODSTRANI_

import java.awt.*;

public class Test09 {

    public static void main(String[] args) {
        RadarskiDiagram diagram = new RadarskiDiagram(new double[]{0.72, 0.06, 0.43, 0.93, 0.24, 0.79, 0.37, 0.65, 0.01, 0.83});
        diagram.sproziRisanje(new String[]{"rezultat09.png", "800x800"});
    }
}
