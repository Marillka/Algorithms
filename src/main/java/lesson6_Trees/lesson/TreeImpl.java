package lesson6_Trees.lesson;

import java.util.Stack;

// имеет обобщение с ограничением по планке Comparable - это значит что все типы данных, которые будет хранить наше дерево должны сравниваться, иначе мы никак не сможем построить бинарное дерево. Надо же понимать какой элемент больше или меньше
public class TreeImpl<E extends Comparable<E>> implements Tree<E> {

    // начинается все с самого первого элемента от которого мы будем отталкиваться
    private Node<E> root;

    // чтобы понимать сколько элементов в дереве есть
    private int size;

    private class NodeAndParent {
        private Node<E> current;// текущий элемент, который ищем
        private Node<E> parent; // элемент родитель для искомого

        public NodeAndParent(Node<E> current, Node<E> parent) {
            this.current = current;
            this.parent = parent;
        }
    }

    @Override
    public boolean contains(E value) {
        NodeAndParent nodeAndParent = doFind(value);
        return nodeAndParent.current != null;

    }

    private NodeAndParent doFind(E value) {
        Node<E> current = root;
        Node<E> parent = null;

        while (current != null) {// идем до конца
            // если нашли, то возвращаем класс с текущим и родительским Node
            if (current.getValue().equals(value)) {
                break;
            }

            parent = current;

            // если разница между текущим и искомым больше нуля то идем влево
            // if (current.getValue().compareTo(value) > 0) {
            if (current.isLeftChild(value)) {
                current = current.getLeftChild();
            } else {
                // в противном идем вправо
                current = current.getRightChild();
            }
        }

        return new NodeAndParent(current, parent);

    }

    @Override
    public boolean add(E value) {
        /* сразу ищем позицию элемента, который мы добавляем. Находим позицию для внедряемого сейчас сюда узла. Во первых мы поймем, а вдрг у нас уже этот элемент есть, и тогда нужно как то среагировать. Во вторых мы узнаем где именно он должен стоять и какому родителю должны добавлять этот самый узел. */
        NodeAndParent nodeAndParent = doFind(value);// запросили экземпляр NodeAndParent
        /* Теперь одна из двух ситуация: либо все хорошо и мы сможем добавить новый узел. Если current = 0, а родитель равняется соответственно не null. Либо же родитель может равнятся null, тогда это особый случай, когда дерево полностью пустое и будет добавляться самый первый элемент.
         */
        if (nodeAndParent.current != null) {// не null - значит элемент внутри присутствует.
            nodeAndParent.current.repeatCount++;
            return false;
        }

        // если же все идет по плану
        Node<E> parent = nodeAndParent.parent;
        Node<E> node = new Node<>(value);

        // процесс подставления.
        // если родитель = null. Означает что все дерево пустое
        // корень всего дерево станет этим самым первый узлом
        if (isEmpty()) {
            root = node;
        } else if (parent.isLeftChild(value)) {
            parent.setLeftChild(node);
        } else {
            parent.setRightChild(node);
        }
        size++;
        return true;
    }

    @Override
    public boolean remove(E value) {
        /*
         3 случая при удалении:
          1) Узел не имеет потомков (является листом) - тогда просто удаляем связь с этим узлом. parent.setChild = null.
          2) Узел имеет одного из потомков (полностью идентична операции удаления в списке) - разрываем связь и присваиваем родителю удаляемого узла значение потомка удаляемого узла). Нужно определять какой остается правый или левый.
          3) Узел имеет два дочерних потомка
         */

        // Вначале проверяем есть ли такой элемент для удаления
        NodeAndParent nodeAndParent = doFind(value);
        Node<E> parent = nodeAndParent.parent;
        Node<E> removed = nodeAndParent.current;// удаляемый элемент

        // существует ли удалаяемый элемент
        if (removed == null) {
            return false;
        }

        // 1 случай - нет потомков
        if (removed.isLeaf()) {
            removeLeafNode(removed, parent);
        }
        // 2 случай - один потомок (справа или слева)
        else if (removed.hasOnlyOneChild()) {
            removeNodeWithOneChild(removed, parent);
        }

        // 3 случай - два потомка (справа и слева)
        else {
            removeNodeWithAllChildren(removed, parent);
        }





        size--;
        return true;
    }

    // метод удаления узла без дочерних элементов
    private void removeLeafNode(Node<E> removed, Node<E> parent) {
        // является ли узел корнем. Если не сделать этой проверки, то обратимся к родителю которого не существует
        if (removed == root) {
            root = null;
        } else if (parent.isLeftChild(removed.getValue())) {// если удаляемый узел - левый дочерний элемент
            parent.setLeftChild(null);
        } else {
            parent.setRightChild(null);
        }

    }

