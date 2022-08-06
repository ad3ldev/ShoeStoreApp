# README Template

Below is a template provided for use when building your README file for students.

# Project Title

Project description goes here.

## Getting Started

Instructions for how to get a copy of the project running on your local machine.

### Dependencies

```
val nav_version = "2.5.1"

Project:
apply plugin: "kotlin-parcelize"

classpath "androidx.navigation:navigation-safe-args-gradle-plugin:$nav_version"

Module:
dependencies {
    implementation "androidx.navigation:navigation-fragment-ktx:$nav_version"
    implementation "androidx.navigation:navigation-ui-ktx:$nav_version"
    implementation "androidx.navigation:navigation-dynamic-features-fragment:$nav_version"
    androidTestImplementation "androidx.navigation:navigation-testing:$nav_version"

    implementation 'com.jakewharton.timber:timber:5.0.1'
}

buildFeatures {
    dataBinding true
}
```

### Installation

Step by step explanation of how to get a dev environment running.

List out the steps

```
Give an example here
```

## Testing

Explain the steps needed to run any automated tests

### Break Down Tests

Explain what each test does and why

```
Examples here
```

## Project Instructions

This section should contain all the student deliverables for this project.

## Built With

* [Item1](www.item1.com) - Description of item
* [Item2](www.item2.com) - Description of item
* [Item3](www.item3.com) - Description of item

Include all items used to build project.

## License
