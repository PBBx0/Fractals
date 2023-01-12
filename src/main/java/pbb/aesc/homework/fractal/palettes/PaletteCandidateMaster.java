package pbb.aesc.homework.fractal.palettes;

import java.awt.*;

public class PaletteCandidateMaster extends Palette {
    public PaletteCandidateMaster() {
        super();
        Color purple = new Color(0xBF40BF);
        purple = new Color(0xb026ff);
        purple = new Color(0x9b116f);
        colors.add(purple);
        for (int cnt = 60, i = 0; i < cnt; ++i) {
            colors.add(new Color((int)(purple.getRed() * (double)i / cnt),
                    (int)(purple.getGreen() * (double)i / cnt),
                    (int)(purple.getBlue() * (double)i / cnt)));
        }
    }
}
