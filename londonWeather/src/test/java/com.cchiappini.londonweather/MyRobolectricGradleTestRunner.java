package com.cchiappini.londonweather;


import org.junit.runners.model.InitializationError;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.manifest.AndroidManifest;
import org.robolectric.res.Fs;

public class MyRobolectricGradleTestRunner extends RobolectricTestRunner {
    public MyRobolectricGradleTestRunner(Class<?> testClass) throws InitializationError {
        super(testClass);
    }

    @Override
    protected AndroidManifest getAppManifest(Config config) {
        String myAppPath = MyRobolectricGradleTestRunner.class.getProtectionDomain()
                .getCodeSource()
                .getLocation()
                .getPath();
        String manifestPath = myAppPath + "../../../manifests/full/debug/AndroidManifest.xml";
        String resPath = "/Users/cchiappini/AndroidStudioProjects/droidConf/londonWeather/build/intermediates/res/merged/debug";
        String assetPath ="/Users/cchiappini/AndroidStudioProjects/droidConf/londonWeather/build/intermediates/assets/debug";

      return createAppManifest(Fs.fileFromPath(manifestPath), Fs.fileFromPath(resPath), Fs.fileFromPath(assetPath), "com.cchiappini.londonweather");
    }

}
