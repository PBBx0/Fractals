package pbb.aesc.homework.fractal.palettes;
import java.awt.Color;
import java.util.ArrayList;
public class Palette {
    public ArrayList<Color> colors;
    public Palette() {
        colors = new ArrayList<>();
    }
    public Color get(int k, boolean max_k) {
        if (max_k) return Color.BLACK;
        return colors.get(k % colors.size());
    }

    public void extend() {
        ArrayList<Color> newColors = new ArrayList<>();
        Color prev = Color.BLACK;
        boolean f = false;
        for (Color x : colors) {
            if (f) {
                newColors.add(new Color(x.getRed() / 2 + prev.getRed() / 2,
                        x.getGreen() / 2 + prev.getGreen() / 2,
                        x.getBlue() / 2 + prev.getBlue() / 2));
            }
            newColors.add(x);
            prev = x;
            f = true;
        }
        colors = newColors;
    }
}
