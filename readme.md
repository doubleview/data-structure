## 简介
#### 此项目是基于java语言的关于数据结构的代码实现，包含所有经典数据结构算法，并且注释完善，非常适合了解和学习数据结构。另外包含了一个联系人存储工具(phonebook)，它由swing展示，并应用了数据结构算法的相关概念。如果对你有帮助，就关注一下吧^O^ 

## 结构

* array--数组和广义表

* graph--图

* list--线性表

* phonebook--综合应用(利用数据结构实现联系人存储软件)

* search--查找

* sort--排序

* stackqueue--栈和队列

* string--串

* tree--树

* leetcode_agorithm leetcode算法示例题解

## 数据机构

### 线性表
线性表是最基本、最简单、也是最常用的一种数据结构。线性表中数据元素之间的关系是一对一的关系，即除了第一个和最后一个数据元素之外，其它数据元素都是首尾相接的(注意，这句话只适用大部分线性表，而不是全部。比如，循环链表逻辑层次上也是一种线性表(存储层次上属于链式存储)，但是把最后一个数据元素的尾指针指向了哨位结点)。

![Alt text](/res/list.png?raw=true "list")
* **SeqList** 用数组实现的一种单链表,时间复杂度如下:
  * 索引: `O(1)`
  * 搜索: `O(n)`
  * 插入: `O(n)`
  * 移除: `O(n)`
 
 ![Alt text](/res/arraylist.jpg?raw=true "SeqList")


* **SinglyLinkedList**  带头结点的单链表，它是由节点（Node）组成的线性集合，每个节点可以利用指针指向其他节点。时间复杂度如下:
  * 索引: `O(n)`
  * 搜索: `O(n)`
  * 插入: `O(1)`
  * 移除: `O(1)`
 
  ![Alt text](/res/linkedlist.jpg?raw=true "SinglyLinkedList")


* **SortedSinglyLinkedList** 一种可排序的单链表，它要求加入的元素必须实现Comparable接口
* **PolySLinkedList** 一种可排序并且可与其他链表相加的一种数据结构，它实现了Addible接口

### 栈与队列
栈是一种先进后出的一种元素集合，其中push为入栈，pop为出栈。
队列是一种先进先出的一种元素集合，其中enqueue为入队，dequeue为出队

![Alt text](/res/stackqueue.png?raw=true "stackqueue")

* **SeqQueue** 使用数组实现一种队列结构，时间复杂度如下:
  * enqueue: `O(1)`
  * dequeue: `O(1)`
* **LinkedQueue**  使用链表实现的一种队列结构

![Alt text](/res/stack_queue.png?raw=true "stackqueue")

* **PriorityQueue** 优先级队列，优先级高的元素最先出队
* **SeqStack** 使用数组实现的一种栈结构
  * push: `O(1)`
  * pop: `O(1)`
* **LinkedStack** 使用链表实现的一种栈结构

### 串

串（string）是由零个或多个宇符组成的有限序列，又名叫字符串。

* **MyString** 模拟字符串结构
* **MyStringBuffer** 模拟可变字符串结构

### 数组和广义表

数组是一个由一组类型相同、下标不同的变量构成的数据结构，广义表元素的值非原子类型，可以再分解，表中元素也可是一个线性表，所有数据元素仍然属于同一数据类型。

* **GenList** 双链结构的广义表
* **DownTriangleMatrix** 线性压缩存储的下三角矩阵
* **CrossLinkedSparseMatrix** 十字链表存储的系数矩阵
* **LinkedSparseMatrix** 三元组行的单链表存储的系数矩阵
* **Matrix** 用数组进行的存储的一种矩阵结构
* **SeqSparseMatrix** 稀疏矩阵三元组顺序表存储的一种矩阵结构

### 树

树状图是一种数据结构，它是由n（n>=1）个有限节点组成一个具有层次关系的集合。把它叫做“树”是因为它看起来像一棵倒挂的树，也就是说它是根朝上，而叶朝下的

* **Tree** 树形结构，每个节点包含孩子结点和兄弟结点
* **BinaryTree** 二叉树，每个节点包含左孩子结点和右孩子及结点

     ![Alt text](/res/binarytree.jpg?raw=true "Hashing")

* **CompleteBinaryTree** 完全二叉树，除最后一层外，每一层上的结点数均达到最大值；在最后一层上只缺少右边的若干结点。

> 满二叉树:除最后一层无任何子节点外，每一层上的所有结点都有两个子结点的二叉树。

