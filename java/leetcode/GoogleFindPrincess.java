package com.tool.java.leetcode;

public class GoogleFindPrincess
{

    //  https://leetcode.com/discuss/interview-question/322598/Google-or-Onsite-interview-or-Find-princess
    
    /*
     * 
     first construct a graph. 
     such that
     graph[u][v] = graph[v][u] = key needed to open the path => weighted graph
     
    class Node:
    def __init__(self, data, key, children):
        self.data = data
        self.key = key
        self.children = children
 
    hashmap<key, list of neighbours>
    def find_princess(N, graph, start_node):
        queue = collections.deque([start_node])
        keys, visited = set(), set([start_node])
     
        while queue :
                pop node
                keys.add(node.key)
                if node.val == N:
                    return True
                for neighbor in graph[node].children:
                    if neighbor not in visited:
                        if graph[node,children] in keys and 
                            queue.append(neighbor)
                            keys.add(neighbor.key)
                            queue.append(map.get(key))
                            map.remove(key)
                            visited.add(neighbor)
                         else
                            map.put(graph[node,children], list.add(neighbour))
     
        return False
     */
    
}
