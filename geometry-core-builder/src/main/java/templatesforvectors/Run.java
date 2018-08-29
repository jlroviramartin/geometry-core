package templatesforvectors;

/**
 *
 * @author joseluis
 */
public class Run {

    public static void main(String[] args) {
        executeJava();
        executeCs();
    }

    public static void executeJava() {
        new templatesforvectors.java.templates.TupleTemplates().execute();
        new templatesforvectors.java.templates.VectorTemplates().execute();
        new templatesforvectors.java.templates.PointTemplates().execute();
        new templatesforvectors.java.templates.ColorTemplates().execute();
        new templatesforvectors.java.templates.MatrixTemplates().execute();
    }

    public static void executeCs() {
        new templatesforvectors.cs.templates.TupleTemplates().execute();
        new templatesforvectors.cs.templates.VectorTemplates().execute();
        new templatesforvectors.cs.templates.PointTemplates().execute();
        new templatesforvectors.cs.templates.ColorTemplates().execute();
        new templatesforvectors.cs.templates.MatrixTemplates().execute();
    }
}
