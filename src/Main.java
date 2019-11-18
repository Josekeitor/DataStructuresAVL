public class Main {
    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>();
        Tree<Integer> test = new Tree<>();
        ArbolPrinter<Integer> printer = new ArbolPrinter<>();

        System.out.println("Utilizé arbol printer del git, para comparar los resultados de las impresiones y para ver cómo calculaste tu los espacios :)");
        System.out.println("Solo que al pasarlo a mis clases y estarle moviendo lo rompimos un poco :(");

        System.out.println("Este es el arbol que hicimos en clase y sus recorridos: ");

        tree.insert(9);
        tree.insert(5);
        tree.insert(15);
        tree.insert(13);
        tree.insert(12);
        tree.insert(14);
        tree.insert(17);
        tree.insert(16);

        tree.printLevelTraversal();
        System.out.println(" ");

        System.out.println("In order");
        tree.inOrdered();
        System.out.println("Pre order");
        tree.preOrdered();
        System.out.println("Post order");
        tree.postOrdered();



        System.out.println("");
        System.out.println("Este es el arbol que copiamos de internet para confirmar que hicimos bien los traversals: ");
        System.out.println("");

        test.insert(25);
        test.insert(15);
        test.insert(50);
        test.insert(10);
        test.insert(22);
        test.insert(35);
        test.insert(70);
        test.insert(4);
        test.insert(12);
        test.insert(18);
        test.insert(24);
        test.insert(31);
        test.insert(44);
        test.insert(66);
        test.insert(90);
        test.printLevelTraversal();
        System.out.println("");
        System.out.println("Y sus recorridos: ");
        System.out.println("");

        System.out.println("In order");
        test.inOrdered();
        System.out.println("Pre order");
        test.preOrdered();
        System.out.println("Post order");
        test.postOrdered();

        System.out.println();

        System.out.println("Gracias!");



    }
}
