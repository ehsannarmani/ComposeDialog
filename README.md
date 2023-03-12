# Animated Dialogs & Material Dialog For JetpackCompose
### A Material Dialog & Animated Library ...
<img src="https://github.com/ehsannarmani/ComposeDialog/blob/master/media/gif.gif" width="250">
<hr/>

## Dependency

### Step 1: Add the JitPack repository to your build file
#### Add it in your root build.gradle at the end of repositories:
```groovy
allprojects {
  repositories {
    ...
    maven { url 'https://jitpack.io' }
  }
}
```

## Step 2: Add the dependency
[![](https://jitpack.io/v/ehsannarmani/ComposeDialog.svg)](https://jitpack.io/#ehsannarmani/ComposeDialog)
```groovy
dependencies {
  implementation 'com.github.ehsannarmani:ComposeDialog:latest_version'
}
```

<hr/>

## Usage

```kotlin
Dialog(
    visible = true or false,
    duration = 2000,
    position= Alignment.BottomCenter,
    dialogEnterAnim = expandHorizontally(),
    dialogExitAnim = shrinkHorizontally(),
    onEnd = { ... },
    ...
) {
    Text(
        text = "...",
        color = Color.White,
        fontSize = 13.sp,
        textAlign = TextAlign.Justify
    )
} 
```