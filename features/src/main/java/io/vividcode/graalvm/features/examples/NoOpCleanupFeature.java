package io.vividcode.graalvm.features.examples;

import com.oracle.svm.core.annotate.AutomaticFeature;
import org.graalvm.nativeimage.hosted.Feature;

@AutomaticFeature
public class NoOpCleanupFeature implements Feature {

    @Override
    public void cleanup() {
        System.out.println("Cleanup");
    }
}
