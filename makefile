read-resource-content:
	cd resources \
		&& mvn compile \
		&& cd target/classes \
		&& native-image io.vividcode.graalvm.resources.ReadResourceContent \
			-H:ResourceConfigurationFiles=./resource-config.txt read-resource-content

resource-bundles:
	cd resources \
 		&& mvn compile \
		&& cd target/classes \
		&& native-image io.vividcode.graalvm.resources.ResourceBundles \
			-H:IncludeResourceBundles=AppResource \
			-H:IncludeLocales=en,zh-CN resource-bundles