![Alt text](/res/complete.jpg?raw=true "Hashing")


* **ThreadBinaryTree** 中序线索二叉树，按照中序遍历，每个节点的左孩子为空，则指向它的前驱结点，右孩子为空，则指向它的后继结点

### 图
图是一种数据元素间为多对多关系的数据结构
* 无向图（Undirected Graph）: 无向图具有对称的邻接矩阵，因此如果存在某条从节点 u 到节点 v 的边，反之从 v 到 u 的边也存在。
* 有向图（Directed Graph）: 有向图的邻接矩阵是非对称的，即如果存在从 u 到 v 的边并不意味着一定存在从 v 到 u 的边。

![Alt text](/res/graph.png?raw=true "Hashing")

* **AdjMatrixGraph** 邻接矩阵表示的带权图数据机构
* **AdjListGraph** 邻接表表示的带权图数据结构

![Alt text](/res/MatrixListGraph.jpg?raw=true "Hashing")


### 排序
#### **插入排序**
 * 直接插入排序(稳定)
 
![Alt text](/res/insertsort1.jpg?raw=true "Hashing")
 * 希尔排序(不稳定)
 
 ![Alt text](/res/insertsort2.jpg?raw=true "Hashing")

 
#### **交换排序**

 * 冒泡排序(稳定)
 
  ![Alt text](/res/bubblesort.jpg?raw=true "Hashing")
  
 * 快速排序(不稳定)  时间复杂度如下:
   * 最优时间: O(nlog(n))
   * 最坏时间: O(n^2)
   * 平均时间: O(nlog(n))
   
     ![Alt text](/res/quicksort.jpg?raw=true "Hashing")

####  **选择排序**
 * 直接选择排序(不稳定)
 
      ![Alt text](/res/selectsort.jpg?raw=true "Hashing")
      
 * 堆排序(不稳定) 利用堆积树（堆）这种数据结构所设计的一种排序算法，它是选择排序的一种。可以利用数组的特点快速定位指定索引的元素。堆分为大根堆和小根堆，是完全二叉树。大根堆的要求是每个节点的值都不大于其父节点的值，即A[PARENT[i]] >= A[i]。在数组的非降序排序中，需要使用的就是大根堆，因为根据大根堆的要求可知，最大的值一定在堆顶。 时间复杂度如下：
   * 最优时间: O(nlog(n))
   * 最坏时间: O(nlog(n))
   * 平均时间: O(nlog(n))
  
       ![Alt text](/res/heapsort.jpg?raw=true "Hashing")

  
* 归并排序(稳定) 归并排序是利用一种分治的思想，它不断地将某个数组分为两个部分，分别对左子数组与右子数组进行排序，然后将两个数组合并为新的有序数组。时间复杂度如下:
  * 最优时间: O(nlog(n))
  * 最坏时间: O(nlog(n))
  * 平均时间: O(nlog(n))
  
     ![Alt text](/res/mergesort.png?raw=true "Hashing")


### 查找

* **BinarySortTree** 二叉排序树，一种特殊的二叉树，对于每一个结点，它的左孩子下所有的结点数值一定比它的右孩子下所有结点的数值小，构造过程如下:

   ![Alt text](/res/binarysort.jpg?raw=true "Hashing")     
      
* **HashSet** 采用链地址法的散列表数据结构，内部使用了SinglyLinkedList数组存储元素

   ![Alt text](/res/hash.jpg?raw=true "Hashing")


> 关于哈希: 一般的线性表，树中，记录在结构中的相对位置是随机的，因此，在结构中查找记录时需进行一系列和关键字的比较。 理想的情况是能直接找到需要的记录，因此必须在记录的存储位置和它的关键字之间建立一个确定的对应关系f，使每个关键字和结构中一个唯一的存储位置相对应。

> 解决冲突：
> * 链接法(拉链法)。将具有同一散列地址的记录存储在一条线性链表中。例，除留余数法中，设关键字为 (18,14,01,68,27,55,79)，除数为13。散列地址为 (5,1,1,3,1,3,1)，
> * 开地址法 在开地址法中，当插入新值时，会判断该值对应的哈希桶是否存在，如果存在则根据某种算法依次选择下一个可能的位置，直到找到一个尚未被占用的地址。所谓开地址法也是指某个元素的位置并不永远由其哈希值决定。

## 联系我

* 邮箱：doubleview@163.com
