import java.util.LinkedList;
import java.util.Queue;

public class Tree<T extends Comparable<T>>{
    private Node<T> root;

    public Node<T> getRoot() {
        return root;
    }

    public void setRoot(Node<T> root) {
        this.root = root;
    }

    public void insert(T element){
        if(root == null){
            root = new Node<>(element);
        }else{
            insert(root,element);
        }


    }
    private Node<T> insert(Node<T> root, T element){
        if(root == null) {
            root = new Node<>(element);
        }else{
            if(element.compareTo(root.getElement())>0){
                root.setRight(insert(root.getRight(),element));
            }else if(element.compareTo(root.getElement())<0){
                root.setLeft(insert(root.getLeft(),element));
            }
        }
        return root;
    }

    //Las funciones de los traversals que hicimos en clase, ya los comprobé todos con el arbol "test" (en main)
    // que saqué de internet.

    public void preOrdered(){
        preOrdered(root);
    }

    private void preOrdered(Node<T> node){
        if(node != null){
            System.out.println("Node: "+ node.getElement());
            preOrdered(node.getLeft());
            preOrdered(node.getRight());
        }

    }

    public void postOrdered(){
        postOrdered(root);
    }

    private void postOrdered(Node<T> node){
        if(node != null){
            postOrdered(node.getLeft());
            postOrdered(node.getRight());
            System.out.println("Node: "+ node.getElement());
        }


    }

    public void inOrdered(){
        inOrdered(root);
    }

    private void inOrdered(Node<T> node){
        if(node != null){
            inOrdered(node.getLeft());
            System.out.println("Node: " + node.getElement());
            inOrdered(node.getRight());
        }
    }

    //public T remove(T element){
    //    remove(root,element);
    //}

    //Código para borrar apenas empezado(copy paste del insert, no está terminado.
    private Node<T> remove(Node<T> root, T element){

        if(root.getElement() == element){
            return root;
        }else if(root.getElement().compareTo(element)<0){
            return remove(root.getRight(),element);
        }else if(root.getElement().compareTo(element)>0){
            return remove(root.getLeft(),element);
        }else{
            System.out.println("The element is not in the tree");
        }
        return null;
    }


//Wrapper y función para contar los "niveles" del arbol (depth).
    public int countLevels(){
        return countLevels(root);
    }


    private int countLevels(Node<T> root){

        if(root == null){
                return 0;

        }else {
            int left = countLevels(root.getLeft());
            int right = countLevels(root.getRight());

            if(left>right){
                return (left + 1);
            }else{
                return (right + 1);
            }
        }
    }

    //Función para imprimir el arbol usando level ordered traversal recursivo (se que usando queue es más eficiente, pero este
    //lo entiendo mejor).

    public void printLevelTraversal(){
        int depth = countLevels();
        int spaceCount;
        int initialSpace;

        for(int i = 1 ;i<=depth; i++){


                spaceCount = (int)Math.round(Math.pow(2,depth-i+1)-1);
                initialSpace =(int)Math.round(Math.pow(2,depth-i)-1);

            printSpaces(initialSpace);
            printLevel(root,i,depth,spaceCount);

            System.out.println("");
            System.out.println("");

        }


    }

    //Función que imprime el nivel específico del arbol usando level ordered traversal recursivo.
    private void printLevel(Node<T> root, int currentLevel, int depth, int spaces){


        int min=Integer.MAX_VALUE;



        if (root == null){
            printSpaces(1);
            return;
        }



        if (currentLevel == 1){
            System.out.print(root.getElement());

        }else if(currentLevel >1) {

            printLevel(root.getLeft(), currentLevel -1,depth,spaces);
            printSpaces(spaces);
            printLevel(root.getRight(), currentLevel -1,depth,spaces);



        }

    }

    //Función como la que hiciste para imprimir espacios de una forma más facil, me pareció una mejor idea que manejar
    //strings de espacios.

    private void printSpaces(int counter){
        for(int i=0; i<counter; i++){
            System.out.print(" ");
        }
    }



}
