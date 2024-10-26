import java.util.*;

public class CakeDivider {
    static class Cake {
        double x, y, width, height;

        public Cake(double x, double y, double width, double height) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }

        public double areaAbove(double yCut) {
            if (yCut <= y) return 0;
            if (yCut >= y + height) return width * height;
            return width * (yCut - y);
        }

        public double areaBelow(double yCut) {
            return width * height - areaAbove(yCut);
        }
    }

    public static double findEqualDivisionY(List<Cake> cakes) {
        double low = cakes.stream().mapToDouble(c -> c.y).min().orElse(0);
        double high = cakes.stream().mapToDouble(c -> c.y + c.height).max().orElse(0);
        double totalArea = cakes.stream().mapToDouble(c -> c.width * c.height).sum();

        while (high - low > 1e-6) { // Precision threshold
            double mid = (low + high) / 2;
            double areaAbove = 0, areaBelow = 0;
            for (Cake cake : cakes) {
                areaAbove += cake.areaAbove(mid);
                areaBelow += cake.areaBelow(mid);
            }
            if (areaAbove > totalArea / 2) high = mid;
            else low = mid;
        }
        return (low + high) / 2;
    }

    public static void main(String[] args) {
        List<Cake> cakes = Arrays.asList(
            new Cake(1, 2, 3, 4),
            new Cake(2, 5, 4, 6)
        );
        System.out.println("Cut position: " + findEqualDivisionY(cakes));
    }
}