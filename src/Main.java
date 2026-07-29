//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int [][] weight = {{10, 20, 27}, {22, 5, 20}, {30, 20, 10}};
        String [] months = {"MONTH 1", "MONTH 2", "MONTH 3"};
        String [] gyms = {"GYM 1", "GYM 2", "GYM 3"};

        System.out.println("GYM WEIGHT LOSS APPLICATION");
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.printf("%-15s", "");
        for(int month = 0; month < months.length; month++){
            System.out.printf("%-12s", months[month]);
        }
        System.out.printf("| %-10s %-10s %-13s %-10s\n", "TOTAL", "AVE", "MIN", "MAX");
        System.out.println("-------------------------------------------------------------------------------------------");

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

            System.out.printf("%-15s", gyms[gym]);
            for (int month = 0; month < weight[gym].length; month++) {
                System.out.printf("%-12s", weight[gym][month] + "kg");
            }

            System.out.printf("| %-10s %-10s %-10s %-10s\n", total + "kg", String.format("%.2fkg", average), min + "kg", max + "kg");
                }
            }
        }