import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArbolPrinter<T extends Comparable<T>> {

    public void printNode(Node<T> root) {
        int maxLevel = maxLevel(root);

        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private void printNodeInternal(List<Node<T>> Nodes, int level, int maxLevel) {
        if (Nodes.isEmpty() || isAllElementsNull(Nodes))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        ArbolPrinter.printWhitespaces(firstSpaces);

        List<Node<T>> newNodes = new ArrayList<Node<T>>();
        for (Node<T> Node : Nodes) {
            if (Node != null) {
                System.out.print(Node.getElement());
                newNodes.add(Node.getLeft());
                newNodes.add(Node.getRight());
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            ArbolPrinter.printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < newNodes.size(); j++) {
                ArbolPrinter.printWhitespaces(firstSpaces - i);
                if (newNodes.get(j) == null) {

                    ArbolPrinter.printWhitespaces( i + 1);
                    continue;
                }

                if (newNodes.get(j).getLeft() != null)
                    System.out.print("/");
                else
                    ArbolPrinter.printWhitespaces(1);

                ArbolPrinter.printWhitespaces(i + i - 1);

                if (newNodes.get(j).getRight() != null)
                    System.out.print("\\");
                else
                    ArbolPrinter.printWhitespaces(1);

                ArbolPrinter.printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private int maxLevel(Node<T> Node) {
        if (Node == null)
            return 0;

        return Math.max(maxLevel(Node.getLeft()), maxLevel(Node.getRight())) + 1;
    }

    private boolean isAllElementsNull(List<Node<T>> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }
}
