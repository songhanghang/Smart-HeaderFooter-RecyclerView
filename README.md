# SmartHeaderFooterRecyclerview

Easy implements Header &amp; Footer view, Support Liner、Grid、StaggeredLayoutManager, With least modify！

非常方便的实现Recyclerview添加HeaderView和FooterView, 支持 LinearLayoutManager & GridLayoutManager & StaggeredLayoutManager

## Feature

* 1, No need change anyting with your target adapter

     不需要修改Target Adapter
* 2, Not destroy target adapter position

     不会破坏Target adapter中的 position (PS: 不需要 +1 -1)
* 3, Support dynamic add & remove

     支持动态添加移除
* 4, Support LinearLayoutManager & GridLayoutManager & StaggeredLayoutManager
 
     支持 LinearLayoutManager & GridLayoutManager & StaggeredLayoutManager 三种布局管理器

* 5, No dependencies code build order
 
     不依赖RecyclerView设置顺序 (eg: 不需要提前设置LayoutManager)

## Gradle Dependency (only 18.8KB)

Add the library to your project `build.gradle`
```gradle
dependencies {
    compile 'com.songhang:smart-headerfooter-recyclerview:1.0.1'
}
```

## Usage
```java
      RecyclerView.Adapter targetAdapter = new RecyclerView.Adapter() { ... };
      SmartRecyclerAdapter smartRecyclerAdapter = new SmartRecyclerAdapter(targetAdapter);
      smartRecyclerAdapter.setFooterView(footerView);
      smartRecyclerAdapter.setHeaderView(headerView);
      recyclerView.setAdapter(smartRecyclerAdapter);
```

## Screenshot
![Renderings](https://github.com/songhanghang/Smart-HeaderFooter-RecyclerView/blob/master/screenshot/screen.png)
![Renderings](https://github.com/songhanghang/Smart-HeaderFooter-Recyclerview/blob/master/screenshot/hammerheadMRA58Nsonghang04272016134831.gif)

## License

    Copyright 2016-2017 songhang
    
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

