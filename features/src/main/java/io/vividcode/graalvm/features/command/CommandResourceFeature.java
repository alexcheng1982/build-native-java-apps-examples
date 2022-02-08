package io.vividcode.graalvm.features.command;

import com.oracle.svm.core.annotate.AutomaticFeature;
import com.oracle.svm.core.configure.ResourcesRegistry;
import org.graalvm.nativeimage.ImageSingletons;
import org.graalvm.nativeimage.hosted.Feature;
import org.graalvm.nativeimage.impl.ConfigurationCondition;

@AutomaticFeature
public class CommandResourceFeature implements Feature {

    @Override
    public void beforeAnalysis(BeforeAnalysisAccess access) {
        ResourcesRegistry registry = ImageSingletons.lookup(ResourcesRegistry.class);
        registry.addResources(ConfigurationCondition.alwaysTrue(), ".*\\.txt");
    }
}
