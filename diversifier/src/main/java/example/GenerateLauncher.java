package example;
import spoon.MavenLauncher;
import spoon.reflect.CtModel;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class GenerateLauncher {
  //  private static final Logger logger = LoggerFactory.getLogger(GenerateLauncher.class);
    private final Path projectPath;
    private final String projectName;

    public GenerateLauncher(Path projectPath) {
        this.projectPath = projectPath;
        this.projectName = projectPath.getFileName().toString();
    }

    public void processWithSpoon() {
        MavenLauncher launcher;
        try {
            launcher = new MavenLauncher(projectPath.toString(),
                    MavenLauncher.SOURCE_TYPE.ALL_SOURCE);
            launcher.getEnvironment().disableConsistencyChecks();
            launcher.buildModel();
        } catch (Exception e) {
            return;
        }
        CtModel model = launcher.getModel();
        model.processWith(new MutateHu());
        String outputDirectory = "./output/generated/" + System.currentTimeMillis()+ projectName;
        launcher.setSourceOutputDirectory(outputDirectory);
        launcher.prettyprint();
        try {
            Files.writeString(Path.of("/home/benoit/Documents/ArticlesPresentations/Talks/ZKM/desordrerougeprocessing/demos/src/main/java/art/algo/test.java"),model.getAllTypes().stream().filter(ct -> ct.getSimpleName().equals("Plein007")).findFirst().get().getPosition().getCompilationUnit().toString());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }        
    }
}