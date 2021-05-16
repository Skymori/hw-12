package task1;

public class Main {
    public static void main(String[] args) {
        Water water = new Water();
        String string = "OOHHHHOOOOHHHHOOHOHOHOHOOHHH";

        Runnable hydrogenRelease = () -> System.out.print("H");
        Runnable oxygenRelease = () -> System.out.print("O");

        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            if (ch == 'O'){
                new Thread(()-> {
                    try {
                        water.oxygen(oxygenRelease);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }).start();
            }else if (ch == 'H'){
                new Thread(()-> {
                    try {
                        water.hydrogen(hydrogenRelease);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }).start();
            }
        }
    }
}
