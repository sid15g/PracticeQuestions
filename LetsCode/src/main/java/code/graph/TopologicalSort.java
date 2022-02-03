package code.graph;

import code.graph.data.SimpleDirectedEdge;
import code.graph.data.SimpleDirectedGraph;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * https://www.geeksforgeeks.org/topological-sorting/
 *
 * Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for every directed edge u v,
 * vertex u comes before v in the ordering. Topological Sorting for a graph is not possible if the graph is not a DAG.
 *
 * For example,
 * A topological sorting of the following graph is “5 4 2 3 1 0”.
 * There can be more than one topological sorting for a graph.
 * Another topological sorting of the following graph is “4 5 2 3 1 0”.
 * The first vertex in topological sorting is always a vertex with in-degree as 0 (a vertex with no incoming edges).
 */
public class TopologicalSort {

    private Stack<Integer> stack = null;

    public int[] topologicalSort(final SimpleDirectedGraph graph) {

        if (graph == null || graph.getTotalNodes() == 0 || graph.getEdges() == null) {
            return new int[]{};
        }
        if (graph.getTotalNodes() == 1) {
            //since node count is 1, the only node we have has value one
            return new int[]{1};
        }

        final boolean[] visitedNodes = new boolean[graph.getTotalNodes()];
        Arrays.fill(visitedNodes, false);

        return topologicalSort(graph, visitedNodes);
    }

    private int[] topologicalSort(final SimpleDirectedGraph graph, final boolean[] visitedNodes) {

        final int[] topologicalSortSequence = new int[graph.getTotalNodes()];
        this.stack = new Stack<>();

        for (int i=1; i <= graph.getTotalNodes(); i++) {
            if (!visitedNodes[i - 1]) {
                depthFirstSearch(i, graph.getEdges(), visitedNodes);
            }
        }

        for(int i=0; !stack.isEmpty(); i++) {
            topologicalSortSequence[i] = stack.pop();
        }

        return topologicalSortSequence;
    }

    private void depthFirstSearch(final int nodeId, final List<SimpleDirectedEdge> edgesOfGraph, final boolean[] visitedNodes) {

        if (visitedNodes[nodeId - 1]) {
            return;
        }

        final List<Integer> connectedNodesList = edgesOfGraph.stream()
                .filter(Objects::nonNull)
                .filter(edge -> edge.getSource() == nodeId)
                .map(SimpleDirectedEdge::getDestination)
                .filter(edge -> !visitedNodes[edge - 1])
                .collect(Collectors.toList());

        visitedNodes[nodeId - 1] = true;

        for (final int node : connectedNodesList) {
            depthFirstSearch(node, edgesOfGraph, visitedNodes);
        }

        stack.push(nodeId);
    }

}
