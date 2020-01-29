package pj;

public class V {
    private static int numVerified = 0;
    private static int numCorrect = 0;

    public static<T> void verify(T found, T expected, String testName) {
        if ((expected == null && found == null) || (expected != null && expected.equals(found))) {
            numVerified++;
            numCorrect++;
            return;
        }

        String errMsg = "";
        if (testName != null) errMsg = "\'" + testName +"\': ";
        verify(false, errMsg + "Expected:\n" + expected + "\nFound:\n" + found);
    }

    public static<T> void verify(T found, T expected) {
        verify(found, expected, null);
    }

    public static void end() {
        if (numCorrect == numVerified) {
            System.out.println(String.format("Success! All %s tests possed!", numVerified));
        } else {
            System.out.println(String.format("Failed %s/%s tests", numVerified-numCorrect, numVerified));
        }
    }

    private static void verify(boolean correct, String error) {
        verify("", correct, error);
    }

    private static void verify(String testName, boolean correct, String error) {
        numVerified++;
        if (!correct) {
            if (testName == null || testName.equals("")) {
                testName = getTestName();
            }
            System.out.println("Test: " + testName + " -> Error!\n" + error);
        } else {
            numCorrect++;
        }
        System.out.println("----------------------------------------------------------");
    }

    private static String getTestName() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        for (int i = stackTrace.length - 1; i >= 0; i--) {
            StackTraceElement frame = stackTrace[i];
            if (frame.getClassName().equals("pj.V")) continue;
            String[] tokens = frame.getClassName().split("\\.");
            return tokens[tokens.length-1] + "@" + frame.getLineNumber();
        }
        return "Unknown Test";
    }
}