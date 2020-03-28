# WrapContentViewPager

A simple Android ViewPager with wrap_content support

## Setup
Grab the latest release through Gradle:
```groovy
dependencies {
    implementation 'com.github.owenlejeune:WrapContentViewPager:1.0.0'
}
```

## Usage
```xml
<com.owenlejeune.wrapcontentviewpager.WrapContentViewPager
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:wrap_method="height|width" />


<com.owenlejeune.wrapcontentviewpager.HorizontalWrapContentViewPager
        android:layout_width="wrap_content"
        android:layout_height="match_parent" />


<com.owenlejeune.wrapcontentviewpager.VerticalWrapContentViewPager
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />
```

## Attributes
| Custom Attributes |                     Description                    |
|:-----------------:|:--------------------------------------------------:|
| `app:wrap_method` | Whether to wrap the view by height, width, or both |

## Releases

#### 1.0
* Initial release

## License
```
Copyright 2020 Owen LeJeune

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```