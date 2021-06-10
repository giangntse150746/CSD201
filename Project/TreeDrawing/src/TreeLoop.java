/**
 *
 * @author saoranngu
 */
public class TreeLoop {
    public static void tree(int n, double x, double y, double a, double branchRadius) throws InterruptedException {
    double bendAngle   = Math.toRadians(15);
    double branchAngle = Math.toRadians(37);
    double branchRatio = 0.65;

    double cx = x + Math.cos(a) * branchRadius;
    double cy = y + Math.sin(a) * branchRadius;

    StdDraw.setPenRadius(0.001);
    // StdDraw.setPenRadius(0.001 * Math.pow(n, 1.2));
    StdDraw.line(x, y, cx, cy);
    if (n == 0) return;

    tree(n-1, cx, cy, a + bendAngle - branchAngle, branchRadius * branchRatio);         //right
    tree(n-1, cx, cy, a + bendAngle + branchAngle, branchRadius * branchRatio);         //left
    tree(n-1, cx, cy, a + bendAngle,               branchRadius * (1 - branchRatio));   //mid
}

    public static void main(String[] args) throws InterruptedException {
        int n = 12;//Integer.parseInt(args[0]);
        StdDraw.enableDoubleBuffering();
        tree(n, 0.5, 0, Math.PI/2, 0.3);
        StdDraw.show();
    }
}