    // метод удаления с одним дочерним элементом
    private void removeNodeWithOneChild(Node<E> removed, Node<E> parent) {
        // Каким элементом является удаляемый (сохраним его в переменую child).
        // Есть ли у удаляемого левый узел
        // Если есть, то единственный элемент у удаляемого - левый
        // и наоборот
        Node<E> child = removed.getLeftChild() != null
                ? removed.getLeftChild()
                : removed.getRightChild();

        // удаляем связь
        if (removed.isLeftChild(child.getValue())) { // если левый
            removed.setLeftChild(null);
        } else { // если правый
            removed.setRightChild(null);
        }

        if (removed == root) {
            root = child;
        } else if (parent.isLeftChild(removed.getValue())) {
            parent.setLeftChild(child);
        } else {
            parent.setRightChild(child);
        }

    }

    // метод удаления с двумя дочерними элементами
    private void removeNodeWithAllChildren(Node<E> removed, Node<E> parent) {
        /*
        Проблема в том что снизу может быть достаточно большое дерево.
        [1 2 3 4 5] 6 [7 8 9 10 11]

        Этапы:
        1) Найти преемника ( 5 в левом дереве или 8 в правом дереве)
        2) Сохранить дочернний элемент у преемника ( у 5 это 4, у 7 это 8)
        3) Преемник должени заменить удаляемый элемент
         */

        // разделим на 2 метода. 1 метод ищет преемника, 2 метод удаляет.
        Node<E> successor = getSuccessor(removed);

        // successor нашли, теперь решаем куда он пойдет
        if (removed == root) {
            root = successor;
        } else if (parent.isLeftChild(removed.getValue())) {
            parent.setLeftChild(successor);
        } else {
            parent.setRightChild(successor);
        }
    }

    private Node<E> getSuccessor(Node<E> removed) {
         Node<E> successor = removed;
         Node<E> parent = null;
         Node<E> current = removed.getRightChild();// пойдем по правой стороне

        // по выходу из этого цикла найдем нужный нам successor
        while (current != null) {
            parent = successor;
            successor = current;
            current = current.getLeftChild();// всегда идем влево потому там всегда меньший элемент
        }

        // 94:02 разобраться
        if (successor != removed.getRightChild() && parent != null) {
            parent.setLeftChild(successor.getRightChild());
            successor.setRightChild(removed.getRightChild());
        }

        successor.setLeftChild(removed.getLeftChild());
        return successor;
    }


    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void display() {
        Stack<Node<E>> globalStack = new Stack<>();
        globalStack.push(root);
        int nBlanks = 64;

        boolean isRowEmpty = false;
        System.out.println("................................................................");

        while (!isRowEmpty) {
            Stack<Node<E>> localStack = new Stack<>();

            isRowEmpty = true;
            for (int i = 0; i < nBlanks; i++) {
                System.out.print(" ");
            }

            while (!globalStack.isEmpty()) {
                Node<E> tempNode = globalStack.pop();
                if (tempNode != null) {
                    System.out.print(tempNode.getValue());
                    localStack.push(tempNode.getLeftChild());
                    localStack.push(tempNode.getRightChild());
                    if (tempNode.getLeftChild() != null || tempNode.getRightChild() != null) {
                        isRowEmpty = false;
                    }
                } else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < nBlanks * 2 - 2; j++) {
                    System.out.print(" ");
                }
            }

            System.out.println();

            while (!localStack.isEmpty()) {
                globalStack.push(localStack.pop());
            }

            nBlanks /= 2;
        }
        System.out.println("................................................................");

    }

    @Override
    public void traverse(TraverMode mode) {
        switch (mode) {
            case PRE_ORDER -> preOrder(root);// прямой обход
            case IN_ORDER -> inOrder(root);// центрированный обход
            case POST_ORDER -> postOrder(root);// обратный обход

        }
        System.out.println();
    }

    private void preOrder(Node<E> current) {
        if (current == null) {
            return;
        }

        System.out.print(current.getValue() + " ");
        preOrder(current.getLeftChild());
        preOrder(current.getRightChild());
    }

    private void inOrder(Node<E> current) {
        if (current == null) {
            return;
        }

        inOrder(current.getLeftChild());
        System.out.print(current.getValue() + " ");
        inOrder(current.getRightChild());
    }

    private void postOrder(Node<E> current) {
        if (current == null) {
            return;
        }

        postOrder(current.getLeftChild());
        postOrder(current.getRightChild());
        System.out.print(current.getValue() + " ");
    }


}
