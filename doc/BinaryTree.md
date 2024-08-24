# 二叉树

```java
class Tree {
    int value;
    Tree left;
    Tree right;
}
```

## 递归

### 前序遍历

```java
void preOrder(Tree head) {
    if (head == null) {
        return;
    }
    System.out.println(head.value);
    preOrder(head.left);
    preOrder(head.right);
}
```

### 中序遍历

```java
void inOrder(Tree head) {
    if (head == null) {
        return;
    }
    inOrder(head.left);
    System.out.println(head.value);
    inOrder(head.right);
}
```

### 后序遍历

```java
void postOrder(Tree head) {
    if (head == null) {
        return;
    }
    posOrder(head.left);
    posOrder(head.right);
    System.out.println(head.value);
}
```

## 非递归

### 前序遍历

```java
void preOrder(Tree head) {
    Deque<Tree> stack = new ArrayDeque<>();
    stack.addFirst(head);
    while (!stack.isEmpty()) {
        head = stack.removeFirst();
        System.out.println(head.value);
        if (head.right != null) {
            stack.addFirst(head.right);
        }
        if (head.left != null) {
            stack.addFirst(head.left);
        }
    }
}
```

### 中序遍历

```java
void preOrder(Tree head) {
    Deque<Tree> stack = new ArrayDeque<>();
    while (!stack.isEmpty() || head != null) {
        if (head != null) {
            stack.addFirst(head);
            head = head.left;
        } else {
            head = stack.removeFirst();
            System.out.println(head.value);
            head = head.right;
        }
    }
}
```

### 后序遍历

```java
void postOrder(Tree head) {
    Deque<Tree> stack = new ArrayDeque<>();
    Deque<Tree> deque = new ArrayDeque<>();
    stack.addFirst(head);
    while (!stack.isEmpty()) {
        head = stack.removeFirst();
        deque.addFirst(head);
        if (head.left != null) {
            stack.addFirst(head.left);
        }
        if (head.right != null) {
            stack.addFirst(head.right);
        }
    }
    while (!deque.isEmpty()) {
        Tree node = deque.removeFirst();
        System.out.println(node.value);
    }
}
```

### 后序遍历 - 优化空间

```java
void postOrder(Tree head) {
    Deque<Tree> stack = new ArrayDeque<>();
    stack.addFirst(head);
    while (!stack.isEmpty()) {
        Tree cur = stack.getFirst();
        if (cur.left != null && cur.left != head && cur.right != head) {
            stack.addFirst(cur.left);
        } else if (cur.right != null && cur.right != head) {
            stack.addFirst(cur.right);
        } else {
            System.out.println(cur.value);
            head = stack.removeFirst();
        }
    }
}
```

## 序列化

### 前序

```java
String serialize(TreeNode root, StringBuilder sb) {
    if (root == null) {
        sb.append("null").append(",");
    } else {
        sb.append(root.val).append(",");
        serialize(root.left, sb);
        serialize(root.right, sb);
    }
    return sb.toString();
}
```

## 反序列化

### 前序

```java
TreeNode deserialize(String data) {
    String[] arr = data.split(",");
    Queue<String> queue = new LinkedList<>();
    for (String s : arr) {
        queue.add(s);
    }
    return deserialize(queue);
}

TreeNode deserialize(Queue<String> queue) {
    String cur = queue.remove();
    if ("null".equals(cur)) {
        return null;
    }
    TreeNode root = new TreeNode(Integer.parseInt(cur));
    root.left = deserialize(queue);
    root.right = deserialize(queue);
    return root;
}
```

## 拓扑排序

可以描述节点之前的关系
要求必须是有向无环图
入度消除法, 如果无法将所有点都消除, 说明图中存在环
