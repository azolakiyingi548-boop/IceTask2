import java.io.*;

public class Main {
    public static void main(String[] args) {
        int[][] weight = {{10, 20, 27}, {22, 5, 20}, {30, 20, 10}};
        String[] months = {"MONTH 1", "MONTH 2", "MONTH 3"};
        String[] gyms = {"GYM 1", "GYM 2", "GYM 3"};

        String fileName = "GymWeightLossReport.txt";

        // WRITE DATA TO FILE
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("GYM WEIGHT LOSS APPLICATION");
            writer.newLine();
            writer.write("-------------------------------------------------------------------------------------------");
            writer.newLine();

            writer.write(String.format("%-15s", ""));
            for (String month: months) {
                writer.write(String.format("%-12s", month));
            }
            writer.write(String.format("| %-10s %-10s %-13s %-10s\n", "TOTAL", "AVE", "MIN", "MAX"));
            writer.write("-------------------------------------------------------------------------------------------");
            writer.newLine();

            for (int gym = 0; gym < weight.length; gym++) {
                int total = 0;
                int min = weight[gym][0];
                int max = weight[gym][0];

                for (int month = 0; month < weight[gym].length; month++) {
                    int w = weight[gym][month];
                    total += w;
                    if (w < min) min = w;
                    if (w > max) max = w;
                }
                double average = (double) total / weight[gym].length;

                writer.write(String.format("%-15s", gyms[gym]));

                for (int month = 0; month < weight[gym].length; month++) {
                    writer.write(String.format("%-12s", weight[gym][month] + "kg"));
                }

                writer.write(String.format("| %-10s %-10s %-10s %-10s\n",
                        total + "kg",
                        String.format("%.2fkg", average),
                        min + "kg",
                        max + "kg"));
            }

            writer.write("-------------------------------------------------------------------------------------------");
            writer.newLine();

            System.out.println("Data successfully written to " + fileName);

        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }

        // READ DATA FROM FILE
        System.out.println();
        System.out.println("READING DATA FROM FILE");
        System.out.println("===============================================================");
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
    }
}