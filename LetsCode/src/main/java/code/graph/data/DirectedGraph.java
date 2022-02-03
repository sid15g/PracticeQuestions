package code.graph.data;

import java.util.List;

public interface DirectedGraph<T> {
    int getTotalNodes();

    List<T> getEdges();
}
