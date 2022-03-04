//[navigation-compose](../../index.md)/[com.chrynan.navigation.compose](index.md)/[autoSaver](auto-saver.md)

# autoSaver

[common]\
expect fun &lt;[T](auto-saver.md)&gt; [autoSaver](auto-saver.md)(): [Saver](-saver/index.md)&lt;[T](auto-saver.md), [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt;

Retrieves a default implementation of a [Saver](-saver/index.md) interface which does not perform any conversion. Similar to the [Saver](-saver/index.md) interface, this function is meant to represent the androidx.compose.runtime.saveable.autoSaver function, but that function is not available for Jetpack Compose Web, so this expected function is defined in the common source set. The Android and JVM targets should simply delegate to the androidx.compose.runtime.saveable.autoSaver function. The JavaScript target should provide a default implementation.

[android, js, jvm]\
[android, js, jvm]\
actual fun &lt;[T](auto-saver.md)&gt; [autoSaver](auto-saver.md)(): [Saver](-saver/index.md)&lt;[T](auto-saver.md), [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt;
