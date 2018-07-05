# Algorithms

·方法分類：

1. String and Array: String: ask captilization, blank space, ASCII or UNICODE

2. LinkedList: Cycle check, null pointer check before accessing its properties like next.
			   No length know, only access from head, recursion.
			   recursion's result may be null;
			   for Double linkedlist, insert requires both the next pointers set and prev pointers set. 4 sets.
			   1. node == null 2. n <= 0 3. n > list.length 4. linkedlist有没有circle之类的

3. Stack and Queue

4. Tree and Graph 
	~Null node， input check，下面要用到左右parent的check自己null；recursive 保护
				insert in tree: left可能有值用recursive去insert，除非没有（left == null）才可以覆盖！（left = new ...)
	~Recursive: bulk 中 寫下所有可能出現.的情況。
				自己是要check的node
				自己是leaf
				自己是要求的
				比較root 和 recursive的結果children，在同一bulk中出現

5. Graph: Cycle, visited
   Matrix: a graph, search path, especially to neighbers or defined directions, mark visited to prevent check back. (stack overflow)



·錯誤：
- if else沒有把所有情況考慮完全，比如 h1 = h2 這種
- recursive 左和右都寫成左……………… （4.8）
- Wrapper class中 要比較這整個class還是那裡面的node or value


