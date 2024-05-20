export JAVA_HOME="$(/usr/libexec/java_home --version 1.17)"
export PATH="$JAVA_HOME/bin:$PATH"

./gradlew assembleRelease
cp ./server/build/outputs/apk/release/server-release-unsigned.apk ./scrcpy-mask-server-v2.4

echo "Output: ./scrcpy-mask-server-v2.4"