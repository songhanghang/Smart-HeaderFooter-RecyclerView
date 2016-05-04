# SmartHeaderFooterRecyclerview

Easy implements Header &amp; Footer view, Support Liner、Grid、StaggeredLayoutManager, With least modification

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

Add this in your root `build.gradle` file (**not** your module `build.gradle` file):

```gradle
allprojects {
	repositories {
		...
		maven { url 'https://dl.bintray.com/songhanghang/maven/' }
	}
}
```

Then, add the library to your project `build.gradle`
```gradle
dependencies {
    'com.songhang:smart-headerfooter-recyclerview:1.0.0'
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

