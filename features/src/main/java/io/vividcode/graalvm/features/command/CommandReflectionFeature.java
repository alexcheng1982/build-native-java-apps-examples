package io.vividcode.graalvm.features.command;

import com.oracle.svm.core.annotate.AutomaticFeature;
import io.vividcode.graalvm.features.command.CommandFactories.RunCommandFactory;
import io.vividcode.graalvm.features.command.CommandFactories.SleepCommandFactory;
import io.vividcode.graalvm.features.command.CommandFactories.ThinkCommandFactory;
import org.graalvm.nativeimage.hosted.Feature;
import org.graalvm.nativeimage.hosted.RuntimeReflection;

@AutomaticFeature
public class CommandReflectionFeature implements Feature {

    @Override
    public void beforeAnalysis(BeforeAnalysisAccess access) {
        registerClass(RunCommandFactory.class);
        registerClass(ThinkCommandFactory.class);
        registerClass(SleepCommandFactory.class);
    }

    private void registerClass(Class<?> clazz) {
        RuntimeReflection.register(clazz);
        RuntimeReflection.registerForReflectiveInstantiation(clazz);
    }
}
