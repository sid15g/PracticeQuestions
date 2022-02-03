package code.graph.data;

import lombok.RequiredArgsConstructor;

import java.util.Objects;

@RequiredArgsConstructor
public class SimpleDirectedEdge implements DirectedEdge<Integer> {

    private final int src;
    private final int dest;

    @Override
    public Integer getSource() {
        return this.src;
    }

    @Override
    public Integer getDestination() {
        return this.dest;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleDirectedEdge that = (SimpleDirectedEdge) o;
        return src == that.src &&
                dest == that.dest;
    }

    @Override
    public int hashCode() {
        return Objects.hash(src, dest);
    }
}
