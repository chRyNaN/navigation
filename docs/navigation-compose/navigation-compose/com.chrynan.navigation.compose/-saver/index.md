//[navigation-compose](../../../index.md)/[com.chrynan.navigation.compose](../index.md)/[Saver](index.md)

# Saver

[common]\
expect interface [Saver](index.md)&lt;[Original](index.md), [Saveable](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt;

A component that can convert the type of the [Original](index.md) into the type of [Saveable](index.md) so that it can be serialized, saved, restored. This component is meant to represent the androidx.compose.runtime.saveable.Saver interface, but that component is not available for Jetpack Compose Web, so this expected interface is defined in the common source set. The Android and JVM targets should simply use a typealias to delegate to the androidx.compose.runtime.saveable.Saver interface. The JavaScript target should provide a default implementation.

[js]\
actual interface [Saver](index.md)&lt;[Original](index.md), [Saveable](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt;

[android, jvm]\
actual typealias [Saver](index.md) = Saver&lt;[Original](index.md), [Saveable](index.md)&gt;
