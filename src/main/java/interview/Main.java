package interview;

public class Main {

    public static void main(String[] args) {
        int argumentSize = args.length;

        if (argumentSize < 2) {
            System.out.println("Error initializing, at least two parameters required where first is the query string");
            return;
        }

        String queryString = args[0];
        String[] dataSample = new String[argumentSize - 1];

        System.arraycopy(args, 1, dataSample, 0, argumentSize - 1);

        Finder finder = new Finder(dataSample);
        String[] result = finder.find(queryString);

        System.out.println("Found strings:");
        for (String s : result) {
            System.out.println(s);
        }

    }
}
