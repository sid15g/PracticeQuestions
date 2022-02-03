package code.graph;

import code.graph.data.SimpleDirectedGraph;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class TopologicalSortTest {

    private TopologicalSort classToTest = null;

    @BeforeMethod
    private void beforeMethod() {
        classToTest = new TopologicalSort();
    }

    @Test(groups = "unit")
    public void testNullCase() {
        int[] result = classToTest.topologicalSort(null);

        assertEquals(result, new int[]{});
        assertEquals(result.length, 0);
    }

    @Test(groups = "unit")
    public void testEmptyGraph() {
        final SimpleDirectedGraph graph = new SimpleDirectedGraph(0);
        int[] result = classToTest.topologicalSort(graph);

        assertEquals(result, new int[]{});
        assertEquals(result.length, 0);
    }


    @Test(groups = "unit")
    public void testGivenCase1() {
        final SimpleDirectedGraph graph = new SimpleDirectedGraph(6);
        graph.addEdge(6, 1);
        graph.addEdge(6, 3);
        graph.addEdge(5, 1);
        graph.addEdge(5, 2);
        graph.addEdge(3, 4);
        graph.addEdge(4, 2);

        int[] result = classToTest.topologicalSort(graph);

        assertNotNull(result);
        assertEquals(result.length, graph.getTotalNodes());
        System.out.println(Arrays.toString(result));
        assertEquals(result, new int[]{6, 5, 3, 4, 2, 1});
    }


}