package templatesforvectors;

import templatesforvectors.java.templates.TupleTemplates;
import templatesforvectors.java.templates.ColorTemplates;
import templatesforvectors.java.templates.VectorTemplates;
import templatesforvectors.java.templates.PointTemplates;
import templatesforvectors.java.templates.MatrixTemplates;

/**
 *
 * @author joseluis
 */
public class Run {

    public static void main(String[] args) {
        new TupleTemplates().execute();
        new VectorTemplates().execute();
        new PointTemplates().execute();
        new ColorTemplates().execute();
        new MatrixTemplates().execute();
    }
}
