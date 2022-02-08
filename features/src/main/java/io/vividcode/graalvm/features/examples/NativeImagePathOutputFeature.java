package io.vividcode.graalvm.features.examples;

import org.graalvm.nativeimage.hosted.Feature;

public class NativeImagePathOutputFeature implements Feature {

    @Override
    public void afterImageWrite(AfterImageWriteAccess access) {
        System.out.println("Native image written to " + access.getImagePath());
    }
}
