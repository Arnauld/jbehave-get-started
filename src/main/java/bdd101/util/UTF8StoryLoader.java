package bdd101.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.jbehave.core.io.InvalidStoryResource;
import org.jbehave.core.io.StoryLoader;
import org.jbehave.core.io.StoryResourceNotFound;

public class UTF8StoryLoader implements StoryLoader {
    
    private final ClassLoader classLoader;

    public UTF8StoryLoader() {
        this(Thread.currentThread().getContextClassLoader());
    }

    public UTF8StoryLoader(Class<?> loadFromClass) {
        this(loadFromClass.getClassLoader());
    }

    public UTF8StoryLoader(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }
    
    @Override
    public String loadStoryAsText(String storyPath) {
        return loadResourceAsText(storyPath);
    }
    
    private String loadResourceAsText(String resourcePath) {
        InputStream stream = resourceAsStream(resourcePath);
        try {
            return IOUtils.toString(stream, "UTF-8");
        } catch (IOException e) {
            throw new InvalidStoryResource(resourcePath, stream, e);
        }
    }

    protected InputStream resourceAsStream(String resourcePath) {
        InputStream stream = classLoader.getResourceAsStream(resourcePath);
        if (stream == null) {
            throw new StoryResourceNotFound(resourcePath, classLoader);
        }
        return stream;
    }
}
