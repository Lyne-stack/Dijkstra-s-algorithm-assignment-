# COSC 333 – Design and Analysis of Algorithms
**Name:** Lyne Jepchirchir  
**Registration Number:** EB3/67305/23

## Dijkstra’s Algorithm Assignment

### 1. Introduction
This repository contains a Java implementation of Dijkstra’s Algorithm. The primary goal is to determine the shortest path from a single source node to all other nodes in a weighted graph without using built-in library implementations of the algorithm.

### 2. How it Works 
Dijkstra's algorithm works on a "greedy" principle. It maintains a list of the shortest known distances to every node. It starts at the source (distance 0) and looks at all its neighbors. If it finds a path to a neighbor that is shorter than what was previously recorded, it updates that distance (this is called "Relaxation"). It then picks the next unvisited node with the smallest distance and repeats the process until every node has been evaluated.



### 3. Step-by-Step Illustration
Using a small 4-node example where Node 0 is the source:
1. **Initial State:** All distances set to Infinity (∞), Source (0) set to 0. `dist = [0, ∞, ∞, ∞]`
2. **Visit Node 0:** Check neighbors (1 and 2). Update distances. `dist = [0, 5, 10, ∞]`
3. **Visit Node 1:** (Smallest unvisited). Check neighbor (3). New path to 3 is $5 + 2 = 7$. Update 3. `dist = [0, 5, 10, 7]`
4. **Visit Node 3:** Check neighbor (2). Path $7 + 1 = 8$. Since 8 < 10, update Node 2. `dist = [0, 5, 8, 7]`
5. **Final Result:** All nodes visited. Shortest paths found.

### 4. Complexity Analysis
* **Time Complexity:**
    * **Best/Average/Worst Case:** $O(V^2)$
    * **Explanation:** Because I used an adjacency matrix, the algorithm must iterate through every vertex $V$ to find the minimum distance, and for each vertex, it scans all other vertices to update edges. This results in $V \times V$ operations.
* **Space Complexity:** $O(V^2)$
    * **Explanation:** The adjacency matrix requires $V \times V$ space to store edge weights. If using an adjacency list, this could be reduced to $O(V + E)$.

### 5. Discussion of Results
By running the program on inputs ranging from 1 to 9,999 nodes, I observed the following:
* As the number of nodes ($V$) increases, the number of comparisons grows by a power of 2 ($V^2$).
* For very large inputs (like 9,999), the execution time is noticeably longer, confirming that while the algorithm is effective, $O(V^2)$ becomes expensive for massive datasets.



