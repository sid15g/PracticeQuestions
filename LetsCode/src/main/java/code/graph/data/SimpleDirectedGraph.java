package code.graph.data;

import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class SimpleDirectedGraph implements DirectedGraph<SimpleDirectedEdge> {

    /**
     * Implies total node count, and that node values would be from 1 -> N
     */
    private final int N;

    @Setter
    private List<SimpleDirectedEdge> edges = new ArrayList<>();

    public boolean addEdge(final int src, final int dest) {
        final SimpleDirectedEdge directedEdge = new SimpleDirectedEdge(src, dest);
        return this.edges.add(directedEdge);
    }

    @Override
    public int getTotalNodes() {
        return this.N;
    }

    @Override
    public List<SimpleDirectedEdge> getEdges() {
        return this.edges;
    }
}
