public class Fourth_task {
    public static void main(String[] args) {
        double[] sinTable = new double[91];

        for (int i = 0; i <= 90; i++) {
            sinTable[i] = Math.sin(Math.toRadians(i));
        }

        System.out.println("Таблиця синусів 0–90°:");
        
        for (int i = 0; i <= 90; i++) {
            System.out.printf("%.4f ", sinTable[i]);

            if ((i + 1) % 10 == 0)
                System.out.println();
        }
    }
}
